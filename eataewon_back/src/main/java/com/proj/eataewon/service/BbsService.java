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

	public BbsDto getBbsListApp(int seq){
		return dao.getBbsListApp(seq);
	}

	public boolean writeBbs(BbsDto dto) {
		int n = dao.writeBbs(dto);
		return n>0?true:false;
	}

	public int writeBbsApp(BbsDto dto) {
		int n = dao.writeBbsApp(dto);
		System.out.println("글저장 후 seq값 돌려받기 "+n);
		return n;
	}

	public void readcount(int seq) {
		dao.readcount(seq);
	}

	public String readcountApp(int seq) {
		System.out.println("readcountApp 테스트" + seq);
		int n = dao.readcountApp(seq);
		return n>0?"Success":"Fail";
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

	public List<BbsDto> scrapBbsList(BbsDto dto) {
		System.out.println("scrapBbsList " + dto + new Date());
		return dao.scrapBbsList(dto);
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

	public List<BbsDto> likeBbsList(BbsDto dto) {
		System.out.println("likeBbsList " + dto.toString() + new Date());
		return dao.likeBbsList(dto);
	}


	public boolean likecntUpdate(LikeDto dto) {
		int n = dao.likecntUpdate(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean likecntDown(LikeDto dto) {
		int n = dao.likecntDown(dto);
		if(n>0){
			return true;
		}
		return false;

	}

	public boolean deleteLike(LikeDto dto) {
		int n = dao.deleteLike(dto);
		if(n == 0) return false;

		return true;
	}

	public boolean bbswriteImgup(BbsFileDto dto) {
		return dao.bbswriteImgup(dto);
	}

	//picture string으로 만든 DB용 서비스
	public boolean writeBbsPic(BbsPicDto dto) {
		int n = dao.writeBbsPic(dto);
		return n>0?true:false;
	}
	public boolean LikePWriteUp(String id){
		int n = dao.likePWriteUp(id);
		return n>0?true:false;
	}

	public boolean LikePHeartUp(String id){
		int n = dao.likePHeartUp(id);
		return n>0?true:false;
	}

	public boolean LikePScrapUp(String id){
		int n = dao.likePScrapUp(id);
		return n>0?true:false;
	}

	public boolean LikePHeartDown(String id){
		int n = dao.likePHeartDown(id);
		return n>0?true:false;
	}

	public boolean LikePScrapDown(String id){
		int n = dao.likePScrapDown(id);
		return n>0?true:false;
	}

}







