package yuanian.pojo;

public class User {


    private Integer usercode;

    private String username;

    private String department;

	public Integer getUsercode() {
		return usercode;
	}

	public void setUsercode(Integer usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "User{" +
				"usercode=" + usercode +
				", username='" + username + '\'' +
				", department='" + department + '\'' +
				'}';
	}
}