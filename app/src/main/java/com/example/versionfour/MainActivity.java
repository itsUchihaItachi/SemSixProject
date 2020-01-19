package com.example.versionfour;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wang.avi.AVLoadingIndicatorView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText username;
    EditText password;
    FloatingActionButton floatingAction;

   // private AVLoadingIndicatorView avi;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        myDB = new DatabaseHelper(this);
        username = findViewById(R.id.erpEditText);
        password = findViewById(R.id.passwordEditText);
        floatingAction = findViewById(R.id.floatingActionButton);

//        this is a loading indicator

//        String indicator = getIntent().getStringExtra("indicator");
//        avi = findViewById(R.id.avi);
//        avi.setIndicator(indicator);
//       stopAnim();

        floatingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startAnim();
                String email = username.getText().toString();
                String pass = password.getText().toString();
                myDB.insert();
                Boolean checkEmailPass = myDB.checkEmail(email, pass);

                if (checkEmailPass) {
                    Toast.makeText(getApplicationContext(), "Successful login", Toast.LENGTH_SHORT).show();
                    //stopAnim();
                    Intent intent = new Intent(v.getContext(), NavigationActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login failed, check credentials", Toast.LENGTH_SHORT).show();
                    //stopAnim();
                }
            }
        });
    }
//    created a thread to check whether it works or nah
//public void startThread()
//{
//    LoginThread Thread = new LoginThread(5);
//    Thread.start();
//}
//    class LoginThread extends Thread {
//        int seconds;
//
//        LoginThread(int seconds) {
//            this.seconds = seconds;
//        }
//
//        @Override
//        public void run() {
//            for (int i = 0; i < seconds; i++) {
//                try {
//                    Thread.sleep(1000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    public final void startAnim() {
//        avi.smoothToShow();
//    }
//
//    public final void stopAnim() {
//        avi.hide();
//    }
}
