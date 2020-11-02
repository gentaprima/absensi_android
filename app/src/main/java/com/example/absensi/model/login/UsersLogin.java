package com.example.absensi.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersLogin {

    @SerializedName("id_users")
    @Expose
    private String idUsers;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("no_telp")
    @Expose
    private String noTelp;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("is_verified")
    @Expose
    private String isVerified;
    @SerializedName("users_id")
    @Expose
    private String usersId;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("agama")
    @Expose
    private String agama;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("gaji")
    @Expose
    private String gaji;
    @SerializedName("id_jabatan")
    @Expose
    private String idJabatan;
    @SerializedName("id_shift")
    @Expose
    private String idShift;

    @SerializedName("tgl_lahir")
    private String tgl_lahir;

    @SerializedName("no_pegawai")
    private String id_pegawai;

    @SerializedName("nama_jabatan")
    private String nama_jabatan;

    public UsersLogin(String idUsers, String namaLengkap, String email, String noTelp, String password, String deviceId, String role, String isVerified, String usersId, String jenisKelamin, String alamat, String agama, String foto, String gaji, String idJabatan, String idShift, String tgl_lahir,String id_pegawai, String nama_jabatan) {
        this.idUsers = idUsers;
        this.namaLengkap = namaLengkap;
        this.email = email;
        this.noTelp = noTelp;
        this.password = password;
        this.deviceId = deviceId;
        this.role = role;
        this.isVerified = isVerified;
        this.usersId = usersId;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.agama = agama;
        this.foto = foto;
        this.gaji = gaji;
        this.idJabatan = idJabatan;
        this.idShift = idShift;
        this.tgl_lahir = tgl_lahir;
        this.id_pegawai = id_pegawai;
        this.nama_jabatan = nama_jabatan;
    }

    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public String getIdShift() {
        return idShift;
    }

    public void setIdShift(String idShift) {
        this.idShift = idShift;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(String id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getNama_jabatan() {
        return nama_jabatan;
    }

    public void setNama_jabatan(String nama_jabatan) {
        this.nama_jabatan = nama_jabatan;
    }
}
