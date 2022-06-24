package bean;

/*
 * 出品情報DTO
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {

	private int itemid;
	private String userid;
	private String itemname;
	private String type; // 0:アクセサリー 1:食器 2:インテリア 3:おもちゃ 4:その他
	private int price;
	private String comment;
	private String status; // 0:販売中 1:売り切れ
	private Date created_at;
	private Date updated_at;

	public Item() {
		this.itemid = 0;
		this.userid = null;
		this.itemname = null;
		this.type = null;
		this.price = 0;
		this.status = "0";
		this.created_at = new Date();
		this.updated_at = null;
	}

//	更新日登録
	public void update() {
		this.updated_at = new Date();
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
		this.created_at = date;
	}

	public void setUpdated_at(Date date) {
		this.updated_at = date;
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

	public String getCreated_at() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		String dateStr = sdf1.format(this.created_at);
		return dateStr;
	}

	public String getUpdated_at() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		String dateStr = sdf1.format(this.updated_at);
		return dateStr;
	}

}
