package ch02_ref;

public interface IWriteArticle {
	void PrintArticle(String article); // 콜백.. 컨트롤 클릭해서 들어오면 여기로 들어옴
	// 어떤객체가 이걸로 연결되었는지는 .. 알기가 힘듬. 찾아야함
}
