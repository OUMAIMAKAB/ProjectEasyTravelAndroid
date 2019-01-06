package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CentreDeChange implements Serializable {
    private int id;
    private String name;
    private double longitude;
    private double latitude;
    private List<Link> links= new ArrayList<Link>();

    @Override
    public String toString() {
        return "CentreDeChange{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

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
}
