package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.directionhelpers.FetchURL;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.directionhelpers.TaskLoadedCallback;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Banque;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.CentreDeChange;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Hopital;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.ListStations;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Pharmacie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Restaurant;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Station;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.LatitudeLongitude;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.test.TestSuggestionActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener , TaskLoadedCallback {

    public FusedLocationProviderClient fusedLocationProviderClient;
    private static final int ERROR_DIALOG_REQUEST = 9001;
    GoogleMap mgoogleMap;
    GoogleApiClient googleApiClient;
    String choix;
    ArrayList<LatitudeLongitude> listPosition;
    Polyline currentPolyline;
    MarkerOptions place1;
    MarkerOptions place2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (googleServicesAvailable()) {
            Toast.makeText(this, "Perfect!!!!", Toast.LENGTH_LONG).show();
            setContentView(R.layout.fragment_map);

            Intent intent=getIntent();
            Bundle bundle=intent.getExtras();
            choix=bundle.getString("choix");


            afficherMarkerSelonChoix(choix);


            initMap();
            /*
            place1=new MarkerOptions().position(new LatLng(27.658143,85.3199503)).title("lacoation1");
            place2=new MarkerOptions().position(new LatLng(27.667491,85.3208503)).title("lacoation2");
            String url=getUrl(place1.getPosition(),place2.getPosition(),"driving");
            new FetchURL(MapActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");
            */

        } else {
            //no google maps layout
        }
    }

    private void afficherMarkerSelonChoix(String choix) {
        listPosition=new ArrayList<LatitudeLongitude>();
        switch (choix){

            case "Carte":
                double latitude=GlobalClass.listVilles.get(GlobalClass.idPositionVilleCourante).getLatitude();
                double longitude=GlobalClass.listVilles.get(GlobalClass.idPositionVilleCourante).getLongitude();
                listPosition.add(new LatitudeLongitude(latitude,longitude,GlobalClass.listVilles.get(GlobalClass.idPositionVilleCourante).getName(),11));
                break;
            case "Banques":
                int nombreBanques=GlobalClass.listVilleBanques.size();
                Toast.makeText(this,"size:"+nombreBanques, Toast.LENGTH_LONG).show();
                for (Banque banque:GlobalClass.listVilleBanques
                        ) {
                    listPosition.add(new LatitudeLongitude(banque.getLatitude(),banque.getLongitude(),banque.getName(),17));
                }
                break;
            case "Centre de Changes":
                int nombreCentreDeChanges=GlobalClass.listVilleCentreDeChanges.size();
                for (CentreDeChange centreDeChange: GlobalClass.listVilleCentreDeChanges) {
                    listPosition.add(new LatitudeLongitude(centreDeChange.getLatitude(),centreDeChange.getLongitude(),centreDeChange.getName(),17));
                }
                break;
            case "Hopitaux":
                for(Hopital hopital:GlobalClass.listVilleHopitals){
                    listPosition.add(new LatitudeLongitude(hopital.getLatitude(),hopital.getLongitude(),hopital.getName(),17));
                }
                break;
            case "Restaurants":
                for(Restaurant restaurant:GlobalClass.listVilleRestaurants){
                    listPosition.add(new LatitudeLongitude(restaurant.getLatitude(),restaurant.getLongitude(),restaurant.getName(),17));
                }
                break;
            case "Pharmacies":
                for(Pharmacie pharmacie:GlobalClass.listVillePharmacies){
                    listPosition.add(new LatitudeLongitude(pharmacie.getLatitude(),pharmacie.getLongitude(),pharmacie.getName(),17));
                }
                break;

            case "mapMaroc": listPosition.add(new LatitudeLongitude(31.7312438,-11.6446178,"MAROC",5));
                /*
            case "transport":
                Intent intent=getIntent();
                Bundle bundle=intent.getExtras();
                ListStations listStations= (ListStations) bundle.getSerializable("listeStations");
                place1=new MarkerOptions().position(new LatLng(listStations.getStations().get(0).getLatitude(),listStations.getStations().get(0).getLongitude())).title("lacoation1");
                place2=new MarkerOptions().position(new LatLng(listStations.getStations().get(1).getLatitude(),listStations.getStations().get(1).getLongitude())).title("lacoation2");
                String url=getUrl(place1.getPosition(),place2.getPosition(),"driving");
                new FetchURL(MapActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");
             //  Toast.makeText(this,"place1 latitude"+listStations.getStations().get(0).getLatitude()+"place1 longitude"+listStations.getStations().get(0).getLongitude(),Toast.LENGTH_LONG).show();
                break;
                */
        }
    }

    private void initMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
/*
        place1=new MarkerOptions().position(new LatLng(27.658143,85.3199503)).title("lacoation1");
        place2=new MarkerOptions().position(new LatLng(27.667491,85.3208503)).title("lacoation2");
        String url=getUrl(place1.getPosition(),place2.getPosition(),"driving");
        new FetchURL(MapActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");
*/
    }


