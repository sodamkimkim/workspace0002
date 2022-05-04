package ch02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor // 다 들어간놈
@NoArgsConstructor // 빈생성자
@ToString
public class MemberDto {

//	public MemberDto(@NonNull String memberId, String memberName, String memberAddress) {
//		super();
//		this.memberId = memberId;
//		this.memberName = memberName;
//		this.memberAddress = memberAddress;
//	}

	@NonNull
	private String memberId; // PK니까 not null

	private String memberName;

	private String memberAddress;

}
