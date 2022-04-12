package com.proj.eataewon.service;

import com.proj.eataewon.dao.AppBbsDao;
import com.proj.eataewon.dao.BbsDao;
import com.proj.eataewon.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AppBbsService {
	
	@Autowired
	AppBbsDao dao;

	public BbsDto getBbsListApp(int seq){
		return dao.getBbsListApp(seq);
	}

	public int writeBbsApp(BbsDto dto) {
		int n = dao.writeBbsApp(dto);
		int seq= dto.getSeq();
		System.out.println("seq 확인: " + seq);
		System.out.println("글저장 후 seq값 돌려받기 "+n);
		return seq;
	}

	public String readcountApp(int seq) {
		System.out.println("readcountApp 테스트" + seq);
		int n = dao.readcountApp(seq);
		return n>0?"Success":"Fail";
	}

	public boolean checkUserLike(LikeDto dto){
		int n = dao.checkUserLike(dto);
		return n>0?true:false;
	}

	public boolean checkUserScrap(ScrapDto dto){
		int n = dao.checkUserScrap(dto);
		return n>0?true:false;
	}

	public boolean likecntPlus(int seq){
		int n = dao.likecntPlus(seq);
		return n>0?true:false;
	}

	public boolean likecntMinus(int seq){
		int n = dao.likecntMinus(seq);
		return n>0?true:false;
	}

	public List<BbsDto> findMyBbs(String id){
		return dao.findMyBbs(id);
	}
}



