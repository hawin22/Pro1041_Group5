/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhuyenMai;
import Model.SanPham;
import Model.Voucher;
import java.util.ArrayList;

/**
 *
 * @author NGHIAPC
 */
public interface ServiceInterface {
    ArrayList<Voucher> getAllVoucher();
    ArrayList<KhuyenMai> getAllKhuyenMai();
    ArrayList<SanPham> getAllSanPham();
}
