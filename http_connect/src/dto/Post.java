package dto;

public class Post {
	public int userId;
	public int id;
	public String title;
	public String body;
	// 단순히 데이터만 담아서 전달..
	// 이런 목적을 가진클래스들을 DTO라고 함
}

//statusCode : 200
//{
//  "userId": 1,
//  "id": 1,
//  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//  "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
//}
