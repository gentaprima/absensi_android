package com.example.absensi.ui.scanner;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.absensi.R;
import com.example.absensi.session.SystemDataLocal;
import com.google.zxing.Result;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView scannerView;
    private SystemDataLocal systemDataLocal;
    private String sessionIdPegawai,sessionDeviceId;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        scannerView = findViewById(R.id.scanner_view);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        systemDataLocal = new SystemDataLocal(this);
        sessionDeviceId = systemDataLocal.getLoginData().getDevice_id();
        sessionIdPegawai = systemDataLocal.getLoginData().getId_pegawai();

    }

    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        scannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();           // Stop camera on pause
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("ShowToast")
    @Override
    public void handleResult(Result rawResult) {
        try {
            ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
            tg.startTone(ToneGenerator.TONE_PROP_BEEP);
            String resultQr = rawResult.getText();
//            LocalDateTime ldt = LocalDateTime.now();
//            String dateNow = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String dateNow = df.format(c);
            String[] parts = resultQr.split("_");
            String no_pegawai = parts[0];
            String device_id = parts[1];
            String date = parts[2];
            if(!no_pegawai.equals(sessionIdPegawai)){
                onBackPressed();
                Toast.makeText(getApplicationContext(),"Maaf, QR tersebut tidak cocok dengan Nomor Pegawai Anda !",Toast.LENGTH_LONG).show();
            }

            if(!device_id.equals(sessionDeviceId)){
                onBackPressed();
                Toast.makeText(getApplicationContext(),"Maaf, QR tersebut tidak cocok dengan ID Device Anda !",Toast.LENGTH_LONG).show();
            }


            if(!date.equals(dateNow)){
                onBackPressed();
                Toast.makeText(getApplicationContext(),"Maaf, QR tersebut sudah kadaluarsa !",Toast.LENGTH_LONG).show();
            }

            if(no_pegawai.equals(sessionIdPegawai) && device_id.equals(sessionDeviceId) && date.equals(dateNow)){
                startActivity(new Intent(ScannerActivity.this,AbsensiActivity.class));
            }else{
                onBackPressed();
                Toast.makeText(getApplicationContext(),"Maaf, QR tidak cocok dengan sistem kami !",Toast.LENGTH_LONG).show();
            }




        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}