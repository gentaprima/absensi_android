package com.example.absensi.network.api;


import com.example.absensi.model.MessageOnly;
import com.example.absensi.model.absensi.AbsensiResponse;
import com.example.absensi.model.laporan.DataLaporanResponse;
import com.example.absensi.model.login.ResponseLogin;
import com.example.absensi.model.profile.ResponseProfile;
import com.example.absensi.model.register.ResponseRegister;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("users/register")
    Call<ResponseRegister>  registerUser(@Field("full_name") String full_name,
                                         @Field("email") String email,
                                         @Field("phone") String phone,
                                         @Field("password") String password,
                                         @Field("imei") String imei,
                                         @Field("nik")String nik);

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

    @Multipart
    @POST("profile/updateImageProfile")
    Call<MessageOnly> updateImageProfile(@Part MultipartBody.Part image,
                                         @Part("id_users")RequestBody id_users);

    @FormUrlEncoded
    @POST("absensi/addAbsensi")
    Call<MessageOnly> addAbsensi(@Field("no_pegawai") String id_pegawai,
                                 @Field("time") String time);

    @FormUrlEncoded
    @POST("absensi/getDataAbsensiByIdUsers")
    Call<AbsensiResponse> getAbsensiHome(@Field("id_users") String id_users);

    @FormUrlEncoded
    @POST("absensi/getLaporanKehadiran")
    Call<DataLaporanResponse> getDataLaporan(@Field("id_users") String id_users);

}
