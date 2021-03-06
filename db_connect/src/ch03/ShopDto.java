package ch03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor // λΉμμ±μ
@ToString
public class ShopDto {
	String userName1;
	int birthYear;
	String addr;
	String mobile;
	String userName2;
	String prodName;
	int price;
	int amount;
}
