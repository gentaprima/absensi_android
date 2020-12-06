package com.example.absensi.ui.surat.cuti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.absensi.R;
import com.example.absensi.model.MessageOnly;
import com.example.absensi.session.SystemDataLocal;
import com.example.absensi.utils.DatePicker;
import com.example.absensi.utils.DialogClass;

public class AddCutiActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_namapegawai,edt_startDate,edt_endDate,edtKeterangan;
    private SystemDataLocal systemDataLocal;
    private AddSuratCutiViewModel addSuratCutiViewModel;
    Button btnSubmit;
    private android.app.AlertDialog alertDialog;
    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cuti);
        edt_namapegawai = findViewById(R.id.edt_namapegawai);
        edt_endDate = findViewById(R.id.edt_endDate);
        edt_startDate = findViewById(R.id.edt_startDate);
        edtKeterangan = findViewById(R.id.edtKeterangan);
        btnSubmit = findViewById(R.id.btn_submit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView tv_title = findViewById(R.id.title);
        tv_title.setText("Daftar Surat Cuti");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        systemDataLocal = new SystemDataLocal(this);
        edt_startDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction()){
                    new DatePicker(new DatePickerDialog.OnDateSetListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                            int bulan = month+1;
                            edt_startDate.setText(year + "-" + bulan + "-" + dayOfMonth);
                        }
                    }).show(getSupportFragmentManager(),"Tanggal");
                }
                return true;
            }
        });

        edt_endDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction()){
                    new DatePicker(new DatePickerDialog.OnDateSetListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                            int bulan = month+1;
                            edt_endDate.setText(year + "-" + bulan + "-" + dayOfMonth);
                        }
                    }).show(getSupportFragmentManager(),"Tanggal");
                }
                return true;
            }
        });
        edt_namapegawai.setText(systemDataLocal.getLoginData().getFull_name());
        addSuratCutiViewModel = ViewModelProviders.of(this).get(AddSuratCutiViewModel.class);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_submit){
            addSuratCuti();
        }
    }

    private void addSuratCuti() {
        String keterangan = edtKeterangan.getText().toString();
        String startDate = edt_startDate.getText().toString();
        String endDate = edt_endDate.getText().toString();
        String idUsers = systemDataLocal.getLoginData().getId_pegawai();
        View v = getLayoutInflater().inflate(R.layout.loading_alert,null,false);
        alertDialog = DialogClass.dialog(this,v).create();
        alertDialog.show();
        addSuratCutiViewModel.addSuratCuti(keterangan,startDate,endDate,idUsers).observe(this, new Observer<MessageOnly>() {
            @Override
            public void onChanged(MessageOnly messageOnly) {
                if(messageOnly.getStatus()){
                    alertDialog.dismiss();
                    Toast.makeText(getApplicationContext(),messageOnly.getMessage(),Toast.LENGTH_LONG).show();
                    onBackPressed();
                }else{
                    alertDialog.dismiss();
                    Toast.makeText(getApplicationContext(),messageOnly.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}