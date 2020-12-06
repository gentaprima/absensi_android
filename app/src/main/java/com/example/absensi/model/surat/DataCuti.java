package com.example.absensi.model.surat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataCuti {
    @SerializedName("id_cuti")
    @Expose
    private String idCuti;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("dari_tanggal")
    @Expose
    private String dariTanggal;
    @SerializedName("sampai_tanggal")
    @Expose
    private String sampaiTanggal;
    @SerializedName("jumlah_hari")
    @Expose
    private String jumlahHari;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("id_users")
    @Expose
    private String idUsers;
    @SerializedName("no_pegawai")
    @Expose
    private String noPegawai;
    @SerializedName("nik")
    @Expose
    private String nik;
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

    public String getIdCuti() {
        return idCuti;
    }

    public void setIdCuti(String idCuti) {
        this.idCuti = idCuti;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getDariTanggal() {
        return dariTanggal;
    }

    public void setDariTanggal(String dariTanggal) {
        this.dariTanggal = dariTanggal;
    }

    public String getSampaiTanggal() {
        return sampaiTanggal;
    }

    public void setSampaiTanggal(String sampaiTanggal) {
        this.sampaiTanggal = sampaiTanggal;
    }

    public String getJumlahHari() {
        return jumlahHari;
    }

    public void setJumlahHari(String jumlahHari) {
        this.jumlahHari = jumlahHari;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }

    public String getNoPegawai() {
        return noPegawai;
    }

    public void setNoPegawai(String noPegawai) {
        this.noPegawai = noPegawai;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
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
}
