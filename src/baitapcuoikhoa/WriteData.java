package baitapcuoikhoa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteData {
	public static ArrayList<DanhMucSach> GhiDuLieu(String add, String filename) {
		ArrayList<DanhMucSach> dataBook = new ArrayList<>();
		FileReader freader = null;
		BufferedReader buffr = null;
		FileWriter fwriter = null;
		BufferedWriter buffw = null;
		System.out.println("Nhap thong tin sach muon them:\n"
				+ "(Cu phap nhap: 'STT';'Ten sach';'Tac gia';'The loai';'Nam xuat ban')");
		Scanner sc = new Scanner(System.in);
			String nhap = sc.nextLine();
			String soSanh = nhap.substring(0, nhap.indexOf(";"));
			try {
				freader = new FileReader(new File(add + filename));
				buffr = new BufferedReader(freader);
				String line;
				while ((line = buffr.readLine())!= null) {
					DanhMucSach dmSach = DanhMucSach.inforBook(line);
					if (dmSach != null) {
						dataBook.add(dmSach);
					}
				}
				DanhMucSach themSach = DanhMucSach.inforBook(nhap);
				dataBook.add(themSach);
				fwriter = new FileWriter(add + filename);
				buffw = new BufferedWriter(fwriter);
				for (DanhMucSach h : dataBook) {
					String lineThem = h.createLine();
					buffw.write(lineThem);
					buffw.newLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (buffr != null) buffr.close();
					if (buffw != null) buffw.close();
				} catch (Exception e2) {}
			}
		return null;
	}
}
