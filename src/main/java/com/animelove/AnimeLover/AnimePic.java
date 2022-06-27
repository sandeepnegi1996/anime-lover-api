package com.animelove.AnimeLover;

public class AnimePic {

    private String url;

    public AnimePic(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AnimePic{" +
                "url='" + url + '\'' +
                '}';
    }


}
