package com.proj.eataewon.dto;

public class MemberDto {
    private String id;
    private String name;
    private String pwd;
    private String email;
    private String nickname;
    private int profilPic;
    private int likepoint;
    private String profilMsg;

    public MemberDto(){

    }

    public MemberDto(String id, String name, String pwd, String email, String nickname, int profilPic, int likepoint, String profilMsg) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.nickname = nickname;
        this.profilPic = profilPic;
        this.likepoint = likepoint;
        this.profilMsg = profilMsg;
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

    public int getProfilPic() {
        return profilPic;
    }

    public void setProfilPic(int profilPic) {
        this.profilPic = profilPic;
    }

    public int getLikepoint() {
        return likepoint;
    }

    public void setLikepoint(int likepoint) {
        this.likepoint = likepoint;
    }

    public String getProfilMsg() {
        return profilMsg;
    }

    public void setProfilMsg(String profilMsg) {
        this.profilMsg = profilMsg;
    }

    @Override
    public String toString() {
        return "MemberDtoTest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profilPic=" + profilPic +
                ", likepoint=" + likepoint +
                ", profilMsg='" + profilMsg + '\'' +
                '}';
    }
}
