package ch13;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;


public class MyException {
	String fileName;

	public MyException(String fileName) {
		this.fileName = fileName;
	}
	
	public String readFile() throws IOException {
		FileInputStream fis = new FileInputStream(this.fileName);
		Properties properties = new Properties();
		properties.load(fis); // fis로 fileName에에 접근하여 properties list를 읽어온다.
		// Reads a property list (key and element pairs) from the inputbyte stream.
		// The input stream is in a simple line-oriented format
		String dbType = properties.getProperty("DBTYPE");
		return dbType;

	} 
	
	
	public static void main(String[] args) {
		String dbType = null;
		MyException my = new MyException("b.txt");
		try {
			dbType = my.readFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("대체구문 작성하는 곳");
		}
		
		
	} // end of main
} // end of class
