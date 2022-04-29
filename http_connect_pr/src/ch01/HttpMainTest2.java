package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import Dto.Post;

public class HttpMainTest2 {
	public static void main(String[] args) throws IOException {
		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/users/1");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int statusCode = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer buffer = new StringBuffer();
			String line = null;

			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
			} else if (statusCode == 400) {
				System.out.println("네트워크 연결이 불안정 합니다.");
			}
			String str = buffer.toString();
			System.out.println(str);
			System.out.println();
			Post post = new Post();
			System.out.println(str.length());
			post.userId = Integer.parseInt(str.substring(13, 14));
			System.out.println(post.userId);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
