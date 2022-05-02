package ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Dto.Post;

public class HttpMainTest2 {
	public static void main(String[] args) {
		try {
			URL url;
			url = new URL("https://jsonplaceholder.typicode.com/posts");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int statusCode = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
			}
			String str = sb.toString();
			Type type = new TypeToken<ArrayList<Post>>() {
			}.getType();
			ArrayList<Post> posts = new Gson().fromJson(str, type);
			for (Post post : posts) {
				System.out.println(post);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
