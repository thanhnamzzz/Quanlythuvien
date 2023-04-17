package baitapcuoikhoa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchID {
	public static ArrayList<DanhMucSach> TimMaSach(String add, String filename) {
		ArrayList<DanhMucSach> dataBook = new ArrayList<>();
		FileReader freader = null;
		BufferedReader buffr = null;
		System.out.println("Nhap ma sach can tim kiem:");
		Scanner sc = new Scanner(System.in);
		String idBook = sc.nextLine();
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
			DanhMucSach search = new DanhMucSach(idBook, null, null, null, null);
			if (dataBook.contains(search)) {
				System.out.println("Thong tin sach can tim:");
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("|%4s |%-50s |%-30s |%-30s |%6s|\n", "Ma", "Ten sach", "Tac gia", "The loai", "Nam XB");
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(dataBook.get(dataBook.indexOf(search)));
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			} else {
				System.out.println("Khong tim thay sach co ID nay");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (buffr != null) buffr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
}
