package studentAssignment.model;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class UserBean {
	@NotEmpty
	private String id;
	
	private String name;
	@NotEmpty
	private String password;
	
	private String confirm;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
}
