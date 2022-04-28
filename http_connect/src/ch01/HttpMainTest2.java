package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import dto.Post;

public class HttpMainTest2 {
	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/posts/20");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET"); // REST API
			connection.setRequestProperty("Content-type", "text/plane");
			// connection.setRequestProperty("Content-type", "application/json");

			int statusCode = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer buffer = new StringBuffer();
			String line = null;

			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
			} else if (statusCode == 404) { // 방어적코드
				System.out.println("네트워크 연결이 불안정합니다.");
			}
			String str = buffer.toString();
//			System.out.println(str);
			System.out.println("---------------------");

			Post post = new Post();
			// 도전!! 문자열을 parsing해서 post 객체에 값을 담아보기
			// 출력까지 !!!
			System.out.println(str);
			post.userId = Integer.parseInt(str.substring(13, 14));

//			post.userId = str.substring(13, 14);
//			System.out.println(post.userId);
//			post.id = str.substring(23, 25);
//			System.out.println(post.id);
			System.out.println(str.length());
			post.userId = Integer.valueOf(str.substring(13, 14));
			System.out.println(post.userId);
			post.id = Integer.valueOf(str.substring(23, 25));
			System.out.println(post.id);
			post.title = str.substring(38, 72);
			System.out.println(post.title);
			post.body = str.substring(86, 303);
			System.out.println(post.body);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
