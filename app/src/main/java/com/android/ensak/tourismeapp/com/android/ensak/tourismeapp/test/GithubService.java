package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.test;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit.http.Query;

public interface GithubService {

    public static final String ENDPOINT = "http://192.168.1.9:8085/tourismeApp";


    @Headers("Cache-Control: max-age=640000")
    @GET("/users/{user}/repos/")
    List<Repo> listRepos(@Path("user") String user);

    @GET("/users/{user}/repos/")
    void listReposAsync(@Path("user") String user, Callback<List<Repo>> callback);

    @GET("/search/repositories")
    List<Repo> searchRepos(@Query("q") String query);
}
