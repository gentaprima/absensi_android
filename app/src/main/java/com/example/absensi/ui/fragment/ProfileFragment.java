package com.example.absensi.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.absensi.R;
import com.example.absensi.model.Users;
import com.example.absensi.session.SystemDataLocal;
import com.example.absensi.ui.profile.UpdateProfileActivity;


public class ProfileFragment extends Fragment implements View.OnClickListener {



    private SystemDataLocal systemDataLocal;
    private Context context;
    TextView tv_name,tv_email,tv_phone,tv_date,tv_jk,tv_addres,tv_id;
    Button btn_update;
    String id_pegawai,no_telp,tgl_lahir,jk,alamat;
    Users users;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        systemDataLocal = new SystemDataLocal(context);
        tv_name = view.findViewById(R.id.tv_name);
        tv_date = view.findViewById(R.id.tv_date);
        tv_email = view.findViewById(R.id.tv_email);
        tv_phone = view.findViewById(R.id.tv_phone);
        tv_jk = view.findViewById(R.id.tv_jk);
        tv_id = view.findViewById(R.id.tv_id);
        tv_addres = view.findViewById(R.id.tv_alamat);
        btn_update = view.findViewById(R.id.button_update);
        users = systemDataLocal.getLoginData();

        tv_name.setText(users.getFull_name());
        tv_email.setText(users.getEmail());
        tv_phone.setText(users.getPhone());
        tv_date.setText(users.getTgl_lahir());
        tv_jk.setText(users.getJenis_kelamin());
        tv_id.setText(users.getId_pegawai());

        id_pegawai = users.getId_pegawai();
        no_telp = users.getPhone();
        tgl_lahir = users.getTgl_lahir();
        jk = users.getJenis_kelamin();
        alamat = users.getAlamat();

        if(users.getAlamat().equals("")){
            String alamat = "-";
            tv_addres.setText(alamat);
        }else{
            tv_addres.setText(users.getAlamat());
        }

        if(users.getJenis_kelamin().equals("")){
            String jk = "-";
            tv_jk.setText(jk);
        }
        btn_update.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = container.getContext();
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_update){
            Intent move = new Intent(getActivity(),UpdateProfileActivity.class);
            move.putExtra("id_pegawai",id_pegawai);
            move.putExtra("no_telp",no_telp);
            move.putExtra("tgl_lahir",tgl_lahir);
            move.putExtra("jk",jk);
            move.putExtra("alamat",alamat);
            context.startActivity(move);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        systemDataLocal = new SystemDataLocal(context);
        users = systemDataLocal.getLoginData();
        tv_name.setText(users.getFull_name());
        tv_email.setText(users.getEmail());
        tv_phone.setText(users.getPhone());
        tv_date.setText(users.getTgl_lahir());
        tv_jk.setText(users.getJenis_kelamin());
        tv_id.setText(users.getId_pegawai());
        tv_addres.setText(users.getAlamat());
    }
}