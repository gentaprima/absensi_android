package com.example.absensi.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.absensi.model.login.ResponseLogin;
import com.example.absensi.network.repository.LoginRepository;

public class LoginViewModel extends ViewModel {
    private LoginRepository loginRepository;
    private LiveData<ResponseLogin> userEntityLiveData;

    public LoginViewModel(){
        loginRepository = new LoginRepository();
    }

    public void setLogin(String email,String password,String device_id){
        userEntityLiveData = loginRepository.getResponseLogin(email,password,device_id);
    }

    public LiveData<ResponseLogin> getUserEntityLiveData(){
        return userEntityLiveData;
    }
}