//@33.9691399,-6.9970062,

    public boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvailable)) {
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(this, "Cant connect to play services", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    Marker marker;
    Circle circle;
    Polyline line;

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mgoogleMap = googleMap;

   //   mgoogleMap.addMarker(place1);
    //   mgoogleMap.addMarker(place2);
       //goToLocation(33.9691399, -6.9970062, 10);



           for (LatitudeLongitude latitudeLongitude: listPosition
                   ) {
               goToLocation(latitudeLongitude.getLatitude(),latitudeLongitude.getLongitude(),latitudeLongitude.getZoom());
               MarkerOptions markerOptions = new MarkerOptions().title(latitudeLongitude.getName())
                       .position(new LatLng(latitudeLongitude.getLatitude(), latitudeLongitude.getLongitude()))
                       .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

               marker = mgoogleMap.addMarker(markerOptions);
               circle= drawCircle(new LatLng(latitudeLongitude.getLatitude(),latitudeLongitude.getLongitude()));
               LatLng latlng1=new LatLng(33.9691399,-6.9970062);
               LatLng latLng2=new LatLng(33.9979957,-6.8768224);
               // drawLine(latlng1,latLng2);

           }



           mgoogleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
               @Override
               public boolean onMarkerClick(Marker marker) {
                   switch(choix){
                       case "Carte":
                           marker.showInfoWindow();
                           //Intent intent = new Intent(getApplicationContext(), TestSuggestionActivity.class);
                           //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                           //getApplicationContext().startActivity(intent);

                           break;
                       case "Banques":
                           marker.showInfoWindow();
                           //Intent intent = new Intent(getApplicationContext(),BanqueActivity.class);
                           //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                           //getApplicationContext().startActivity(intent);
                           break;
                       case "Centre de Changes":
                           marker.showInfoWindow();
                           //Intent intent = new Intent(getApplicationContext(), TestSuggestionActivity.class);
                           //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                           //getApplicationContext().startActivity(intent);
                           break;
                       case "Hopitaux":
                           marker.showInfoWindow();
                           Intent intent = new Intent(getApplicationContext(), HopitalActivity.class);
                           intent.putExtra("nomHopital",marker.getTitle());
                           intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                           getApplicationContext().startActivity(intent);
                           break;
                       case "Restaurants":
                           marker.showInfoWindow();
                           Intent intent2 = new Intent(getApplicationContext(), RestaurantActivity.class);
                           intent2.putExtra("nomRestaurant",marker.getTitle());
                           intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                           getApplicationContext().startActivity(intent2);
                           break;
                       case "Pharmacies":
                           marker.showInfoWindow();
                           Intent intent3 = new Intent(getApplicationContext(), PharmacieActivity.class);
                           intent3.putExtra("nomPharmacie",marker.getTitle());
                           intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                           getApplicationContext().startActivity(intent3);
                           break;
                   }
                   return true;
               }
           });





        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mgoogleMap.setMyLocationEnabled(true);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        googleApiClient.connect();


    }

    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);

        return url;
    }


    private Circle drawCircle(LatLng latLng) {
        CircleOptions options=new CircleOptions()
                .center(latLng)
                .radius(1000)
                .fillColor(0x33ff0000)
                .strokeColor(Color.BLUE)
                .strokeWidth(3);
        return mgoogleMap.addCircle(options);

    }

    private void drawLine(LatLng lng1,LatLng lng2){

        PolylineOptions options=new PolylineOptions()
                .add(lng1)
                .add(lng2)
                .color(Color.BLUE)
                .width(3);
        line=mgoogleMap.addPolyline(options);
    }


    private void goToLocation(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mgoogleMap.moveCamera(cameraUpdate);

    }

    private void goToLocation(double lat, double lng) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(ll);
        mgoogleMap.moveCamera(cameraUpdate);

    }


    /*
        public void chercherEndroit(View view) throws IOException {
            EditText editText = (EditText) findViewById(R.id.editText);
            String location = editText.getText().toString();
            Geocoder gc = new Geocoder(this);
            List<Address> list = new ArrayList<>();
            try {
                list = gc.getFromLocationName(location, 1);
            } catch (IOException e) {
            }
            //  gc.getFromLocationName(location,100);
            Address address;
            if (list.size() > 0) {
                address = list.get(0);
                Toast.makeText(this, String.valueOf(list.size()), Toast.LENGTH_LONG).show();
            }
            //Address address=list.get(0);
            String locality = address.getLocality();
            double lat = address.getLatitude();
            double lng = address.getLongitude();
            goToLocation(lat, lng, 10);
            if (marker != null) {
                marker.remove();
            }
            MarkerOptions markerOptions = new MarkerOptions().title(locality)
                    .position(new LatLng(lat, lng))
                    .snippet("hello I am here")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            marker = mgoogleMap.addMarker(markerOptions);
        }
    */
    LocationRequest locationRequest;

    @SuppressLint("MissingPermission")
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        // locationRequest.setInterval(1);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }
    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        if(location==null){
            Toast.makeText(this,"cant get current location",Toast.LENGTH_LONG).show();
        }else{
            LatLng ll= new LatLng(location.getLatitude(),location.getLongitude());
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll,15);
            mgoogleMap.animateCamera(update);
        }
    }
    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();
        currentPolyline = mgoogleMap.addPolyline((PolylineOptions) values[0]);
    }
}