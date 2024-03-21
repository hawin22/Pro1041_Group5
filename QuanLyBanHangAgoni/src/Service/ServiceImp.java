/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.*;
import java.util.ArrayList;
import java.sql.*;
import DbConnect.*;

/**
 *
 * @author NGHIAPC
 */
public class ServiceImp implements ServiceInterface {
    
    ArrayList<Voucher> listVoucher = new ArrayList<>();
    ArrayList<KhuyenMai> listKhuyenMai = new ArrayList<>();
    ArrayList<NguoiDung> listNguoiDung = new ArrayList<>();
    ArrayList<SanPham> listSanPham = new ArrayList<>();
    ArrayList<KhachHang> listKhachHang = new ArrayList<>();
    ArrayList<Login> listLogin = new ArrayList<>();
    
    public ArrayList<KhachHang> getAllKhachHang() {
        String sql = "select * from KhachHang";
        listKhachHang.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSDT(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                listKhachHang.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listKhachHang;
    }
    
    @Override
    public ArrayList<Voucher> getAllVoucher() {
        String sql = "select * from Voucher";
        listVoucher.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Voucher vc = new Voucher();
                vc.setMaVoucher(rs.getString(1));
                vc.setTenVoucher(rs.getString(2));
                vc.setSoLuongVC(rs.getInt(3));
                vc.setHanSuDungVC(rs.getString(4));
                vc.setNgayBatDauVC(rs.getString(5));
                vc.setSoTienGiam(rs.getDouble(6));
                vc.setSoTienYeuCau(rs.getDouble(7));
                listVoucher.add(vc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listVoucher;
        
    }
    
    public ArrayList<Login> LoginSearch(String user, String pass) {
        String sql = "select TenDangNhap, MatKhau, Roles.TenRole, Email from NguoiDung \n"
                + "join Roles on NguoiDung.Roles = Roles.Marole\n"
                + "where NguoiDung.TenDangNhap = ? and MatKhau = ?";
        listLogin.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Login lg = new Login();
                lg.setUserName(rs.getString(1));
                lg.setPassword(rs.getString(2));
                lg.setEmail(rs.getString(4));
                lg.setRole(rs.getString(3));
                listLogin.add(lg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLogin;
    }
    
    public ArrayList<Login> FogotPassword(String user, String email) {
        String sql = "select TenDangNhap, MatKhau, Roles.TenRole, Email from NguoiDung \n"
                + "join Roles on NguoiDung.Roles = Roles.Marole\n"
                + "where NguoiDung.TenDangNhap = ? and Email = ?";
        listLogin.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, email);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                Login lg = new Login();
                lg.setUserName(rs.getString(1));
                lg.setPassword(rs.getString(2));
                lg.setEmail(rs.getString(4));
                lg.setRole(rs.getString(3));
                listLogin.add(lg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLogin;
    }
    
    @Override
    public ArrayList<KhuyenMai> getAllKhuyenMai() {
        listKhuyenMai.clear();
        String sql = "select KhuyenMai.MaKhuyenMai, TenKhuyenMai, SoLuong, NgayBatDau, HanSuDung, PTKhuyenMai, ChiTietKhuyenMai.MaSanPhamChiTiet from KhuyenMai\n"
                + "join ChiTietKhuyenMai on ChiTietKhuyenMai.MaKhuyenMai = KhuyenMai.MaKhuyenMai";
        try {
            Connection conn = DBConnect1.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString(1));
                km.setTenKM(rs.getString(2));
                km.setSoLuongKM(rs.getInt(3));
                km.setNgayBatDauKM(rs.getString(4));
                km.setHanSuDungKM(rs.getString(5));
                km.setGiamGia(rs.getDouble(6));
                km.setMaCTSP(rs.getString(7));
                listKhuyenMai.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhuyenMai;
    }
    
    @Override
    public ArrayList<NguoiDung> getAllNguoiDung() {
        String sql = "select * from NguoiDung where Roles like 'NV%'";
        listNguoiDung.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setTenNguoiDung(rs.getString(2));
                nd.setGioiTinh(rs.getBoolean(3));
                nd.setSDT(rs.getString(4));
                nd.setEmail(rs.getString(5));
                nd.setRoles(rs.getString(6));
                nd.setTenDN(rs.getString(7));
                nd.setPassWord(rs.getString(8));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }
    
    public ArrayList<SanPham> getAllSanPham() {
        listSanPham.clear();
        String sql = "select SanPham.MaSanPham, TenSanPham, TenNCC, GiaDau, SoLuong, MauSac, KichThuoc, Mau, ChatLieu, HinhAnh, Hang, MaKhuyenMai\n"
                + "from SanPham\n"
                + "join ChiTietSanPham on ChiTietSanPham.MaSanPham = SanPham.MaSanPham\n"
                + "join MauSac on MauSac.MaMauSac = ChiTietSanPham.MaMauSac\n"
                + "join KichThuoc on KichThuoc.MaKichThuoc = ChiTietSanPham.MaKichThuoc\n"
                + "join NhaCungCap on NhaCungCap.MaNCC = ChiTietSanPham.NCC\n"
                + "join LichSuDonGia on LichSuDonGia.MaDonGia = ChiTietSanPham.DonGia\n"
                + "join HinhAnh on HinhAnh.MaHinhAnh = ChiTietSanPham.MaHinhAnh\n"
                + "join ChiTietKhuyenMai on ChiTietKhuyenMai.MaSanPhamChiTiet = ChiTietSanPham.MaSanPhamChiTiet";
        try {
            Connection conn = DBConnect1.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setNhaCungCap(rs.getString(3));
                sp.setDonGia(rs.getDouble(4));
                sp.setSoLuongSP(rs.getInt(5));
                sp.setMauSac(rs.getString(6));
                sp.setKichThuoc(rs.getString(7));
                sp.setMau(rs.getString(8));
                sp.setChatLieu(rs.getString(9));
                sp.setHinhAnh(rs.getString(10));
                sp.setHang(rs.getString(11));
                sp.setMaSPKM(rs.getString(12));
                listSanPham.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
    @Override
    public NguoiDung getRowNguoiDung(int row) {
        return listNguoiDung.get(row);
        
    }
    
    @Override
    public ArrayList<NguoiDung> searchNguoiDung(String ma) {
        String sql = "select * from NguoiDung where MaNguoiDung like ?";
        listNguoiDung.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%"+ma+"%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setTenNguoiDung(rs.getString(2));
                nd.setGioiTinh(rs.getBoolean(3));
                nd.setSDT(rs.getString(4));
                nd.setEmail(rs.getString(5));
                nd.setRoles(rs.getString(6));
                nd.setTenDN(rs.getString(7));
                nd.setPassWord(rs.getString(8));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }

    @Override
    public ArrayList<NguoiDung> sapXepTheoMaNgDung() {
        String sql = "select * from NguoiDung where Roles like 'NV%' order by MaNguoiDung desc ";
        listNguoiDung.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setTenNguoiDung(rs.getString(2));
                nd.setGioiTinh(rs.getBoolean(3));
                nd.setSDT(rs.getString(4));
                nd.setEmail(rs.getString(5));
                nd.setRoles(rs.getString(6));
                nd.setTenDN(rs.getString(7));
                nd.setPassWord(rs.getString(8));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNguoiDung;
    }
    
}
