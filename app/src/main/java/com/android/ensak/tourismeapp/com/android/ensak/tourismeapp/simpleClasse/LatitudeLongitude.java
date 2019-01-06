package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse;

public class LatitudeLongitude {
    private double latitude;
    private double longitude;
    private String name;
    private int zoom;
    private int id;

    public LatitudeLongitude(double latitude, double longitude, String name, int zoom, int id) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.zoom = zoom;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatitudeLongitude(double latitude, double longitude, String name, int zoom) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.zoom = zoom;
    }

    public LatitudeLongitude(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public LatitudeLongitude(double latitude, double longitude) {
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
