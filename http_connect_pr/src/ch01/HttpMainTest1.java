package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpMainTest1 {

	public static void main(String[] args) {
		try {
			// 준비물 1
			URL url;
			url = new URL("https://jsonplaceholder.typicode.com/posts/20");
			// 준비물 2
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			// 서버에 GET요청.
			// URL(Uniform Resource Locator)은 인터넷에서 웹 페이지, 이미지, 비디오 등 리소스의 위치를 가리키는 문자열
			connection.setRequestMethod("GET");
			connection.connect();// 이 URL에서 참조하는 리소스에 대한 통신 링크를 엽니다.

			// statusCode
			// 그리고 상태 코드는,, 서버에 자원을 요청했고, 요청에 대한 처리 결과를 세 자릿수로 나타낸다.
			// 100,200,300,400,500번대 종류가 있다.
			int statusCode = connection.getResponseCode(); // 서버에서 응답 받아옴. 상태코드
			System.out.println(statusCode); // 통신이 정상적으로 완료되었으면 코드 200번 출력된다.
			// HTTP 통신할 때 스트림 달아야 한다.
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			if (statusCode == 200) {
				while ((line = bufferedReader.readLine()) != null) {
					sb.append(line + "\n");
				}
			}
			// 사이트에 저장되어 있는 값을 그대로 출력
			String str = sb.toString();
			System.out.println(str);
			System.out.println("--------------------------");

			System.out.println(str.substring(5, 11));// substring(포함,안포함)
			System.out.println(str.substring(14, 15));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
