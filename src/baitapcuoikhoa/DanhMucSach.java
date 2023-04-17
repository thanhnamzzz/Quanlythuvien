package baitapcuoikhoa;

public class DanhMucSach {
	String ma,ten, tacGia, theLoai, nam;
	public DanhMucSach(String ma, String ten, String tacGia, String theLoai, String nam) {
		this.ma = ma;
		this.ten = ten;
		this.tacGia = tacGia;
		this.theLoai = theLoai;
		this.nam = nam;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DanhMucSach) {
			DanhMucSach dmSach = (DanhMucSach)obj;
			return dmSach.ma.equals(this.ma)||dmSach.tacGia.equals(this.tacGia);
		}
		return super.equals(obj);
	}
	@Override
	public String toString() {
		String tenHienThi,tacGiaHienThi, theLoaiHienThi;
		if (ten.length()>50) {
			tenHienThi = ten.substring(0,47) + "...";
		} else {
			tenHienThi = ten;
		}
		if (tacGia.length()>30) {
			tacGiaHienThi = tacGia.substring(0,27) + "...";
		} else {
			tacGiaHienThi = tacGia;
		}
		if (theLoai.length()>30) {
			theLoaiHienThi = theLoai.substring(0,27) + "...";
		} else {
			theLoaiHienThi = theLoai;
		}
		return String.format("|%4s |%-50s |%-30s |%-30s |%6s|", ma, tenHienThi, tacGiaHienThi, theLoaiHienThi, nam);
	}
	public static DanhMucSach inforBook(String line) {
		try {
			String[] lineBook = line.split(";");
			DanhMucSach dmSach = new DanhMucSach(lineBook[0],lineBook[1],lineBook[2],lineBook[3],lineBook[4]);
			return dmSach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String createLine() {
		return ma+";"+ten+";"+tacGia+";"+theLoai+";"+nam;
	}
}
