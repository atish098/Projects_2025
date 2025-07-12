package API.Ecommerce;

import com.fasterxml.jackson.annotation.JsonProperty;

public class loginResponse {

	String token;
	
	 @JsonProperty("userId")
	String userId;
	String message;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserid() {
		return userId;
	}
	public void setUserid(String userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
