package baitapcuoikhoa;

import java.util.Scanner;

public class QuanLyThuVien {
	public static String address = "D://00.Hoc Java Android//HOMEWORK//J70_BaiTapCuoiKhoa_NguyenThanhNam//";
	public static String filename = "book_data_en.txt";
	
	public static void main(String[] args) {
		int chon;
			Scanner sc = new Scanner(System.in); 
			System.out.println("Nhap lua chon:");
			System.out.println("Chon 1 - Hien thi danh sach toan bo sach.");
			System.out.println("Chon 2 - Them sach moi.");
			System.out.println("Chon 3 - Xoa sach theo ma sach.");
			System.out.println("Chon 4 - Tra cuu thong tin cuon sach (dua tren ma sach).");
			System.out.println("Chon 5 - Tim kiem sach dua theo ten tac gia.");
			System.out.println("Chon 6 - Tim kiem sach dua theo ten sach.");
			System.out.println("Chon 0 - Thoat khoi chuong trinh.");
			do {
				System.out.println("Nhap lua chon: ");
				chon = sc.nextInt();
				switch (chon) {
				case 1: {
					selection1();
					break;
				}
				case 2: {
					selection2();
					break;
				}
				case 3: {
					selection3();
					break;
				}
				case 4: {
				selection4();
					break;
				}
				case 5: {
				selection5();
					break;
				}
				case 6: {
				selection6();
					break;
				}
				case 0: {
					break;
				}
				default:
					System.out.println("Loi!");
				}
			} while (chon != 0);
		
	}

	private static void selection6() {
		BookName.TimTenSach(address, filename);
	}

	private static void selection5() {
		AuthorSearch.TimTacGia(address, filename);
	}

	private static void selection4() {
		SearchID.TimMaSach(address, filename);
	}

	private static void selection3() {
		DeleteData.XoaDuLieu(address,filename);
	}
	
	private static void selection2() {
		WriteData.GhiDuLieu(address,filename);
	}
	
	private static void selection1() {
		ReadData.DocDuLieu(address,filename);
	}
}
