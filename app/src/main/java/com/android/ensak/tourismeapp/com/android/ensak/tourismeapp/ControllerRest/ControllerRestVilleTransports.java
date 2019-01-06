package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Transport;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVilleTransports {
    TourismeAppService tourismeAppService;
    public static List<Transport> transports ;
    private static ControllerRestVilleTransports controllerRestClass;
    private ControllerRestVilleTransports(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVilleTransports getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVilleTransports();
        }
        return controllerRestClass;
    }


    public void listVilleTransportsAsync(int idVille) {

        tourismeAppService.listVilleTransportsAsync(idVille,new Callback<List<Transport>>() {
            @Override
            public void success(List<Transport> transports, Response response) {
                listTransports(transports);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listTransports(List<Transport> transports) {
        GlobalClass.listVilleTransports=transports;
    }

}
