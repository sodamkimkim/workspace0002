package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpMainTest1 {
	public static void main(String[] args) {
		// 준비물1
		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/posts/1");
			// 준비물2
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 부가적인 정보를 추가해서 보내기!!!
			connection.setRequestMethod("GET");
//			connection.setRequestMethod("POST");
			connection.connect();

			// 100, 200, 300, 400, 500 대 종류가 있다.
			int statusCode = connection.getResponseCode();
			System.out.println("statusCode : " + statusCode);
			// http통신 할 때 스트림을 달아야 한다.
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
			}
			String str = sb.toString();// string으로 변환 (데이터타입 다르다)
			System.out.println(str);
			System.out.println("----------------------------");
			System.out.println(str.substring(5,11)); // string 자르기
			System.out.println(str.substring(14,15));
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
