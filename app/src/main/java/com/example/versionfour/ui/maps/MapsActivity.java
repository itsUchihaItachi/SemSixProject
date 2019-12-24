package com.example.versionfour.ui.maps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.versionfour.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends AppCompatActivity {

    private Context context;
    private GoogleMap mMap;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
    }

    @Nullable
//    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        public void onMapReady(GoogleMap googleMap){

            mMap = googleMap;
            float zoomLevel = 18.0f; //This goes up to 21
            // Add a marker in MIT and move the camera
            LatLng mit = new LatLng(18.515983, 73.8129008);
            final Marker m = mMap.addMarker(new MarkerOptions().position(mit).title("Marker in MIT"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mit));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mit, zoomLevel));
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    if (marker.equals(m)) {
                        openMapsOnCLick();
                    }
                    return true;
                }
            });
            return rootView;

        }
    }


        private void openMapsOnCLick() {
//        Uri gmmIntentUri = Uri.parse("geo:18.515983,73.8129008");
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");
//        if (mapIntent.resolveActivity(getPackageManager()) != null) {
//            startActivity(mapIntent);
            Uri gmmIntentUri = Uri.parse("google.navigation:q=MIT+College,+Pune+Maharashtra");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
    }



