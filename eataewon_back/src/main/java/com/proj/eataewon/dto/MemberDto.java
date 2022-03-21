package com.proj.eataewon.dto;

public class MemberDto {

	private int seq;
	private String name;
	private String id;
	private String pwd;
	private String email;
	private String nickName;
	private String profilPic;
	private int likePoint;
	private String profilMsg;
	
	public MemberDto() {
	}

	public MemberDto(int seq, String name, String id, String pwd, String email, String nickName, String profilPic, int likePoint, String profilMsg) {
		this.seq = seq;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.nickName = nickName;
		this.profilPic = profilPic;
		this.likePoint = likePoint;
		this.profilMsg = profilMsg;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfilPic() {
		return profilPic;
	}

	public void setProfilPic(String profilPic) {
		this.profilPic = profilPic;
	}

	public int getLikePoint() {
		return likePoint;
	}

	public void setLikePoint(int likePoint) {
		this.likePoint = likePoint;
	}

	public String getProfilMsg() {
		return profilMsg;
	}

	public void setProfilMsg(String profilMsg) {
		this.profilMsg = profilMsg;
	}
}
