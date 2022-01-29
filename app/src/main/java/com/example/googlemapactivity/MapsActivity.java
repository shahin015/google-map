package com.example.googlemapactivity;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapactivity.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap,mymap;
    private ActivityMapsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        SupportMapFragment fragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map2);
        fragment.getMapAsync(this::maps);

    }

    String data;
    String tata;


    public void maps(GoogleMap map){


        data=getIntent().getExtras().getString("note");
        tata=getIntent().getExtras().getString("put");

        String longitude=tata;
        float lo=Float.parseFloat(longitude);
        String latitude=data;
       float l=Float.parseFloat(latitude);


        mymap=map;


        LatLng sydneys = new LatLng(l,lo);
        mymap.addMarker(new MarkerOptions().position(sydneys).title("Shaheed Ahsan Ullah Master General Hospital, Station Rd Over Bridge, Tongi Search Google Maps"));

        mymap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydneys,10));

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;




        ////



        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(24.374246955612175, 89.97342912400934);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Panday"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,4));
    }


}