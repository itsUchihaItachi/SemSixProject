package com.example.versionfour.ui.attendance;

import android.annotation.SuppressLint;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.versionfour.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoadingFirebase extends AppCompatActivity {
    Button viewDatabase;
    TextView sname;
    TextView smac;

    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_firebase);

        sname = findViewById(R.id.name);
        smac = findViewById(R.id.mac);
        viewDatabase = findViewById(R.id.data);

        FirebaseApp.initializeApp(getApplicationContext());
        viewDatabase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String a = "student";
                String b = "18MCA045";
                WifiManager wifiMgr = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
                @SuppressLint("HardwareIds") final String mac_address = wifiInfo.getMacAddress();

                reff = FirebaseDatabase.getInstance().getReference().child(a).child(b);

                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String name = dataSnapshot.child("fname").getValue().toString();
                        String mac = dataSnapshot.child("mac").getValue().toString();
                        String newmac = dataSnapshot.child("mac").getValue().toString();

                        String mac_db = newmac;
                        Log.v("DB name", name);
                        Log.v("MOBILE MAC", mac_address);
                        Log.v("DB MAC", mac);

                        if (mac_address.equals(mac_db)) {
                            sname.setText(name);
                            smac.setText(mac);
                            reff.child("attendance").setValue("Marked");

                        } else {
                            Toast.makeText(LoadingFirebase.this, "Nope..", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(LoadingFirebase.this, "Couldn't Update..", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}
