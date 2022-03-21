package com.proj.eataewon.dto;

public class LikeDto {

    private String id;
    private int bbsseq;
    private int seq;

    public LikeDto(){}

    public LikeDto(String id, int bbsseq, int seq){
        super();
        this.id=id;
        this.bbsseq=bbsseq;
        this.seq=seq;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public int getSeq_bbs() {return bbsseq;}

    public void setSeq_bbs(int bbsseq) {this.bbsseq = bbsseq;}

    public int getSeq() {return seq;}

    public void setSeq(int seq) {this.seq = seq;}


}
