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
    ArrayList<HoaDonChiTiet> updateSoluongSanPhamBanHang(String maSanPham, Integer soLuong, String maHoaDon);
    ArrayList<HoaDonChiTiet> updateSoluongSanPhamBanHangTru(String maSanPham, Integer soLuong, String maHoaDon);
    HoaDon getRowHoaDon(int row);
    SanPham getRowSanPham(int row);
    //HoaDonChiTiet getRowHDCT(int row);
    String getMaSanPhamChiTietFromSanPham(String maSanPham);
    ArrayList<SanPham> updateSanPhamTruBanHang(String maSanPham, Integer soLuong);
    ArrayList<SanPham> updateSanPhamCongBanHang(String maSanPham, Integer soLuong);
    void updateNV(NguoiDung nd);
    ArrayList<NguoiDung> getAllQuanLy();
};
