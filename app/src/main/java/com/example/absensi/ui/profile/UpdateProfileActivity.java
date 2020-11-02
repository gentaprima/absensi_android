package com.example.absensi.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Update;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.absensi.R;
import com.example.absensi.model.Users;
import com.example.absensi.model.profile.ResponseProfile;
import com.example.absensi.session.SystemDataLocal;
import com.example.absensi.ui.home.HomeActivity;
import com.example.absensi.utils.DialogClass;

public class UpdateProfileActivity extends AppCompatActivity {

    String id_pegawai,no_telp,tgl_lahir,jk,alamat;
    EditText edt_idpegawai,edt_notelepon,edt_tgllahir,edt_jeniskelamin,edt_alamat;
    Button btn_update;
    private android.app.AlertDialog alertDialog;
    private UpdateProfileViewModel updateProfileViewModel;
    private SystemDataLocal systemDataLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        id_pegawai = getIntent().getStringExtra("id_pegawai");
        no_telp = getIntent().getStringExtra("no_telp");
        tgl_lahir = getIntent().getStringExtra("tgl_lahir");
        jk = getIntent().getStringExtra("jk");
        alamat = getIntent().getStringExtra("alamat");
        updateProfileViewModel = ViewModelProviders.of(this).get(UpdateProfileViewModel.class);
        systemDataLocal = new SystemDataLocal(this);
//        Users users = systemDataLocal.getLoginData();

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
        systemDataLocal.edtAllSessionLogin(systemDataLocal.getLoginData().getId_user(),
                                            systemDataLocal.getLoginData().getEmail(),
                                            systemDataLocal.getLoginData().getFull_name(),
                                            no_telp,
                                            systemDataLocal.getLoginData().getPassword(),
                                            systemDataLocal.getLoginData().getRole(),
                                            systemDataLocal.getLoginData().getDevice_id(),
                                            systemDataLocal.getLoginData().getIs_verified(),
                                            systemDataLocal.getLoginData().getAgama(),
                                            alamat,
                                            systemDataLocal.getLoginData().getFoto(),
                                            date,
                                            jk,
                                            id_pegawai,
                                            systemDataLocal.getLoginData().getNama_jabatan()
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