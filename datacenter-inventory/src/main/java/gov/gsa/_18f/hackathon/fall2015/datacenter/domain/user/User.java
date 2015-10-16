package gov.gsa._18f.hackathon.fall2015.datacenter.domain.user;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 9142765294152398696L;
	
	private String username;
	private String password;
	private String email;
	private Boolean authenticated = Boolean.FALSE;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + "]";
	}

}
