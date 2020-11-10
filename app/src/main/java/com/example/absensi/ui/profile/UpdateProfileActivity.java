package com.example.absensi.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Update;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.absensi.R;
import com.example.absensi.model.Users;
import com.example.absensi.model.profile.ResponseProfile;
import com.example.absensi.session.SystemDataLocal;
import com.example.absensi.ui.home.HomeActivity;
import com.example.absensi.utils.DatePicker;
import com.example.absensi.utils.DialogClass;

public class UpdateProfileActivity extends AppCompatActivity {

    String id_pegawai,no_telp,tgl_lahir,jk,alamat;
    EditText edt_idpegawai,edt_notelepon,edt_tgllahir,edt_jeniskelamin,edt_alamat;
    Button btn_update;
    private android.app.AlertDialog alertDialog;
    private UpdateProfileViewModel updateProfileViewModel;
    private SystemDataLocal systemDataLocal;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);


        updateProfileViewModel = ViewModelProviders.of(this).get(UpdateProfileViewModel.class);
        systemDataLocal = new SystemDataLocal(this);
        id_pegawai = systemDataLocal.getLoginData().getId_pegawai();
        no_telp = systemDataLocal.getLoginData().getPhone();
        tgl_lahir = systemDataLocal.getLoginData().getTgl_lahir();
        jk = systemDataLocal.getLoginData().getJenis_kelamin();
        alamat = systemDataLocal.getLoginData().getAlamat();

        edt_idpegawai = findViewById(R.id.edt_idpegawai);
        edt_notelepon = findViewById(R.id.edt_notelepon);
        edt_tgllahir = findViewById(R.id.edt_tgllahir);
        edt_alamat = findViewById(R.id.edt_alamat);
        edt_jeniskelamin = findViewById(R.id.edt_jeniskelamin);
        btn_update = findViewById(R.id.btn_update);


        if(jk.equals("")){
            jk = "-";
        }

        if(alamat.equals("")){
            alamat = "-";
        }

        edt_idpegawai.setText(id_pegawai);
        edt_notelepon.setText(no_telp);
        edt_tgllahir.setText(tgl_lahir);
        edt_alamat.setText(alamat);
        edt_jeniskelamin.setText(jk);
        edt_tgllahir.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction()){
                    new DatePicker(new DatePickerDialog.OnDateSetListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                            int bulan = month+1;
                            edt_tgllahir.setText(year + "-" + bulan + "-" + dayOfMonth);
                        }
                    }).show(getSupportFragmentManager(),"Tanggal");
                }
                return true;
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prosesUpdate();
            }
        });
    }

    private void prosesUpdate() {
        String id_pegawai = edt_idpegawai.getText().toString();
        String no_telp = edt_notelepon.getText().toString();
        String date = edt_tgllahir.getText().toString();
        String jk = edt_jeniskelamin.getText().toString();
        String alamat = edt_alamat.getText().toString();
        View v = getLayoutInflater().inflate(R.layout.loading_alert,null,false);
        alertDialog = DialogClass.dialog(this,v).create();
        alertDialog.show();
        systemDataLocal.edtAllSessionLogin(systemDataLocal.getLoginData().getEmail(),
                                            systemDataLocal.getLoginData().getFull_name(),
                                            no_telp,
                                            systemDataLocal.getLoginData().getDevice_id(),
                                            systemDataLocal.getLoginData().getId_user(),
                                            systemDataLocal.getLoginData().getIs_verified(),
                                            systemDataLocal.getLoginData().getRole(),
                                            systemDataLocal.getLoginData().getPassword(),
                                            alamat,
                                            systemDataLocal.getLoginData().getFoto(),
                                            jk,
                                            systemDataLocal.getLoginData().getId_pegawai(),
                                            systemDataLocal.getLoginData().getId_jabatan(),
                                            systemDataLocal.getLoginData().getNama_jabatan(),
                                            systemDataLocal.getLoginData().getGaji(),
                                            date,
                                            systemDataLocal.getLoginData().getNik(),
                                            systemDataLocal.getLoginData().getCheck_in(),
                                            systemDataLocal.getLoginData().getCheck_out()
                                            );

        updateProfileViewModel.getProfileResponse(
                                                    systemDataLocal.getLoginData().getId_pegawai(),
                                                    systemDataLocal.getLoginData().getPhone(),
                                                    systemDataLocal.getLoginData().getTgl_lahir(),
                                                    systemDataLocal.getLoginData().getJenis_kelamin(),
                                                    systemDataLocal.getLoginData().getAlamat()).observe(this, new Observer<ResponseProfile>() {
            @Override
            public void onChanged(ResponseProfile responseProfile) {
                if(responseProfile != null){
                    if(responseProfile.getStatus()){
                        alertDialog.dismiss();
                        Toast.makeText(UpdateProfileActivity.this,responseProfile.getMessage(),Toast.LENGTH_LONG).show();
                        onBackPressed();
                        finish();

                    }else{
                        Toast.makeText(UpdateProfileActivity.this,responseProfile.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

}