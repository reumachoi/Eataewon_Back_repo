package com.proj.eataewon.dto;

public class BbsParam {

    private String choice; //제목, 내용,작성자, +)해쉬태그
    private String search; //검색어

    private int page; //현재 페이지

    private int start; //페이지 글의 범위
    private int end;


    public BbsParam() {}


    public BbsParam(String choice, String search, int page, int start, int end) {
        super();
        this.choice = choice;
        this.search = search;
        this.page = page;
        this.start = start;
        this.end = end;
    }


    public String getChoice() {
        return choice;
    }


    public void setChoice(String choice) {
        this.choice = choice;
    }


    public String getSearch() {
        return search;
    }


    public void setSearch(String search) {
        this.search = search;
    }


    public int getPage() {
        return page;
    }


    public void setPage(int page) {
        this.page = page;
    }


    public int getStart() {
        return start;
    }


    public void setStart(int start) {
        this.start = start;
    }


    public int getEnd() {
        return end;
    }


    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "BbsParam [choice=" + choice + ", search=" + search + ", page=" + page + ", start=" + start + ", end="
                + end + "]";
    }



}
