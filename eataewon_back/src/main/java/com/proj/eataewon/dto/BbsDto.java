package com.proj.eataewon.dto;

/*
create table eataewonBbs(
    id varchar(50) not null,
    seq int ,
    title varchar(500) not null,
    content varchar(4000) not null,
    hashtag varchar(500),
    wdate timestamp,
    shopname varchar(100),
    address varchar(500),
    latitude number(12,8),
    longtitude number(12,8),
    readcnt int,
    likecnt int,
    constraint pk_eataewonBbs primary key(seq)
);
*/

public class BbsDto {

	private String id;
	private int seq;
	private String title;
	private String content;
	private int picture;
	private String nickname;



	private String hashtag;
	private String wdate;
	private String shopname;
	private String address;
	private double latitude;
	private double longtitude;
	private int readcnt;
	private int likecnt;

	private String shopphnum;
	private String shopurl;

	public BbsDto() {
	}

	public BbsDto(String id, int seq, String title, String content, int picture, String hashtag, String wdate,
				  String shopname, String address, double latitude, double longtitude,
				  int readcnt, int likecnt, String shopphnum,String shopurl) {
		this.id=id;
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.hashtag = hashtag;
		this.wdate = wdate;
		this.shopname = shopname;
		this.address = address;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.readcnt = readcnt;
		this.likecnt = likecnt;
		this.shopphnum = shopphnum;
		this.shopurl = shopurl;
	}

	public BbsDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}



	public BbsDto(String id, String title, String content, int picture, String hashtag, String shopname,
				  String address, double latitude, double longtitude, String shopphnum, String shopurl) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.hashtag = hashtag;
		this.shopname = shopname;
		this.address = address;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.shopphnum = shopphnum;
		this.shopurl = shopurl;


	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPicture() {return picture;}

	public void setPicture(int picture) {this.picture = picture;}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getShopname(){ return shopname;}

	public void setShopname(String shopname) { this.shopname = shopname;}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getShopphnum() {return shopphnum;}

	public void setShopphnum(String shopphnum) {this.shopphnum = shopphnum;}

	public String getShopurl() {return shopurl;}

	public void setShopurl(String shopurl) {this.shopurl = shopurl;}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	public String getNickname() { return nickname; }

	public void setNickname(String nickname) {this.nickname = nickname;}
}
