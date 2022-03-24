package com.proj.eataewon.dto;

public class LikeDto {

    private String id;
    private int bbsseq;
    private int seq;

    public LikeDto() {
    }
    @Override
    public String toString() {
        return "LikeDto{" +
                "id='" + id + '\'' +
                ", bbsseq=" + bbsseq +
                ", seq=" + seq +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBbsseq() {
        return bbsseq;
    }

    public void setBbsseq(int bbsseq) {
        this.bbsseq = bbsseq;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
