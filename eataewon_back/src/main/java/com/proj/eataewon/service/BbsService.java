package com.proj.eataewon.service;

import com.proj.eataewon.dao.BbsDao;
import com.proj.eataewon.dao.MemberDao;
import com.proj.eataewon.dto.BbsDto;
import com.proj.eataewon.dto.BbsParam;
import com.proj.eataewon.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public void likeUpdate(int seq) {dao.likeUpdate(seq);}

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
}







