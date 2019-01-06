package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest;

import java.io.Serializable;

public class Link implements Serializable {
    private String link;
    private String rel;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @Override
    public String toString() {
        return "Link{" +
                "link='" + link + '\'' +
                ", rel='" + rel + '\'' +
                '}';
    }
}
