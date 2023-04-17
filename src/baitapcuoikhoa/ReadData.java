package baitapcuoikhoa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadData {
	public static ArrayList<DanhMucSach> DocDuLieu(String addr,String filename) {
		FileReader freader = null;
		BufferedReader buffR = null;
		try {
			freader = new FileReader(new File(addr + filename));
			buffR = new BufferedReader(freader);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
//			System.out.println("┌────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┬────┐");
			System.out.printf("|%4s |%-50s |%-30s |%-30s |%6s|\n", "Ma", "Ten sach", "Tac gia", "The loai", "Nam XB");
//			System.out.println("├────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┼────┤");
			String line;
			while ((line = buffR.readLine())!= null) {
				DanhMucSach dmSach = DanhMucSach.inforBook(line);
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(dmSach);
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffR != null) buffR.close();
			} catch (Exception e2) {}
		}
		return null;
	}
}
