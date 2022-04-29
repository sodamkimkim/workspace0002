
package ch05;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Yts {

	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("status_message") // 서버에서 보낸 키값과 이 키값이 다르면 못받는다.
	@Expose
	private String statusMessage;
	@SerializedName("data")
	@Expose
	private Data data;

}
