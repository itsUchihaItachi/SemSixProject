package com.example.versionfour.ui.contacts;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.versionfour.R;

public class contactsFragment extends Fragment {
    private contactsViewModel contactsViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contactsViewModel = ViewModelProviders.of(this).get(contactsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_contacts, container, false);
        final TextView textView = root.findViewById(R.id.text_contact);
        contactsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
