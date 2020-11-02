package com.example.absensi.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.absensi.R;
import com.example.absensi.session.SystemDataLocal;
import com.example.absensi.utils.ProgressBarAnimation;

public class HomeFragment extends Fragment {

    SystemDataLocal systemDataLocal;
    TextView name;
    Context context;
    ProgressBar  progressBar;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        systemDataLocal = new SystemDataLocal(context);
        String full_name = systemDataLocal.getLoginData().getFull_name();
        String[] split = full_name.split(" ");
        name = view.findViewById(R.id.name);
        name.setText(split[0]);
        progressBar = view.findViewById(R.id.progressbar);

        ProgressBarAnimation anim = new ProgressBarAnimation(progressBar,0,90);
        anim.setDuration(1000);
        progressBar.startAnimation(anim);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = container.getContext();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }


}