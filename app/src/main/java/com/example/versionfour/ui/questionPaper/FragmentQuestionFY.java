package com.example.versionfour.ui.questionPaper;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.versionfour.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FragmentQuestionFY extends Fragment {
    View view;

    ImageView imgView;
    Button savebtn;

    public FragmentQuestionFY() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fy_qp,container,false);
        imgView=view.findViewById(R.id.fyQTSImageView);
        savebtn=view.findViewById(R.id.fyQTSDownloadBtn);

        ActivityCompat.requestPermissions((Activity) getContext(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        ActivityCompat.requestPermissions((Activity) getContext(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSaveToMyPhone();
            }
        });
        return view;
    }

    public void imageSaveToMyPhone(){
        imgView=view.findViewById(R.id.fyQTSImageView);
        BitmapDrawable draw = (BitmapDrawable) imgView.getDrawable();
        Bitmap bitmap = draw.getBitmap();

        FileOutputStream outputStream = null;
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath() +"/SAVEIMAGES");
        dir.mkdirs();
        String filename = String.format("%d.jpg",System.currentTimeMillis());
        File outFile = new File(dir, filename);
        try{
            outputStream = new FileOutputStream(outFile);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        try{
            outputStream.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            outputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
