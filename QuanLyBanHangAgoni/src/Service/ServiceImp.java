/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DbConnect.DBConnect1;
import Model.KhuyenMai;
import Model.SanPham;
import Model.Voucher;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author NGHIAPC
 */
public class ServiceImp implements ServiceInterface {

    ArrayList<Voucher> listVoucher = new ArrayList<>();
    ArrayList<KhuyenMai> listKhuyenMai = new ArrayList<>();
    ArrayList<SanPham> listSanPham = new ArrayList<>();

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

}
