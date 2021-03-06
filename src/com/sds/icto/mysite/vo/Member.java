package com.sds.icto.mysite.vo;

public class Member {

	private Long no;
	private String name;
	private String email;
	private String password;
	private String gender;

	public Member(Long no, String name, String email, String password,
			String gender) {
		this.no = no;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	public Member() {
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}

}
