package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVilleMonuments {
    TourismeAppService tourismeAppService;
    public static List<Monument> monuments ;
    private static ControllerRestVilleMonuments controllerRestClass;
    private ControllerRestVilleMonuments(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVilleMonuments getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVilleMonuments();
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
        ArrayList<Monument> monumentt= (ArrayList<Monument>) monuments;
        GlobalClass.listVilleMonuments=monumentt;
    }

}
