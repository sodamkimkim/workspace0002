package Dto;

import lombok.ToString;

// 객체를 갖고 올때,
// 해당 키값의 value를 갖고 올떄는 subString으로 하나하나 쪼개서 들고와도 되겠지만
// 하나의 객체로 만들어서 그 객체의 키값에 밸류를 넣어주고 사용하는 것이 편하다.
@ToString
public class Post {
	public int userId;
	public int id;
	public String title;
	public String body;

}
