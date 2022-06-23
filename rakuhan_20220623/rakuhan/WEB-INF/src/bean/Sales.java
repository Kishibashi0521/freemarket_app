package bean;

/*
 * 購入済み商品DTO
 */

import java.util.Date;

public class Sales {
	private int salesid;
	private String userid;
	private int itemid;
	private Date salesdate; // 売上日(自動生成)
	private String send; // 0:未発送 1:発送済み
	private String payment; // 0:未払い1:支払い済み
	private String transaction_completed; // 0:受け取り前 1:受け取り済み

	public Sales() {
		this.salesid = 0;
		this.userid = null;
		this.itemid = 0;
		this.salesdate = new Date();
		this.send = null;
		this.payment = null;
		this.transaction_completed = null;
	}

//	アクセサメソッド
	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setSalesDate(Date salesdate) {
		this.salesdate = salesdate;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public void setTransaction(String transaction) {
		this.transaction_completed = transaction;
	}

	public int getSalesid() {
		return this.salesid;
	}

	public int getItemid() {
		return this.itemid;
	}

	public String getUserid() {
		return this.userid;
	}

	public Date getSalesDate() {
		return this.salesdate;
	}

	public String getSend() {
		return this.send;
	}

	public String getPayment() {
		return this.payment;
	}

	public String getTransaction() {
		return this.transaction_completed;
	}

}
