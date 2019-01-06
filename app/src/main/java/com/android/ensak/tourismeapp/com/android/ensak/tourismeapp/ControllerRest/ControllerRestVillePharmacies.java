package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Pharmacie;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVillePharmacies {
    TourismeAppService tourismeAppService;
    public static List<Pharmacie> pharmacies ;
    private static ControllerRestVillePharmacies controllerRestClass;
    private ControllerRestVillePharmacies(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVillePharmacies getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVillePharmacies();
        }
        return controllerRestClass;
    }


    public void listVillePharmaciesAsync(int idVille) {

        tourismeAppService.listVillePharmaciesAsync(idVille,new Callback<List<Pharmacie>>() {
            @Override
            public void success(List<Pharmacie> pharmacies, Response response) {
                listPharmacies(pharmacies);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listPharmacies(List<Pharmacie> pharmacies) {
        GlobalClass.listVillePharmacies=pharmacies;
    }

}
