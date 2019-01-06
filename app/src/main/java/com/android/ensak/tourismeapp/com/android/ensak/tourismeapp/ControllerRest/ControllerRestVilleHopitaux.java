package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Hopital;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVilleHopitaux {
    TourismeAppService tourismeAppService;
    public static List<Hopital> hopitals ;
    private static ControllerRestVilleHopitaux controllerRestClass;
    private ControllerRestVilleHopitaux(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVilleHopitaux getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVilleHopitaux();
        }
        return controllerRestClass;
    }


    public void listVilleHopitauxAsync(int idVille) {

        tourismeAppService.listVilleHopitauxAsync(idVille,new Callback<List<Hopital>>() {
            @Override
            public void success(List<Hopital> hopitals, Response response) {
                listHopitals(hopitals);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listHopitals(List<Hopital> hopitals) {
        GlobalClass.listVilleHopitals=hopitals;
    }

}
