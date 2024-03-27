/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.*;
import java.util.ArrayList;

/**
 *
 * @author NGHIAPC
 */
public interface ServiceInterface {
    ArrayList<KhachHang> getAllKhachHang();
    KhachHang getRowKhachHang(int row);
    ArrayList<Login> LoginSearch(String user, String pass);
    ArrayList<Login> FogotPassword(String user, String email);
    ArrayList<Voucher> getAllVoucher();
    ArrayList<KhuyenMai> getAllKhuyenMai();
    ArrayList<NguoiDung> getAllNhanVien();
    NguoiDung getRowNhanVien(int row);
    ArrayList<SanPham> getAllSanPham();
    ArrayList<NguoiDung> searchNguoiDung(String ma);
    ArrayList<NguoiDung> sapXepTheoMaNgDung();
    void addKhachHang(KhachHang kh);
    void updateKhachHang(KhachHang kh);
    void deleteKhachHang(String MaKhachHang);
    ArrayList<NguoiDung> searchNhanVien(String ma);
    ArrayList<NguoiDung> sapXepTheoMaNhVien();
    ArrayList<NguoiDung> sapXepTheoTenNhVien();
    ArrayList<NguoiDung> getAllNguoiDung();
    Boolean add(NguoiDung nd);
    ArrayList<Voucher> searchVoucher(String maVC);
    ArrayList<HoaDon> getAllHoaDon();
    ArrayList<HoaDonChiTiet> getAllHoaDonChiTiet();
    ArrayList<Voucher> sXMaVoucher();
    ArrayList<Voucher> sXTTTenVoucher();
    ArrayList<HoaDonChiTiet> getAllHoaDonChiTiet(String maHoaDon);
    ArrayList<LichSuGia> getAllLichSuGia();
    void update(NguoiDung nd);
    ArrayList<Voucher> tKTNVoucher(String ngayBD, String HanSD);
    ArrayList<KhuyenMai> tKTNKhuyenMai(String ngayBD, String HanSD);
};
