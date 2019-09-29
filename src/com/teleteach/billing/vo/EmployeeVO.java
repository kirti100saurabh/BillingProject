package com.teleteach.billing.vo;

import java.sql.Date;

public class EmployeeVO {
	
	private int id;
	private String password;
	private String fname;
	private String lname;
	private String gender;
	private String address;
	private String mobile1;
	private String mobile2;
	private Date dob;
	private int deg;
	private String del_flag;
	private int create_id;
	private Date create_time;
	private int update_id;
	private Date update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getDeg() {
		return deg;
	}
	public void setDeg(int deg) {
		this.deg = deg;
	}
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	public int getCreate_id() {
		return create_id;
	}
	public void setCreate_id(int create_id) {
		this.create_id = create_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getUpdate_id() {
		return update_id;
	}
	public void setUpdate_id(int update_id) {
		this.update_id = update_id;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", gender="
				+ gender + ", address=" + address + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", dob=" + dob
				+ ", deg=" + deg + ", del_flag=" + del_flag + ", create_id=" + create_id + ", create_time="
				+ create_time + ", update_id=" + update_id + ", update_time=" + update_time + "]";
	}
	
	
	
	
}
