package bean;

/*
 * ユーザー情報DTOクラス
 *
 */


import java.text.*;
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
	private Date updated_at;

	public User() {
		this.userid = null;
		this.password = null;
		this.authority = null;
		this.name = null;
		this.nickName = null;
		this.address = null;
		this.email = null;
		this.created_at = new Date();
		this.updated_at = null;
	}

//	更新日登録
	public void update() {
		this.updated_at = new Date();
	}

//	アクセサメソッド
	public void setCreated_at(Date date) {
		this.created_at = date;
	}

	public void setUpdated_at(Date date) {
		this.updated_at = date;
	}

	public String getCreated_at() {
		SimpleDateFormat sdf1
        = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf1.format(this.created_at);
		return dateStr;
	}

	public String getUpdated_at() {
		SimpleDateFormat sdf1
        = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf1.format(this.updated_at);
		return dateStr;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickName = nickname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserid() {
		return this.userid;
	}

	public String getPassword() {
		return this.password;
	}

	public String getAuthority() {
		return this.authority;
	}

	public String getName() {
		return this.name;
	}

	public String getNickname() {
		return this.nickName;
	}

	public String getAddress() {
		return this.address;
	}

	public String getEmail() {
		return this.email;
	}

}
