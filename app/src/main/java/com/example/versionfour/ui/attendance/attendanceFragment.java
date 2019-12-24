//package com.example.versionfour.ui.attendance;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AlertDialog;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//import androidx.fragment.app.Fragment;
//
//import com.example.versionfour.R;
//import com.google.zxing.Result;
//
//import me.dm7.barcodescanner.zxing.ZXingScannerView;
//
//import static android.Manifest.permission.CAMERA;
//
//
//public class attendanceFragment extends Fragment implements ZXingScannerView.ResultHandler {
//
//    private attendanceViewModel attendanceViewModel;
//    private Context context;
//    private static final int REQUEST_CAMERA = 1;
//    private ZXingScannerView scannerView;
//
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        context = getContext();
//
//        scannerView = new ZXingScannerView(context);
//        setContentView(scannerView);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (checkPermission()) {
//                Toast.makeText(context, "Permission is Granted", Toast.LENGTH_LONG).show();
//            } else {
//                requestPermission();
//            }
//        }
//    }
//
//
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_links, container, false);
//
//
//        return rootView;
//    }
//
//    private boolean checkPermission() {
//        return (ContextCompat.checkSelfPermission(context, CAMERA) == PackageManager.PERMISSION_GRANTED);
//    }
//
//    private void requestPermission() {
//        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
//
//    }
//
//    public void onRequestPermissionsResult(int requestCode, String permission[], int grantResults[]) {
//        switch (requestCode) {
//            case REQUEST_CAMERA:
//                if (grantResults.length > 0) {
//                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    if (cameraAccepted) {
//                        Toast.makeText(context, "Permission Granted", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(context, "Pemission Denied", Toast.LENGTH_LONG).show();
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                            if (shouldShowRequestPermissionRationale(CAMERA)) {
//                                displayAlertMessage("You need to allow access for both permissions",
//                                        new DialogInterface.OnClickListener() {
//
//                                            @Override
//                                            public void onClick(DialogInterface dialog, int i) {
//                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                                    requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);
//                                                }
//                                            }
//                                        });
//                                return;
//                            }
//                        }
//                    }
//                }
//                break;
//        }
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (checkPermission()) {
//                if (scannerView == null) {
//                    scannerView = new ZXingScannerView(context);
//                    setContentView(scannerView);
//                }
//                scannerView.setResultHandler(this);
//                scannerView.startCamera();
//            } else {
//                requestPermission();
//            }
//        }
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        scannerView.stopCamera();
//    }
//
//    public void displayAlertMessage(String message, DialogInterface.OnClickListener listener) {
//        new AlertDialog.Builder(QrScan.this)
//                .setMessage(message)
//                .setPositiveButton("OK", listener)
//                .setNegativeButton("Cancel", null)
//                .create()
//                .show();
//    }
//
//    @Override
//    public void handleResult(Result result) {
//        final String scanResult = result.getText();
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("Scan Result");
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                scannerView.resumeCameraPreview((ZXingScannerView.ResultHandler) context);
//
//            }
//        });
//        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scanResult));
//                startActivity(intent);
//            }
//        });
//        builder.setMessage(scanResult);
//        AlertDialog alert = builder.create();
//        alert.show();
//    }
//}