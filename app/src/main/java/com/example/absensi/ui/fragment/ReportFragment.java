package com.example.absensi.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.absensi.R;
import com.example.absensi.adapter.LaporanAdapter;
import com.example.absensi.model.laporan.DataLaporanResponse;
import com.example.absensi.session.SystemDataLocal;
import com.example.absensi.ui.laporan.GetDataLaporanViewModel;

public class ReportFragment extends Fragment {


    private RecyclerView rv_laporan;
    private SystemDataLocal systemDataLocal;
    private GetDataLaporanViewModel getDataLaporanViewModel;
    private Activity activity;
    private TextView tv_hadir,tv_tidakhadir,tv_izin;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_laporan = view.findViewById(R.id.rv_laporan);
        systemDataLocal = new SystemDataLocal(getContext());
        getDataLaporanViewModel = ViewModelProviders.of(this).get(GetDataLaporanViewModel.class);
        tv_hadir = view.findViewById(R.id.tv_hadir);
        tv_tidakhadir = view.findViewById(R.id.tv_tidakhadir);
        tv_izin = view.findViewById(R.id.tv_izin);
        readDataLaporan();
    }

    private void readDataLaporan() {
        String id_users = systemDataLocal.getLoginData().getId_pegawai();
        getDataLaporanViewModel.getDataLaporan(id_users).observe(this, new Observer<DataLaporanResponse>() {
            @Override
            public void onChanged(DataLaporanResponse dataLaporanResponse) {
                if(dataLaporanResponse.getStatus()){
                    if(dataLaporanResponse.getDataLaporan().size() > 0){
                        LaporanAdapter laporanAdapter = new LaporanAdapter(activity,dataLaporanResponse.getDataLaporan());
                        rv_laporan.setLayoutManager(new GridLayoutManager(getContext(),2));
                        rv_laporan.setAdapter(laporanAdapter);
                        tv_hadir.setText(dataLaporanResponse.getHadir());
                        tv_tidakhadir.setText(dataLaporanResponse.getTidakHadir());
                        tv_izin.setText(dataLaporanResponse.getIzin());
                        rv_laporan.setNestedScrollingEnabled(false);
                    }
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        readDataLaporan();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }
}