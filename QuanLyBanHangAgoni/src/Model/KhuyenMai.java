/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class KhuyenMai {
    private String maKM, tenKM, ngayBatDau, hanSuDung;
    private Double giamGia;
    private Integer soLuongKM;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, String ngayBatDau, String hanSuDung, Double giamGia, Integer soLuongKM) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayBatDau = ngayBatDau;
        this.hanSuDung = hanSuDung;
        this.giamGia = giamGia;
        this.soLuongKM = soLuongKM;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(String hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public Double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Double giamGia) {
        this.giamGia = giamGia;
    }

    public Integer getSoLuongKM() {
        return soLuongKM;
    }

    public void setSoLuongKM(Integer soLuongKM) {
        this.soLuongKM = soLuongKM;
    }
    
    
    
    
}
