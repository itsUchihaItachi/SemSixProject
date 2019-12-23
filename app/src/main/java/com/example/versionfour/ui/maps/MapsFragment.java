package com.example.versionfour.ui.maps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.versionfour.R;

public class MapsFragment extends Fragment {

    private MapsViewModel mapsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mapsViewModel =
                ViewModelProviders.of(this).get(MapsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_maps, container, false);
        final TextView textView = root.findViewById(R.id.text_maps);
        mapsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}