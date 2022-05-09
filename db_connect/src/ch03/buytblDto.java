package ch03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor // 빈생성자
@ToString
public class buytblDto {
	String userName;
	String prodName;
	int price;
	int amount;
}
