package com.krstar.infopublishing.prize.entity;

public class Prize {
    private Integer id;

    private String number;

    private String name;

    private String img;

    private String introPrize;

    private String sponsor;

    private String introSponsor;

    private String saySponsor;

    private String url;

    private String gmtCreate;

    private String gmtOpen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getIntroPrize() {
        return introPrize;
    }

    public void setIntroPrize(String introPrize) {
        this.introPrize = introPrize == null ? null : introPrize.trim();
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public String getIntroSponsor() {
        return introSponsor;
    }

    public void setIntroSponsor(String introSponsor) {
        this.introSponsor = introSponsor == null ? null : introSponsor.trim();
    }

    public String getSaySponsor() {
        return saySponsor;
    }

    public void setSaySponsor(String saySponsor) {
        this.saySponsor = saySponsor == null ? null : saySponsor.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate == null ? null : gmtCreate.trim();
    }

    public String getGmtOpen() {
        return gmtOpen;
    }

    public void setGmtOpen(String gmtOpen) {
        this.gmtOpen = gmtOpen == null ? null : gmtOpen.trim();
    }
}