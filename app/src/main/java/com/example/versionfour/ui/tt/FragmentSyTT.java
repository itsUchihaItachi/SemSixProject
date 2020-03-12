package com.example.versionfour.ui.tt;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import androidx.fragment.app.Fragment;

import com.example.versionfour.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FragmentSyTT extends Fragment {
    View view;
    Button sybtn;
    ImageView imgView;

    public FragmentSyTT() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sy_tt,container,false);

        imgView=view.findViewById(R.id.syTTImageView);
        sybtn = view.findViewById(R.id.syTTDownloadBtn);

        sybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "File downloaded", Toast.LENGTH_SHORT).show();
                imageSaveToMyPhone();
            }
        });
        return view;
    }

    public void imageSaveToMyPhone(){
        imgView=view.findViewById(R.id.syTTImageView);
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
