package com.example.versionfour.ui.tt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.versionfour.R;

public class FragmentSyTT extends Fragment {
    View view;
    Button sybtn;
    public FragmentSyTT() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sy_tt,container,false);
        sybtn = view.findViewById(R.id.syTTDownloadBtn);

        sybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "File downloaded", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
