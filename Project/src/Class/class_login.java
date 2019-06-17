package Class;

public class class_login {
    private Integer ID_user;
	private String username;
	private String password;
	private Integer FK_user_type;
	private Integer FK_permit_type;

    public class_login(Integer ID_user, String username, String password, Integer FK_user_type, Integer FK_permit_type) {
        this.ID_user = ID_user;
        this.username = username;
        this.password = password;
        this.FK_user_type = FK_user_type;
        this.FK_permit_type = FK_permit_type;
    }

    public class_login() {
		// TODO Auto-generated constructor stub
	}

	public Integer getID_user() {
        return ID_user;
    }

    public void setID_user(Integer ID_user) {
        this.ID_user = ID_user;
    }

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

    public Integer getFK_user_type() {
        return FK_user_type;
    }

    public void setFK_user_type(Integer FK_user_type) {
        this.FK_user_type = FK_user_type;
    }

    public Integer getFK_permit_type() {
        return FK_permit_type;
    }

    public void setFK_permit_type(Integer FK_permit_type) {
        this.FK_permit_type = FK_permit_type;
    }
}
