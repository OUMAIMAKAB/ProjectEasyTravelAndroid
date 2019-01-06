package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ville implements Serializable {
    private int id;
    private String name;
    private String image;
    private double longitude;
    private double latitude;
    private List<Link> links=new ArrayList<Link>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getStringLinks(){
       if(links.size()!=0){
           StringBuffer stringBuffer=new StringBuffer();
           for (Link link: links
                ) {
               stringBuffer.append(link.toString());
           }
           return stringBuffer.toString();
       }
       return null;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", links="+ getStringLinks()+
                '}';
    }
}
