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
    ArrayList<Login> LoginSearch(String user, String pass);
    ArrayList<Login> FogotPassword(String user, String email);
    ArrayList<Voucher> getAllVoucher();
    ArrayList<KhuyenMai> getAllKhuyenMai();
    ArrayList<NguoiDung> getAllNhanVien();
    NguoiDung getRowNhanVien(int row);
    ArrayList<SanPham> getAllSanPham();
    ArrayList<NguoiDung> searchNhanVien(String ma);
    ArrayList<NguoiDung> sapXepTheoMaNhVien();
    ArrayList<NguoiDung> sapXepTheoTenNhVien();
    ArrayList<NguoiDung> getAllNguoiDung();
    Boolean add(NguoiDung nd);
    ArrayList<Voucher> searchVoucher(String maVC);
    ArrayList<HoaDon> getAllHoaDon();
    ArrayList<HoaDonChiTiet> getAllHoaDonChiTiet(String maHoaDon);
    ArrayList<LichSuGia> getAllLichSuGia();
    ArrayList<HoaDonChiTiet> updateSoluongSanPhamBanHang(String maSanPham, Integer soLuong, String maHoaDon);
    HoaDon getRowHoaDon(int row);
    SanPham getRowSanPham(int row);
    //HoaDonChiTiet getRowHDCT(int row);
    String getMaSanPhamChiTietFromSanPham(String maSanPham);
};
