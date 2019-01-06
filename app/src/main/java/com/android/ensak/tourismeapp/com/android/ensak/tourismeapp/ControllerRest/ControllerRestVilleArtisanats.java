package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVilleArtisanats {

    TourismeAppService tourismeAppService;
    public static List<Artisanat> artisanats ;
    private static ControllerRestVilleArtisanats controllerRestClass;
    private ControllerRestVilleArtisanats(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVilleArtisanats getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVilleArtisanats();
        }
        return controllerRestClass;
    }


    public void listVilleArtisanatsAsync(int idVille) {

        tourismeAppService.listVilleArtisanatsAsync(idVille,new Callback<List<Artisanat>>() {
            @Override
            public void success(List<Artisanat> artisanats, Response response) {
                listArtisanats(artisanats);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listArtisanats(List<Artisanat> artisanats) {
        GlobalClass.listVilleArtisanats=artisanats;
    }

}
