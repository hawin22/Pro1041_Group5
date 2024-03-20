/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DbConnect.DBConnect1;
import Model.KhuyenMai;
import Model.Voucher;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author NGHIAPC
 */
public class ServiceImp implements ServiceInterface{
    
    ArrayList<Voucher> listVoucher = new ArrayList<>();
    ArrayList<KhuyenMai> listKhuyenMai = new ArrayList<>();
    
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
    
}
