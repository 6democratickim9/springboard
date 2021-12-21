package org.kosta.myproject.model.domain;

public class MemberDTO {
	private int memberId;
	private String email;
	private String name;
	private String nickname;
	private String address;
	private String phoneNum;
	private String birth;
	private int enable;
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(int memberId, String email, String name, String nickname, String address, String phoneNum,
			String birth, int enable) {
		super();
		this.memberId = memberId;
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.address = address;
		this.phoneNum = phoneNum;
		this.birth = birth;
		this.enable = enable;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	

	
	
	

}
