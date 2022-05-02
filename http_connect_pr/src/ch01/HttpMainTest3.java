package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import Dto.Post;

public class HttpMainTest3 {
	public static void main(String[] args) {

		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/posts/1");
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
			System.out.println();
			Gson gson = new Gson();
			Post post = gson.fromJson(str, Post.class); // 리플렉션 기법

			System.out.println(post.userId);
			System.out.println(post.id);
			System.out.println(post.title);
			System.out.println(post.body);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
