/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String maSP, tenSP, mau, hang, chatLieu, mauSac, kichThuoc, nhaCungCap, hinhAnh, maSPKM;
    private Double donGia;
    private Integer soLuongSP;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String mau, String hang, String chatLieu, String mauSac, String kichThuoc, String nhaCungCap, String hinhAnh, String maSPKM, Double donGia, Integer soLuongSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mau = mau;
        this.hang = hang;
        this.chatLieu = chatLieu;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.nhaCungCap = nhaCungCap;
        this.hinhAnh = hinhAnh;
        this.maSPKM = maSPKM;
        this.donGia = donGia;
        this.soLuongSP = soLuongSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMaSPKM() {
        return maSPKM;
    }

    public void setMaSPKM(String maSPKM) {
        this.maSPKM = maSPKM;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Integer getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(Integer soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    

    
    
    
    
}
