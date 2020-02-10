package com.example.versionfour.ui.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.versionfour.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

public class ShowEvent extends Fragment{// AppCompatActivity {

    private MaterialSpinner spinner;
    private DatabaseReference databaseReference;
    PostAdapter postAdapter;
    RecyclerView recyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_show_event, container, false);

        spinner = rootView.findViewById(R.id.spinner);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        databaseReference = FirebaseDatabase.getInstance().getReference("/");
        // Log.d("bla", String.valueOf(databaseReference));

        Query query = databaseReference.orderByChild("Events");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final List<String> eventlist = new ArrayList<>();

                for (DataSnapshot ds : dataSnapshot.child("Events").getChildren()) {
                    eventlist.add(ds.getKey());
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, eventlist);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);

                Log.e("-------Data-----------",""+eventlist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Log.d("POS", String.valueOf(position));
                Log.d("VOS", item);
                setupRecyclerView(item);
            }
        });


        return rootView;

    }


    private void setupRecyclerView(String item) {
//        String  a =  getIntent().getStringExtra("VOS");
        Log.d("VAL", item);
        /*
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/

        FirebaseRecyclerOptions<Post> options = new FirebaseRecyclerOptions.Builder<Post>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Events").child(item), Post.class)
                .build();

        postAdapter = new PostAdapter(options);
        Log.e("Data",""+options);
        postAdapter.startListening();
        recyclerView.setAdapter(postAdapter);
    }

    /*

    public static void start(Context context) {
        Intent i = new Intent(context, ShowEvent.class);
        context.startActivity(i);
    }

    private MaterialSpinner spinner;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_event);
        spinner = findViewById(R.id.spinner);


        databaseReference = FirebaseDatabase.getInstance().getReference("/");
        // Log.d("bla", String.valueOf(databaseReference));

        Query query = databaseReference.orderByChild("Events");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final List<String> eventlist = new ArrayList<>();

                for (DataSnapshot ds : dataSnapshot.child("Events").getChildren()) {
                    eventlist.add(ds.getKey());
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, eventlist);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ShowEvent.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Log.d("POS", String.valueOf(position));
                Log.d("VOS", item);
                setupRecyclerView(item);
            }
        });
    }

    private void setupRecyclerView(String item) {
//        String  a =  getIntent().getStringExtra("VOS");
        Log.d("VAL", item);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Post> options = new FirebaseRecyclerOptions.Builder<Post>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Events").child(item), Post.class)
                .build();

        postAdapter = new PostAdapter(options);
        postAdapter.startListening();
        recyclerView.setAdapter(postAdapter);
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (postAdapter != null) {
            postAdapter.stopListening();
        }
    }*/

}
