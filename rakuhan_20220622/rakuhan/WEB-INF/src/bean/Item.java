package bean;

import java.util.Date;

public class Item {

	private int itemid;
	private String userid;
	private String itemname;
	private String type; //0:その他　1:食器　2:インテリア　3:おもちゃ　4:その他
	private int price;
	private String comment;
	private String status;
	private Date created_at;
	private Date update_at;

	public Item() {
		this.itemid = 0;
		this.userid = null;
		this.itemname = null;
		this.type = null;
		this.price = 0;
		this.status = null;
		this.created_at = new Date();
		this.update_at = null;
	}

//	更新日登録
	public void update() {
		this.update_at=new Date();
	}

//	アクセサメソッド
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCreated_at(Date date) {
		this.created_at=date;
	}

	public void setUpdated_at(Date date) {
		this.update_at = date;
	}

	public int getItemid() {
		return this.itemid;
	}

	public String getUserid() {
		return this.userid;
	}

	public String getItemname() {
		return this.itemname;
	}

	public String getType() {
		return this.type;
	}

	public int getPrice() {
		return this.price;
	}

	public String getComment() {
		return this.comment;
	}

	public String getStatus() {
		return this.status;
	}

	public Date getCreate_at() {
		return this.created_at;
	}

	public Date getUpdate_at() {
		return this.update_at;
	}

}
