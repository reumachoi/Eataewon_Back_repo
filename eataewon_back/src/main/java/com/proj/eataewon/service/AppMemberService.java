package com.proj.eataewon.service;

import com.proj.eataewon.dao.AppMemberDao;
import com.proj.eataewon.dao.MemberDao;
import com.proj.eataewon.dto.BbsDto;
import com.proj.eataewon.dto.MemberBbsDto;
import com.proj.eataewon.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppMemberService {

    @Autowired
    AppMemberDao dao;

    public boolean getIdApp(String id) {
        System.out.println("+" + id + "+");
        int n = dao.getIdApp(id);
        System.out.println(n);
        return n>0?true:false;
    }

    public boolean LikePWriteUp(String id){
        int n = dao.LikePWriteUp(id);
        return n>0?true:false;
    }

    public boolean LikePHeartUp(String id){
        int n = dao.LikePHeartUp(id);
        return n>0?true:false;
    }

    public boolean LikePScrapUp(String id){
        int n = dao.LikePScrapUp(id);
        return n>0?true:false;
    }

    public boolean LikePHeartDown(String id){
        int n = dao.LikePHeartDown(id);
        return n>0?true:false;
    }

    public boolean LikePScrapDown(String id){
        int n = dao.LikePScrapDown(id);
        return n>0?true:false;
    }
}
