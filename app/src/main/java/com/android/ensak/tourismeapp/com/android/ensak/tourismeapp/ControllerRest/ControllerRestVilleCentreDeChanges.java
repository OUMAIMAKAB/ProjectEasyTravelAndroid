package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.CentreDeChange;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVilleCentreDeChanges {
    TourismeAppService tourismeAppService;
    public static List<CentreDeChange> centreDeChanges ;
    private static ControllerRestVilleCentreDeChanges controllerRestClass;
    private ControllerRestVilleCentreDeChanges(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVilleCentreDeChanges getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVilleCentreDeChanges();
        }
        return controllerRestClass;
    }


    public void listVilleCentreDeChangesAsync(int idVille) {

        tourismeAppService.listVilleCentreDeChangesAsync(idVille,new Callback<List<CentreDeChange>>() {
            @Override
            public void success(List<CentreDeChange> centreDeChanges, Response response) {
                listCentreDeChanges(centreDeChanges);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listCentreDeChanges(List<CentreDeChange> centreDeChanges) {
        GlobalClass.listVilleCentreDeChanges=centreDeChanges;
    }

}
