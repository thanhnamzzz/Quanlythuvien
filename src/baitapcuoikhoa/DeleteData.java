package baitapcuoikhoa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteData {
	public static ArrayList<DanhMucSach> XoaDuLieu(String add, String filename) {
		ArrayList<DanhMucSach> dataBook = new ArrayList<>();
		FileReader freader = null;
		BufferedReader buffr = null;
		FileWriter fwriter = null;
		BufferedWriter buffw = null;
		System.out.println("Nhap ma sach muon xoa:");
		Scanner sc = new Scanner(System.in);
		String idClear = sc.nextLine();
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
				DanhMucSach delete = new DanhMucSach(idClear, null, null, null, null);
				dataBook.remove(delete);
//				for (int i = 0; i < dataBook.size(); i++) {
//					System.out.println(dataBook.get(i));
//				}
				fwriter = new FileWriter(add + filename);
				buffw = new BufferedWriter(fwriter);
				for (DanhMucSach h : dataBook) {
					String lineThem = h.createLine();
					buffw.write(lineThem);
					buffw.newLine();
				}
			} catch (Exception e) {
			} finally {
				try {
					if (buffw != null) buffw.close();
					if (buffr != null) buffr.close();
				} catch (Exception e2) {}
			}
		return null;
	}
}
