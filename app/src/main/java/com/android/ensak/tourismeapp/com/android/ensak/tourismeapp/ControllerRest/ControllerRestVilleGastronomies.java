package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Gastronomie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVilleGastronomies {
    TourismeAppService tourismeAppService;
    public static List<Gastronomie> gastronomies ;
    private static ControllerRestVilleGastronomies controllerRestClass;
    private ControllerRestVilleGastronomies(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVilleGastronomies getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVilleGastronomies();
        }
        return controllerRestClass;
    }


    public void listVilleGastronomiesAsync(int idVille) {

        tourismeAppService.listVilleGastronomiesAsync(idVille,new Callback<List<Gastronomie>>() {
            @Override
            public void success(List<Gastronomie> gastronomies, Response response) {
                listGastronomies(gastronomies);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listGastronomies(List<Gastronomie> gastronomies) {
        GlobalClass.listVilleGastronomies=gastronomies;
    }

}
