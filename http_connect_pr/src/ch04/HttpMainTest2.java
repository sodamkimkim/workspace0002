package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpMainTest2 {
	public static void main(String[] args) {
		// URL연결(json넘어옴)
		// request get방식 요청, response받기
		// status code
	
		try {
		URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			try {
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				int statusCode = connection.getResponseCode();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String line = null;
				if(statusCode == 200) {
					while((line = bufferedReader.readLine())!=null) {
						sb.append(line + "\n");
					}
				}
				String str = sb.toString();
				Type type = new TypeToken<ArrayList<Post>>
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// stream연결
		// while문으로 받기 -> json파싱해서 어레이리스트에 저장
		// DTO post타입 출력해주기

	}
}
