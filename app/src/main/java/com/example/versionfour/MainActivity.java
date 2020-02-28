package com.example.versionfour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.versionfour.databinding.LoginLayoutBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    LoginLayoutBinding layoutBinding;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutBinding = DataBindingUtil.setContentView(this, R.layout.login_layout);
        myDB = new DatabaseHelper(this);

        layoutBinding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = layoutBinding.erpEditText.getText().toString();
                String pass = layoutBinding.passwordEditText.getText().toString();
                myDB.insert();
                Boolean checkEmailPass = myDB.checkEmail(email, pass);
                if (checkEmailPass) {
                    Toast.makeText(getApplicationContext(), "Successful login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), NavigationActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login failed, check credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
