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
    ArrayList<NguoiDung> getAllNguoiDung();
    NguoiDung getRowNguoiDung(int row);
    ArrayList<SanPham> getAllSanPham();
    ArrayList<NguoiDung> searchNguoiDung(String ma);
    ArrayList<NguoiDung> sapXepTheoMaNgDung();
    ArrayList<NguoiDung> sapXepTheoTenNgDung();
}
