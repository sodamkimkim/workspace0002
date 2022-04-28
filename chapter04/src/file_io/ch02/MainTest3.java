package file_io.ch02;

import java.io.FileInputStream;
import java.util.Iterator;

// 입력스트림
//바이트단위 스트림
// 파일에서 배열단위로 읽기
public class MainTest3 {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("boot_b.txt")) {
			byte[] bs = new byte[10];
			int i;
//			while ((i = fis.read(bs)) != -1) {
//				for (int j = 0; j < i; j++) {
//					System.out.println("------");
//					System.out.println("i : " + i);
//					System.out.println("j : " + j);
//					System.out.println((char)bs[j]);
//				}
//
//			}
			
			while ((i = fis.read(bs,1,5)) != -1) {
				for (int j = 0; j < i; j++) {
					System.out.println("------");
//					System.out.println("i : " + i);
//					System.out.println("j : " + j);
					System.out.println((char)bs[j]);
					
				}
				System.out.println("i : " + i + " 바이트 읽음.");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
