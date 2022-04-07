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


	public boolean likepointup(BbsDto dto) {
		int n = dao.likepointup(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean likepointdown(BbsDto dto) {
		int n = dao.likepointdown(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean lppluspoint(BbsDto bdto) {
		int n = dao.lppluspoint(bdto);
		if(n > 0) {
			return true;
		}
		return false;
	}


	public boolean lpminuspoint(BbsDto bdto) {
		int n = dao.lpminuspoint(bdto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean scrpointup(BbsDto bdto) {
		int n = dao.scrpointup(bdto);
		if(n > 0) {
			return true;
		}
		return false;

	}

	public boolean scrpointminus(BbsDto dto) {
		int n = dao.scrpointminus(dto);
		if(n > 0) {
			return true;
		}
		return false;

	}

	public BbsFileDto getBbsDetail(int seq) {
		return dao.getBbsDetail(seq);
	}

	public List<BbsFileDto> getBbsListFileSearchPage(BbsParam param) {
		return dao.getBbsListFileSearchPage(param);
	}

	public boolean bbswriteImgup(BbsFileDto dto) {
		return dao.bbswriteImgup(dto);
	}

	public void readcountFile(int seq) {
		dao.readcountFile(seq);
	}

	public boolean updateBbsFile(BbsFileDto dto) {
		int n = dao.updateBbsFile(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteBbsFile(int seq) {
		int n = dao.deleteBbsFile(seq);
		if(n == 0) return false;

		return true;
	}

	public boolean likeBbsFile(LikeDto dto) {
		System.out.println("likeBbs " + dto + new Date());
		int n = dao.likeBbsFile(dto);
		return n > 0 ? true : false;
	}

	public List<BbsFileDto> likeBbsListFile(BbsFileDto dto) {
		System.out.println("likeBbsList " + dto.toString() + new Date());
		return dao.likeBbsListFile(dto);
	}

	public boolean likebbsfileCnt(LikeDto dto) {
		System.out.println("likebbsfileCnt " + dto + new Date());
		int n = dao.likebbsfileCnt(dto);
		System.out.println("likebbsfileCnt : "  + n);
		return n == 0 ? true : false;
	}

	public boolean lpplusfilepoint(BbsFileDto fdto) {
		int n = dao.lpplusfilepoint(fdto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean likecntfileUpdate(LikeDto dto) {
		int n = dao.likecntfileUpdate(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean likecntDownfile(LikeDto dto) {
		int n = dao.likecntDownfile(dto);
		if(n>0){
			return true;
		}
		return false;
	}

	public boolean lpminuspointfile(BbsFileDto fdto) {
		int n = dao.lpminuspointfile(fdto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteLikefile(LikeDto dto) {
		int n = dao.deleteLikefile(dto);
		if(n == 0) return false;

		return true;
	}

	public boolean scrapBbsCntfile(ScrapDto dto) {
		System.out.println("scrapBbsCntfile " + dto + new Date());
		int n = dao.scrapBbsCntfile(dto);
		System.out.println("scrapBbsCntfile : "  + n);
		return n == 0 ? true : false;
	}

	public boolean scrpointupfile(BbsFileDto bdto) {
		int n = dao.scrpointupfile(bdto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean bbsScrapfile(ScrapDto dto) {
		System.out.println("ScrapDto " + dto + new Date());
		int n = dao.bbsScrapfile(dto);
		return n > 0 ? true : false;
	}

	public List<BbsFileDto> scrapBbsListfile(BbsFileDto dto) {
		System.out.println("scrapBbsListfile " + dto + new Date());
		return dao.scrapBbsListfile(dto);
	}

	public boolean deleteScrapfile(ScrapDto dto) {
		int n = dao.deleteScrapfile(dto);
		if(n == 0) return false;

		return true;
	}

	public boolean scrpointminusfile(BbsFileDto dto) {
		int n = dao.scrpointminusfile(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public int getBbsFileCount(BbsParam param) {
		return dao.getBbsFileCount(param);
	}

	public boolean likepointupfile(BbsFileDto dto) {
		int n = dao.likepointupfile(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public boolean likepointdownfile(BbsFileDto dto) {
		int n = dao.likepointdownfile(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}

	public List<BbsFileDto> getBbsListFileSearchPageImg(BbsParam param) {
		return dao.getBbsListFileSearchPageImg(param);
	}
}



