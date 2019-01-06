package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVilleLogements {
    TourismeAppService tourismeAppService;
    public static List<Logement> logements ;
    private static ControllerRestVilleLogements controllerRestClass;
    private ControllerRestVilleLogements(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVilleLogements getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVilleLogements();
        }
        return controllerRestClass;
    }


    public void listVilleLogementsAsync(int idVille) {

        tourismeAppService.listVilleLogementsAsync(idVille,new Callback<List<Logement>>() {
            @Override
            public void success(List<Logement> logements, Response response) {
                listLogements(logements);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listLogements(List<Logement> logements) {
        GlobalClass.listVilleLogements=logements;
    }

}
