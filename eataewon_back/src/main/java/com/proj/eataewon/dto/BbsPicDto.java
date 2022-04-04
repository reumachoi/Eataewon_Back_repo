package com.proj.eataewon.dto;


import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class BbsPicDto {

	private String id;
	private int seq;
	private String title;
	private String content;
	private String picture;

	private String hashtag;
	private String wdate;
	private String shopname;
	private String address;
	private double latitude;
	private double longtitude;
	private int readcnt;
	private int likecnt;
	
	private String name;
	private String pwd;
	private String email;
	private String nickName;
	private int profilPic;
	private int likePoint;
	private String profilMsg;
}
