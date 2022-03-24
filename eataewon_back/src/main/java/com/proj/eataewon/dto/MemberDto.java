package com.proj.eataewon.dto;

 /*
 		id varchar(50) not null,
		 name varchar(50) not null,
		 pwd varchar(50) not null,
		 email varchar(100) not null,
		 nickName varchar(50) not null,
		 profilPic int,
		 likePoint int,
		 profilMsg varchar(500),*/

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberDto {
	private String id;
	private String name;
	private String pwd;
	private String email;
	private String nickName;
	private int profilPic;
	private int likePoint;
	private String profilMsg;
	

}
