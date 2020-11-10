package com.example.absensi.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.absensi.R;
import com.example.absensi.ui.surat.tidak_hadir.SuratTidakHadirActivity;


public class PresensiFragment extends Fragment implements View.OnClickListener {

    private CardView cardTidakHadir;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardTidakHadir = view.findViewById(R.id.cardTidakHadir);
        cardTidakHadir.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_presensi, container, false);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.cardTidakHadir){
            startActivity(new Intent(getContext(), SuratTidakHadirActivity.class));
        }
    }
}