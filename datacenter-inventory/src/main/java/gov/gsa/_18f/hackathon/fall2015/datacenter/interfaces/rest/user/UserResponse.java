package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest.user;

public class UserResponse {
	private String token;

	public UserResponse() {}
	public UserResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
