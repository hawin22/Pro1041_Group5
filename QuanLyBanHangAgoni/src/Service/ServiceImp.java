/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DbConnect.DBConnect1;
import Model.KhuyenMai;
import Model.NguoiDung;
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
    ArrayList<NguoiDung> listNguoiDung = new ArrayList<>();

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

    @Override
    public NguoiDung getRowNguoiDung(int row) {
        return listNguoiDung.get(row);
    }

}
