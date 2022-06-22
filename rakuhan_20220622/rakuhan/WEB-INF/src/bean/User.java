package bean;

import java.util.Date;

public class User {

	private String userid;
	private String password;
	private String authority;
	private String name;
	private String nickName;
	private String address;
	private String email;
	private Date created_at;
	private Date update_at;

	public User(){
		this.userid = null;
		this.password = null;
		this.authority = null;
		this.name=null;

	}

}
