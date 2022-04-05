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

	public void readcount(int seq) {
		dao.readcount(seq);
	}

	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}

	public BbsFileDto getBbsDetail(int seq) {
		return dao.getBbsDetail(seq);
	}

	public List<BbsDto> getBbsListSearch(BbsParam param) {
		return dao.getBbsListSearch(param);
	}

	public List<BbsDto> getBbsListSearchPage(BbsParam param) {
		return dao.getBbsListSearchPage(param);
	}

	public List<BbsFileDto> getBbsListFileSearchPage(BbsParam param) {
		return dao.getBbsListFileSearchPage(param);
	}

	public int getBbsCount(BbsParam param) {
		return dao.getBbsCount(param);
	}

	public boolean updateBbs(BbsDto dto) {
		int n = dao.updateBbs(dto);
		return n>0?true:false;
	}

	public boolean deleteBbs(int seq) {
		int n = dao.deleteBbs(seq);
		return n>0?true:false;
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

	public List<BbsDto> scrapBbsList(BbsDto dto) {
		System.out.println("scrapBbsList " + dto + new Date());
		return dao.scrapBbsList(dto);
	}


	public boolean deleteScarp(int seq) {
		int n = dao.deleteScarp(seq);
		return n>0?true:false;
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

	public List<BbsDto> likeBbsList(BbsDto dto) {
		System.out.println("likeBbsList " + dto.toString() + new Date());
		return dao.likeBbsList(dto);
	}


	public boolean likecntUpdate(LikeDto dto) {
		int n = dao.likecntUpdate(dto);
		return n>0?true:false;
	}

	public boolean likecntDown(LikeDto dto) {
		int n = dao.likecntDown(dto);
		return n>0?true:false;
	}

	public boolean deleteLike(LikeDto dto) {
		int n = dao.deleteLike(dto);
		return n>0?true:false;
	}

	public boolean bbswriteImgup(BbsFileDto dto) {
		return dao.bbswriteImgup(dto);
	}


}