package com.example.absensi.ui.surat.tidak_hadir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.absensi.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SuratTidakHadirActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tv_title;
    private FloatingActionButton floatAdd;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat_tidak_hadir);
        toolbar = findViewById(R.id.toolbar);
        tv_title = findViewById(R.id.title);
        floatAdd = findViewById(R.id.floatAdd);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuratTidakHadirActivity.this,TambahSuratTidakHadirActivity.class));
            }
        });
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tv_title.setText("Daftar Surat Tidak Hadir");
    }
}