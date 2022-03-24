package com.proj.eataewon.dto;

public class ScrapDto {

    private String id;
    private int bbsseq;
    private int seq;

    public ScrapDto(){}

    public ScrapDto(String id, int bbsseq, int seq) {
        this.id = id;
        this.bbsseq = bbsseq;
        this.seq = seq;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public int getBbs_seq() {return bbsseq;}

    public void setBbs_seq(int bbsseq) {this.bbsseq = bbsseq;}

    public int getSeq() {return seq;}

    public void setSeq(int seq) {this.seq = seq;}



    @Override
    public String toString() {
        return "ScrapDto{" +
                "id='" + id + '\'' +
                ", bbsseq=" + bbsseq +
                ", seq=" + seq +
                '}';
    }


}


