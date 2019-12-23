package com.example.versionfour.ui.tt;

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

public class TTFragment extends Fragment {

    private TTViewModel TTViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TTViewModel =
                ViewModelProviders.of(this).get(TTViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tt, container, false);
        final TextView textView = root.findViewById(R.id.text_tt);
        TTViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}