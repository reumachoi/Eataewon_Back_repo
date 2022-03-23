package com.proj.eataewon.service;

import com.proj.eataewon.dao.BbsDao;
import com.proj.eataewon.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BbsService {
	
	@Autowired
	BbsDao dao;

	public List<BbsDto> getBbsList(){
		return dao.getBbsList();
	}

	public boolean writeBbs(BbsDto dto) {
		int n = dao.writeBbs(dto);
		return n>0?true:false;
	}

	public boolean bbswriteImgup(BbsDto dto) {

		return dao.bbswriteImgup(dto);
	}



	public void readcount(int seq) {
		dao.readcount(seq);
	}

	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}

	public List<BbsDto> getBbsListSearch(BbsParam param) {
		return dao.getBbsListSearch(param);
	}

	public List<BbsDto> getBbsListSearchPage(BbsParam param) {
		return dao.getBbsListSearchPage(param);
	}

	public int getBbsCount(BbsParam param) {
		return dao.getBbsCount(param);
	}

	public boolean updateBbs(BbsDto dto) {
		int n = dao.updateBbs(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteBbs(int seq) {
		int n = dao.deleteBbs(seq);
		if(n == 0) return false;

		return true;
	}

	public boolean bbsScrap(ScrapDto dto) {
		System.out.println("ScrapDto " + dto + new Date());
		int n = dao.bbsScrap(dto);
		return n > 0 ? true : false;

	}

	public boolean scrapBbsCnt(ScrapDto dto) {
		System.out.println("scrapBbsCnt " + dto + new Date());
		int n = dao.scrapBbsCnt(dto);
		System.out.println("scrapBbsCnt : "  + n);
		return n == 0 ? true : false;

	}

	public List<BbsDto> scrapBbsList(String id) {
		System.out.println("scrapBbsList " + id + new Date());
		return dao.scrapBbsList(id);
	}


	public boolean deleteScarp(int seq) {
		int n = dao.deleteScarp(seq);
		if(n == 0) return false;

		return true;
	}

	public boolean likeBbs(LikeDto dto) {
		System.out.println("likeBbs " + dto + new Date());
		int n = dao.likeBbs(dto);
		return n > 0 ? true : false;

	}

	public boolean likebbsCnt(LikeDto dto) {
		System.out.println("likebbsCnt " + dto + new Date());
		int n = dao.likebbsCnt(dto);
		System.out.println("likebbsCnt : "  + n);
		return n == 0 ? true : false;

	}

	public List<BbsDto> likeBbsList(String id) {
		System.out.println("likeBbsList " + id + new Date());
		return dao.likeBbsList(id);
	}



	public boolean likecntUpdate(LikeDto dto) {
		int n = dao.likecntUpdate(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteLike(int seq) {
		int n = dao.deleteLike(seq);
		if(n == 0) return false;

		return true;
	}


}







