package com.proj.eataewon.dto;

public class MemberDto {
    private String id;
    private String name;
    private String pwd;
    private String email;
    private String nickname;
    private String profilpic;
    private int likepoint;
    private String profilmsg;
    private int del;

    public MemberDto(){

    }

    public MemberDto(String id, String name, String pwd, String email, String nickname,
                     String profilpic, int likepoint, String profilmsg, int del) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.nickname = nickname;
        this.profilpic = profilpic;
        this.likepoint = likepoint;
        this.profilmsg = profilmsg;
        this.del = del;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfilpic() {
        return profilpic;
    }

    public void setProfilpic(String profilpic) {
        this.profilpic = profilpic;
    }

    public int getLikepoint() {
        return likepoint;
    }

    public void setLikepoint(int likepoint) {
        this.likepoint = likepoint;
    }

    public String getProfilmsg() {
        return profilmsg;
    }

    public void setProfilmsg(String profilmsg) {
        this.profilmsg = profilmsg;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profilpic='" + profilpic + '\'' +
                ", likepoint=" + likepoint +
                ", profilmsg='" + profilmsg + '\'' +
                ", del=" + del +
                '}';
    }
}
