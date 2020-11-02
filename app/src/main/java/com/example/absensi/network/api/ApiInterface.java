package com.example.absensi.network.api;


import com.example.absensi.model.login.ResponseLogin;
import com.example.absensi.model.profile.ResponseProfile;
import com.example.absensi.model.register.ResponseRegister;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("users/register")
    Call<ResponseRegister>  registerUser(@Field("full_name") String full_name,
                                         @Field("email") String email,
                                         @Field("phone") String phone,
                                         @Field("password") String password,
                                         @Field("imei") String imei);

    @FormUrlEncoded
    @POST("users/login")
    Call<ResponseLogin> loginUser(@Field("email") String email,
                                  @Field("password") String password,
                                  @Field("device_id") String device_id);

    @FormUrlEncoded
    @POST("users/updateProfil")
    Call<ResponseProfile> updateProfile(@Field("id_pegawai") String id_pegawai,
                                        @Field("no_telp") String no_telp,
                                        @Field("date") String date,
                                        @Field("jk") String jk,
                                        @Field("alamat") String alamat);

}
