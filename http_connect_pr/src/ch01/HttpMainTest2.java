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
		URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		int statusCode = connection.getResponseCode();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuffer buffer = new StringBuffer();
		String line = null;

		if (statusCode == 200) {
			while ((line = reader.readLine()) != null) {
				buffer.append(line + "\n");
			}
		} else if (statusCode == 404) {
			System.out.println("네트워크 연결이 불안정 합니다.");
		}
		String str = buffer.toString();
		System.out.println(str);

		Post post = new Post();
		System.out.println(str.length());
		post.userId = Integer.parseInt(str.substring(13, 14));
		post.id = Integer.parseInt(str.substring(23,25));
		post.title = str.substring(38,72);
		

	}
}
