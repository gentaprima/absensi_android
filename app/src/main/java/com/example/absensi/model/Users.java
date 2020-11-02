package com.example.absensi.model;

public class Users {
    private String id_user;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String device_id;
    private String is_verified;
    private String full_name;
    private String jenis_kelamin;
    private String alamat;
    private String agama;
    private String foto;
    private String gaji;
    private String id_jabatan;
    private String id_shift;
    private String tgl_lahir;
    private String id_pegawai;
    private String nama_jabatan;

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public Users(String id_user, String email, String password, String role, String phone, String device_id, String is_verified, String full_name, String jenis_kelamin, String alamat, String agama, String foto, String gaji, String id_jabatan, String id_shift, String tgl_lahir,String id_pegawai,String nama_jabatan) {
        this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.device_id = device_id;
        this.is_verified = is_verified;
        this.full_name = full_name;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
        this.agama = agama;
        this.foto = foto;
        this.gaji = gaji;
        this.id_jabatan = id_jabatan;
        this.id_shift = id_shift;
        this.tgl_lahir = tgl_lahir;
        this.id_pegawai = id_pegawai;
        this.nama_jabatan = nama_jabatan;
    }

    public String getId_pegawai() {
        return id_pegawai;
    }

    public String getId_user() {
        return id_user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public String getDevice_id() {
        return device_id;
    }

    public String getNama_jabatan() {
        return nama_jabatan;
    }

    public String getIs_verified() {
        return is_verified;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getAgama() {
        return agama;
    }

    public String getFoto() {
        return foto;
    }

    public String getGaji() {
        return gaji;
    }

    public String getId_jabatan() {
        return id_jabatan;
    }

    public String getId_shift() {
        return id_shift;
    }
}
