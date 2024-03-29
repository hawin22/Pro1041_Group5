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
    ArrayList<HoaDonChiTiet> updateSoluongSanPhamBanHang(String maSanPham, Integer soLuong, String maHoaDon);
    HoaDon getRowHoaDon(int row);
    SanPham getRowSanPham(int row);
    //HoaDonChiTiet getRowHDCT(int row);
    String getMaSanPhamChiTietFromSanPham(String maSanPham);
    void update(NguoiDung nd);
  
    ArrayList<SanPham> getAllMauSac();
    ArrayList<SanPham> getAllKichThuoc();
    ArrayList<SanPham> getAllChatLieu();
    ArrayList<SanPham> getAllNCC();
    void addMauSacTTSP(SanPham s);
    void updateMauSacTTSP(SanPham s);
    void deleteMauSacTTSP(String ma);
    void addKichThuocTTSP(SanPham s);
    void updateKichThuocTTSP(SanPham s);
    void deleteKichThuocTTSP(String ma);
    void addChatLieuTTSP(SanPham s);
    void updateChatLieuTTSP(SanPham s);
    void deleteChatLieuTTSP(String ma);
    void addNCCTTSP(SanPham s);
    void updateNCCTTSP(SanPham s);
    void deleteNCCTTSP(String ma);
};
