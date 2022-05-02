package ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Dto.TodosDto;

public class HttpMainTest3 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos");
			// URL 연결 인스턴스 생성,
			// HttpURLConnection타입으로 다운캐스팅
			// ㄴ url.openConnection()이 HttpURLConnection타입보다 더 추상화된 개념임을 알 수있다.
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// url에 대해 HttpURLConnection방식으로 "GET"request를 한다.
			connection.setRequestMethod("GET"); // 8가지? requestMethod가 있다.
			connection.connect(); // thread.start(); 같은 개념
			// 100,200,300,400,500번대 종류가 있는데
			// 응답 상태코드가 200이면 정상연결된 것임.
			int statusCode = connection.getResponseCode();
			//BufferedReader 객체를 생성해서
			// HttpURLConnection을 하는 connection(URL연결 instance)의 inputStream을 연결.
			// 데이터를 read한다.
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// StringBuffer는 insert, append, subString할 수 있다.
			// BufferedReader로 String line을 한줄씩 받아서
			// 그것을 StringBuffer sb에 append해준 다음
			//  또다른 String str을 생성하고 sb.toString()넣어주고
			// 그 str을 arrayList 형태로 값 저장해 줄것임.
			// 근데 이 str이 Json형태라서 Gson().fromJson(str, ArrayList)형태로 파싱할 것이고
			
			// 또한 str이 Dto로 설계해둔 TodosDto 객체 값의 연속이므로
			// 배열 또는 ArrayList등의 자료구조 형태를 이요할 것인데
			// 여기선 ArrayList<TodosDto>쓰는것임.
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = reader.readLine()) != null) {
//				sb = line + "\n"; --> StringBuffer는 append해야한다.
				sb.append(line + "\n");
				
			}
			
			String str = sb.toString();
			// 근데 Gson왜쓰는거지
			// Gson안쓰려면 subString일일이 해줘야 한다.
			//post.userId = Integer.parseInt(str.substring(13, 14)); 이런식으로..
			//StringBuffer toString저장한 str을 substring으로 데이터를 넣어줘야 하는데..
			//우리는 Dto를 설계했고(또는 https://www.jsonschema2pojo.org/로 자동 만들기)
			//Gson 라이브러리를 이용해서 그 Dto를 활용할 수 있도록 하는 것임.
			
			//근데 List계열로 파싱할 때 --> 상세히는 generic으로 설계된 자료구조로 파싱할땐,,
			// 아직 자바에서 제네릭(클래스<E>이런형태)형태로의 파싱방법이 나오지 않아서
			// Type 클래스를 이용해서 TypeToken객체를 생성하여 파싱에 사용한다.
			// import java.lang.reflect.Type; 이걸 import해줘야한다.
			Type type = new TypeToken<ArrayList<TodosDto>>(){}.getType();			
			ArrayList<TodosDto> todos = new Gson().fromJson(str,type);
			for (TodosDto todosDto : todos) {
				System.out.println(todos);
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
