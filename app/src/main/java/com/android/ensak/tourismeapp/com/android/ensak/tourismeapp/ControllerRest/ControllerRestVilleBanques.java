package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Banque;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVilleBanques {
    TourismeAppService tourismeAppService;
    public static List<Banque> banques ;
    private static ControllerRestVilleBanques controllerRestClass;
    private ControllerRestVilleBanques(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVilleBanques getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVilleBanques();
        }
        return controllerRestClass;
    }


    public void listVilleBanquesAsync(int idVille) {

        tourismeAppService.listVilleBanquesAsync(idVille,new Callback<List<Banque>>() {
            @Override
            public void success(List<Banque> banques, Response response) {
                listBanques(banques);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listBanques(List<Banque> banques) {
        GlobalClass.listVilleBanques=banques;
    }

}
