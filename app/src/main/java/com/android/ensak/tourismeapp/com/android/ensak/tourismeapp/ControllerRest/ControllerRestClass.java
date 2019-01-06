package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import android.util.Log;
import android.widget.Toast;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestClass {
    TourismeAppService tourismeAppService;
    public static List<Monument> monumentsf ;
    public static  String name = null;
    private static ControllerRestClass controllerRestClass;
    private ControllerRestClass(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestClass getInstanceControllerRestClass(){
        if(controllerRestClass==null){
                controllerRestClass=new ControllerRestClass();
        }
        return controllerRestClass;
    }


    public void listVilleMonumentsAsync(int idVille) {

        tourismeAppService.listVilleMonumentsAsync(idVille,new Callback<List<Monument>>() {
            @Override
            public void success(List<Monument> monuments, Response response) {
              listMonuments(monuments);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listMonuments(List<Monument> monuments) {
        name="oooo";
    }



}
