package com.example.absensi.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.absensi.R;
import com.example.absensi.session.SystemDataLocal;
import com.example.absensi.ui.home.HomeActivity;
import com.example.absensi.ui.login.LoginActivity;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    CardView card_logout,card_email,card_password;
    private SystemDataLocal systemDataLocal;
    Toolbar toolbar;
    TextView tv_title;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_title = findViewById(R.id.title);
        tv_title.setText("Settings");
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        card_logout = findViewById(R.id.card_logout);
        card_logout.setOnClickListener(this);
        systemDataLocal = new SystemDataLocal(this);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.card_logout){
            systemDataLocal.destroySessionLogin();
            startActivity(new Intent(SettingActivity.this, LoginActivity.class));
        }
    }
}