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

	public boolean bbswriteImgup(BbsFileDto dto) {
		return dao.bbswriteImgup(dto);
	}



/*

	public void BbsImgUp(BbsDto bdto, HttpServletRequest request){
		HttpSession session = request.getSession(false);
		MemberDto mdto = (MemberDto) session.getAttribute("memberDto");
		bdto.setId(mdto.getId());

		boolean contentNo = writeBbs(bdto); //글쓰는 값 들어가면 true

		//파일 업로드 path 설정
		// getServletContext()를 사용하여 웹 서비스 디렉토리의 물리적 경로를 구한다.
		String uploadPath=request.getSession().getServletContext().getRealPath("/resources/img/");


		//파일 리스트를 getFile()로 받는다.

		//List<MultipartFile> fileList=bdto.getPicture();
		String fileList=bdto.getPicture();
		ArrayList<String> nameList=new ArrayList<String>();
		for(int i=0; i<fileList.length(); i++){
			if(fileList.isEmpty()==false){
				BbsDto bbsfileDto=new BbsDto();
				//FileVO fileVO=new FileVO();
				String fileName=fileList.get(i).getOriginalFilename();
				if(fileName.equals("")==false){
					try{
						//업로드된 이미지 파일을 transferTo 메서드를 사용하여 업로드 경로에 전송한다.
						fileList.get(i).transferTo(new File(uploadPath+fileName));
						fileVO.setNo(contentNo);
						fileVO.setFilepath(fileName);
						boardVO.setFileVO(fileVO);
						nameList.add(fileName);
						//업로드된 파일의 정보를 데이터베이스에 저장한다.
						boardDAO.freeboardWriteFileUpload(boardVO);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		}




	}
*/


}







