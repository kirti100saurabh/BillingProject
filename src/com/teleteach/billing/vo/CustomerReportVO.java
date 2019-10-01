package com.teleteach.billing.vo;

public class CustomerReportVO {
	private String id;
	private String name;
	private String mobno;
	private String credit;
	private String debit;
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
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	@Override
	public String toString() {
		return "CustomerReportVO [id=" + id + ", name=" + name + ", mobno=" + mobno + ", credit=" + credit + ", debit="
				+ debit + "]";
	}

}
