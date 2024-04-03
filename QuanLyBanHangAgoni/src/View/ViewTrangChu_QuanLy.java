/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DbConnect.DBConnect1;
import Model.ChiTietHoaDon;
import Model.HoaDon;
import Model.HoaDonChiTiet;
import Model.NguoiDung;
import Model.KhuyenMai;
import Model.SanPham;
import Model.Voucher;
import Service.ServiceImp;
import Service.ServiceInterface;
import com.sun.jdi.connect.spi.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DecimalFormat;

/**
 *
 * @author NGHIAPC
 */
public class ViewTrangChu_QuanLy extends javax.swing.JFrame {

    /**
     * Creates new form ViewTrangChu
     */
    ServiceInterface ser = new ServiceImp();
    DefaultTableModel dtm;
    
    DecimalFormat df = new DecimalFormat("#");
    Double tongDoanhThu = ser.tongDoanhThuMD();
    String formattedResult = df.format(tongDoanhThu);
    ArrayList<HoaDon> listHoaDon = new ArrayList<>();

    public ViewTrangChu_QuanLy() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadDataVoucher(ser.getAllVoucher());
        loadDataNhanVien(ser.getAllNhanVien(true));
        loadDataKhuyenMai(ser.getAllKhuyenMai());
        loadDataSPKM(ser.getAllSanPham());
        loadDataKMChonSP(ser.getAllKhuyenMai());
        loadDataQuanLy(ser.getAllQuanLy());
        loadDataChiTietSP(ser.getAllSanPham());
        rdAllVoucher.setSelected(true);
         loadDaTaChiTietHD(ser.getALlCTHD());
        txtTongDonHang.setText(String.valueOf(ser.tongHoaDonMD()));
        txtTongDoanhThu.setText(formattedResult);
        txtTongDoanhSoBanHang.setText(String.valueOf(ser.tongDoanhSoMD()));
        lblThanhCong.setText(String.valueOf(ser.tongHoaDonThanhToan()));
        lblCTT.setText(String.valueOf(ser.tongHoaDonMD()-ser.tongHoaDonThanhToan()));
        loadDataNhanVienNghi(ser.getAllNhanVien(false));
        loadDataQuanLyHD(ser.getAllQuanLyHD());
        loadDataQuanLyHDHuy(ser.getAllQLHDHuy());
        rdAllVoucher.setSelected(true);

    }
    
    void loadDaTaChiTietHD(ArrayList<ChiTietHoaDon> list){
        dtm = (DefaultTableModel) tblChiTietHoaDon.getModel();
        dtm.setRowCount(0);
        for (ChiTietHoaDon cthd : list) {
            dtm.addRow(new Object[]{
                cthd.getMaHoaDon(),
                cthd.getNgayTao(),
                cthd.getTrangThai(),
                cthd.getMaVoucher(),
                cthd.getMaNhanVien(),
                cthd.getNgayHoanThanh(),
                cthd.getLoaiThanhToan(),
                cthd.getMaSanPhamChiTiet(),
                cthd.getSoLuong()
               
                
                
            });
        }
        
    }
    

    void loadDataVoucher(ArrayList<Voucher> list) {
        dtm = (DefaultTableModel) tblVoucher.getModel();
        dtm.setRowCount(0);
        for (Voucher voucher : list) {
            dtm.addRow(new Object[]{
                voucher.getMaVoucher(),
                voucher.getTenVoucher(),
                voucher.getSoLuongVC(),
                voucher.getHanSuDungVC(),
                voucher.getNgayBatDauVC(),
                voucher.getSoTienGiam(),
                voucher.getSoTienYeuCau()
            });
        }
    }
    

    Voucher getFormVoucher() {
        Voucher vc = new Voucher();
        vc.setMaVoucher(txtMaVoucher.getText());
        vc.setTenVoucher(txtTenVoucher.getText());
        if (txtSoLuongVoucher.getText() == "" || txtSoLuongVoucher.getText() == "0") {
            vc.setSoLuongVC(null);
        } else {
            vc.setSoLuongVC(Integer.parseInt(txtSoLuongVoucher.getText()));
        }
        vc.setNgayBatDauVC(txtNBatDauVoucher.getText());
        vc.setHanSuDungVC(txtNKetThucVoucher.getText());
        if (txtSoTienGiamVoucher.getText() == "" || txtSoTienGiamVoucher.getText() == "0") {
            vc.setSoTienGiam(null);
        } else {
            vc.setSoTienGiam(Double.parseDouble(txtSoTienGiamVoucher.getText()));
        }
        if (txtSoTienYCVoucher.getText() == "" || txtSoTienYCVoucher.getText() == "0") {
            vc.setSoTienYeuCau(null);
        } else {
            vc.setSoTienYeuCau(Double.parseDouble(txtSoTienYCVoucher.getText()));
        }
        return vc;
    }

    void setFormVoucher(Voucher vc) {
        txtMaVoucher.setText(vc.getMaVoucher());
        txtTenVoucher.setText(vc.getTenVoucher());
        if (vc.getSoLuongVC() == 0) {
            txtSoLuongVoucher.setText("0");
        } else {
            txtSoLuongVoucher.setText(String.valueOf(vc.getSoLuongVC()));
        }
        txtNBatDauVoucher.setText(vc.getNgayBatDauVC());
        txtNKetThucVoucher.setText(vc.getHanSuDungVC());
        if (vc.getSoTienGiam() == 0) {
            txtSoTienGiamVoucher.setText("0");
        } else {
            txtSoTienGiamVoucher.setText(String.valueOf(vc.getSoTienGiam()));
        }
        if (vc.getSoTienYeuCau() == 0) {
            txtSoTienYCVoucher.setText("0");
        } else {
            txtSoTienYCVoucher.setText(String.valueOf(vc.getSoTienYeuCau()));
        }
    }

    void loadDataNhanVien(ArrayList<NguoiDung> list) {
        dtm = (DefaultTableModel) tblNhanVien.getModel();
        dtm.setRowCount(0);
        for (NguoiDung nd : list) {
            dtm.addRow(new Object[]{
                nd.getMaNguoiDung(),
                nd.getTenNguoiDung(),
                nd.isGioiTinh() ? "Nam" : "Nữ",
                nd.getTuoi(),
                nd.getSDT(),
                nd.getEmail(),
                nd.getRoles(),
                nd.getTenDN(),
                nd.getPassWord(),
                nd.isTrangThai() ? "Đang hoạt động" : "Không hoạt động"
            });
        }
    }

    NguoiDung getFormNhanVien() {
        NguoiDung nd = new NguoiDung();
        nd.setMaNguoiDung(txtMaNV.getText());
        nd.setTenNguoiDung(txtTenNV.getText());
        boolean gioiTinh;
        if (rdNam.isSelected()) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        nd.setGioiTinh(gioiTinh);
        nd.setTuoi(Integer.valueOf(txtTuoi.getText()));
        nd.setSDT(txtSDT.getText());
        nd.setEmail(txtEmail.getText());
        nd.setRoles(lblRoles.getText());
        nd.setTenDN(txtTenDN.getText());
        nd.setPassWord(txtPassword.getText());
        return nd;
    }

    void setFormNhanVien(NguoiDung nd) {
        txtMaNV.setText(nd.getMaNguoiDung());
        txtTenNV.setText(nd.getTenNguoiDung());
        Boolean gioiTinh = nd.isGioiTinh();
        if (gioiTinh) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        txtTuoi.setText(nd.getTuoi() + "");
        txtSDT.setText(nd.getSDT());
        txtEmail.setText(nd.getEmail());
        lblRoles.setText(nd.getRoles());
        txtTenDN.setText(nd.getTenDN());
        txtPassword.setText(nd.getPassWord());
    }

    void loadDataKhuyenMai(ArrayList<KhuyenMai> list) {
        dtm = (DefaultTableModel) tblKhuyenMai.getModel();
        dtm.setRowCount(0);
        for (KhuyenMai khuyenMai : list) {
            dtm.addRow(new Object[]{
                khuyenMai.getMaKM(),
                khuyenMai.getTenKM(),
                khuyenMai.getSoLuongKM(),
                khuyenMai.getHanSuDungKM(),
                khuyenMai.getNgayBatDauKM(),
                khuyenMai.getGiamGia(),
                khuyenMai.getMaCTSP()
            });
        }
    }

    KhuyenMai getFormKhuyenMai() {
        KhuyenMai km = new KhuyenMai();
        km.setMaKM(txtMaKhuyenMai.getText());
        km.setTenKM(txtTenKhuyenMai.getText());
        if (txtSoLuongKhuyenMai.getText().equals("")) {
            km.setSoLuongKM(0);
        } else {
            km.setSoLuongKM(Integer.valueOf(txtSoLuongKhuyenMai.getText()));
        }
        km.setNgayBatDauKM(txtNBatDauKhuyenMai.getText());
        km.setHanSuDungKM(txtNKetThucKhuyenMai.getText());
        if (txtGiamGiaKhuyenMai.getText().equals("")) {
            km.setGiamGia(0.0);
        } else {
            km.setGiamGia(Double.parseDouble(txtGiamGiaKhuyenMai.getText()));
        }

        return km;
    }

    void setFormKhuyenMai(KhuyenMai km) {
        txtMaKhuyenMai.setText(km.getMaKM());
        txtTenKhuyenMai.setText(km.getTenKM());
        if (km.getSoLuongKM() == 0) {
            txtSoLuongKhuyenMai.setText("0");
        } else {
            txtSoLuongKhuyenMai.setText(String.valueOf(km.getSoLuongKM()));
        }
        txtNBatDauKhuyenMai.setText(km.getNgayBatDauKM());
        txtNKetThucKhuyenMai.setText(km.getHanSuDungKM());
        if (km.getGiamGia() == 0) {
            txtGiamGiaKhuyenMai.setText("0");
        } else {
            txtGiamGiaKhuyenMai.setText(String.valueOf(km.getGiamGia()));
        }
    }

    void loadDataSPKM(ArrayList<SanPham> list) {
        dtm = (DefaultTableModel) tblSPKM.getModel();
        dtm.setRowCount(0);
        for (SanPham sanPham : list) {
            dtm.addRow(new Object[]{
                sanPham.getMaSP(),
                sanPham.getTenSP(),
                sanPham.getMaSPKM()
            });
        }
    }

    void loadDataKMChonSP(ArrayList<KhuyenMai> list) {
        dtm = (DefaultTableModel) tblKMChonSP.getModel();
        dtm.setRowCount(0);
        for (KhuyenMai khuyenMai : list) {
            dtm.addRow(new Object[]{
                khuyenMai.getMaKM(),
                khuyenMai.getTenKM(),
                khuyenMai.getGiamGia()
            });
        }
    }

    void loadDataQuanLy(ArrayList<NguoiDung> list) {
        dtm = (DefaultTableModel) tblQuanLy.getModel();
        dtm.setRowCount(0);
        for (NguoiDung nd : list) {
            dtm.addRow(new Object[]{
                nd.getMaNguoiDung(),
                nd.getEmail(),
                nd.getRoles(),
                nd.getTenDN()
            });
        }
    }
    
    void loadDataChiTietSP(ArrayList<SanPham> list){
        dtm = (DefaultTableModel) tblThongTinChiTietSanPham.getModel();
        dtm.setRowCount(0);
        for(SanPham sp : list){
            dtm.addRow(new Object[]{
                sp.getMaSP(),sp.getSoLuongSP(),sp.getKichThuoc(),sp.getMauSac(),sp.getDonGia(),sp.getNhaCungCap(),sp.getChatLieu()
            });
        }
    }

    public boolean checkNhanVien() {
        int i = tblNhanVien.getSelectedRow();
        int count = 0;
        if (txtMaNV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã nhân viên");
            count++;
        }
        if (txtTenNV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên nhân viên");
            count++;
        }
        if (rdNam.isSelected() == false && rdNu.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Chưa chọn giới tính");
            count++;
        }
        if (txtTuoi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống tuổi");
            count++;
        }
        if (txtSDT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống số điện thoại");
            count++;
        }

        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống email");
            count++;
        }
        if (txtTenDN.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên đăng nhập");
            count++;
        }
        if (txtPassword.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống password");
            count++;
        }

        if (count > 0) {
            return false;
        } else {
            return true;

        }
    }

    public boolean checkTuoiNV() {
        try {
            int tuoi = Integer.parseInt(txtTuoi.getText());
            if (tuoi < 0) {
                JOptionPane.showMessageDialog(this, "Tuổi phải là số dương");
            } else if (tuoi < 18 || tuoi > 55) {
                JOptionPane.showMessageDialog(this, "Độ tuổi không nằm trong độ tuổi lao động");
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số");
            return false;
        }
    }

    public boolean checkEmailNV(String email) {
        String emailRegex = "[A-Za-z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }

    boolean emailNV() {
        if (checkEmailNV(txtEmail.getText())) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Sai định dạng email");
            return false;
        }
    }

    public boolean checkTrungMaNhanVien(String ma) {
        int count = 0;
        for (NguoiDung nd : ser.getAllNguoiDung()) {
            if (nd.getMaNguoiDung().equals(ma)) {
                count++;
            }
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(this, "Trùng mã");
            return false;
        } else {
            return true;
        }

    }

    public boolean checkTrungTenDNNhanVien(String ten) {
        int count = 0;
        for (NguoiDung nd : ser.getAllNguoiDung()) {
            if (nd.getTenDN().equals(ten)) {
                count++;
            }
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(this, "Trùng tên đăng nhập");
            return false;
        } else {
            return true;
        }

    }

    public boolean checkTrungEmailNhanVien(String email) {
        int count = 0;
        for (NguoiDung nd : ser.getAllNguoiDung()) {
            if (nd.getEmail().equals(email)) {
                count++;
            }
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(this, "Trùng email");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkTrungEmailTenDNNhanVien(String maNV, String email, String tenDN) {
        ArrayList<NguoiDung> listEmailTenDN = ser.getAllNguoiDung();
        for (int i = 0; i < listEmailTenDN.size(); i++) {
            if (listEmailTenDN.get(i).getMaNguoiDung().equals(maNV)) {
                listEmailTenDN.remove(i);
            }
        }
        int count = 0;
        for (NguoiDung nd : listEmailTenDN) {
            if (nd.getEmail().equals(email)) {
                count++;
                JOptionPane.showMessageDialog(this, "Email này đã tồn tại");
            }
            if (nd.getTenDN().equals(tenDN)) {
                count++;
                JOptionPane.showMessageDialog(this, "Tên đăng nhập này đã tồn tại");
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    void loadDataNhanVienNghi(ArrayList<NguoiDung> list) {
        dtm = (DefaultTableModel) tblNhanVienNghi.getModel();
        dtm.setRowCount(0);
        for (NguoiDung nd : list) {
            dtm.addRow(new Object[]{
                nd.getMaNguoiDung(),
                nd.getTenNguoiDung(),
                nd.isGioiTinh() ? "Nam" : "Nữ",
                nd.getTuoi(),
                nd.getSDT(),
                nd.getEmail(),
                nd.getRoles(),
                nd.getTenDN(),
                nd.getPassWord(),
                nd.isTrangThai() ? "Đang hoạt động" : "Không hoạt động"
            });
        }
    }

    double tinhTongTienTheoHoaDon(String maHoaDon) {
        double tinhTien = 0.0;
        for (HoaDonChiTiet hdct : ser.getAllHoaDonChiTiet(maHoaDon)) {
            tinhTien += hdct.getDonGiaSau() * hdct.getSoLuong();
        }
        return tinhTien;
    }

    void loadDataQuanLyHD(ArrayList<HoaDon> list) {
        dtm = (DefaultTableModel) tblQLHoaDon.getModel();
        dtm.setRowCount(0);
        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{
                hd.getMaHoaDon(),
                hd.getNgayTao(),
                hd.getTrangThai(),
                hd.getMaVoucher(),
                hd.getMaNhanVien(),
                hd.getNgayHoanThanh(),
                hd.getLoaiThanhToan(),
                hd.getMaKhachHang(),
                tinhTongTienTheoHoaDon(hd.getMaHoaDon())
            });
        }
    }

    void loadDataQuanLyHDHuy(ArrayList<HoaDon> list) {
        dtm = (DefaultTableModel) tblQLHoaDonHuy.getModel();
        dtm.setRowCount(0);
        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{
                hd.getMaHoaDon(),
                hd.getNgayTao(),
                hd.getTrangThai(),
                hd.getMaVoucher(),
                hd.getMaNhanVien(),
                "null",
                hd.getLoaiThanhToan(),
                hd.getMaKhachHang(),
                tinhTongTienTheoHoaDon(hd.getMaHoaDon())
            });
        }
    }

    void loadDataQLHDSP(ArrayList<SanPham> list) {
        dtm = (DefaultTableModel) tblQLSanPham.getModel();
        dtm.setRowCount(0);
        for (SanPham sp : list) {
            dtm.addRow(new Object[]{
                sp.getTenSP(),
                sp.getChatLieu(),
                sp.getKichThuoc(),
                sp.getMauSac(),
                sp.getMau(),
                sp.getHang(),
                sp.getSoLuongSP(),
                sp.getDonGia(),
                sp.getSoLuongSP() * sp.getDonGia()
            });

        }
    }

    void loadDataQLHDSPHuy(ArrayList<SanPham> list) {
        dtm = (DefaultTableModel) tblSanPhamHuy.getModel();
        dtm.setRowCount(0);
        for (SanPham sp : list) {
            dtm.addRow(new Object[]{
                sp.getTenSP(),
                sp.getChatLieu(),
                sp.getKichThuoc(),
                sp.getMauSac(),
                sp.getMau(),
                sp.getHang(),
                sp.getSoLuongSP(),
                sp.getDonGia(),
                sp.getSoLuongSP() * sp.getDonGia()
            });

        }
    }

    public LocalDate getLocaldate() {
        return LocalDate.now();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jPanel33 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTKVoucher = new javax.swing.JTextField();
        rdSXTMaVoucher = new javax.swing.JRadioButton();
        rdSXTTenVoucher = new javax.swing.JRadioButton();
        rdSXTNgayVoucher = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtNKetThucVoucher = new javax.swing.JTextField();
        txtNBatDauVoucher = new javax.swing.JTextField();
        txtSoLuongVoucher = new javax.swing.JTextField();
        txtTenVoucher = new javax.swing.JTextField();
        txtMaVoucher = new javax.swing.JTextField();
        btnThemVoucher = new javax.swing.JButton();
        btnSuaVoucher = new javax.swing.JButton();
        btnXoaVoucher = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtSoTienYCVoucher = new javax.swing.JTextField();
        txtSoTienGiamVoucher = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        rdAllVoucher = new javax.swing.JRadioButton();
        jLabel66 = new javax.swing.JLabel();
        txtTKNKTVoucher = new javax.swing.JTextField();
        txtTKNBDVoucher = new javax.swing.JTextField();
        btnTKTNVoucher = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtTKKhuyenMai = new javax.swing.JTextField();
        rdSXTMaKhuyenMai = new javax.swing.JRadioButton();
        rdSXTTenKhuyenMai = new javax.swing.JRadioButton();
        rdSXTNgayKhuyenMai = new javax.swing.JRadioButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        btnThemKhuyenMai = new javax.swing.JButton();
        tbnSuaKhuyenMai = new javax.swing.JButton();
        btnXoaKhuyenMai = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        txtTenKhuyenMai = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtSoLuongKhuyenMai = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtNBatDauKhuyenMai = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtNKetThucKhuyenMai = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtGiamGiaKhuyenMai = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        rdAllKhuyenMai = new javax.swing.JRadioButton();
        jLabel65 = new javax.swing.JLabel();
        txtTKNBDKhuyenMai = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtTKNKTKhuyeMai = new javax.swing.JTextField();
        tbnTKTKNKM = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        txtTKMaSPKhuyenMai = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtMaSPThemKM = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblSPKM = new javax.swing.JTable();
        tbnThemSPKM = new javax.swing.JButton();
        tbnXoaSPKM = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblKMChonSP = new javax.swing.JTable();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txtTenKMChonSP = new javax.swing.JTextField();
        txtGiamGiaKMChonSP = new javax.swing.JTextField();
        txtMaKMChonSP = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel32 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnHienThiNV = new javax.swing.JButton();
        btnSearchNV = new javax.swing.JButton();
        txtSearchNV = new javax.swing.JTextField();
        rdTheoMaNV = new javax.swing.JRadioButton();
        rdTheoTenNV = new javax.swing.JRadioButton();
        rdTheoTuoiNhanVien = new javax.swing.JRadioButton();
        btnAddNhanVien = new javax.swing.JButton();
        btnUpdateNhanVien = new javax.swing.JButton();
        btnDeleteNhanVien = new javax.swing.JButton();
        btnNewNhanVien = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblQuanLy = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        lblRoles = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblNhanVienNghi = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        btnHienThiNVNghi = new javax.swing.JButton();
        btnSearchNVNghi = new javax.swing.JButton();
        txtSearchNVNghi = new javax.swing.JTextField();
        rdTheoMaNVNghi = new javax.swing.JRadioButton();
        rdTheoTenNVNghi = new javax.swing.JRadioButton();
        rdTheoTuoiNhanVienNghi = new javax.swing.JRadioButton();
        btnKhoiPhuc = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnSearchHD = new javax.swing.JButton();
        btnHienThiHD = new javax.swing.JButton();
        txtSearchHD = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblQLSanPham = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblQLHoaDon = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        txtBatDauHD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtKetThucHD = new javax.swing.JTextField();
        btnLocHD = new javax.swing.JButton();
        btnBoLocHD = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnSearchHuy = new javax.swing.JButton();
        btnHienThiHuy = new javax.swing.JButton();
        txtSearchHuy = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        txtBatDauHuy = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtKetThucHuy = new javax.swing.JTextField();
        btnLocHuy = new javax.swing.JButton();
        btnBoLocHuy = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblQLHoaDonHuy = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSanPhamHuy = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jPanel26 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        txtTKUuDai1 = new javax.swing.JTextField();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTongDoanhThu = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtTongDoanhSoBanHang = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtTongDonHang = new javax.swing.JTextField();
        lblThanhCong = new javax.swing.JLabel();
        lblCTT = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNgayKetThuc = new javax.swing.JTextField();
        txtNgayBatDau = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnHienThiBCTK = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblThongTinChiTietSanPham = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblThongTinChiTietSanPham1 = new javax.swing.JTable();
        jLabel75 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTabbedPane2.setForeground(new java.awt.Color(51, 153, 255));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTabbedPane5.setForeground(new java.awt.Color(51, 153, 255));
        jTabbedPane5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel2.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("Voucher");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tìm kiếm voucher");

        txtTKVoucher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTKVoucherKeyReleased(evt);
            }
        });

        buttonGroup2.add(rdSXTMaVoucher);
        rdSXTMaVoucher.setText("Sắp xếp theo mã");
        rdSXTMaVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSXTMaVoucherActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdSXTTenVoucher);
        rdSXTTenVoucher.setText("Sắp xếp theo tên");

        buttonGroup2.add(rdSXTNgayVoucher);
        rdSXTNgayVoucher.setText("Sắp xếp theo ngày tạo");

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã voucher", "Tên voucher", "Số lượng", "Ngày bắt đầu", "Ngày hết hạn", "Số tiền giảm", "Số tiền yêu cầu"
            }
        ));
        tblVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVoucher);

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setText("Thông tin voucher");

        jLabel48.setText("Mã voucher");

        jLabel49.setText("Tên voucher");

        jLabel50.setText("Số lượng");

        jLabel51.setText("Ngày bắt đầu");

        jLabel52.setText("Ngày hết hạn");

        btnThemVoucher.setBackground(new java.awt.Color(51, 153, 255));
        btnThemVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnThemVoucher.setText("Thêm");
        btnThemVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVoucherActionPerformed(evt);
            }
        });

        btnSuaVoucher.setBackground(new java.awt.Color(51, 153, 255));
        btnSuaVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaVoucher.setText("Sửa");
        btnSuaVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaVoucherActionPerformed(evt);
            }
        });

        btnXoaVoucher.setBackground(new java.awt.Color(51, 153, 255));
        btnXoaVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaVoucher.setText("Xoá");
        btnXoaVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaVoucherActionPerformed(evt);
            }
        });

        jLabel53.setText("Số tiền giảm");

        jLabel54.setText("Số tiền yêu cầu");

        jLabel64.setText("Tìm kiếm ngày bắt đầu");

        buttonGroup2.add(rdAllVoucher);
        rdAllVoucher.setText("Tất cả");
        rdAllVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAllVoucherActionPerformed(evt);
            }
        });

        jLabel66.setText("Tìm kiếm ngày kết thúc");

        btnTKTNVoucher.setBackground(new java.awt.Color(51, 153, 255));
        btnTKTNVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTKTNVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnTKTNVoucher.setText("Tìm kiếm theo ngày");
        btnTKTNVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKTNVoucherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel47)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel52)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50)
                            .addComponent(jLabel49)
                            .addComponent(jLabel48)
                            .addComponent(jLabel54)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSoTienYCVoucher, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenVoucher, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuongVoucher, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTKVoucher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(txtNKetThucVoucher, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNBatDauVoucher, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaVoucher)
                            .addComponent(txtSoTienGiamVoucher))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdSXTMaVoucher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdSXTTenVoucher)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnThemVoucher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuaVoucher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoaVoucher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdSXTNgayVoucher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdAllVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel64))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTKNKTVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTKNBDVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTKTNVoucher)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTKVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdSXTMaVoucher)
                    .addComponent(rdSXTTenVoucher)
                    .addComponent(rdSXTNgayVoucher)
                    .addComponent(rdAllVoucher))
                .addGap(18, 18, 18)
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtMaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemVoucher)
                    .addComponent(jLabel64)
                    .addComponent(txtTKNBDVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtTenVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaVoucher)
                    .addComponent(jLabel66)
                    .addComponent(txtTKNKTVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtSoLuongVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaVoucher)
                    .addComponent(btnTKTNVoucher))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtNBatDauVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtNKetThucVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtSoTienGiamVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtSoTienYCVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Voucher", jPanel2);

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 153, 255));
        jLabel55.setText("Khuyến mãi");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel56.setText("Tìm kiếm khuyến mãi");

        buttonGroup5.add(rdSXTMaKhuyenMai);
        rdSXTMaKhuyenMai.setText("Sắp xếp theo mã");

        buttonGroup5.add(rdSXTTenKhuyenMai);
        rdSXTTenKhuyenMai.setText("Sắp xếp theo tên");

        buttonGroup5.add(rdSXTNgayKhuyenMai);
        rdSXTNgayKhuyenMai.setText("Sắp xếp theo ngày tạo");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setText("Thông tin khuyến mãi");

        jLabel58.setText("Mã voucher");

        btnThemKhuyenMai.setBackground(new java.awt.Color(51, 153, 255));
        btnThemKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKhuyenMai.setText("Thêm");

        tbnSuaKhuyenMai.setBackground(new java.awt.Color(51, 153, 255));
        tbnSuaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbnSuaKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        tbnSuaKhuyenMai.setText("Sửa");

        btnXoaKhuyenMai.setBackground(new java.awt.Color(51, 153, 255));
        btnXoaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaKhuyenMai.setText("Xoá");

        jLabel59.setText("Tên voucher");

        jLabel60.setText("Số lượng");

        jLabel61.setText("Ngày bắt đầu");

        jLabel62.setText("Ngày hết hạn");

        jLabel63.setText("Giảm giá(%)");

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Số lượng", "Ngày bắt đầu", "Ngày hết hạn", "Giảm giá(%)", "Mã sản phẩm"
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblKhuyenMai);

        buttonGroup5.add(rdAllKhuyenMai);
        rdAllKhuyenMai.setText("Tất cả");

        jLabel65.setText("Tìm kiếm theo ngày đầu");

        jLabel67.setText("Tìm kiếm ngày kết thúc");

        tbnTKTKNKM.setBackground(new java.awt.Color(51, 153, 255));
        tbnTKTKNKM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbnTKTKNKM.setForeground(new java.awt.Color(255, 255, 255));
        tbnTKTKNKM.setText("Tìm kiếm theo khoảng ngày");
        tbnTKTKNKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnTKTKNKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(jLabel57)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(jLabel62)
                            .addComponent(jLabel61)
                            .addComponent(jLabel60)
                            .addComponent(jLabel59)
                            .addComponent(jLabel58)
                            .addComponent(jLabel63))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuongKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTKKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(txtNKetThucKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNBatDauKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaKhuyenMai)
                            .addComponent(txtGiamGiaKhuyenMai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdSXTMaKhuyenMai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdSXTTenKhuyenMai)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnThemKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tbnSuaKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoaKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(rdSXTNgayKhuyenMai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdAllKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67)
                                    .addComponent(jLabel65))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTKNKTKhuyeMai, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTKNBDKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbnTKTKNKM)))))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 1273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtTKKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdSXTMaKhuyenMai)
                    .addComponent(rdSXTTenKhuyenMai)
                    .addComponent(rdSXTNgayKhuyenMai)
                    .addComponent(rdAllKhuyenMai))
                .addGap(18, 18, 18)
                .addComponent(jLabel57)
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemKhuyenMai))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbnSuaKhuyenMai)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(txtTKNBDKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(txtTKNKTKhuyeMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtSoLuongKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKhuyenMai)
                    .addComponent(tbnTKTKNKM))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(txtNBatDauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(txtNKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(txtGiamGiaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Khuyến mãi", jPanel30);

        jLabel68.setText("Tìm kiếm sản phẩm");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(51, 153, 255));
        jLabel69.setText("Thông tin sản phẩm");

        jLabel70.setText("Mã sản phẩm");

        jLabel71.setText("Trạng thái");

        jCheckBox1.setText("Thêm khuyến mãi vào sản phẩm");

        tblSPKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Trạng thái"
            }
        ));
        jScrollPane15.setViewportView(tblSPKM);

        tbnThemSPKM.setBackground(new java.awt.Color(51, 153, 255));
        tbnThemSPKM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbnThemSPKM.setForeground(new java.awt.Color(255, 255, 255));
        tbnThemSPKM.setText("Thêm");

        tbnXoaSPKM.setBackground(new java.awt.Color(51, 153, 255));
        tbnXoaSPKM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbnXoaSPKM.setForeground(new java.awt.Color(255, 255, 255));
        tbnXoaSPKM.setText("Xoá");

        tblKMChonSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Giảm giá(%)"
            }
        ));
        jScrollPane16.setViewportView(tblKMChonSP);

        jLabel72.setText("Mã khuyến mãi");

        jLabel73.setText("Tên khuyến mãi");

        jLabel74.setText("Giảm giá(%)");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTKMaSPKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSPThemKM, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(132, 132, 132)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbnXoaSPKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tbnThemSPKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(135, 135, 135)
                        .addComponent(jLabel72)
                        .addGap(629, 629, 629))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel70)
                                    .addComponent(jLabel71))
                                .addGap(50, 50, 50)
                                .addComponent(jCheckBox1)
                                .addGap(346, 346, 346)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel74))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenKMChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiamGiaKMChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKMChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(txtTKMaSPKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbnThemSPKM)
                            .addComponent(jLabel72)
                            .addComponent(txtMaKMChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(txtMaSPThemKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbnXoaSPKM)
                            .addComponent(jLabel73)
                            .addComponent(txtTenKMChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(jCheckBox1)
                            .addComponent(jLabel74)
                            .addComponent(txtGiamGiaKMChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(380, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Chọn sản phẩm khuyến mãi", jPanel31);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        jTabbedPane2.addTab("Quản lý ưu đãi", jPanel5);

        jTabbedPane6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 255));
        jLabel8.setText("Thông tin nhân viên");

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnHienThiNV.setBackground(new java.awt.Color(51, 153, 255));
        btnHienThiNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHienThiNV.setForeground(new java.awt.Color(255, 255, 255));
        btnHienThiNV.setText("Hiển thị");
        btnHienThiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiNVActionPerformed(evt);
            }
        });

        btnSearchNV.setBackground(new java.awt.Color(51, 153, 255));
        btnSearchNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchNV.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-interface-symbol.png"))); // NOI18N
        btnSearchNV.setText("Tìm kiếm ");
        btnSearchNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchNVActionPerformed(evt);
            }
        });

        txtSearchNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtSearchNVMouseReleased(evt);
            }
        });
        txtSearchNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNVKeyReleased(evt);
            }
        });

        buttonGroup3.add(rdTheoMaNV);
        rdTheoMaNV.setText("Sắp xếp theo mã");
        rdTheoMaNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTheoMaNVMouseClicked(evt);
            }
        });

        buttonGroup3.add(rdTheoTenNV);
        rdTheoTenNV.setText("Sắp xếp theo tên");
        rdTheoTenNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTheoTenNVMouseClicked(evt);
            }
        });

        buttonGroup3.add(rdTheoTuoiNhanVien);
        rdTheoTuoiNhanVien.setText("Sắp xếp theo tuổi");
        rdTheoTuoiNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTheoTuoiNhanVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienThiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(btnSearchNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchNV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(rdTheoMaNV)
                        .addGap(112, 112, 112)
                        .addComponent(rdTheoTenNV)
                        .addGap(112, 112, 112)
                        .addComponent(rdTheoTuoiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHienThiNV, btnSearchNV});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchNV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdTheoMaNV)
                    .addComponent(rdTheoTenNV)
                    .addComponent(btnSearchNV)
                    .addComponent(rdTheoTuoiNhanVien))
                .addGap(18, 18, 18)
                .addComponent(btnHienThiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHienThiNV, btnSearchNV});

        btnAddNhanVien.setBackground(new java.awt.Color(51, 153, 255));
        btnAddNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNhanVien.setText("Add");
        btnAddNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNhanVienActionPerformed(evt);
            }
        });

        btnUpdateNhanVien.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdateNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateNhanVien.setText("Update");
        btnUpdateNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNhanVienActionPerformed(evt);
            }
        });

        btnDeleteNhanVien.setBackground(new java.awt.Color(51, 153, 255));
        btnDeleteNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteNhanVien.setText("Delete");
        btnDeleteNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNhanVienActionPerformed(evt);
            }
        });

        btnNewNhanVien.setBackground(new java.awt.Color(51, 153, 255));
        btnNewNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNewNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNewNhanVien.setText("New");
        btnNewNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewNhanVienActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "Tuổi", "Số điện thoại", "Email", "Roles", "Tên đăng nhập", "Password", "Trạng thái"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblNhanVien);

        tblQuanLy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã quản lý", "Email", "Roles", "Tên đăng nhập"
            }
        ));
        jScrollPane17.setViewportView(tblQuanLy);

        jLabel16.setText("Roles");

        lblRoles.setText("NV");

        jLabel9.setText("Mã nhân viên");

        jLabel29.setText("Tuổi");

        jLabel12.setText("Tên nhân viên");

        jLabel14.setText("Số điện thoại");

        jLabel17.setText("Tên đăng nhập");

        jLabel15.setText("Giới tính");

        buttonGroup4.add(rdNam);
        rdNam.setText("Nam");

        buttonGroup4.add(rdNu);
        rdNu.setText("Nữ");

        jLabel18.setText("Password");

        jLabel13.setText("Email");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(btnAddNhanVien)
                                .addGap(180, 180, 180)
                                .addComponent(btnUpdateNhanVien)
                                .addGap(180, 180, 180)
                                .addComponent(btnDeleteNhanVien)
                                .addGap(183, 183, 183)
                                .addComponent(btnNewNhanVien))
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNV)
                            .addComponent(txtTuoi)
                            .addComponent(lblRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addComponent(rdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64)
                                        .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(519, 519, 519))
        );

        jPanel32Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddNhanVien, btnDeleteNhanVien, btnNewNhanVien, btnUpdateNhanVien});

        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel8)
                .addGap(44, 44, 44)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel14)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lblRoles)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(rdNam)
                            .addComponent(rdNu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateNhanVien)
                    .addComponent(btnAddNhanVien)
                    .addComponent(btnDeleteNhanVien)
                    .addComponent(btnNewNhanVien))
                .addGap(39, 39, 39)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        jPanel32Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddNhanVien, btnDeleteNhanVien, btnNewNhanVien, btnUpdateNhanVien});

        jPanel32Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane17, jScrollPane9});

        jTabbedPane6.addTab("Danh sách nhân viên", jPanel32);

        tblNhanVienNghi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "Tuổi", "Số điện thoại", "Email", "Roles", "Tên đăng nhập", "Password", "Trạng thái"
            }
        ));
        jScrollPane18.setViewportView(tblNhanVienNghi);

        jPanel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnHienThiNVNghi.setBackground(new java.awt.Color(51, 153, 255));
        btnHienThiNVNghi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHienThiNVNghi.setForeground(new java.awt.Color(255, 255, 255));
        btnHienThiNVNghi.setText("Hiển thị");
        btnHienThiNVNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiNVNghiActionPerformed(evt);
            }
        });

        btnSearchNVNghi.setBackground(new java.awt.Color(51, 153, 255));
        btnSearchNVNghi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchNVNghi.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchNVNghi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-interface-symbol.png"))); // NOI18N
        btnSearchNVNghi.setText("Tìm kiếm ");
        btnSearchNVNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchNVNghiActionPerformed(evt);
            }
        });

        txtSearchNVNghi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtSearchNVNghiMouseReleased(evt);
            }
        });
        txtSearchNVNghi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNVNghiKeyReleased(evt);
            }
        });

        buttonGroup3.add(rdTheoMaNVNghi);
        rdTheoMaNVNghi.setText("Sắp xếp theo mã");
        rdTheoMaNVNghi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTheoMaNVNghiMouseClicked(evt);
            }
        });

        buttonGroup3.add(rdTheoTenNVNghi);
        rdTheoTenNVNghi.setText("Sắp xếp theo tên");
        rdTheoTenNVNghi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTheoTenNVNghiMouseClicked(evt);
            }
        });

        buttonGroup3.add(rdTheoTuoiNhanVienNghi);
        rdTheoTuoiNhanVienNghi.setText("Sắp xếp theo tuổi");
        rdTheoTuoiNhanVienNghi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTheoTuoiNhanVienNghiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienThiNVNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(btnSearchNVNghi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchNVNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(rdTheoMaNVNghi)
                        .addGap(112, 112, 112)
                        .addComponent(rdTheoTenNVNghi)
                        .addGap(112, 112, 112)
                        .addComponent(rdTheoTuoiNhanVienNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchNVNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdTheoMaNVNghi)
                    .addComponent(rdTheoTenNVNghi)
                    .addComponent(btnSearchNVNghi)
                    .addComponent(rdTheoTuoiNhanVienNghi))
                .addGap(18, 18, 18)
                .addComponent(btnHienThiNVNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        btnKhoiPhuc.setBackground(new java.awt.Color(51, 153, 255));
        btnKhoiPhuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhoiPhuc.setForeground(new java.awt.Color(255, 255, 255));
        btnKhoiPhuc.setText("Khôi phục");
        btnKhoiPhuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnKhoiPhuc))
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(221, 221, 221))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btnKhoiPhuc)))
                .addContainerGap(342, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Danh sách nhân viên đã nghỉ", jPanel34);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 139, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản lý nhân viên", jPanel10);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSearchHD.setBackground(new java.awt.Color(51, 153, 255));
        btnSearchHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchHD.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-interface-symbol.png"))); // NOI18N
        btnSearchHD.setText("Tìm kiếm ");
        btnSearchHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHDActionPerformed(evt);
            }
        });

        btnHienThiHD.setBackground(new java.awt.Color(51, 153, 255));
        btnHienThiHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHienThiHD.setForeground(new java.awt.Color(255, 255, 255));
        btnHienThiHD.setText("Hiển thị");
        btnHienThiHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienThiHD, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnSearchHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHienThiHD, btnSearchHD});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchHD))
                .addGap(18, 18, 18)
                .addComponent(btnHienThiHD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHienThiHD, btnSearchHD});

        tblQLSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sản phẩm", "Chất liệu", "Kích thước", "Màu sắc", "Mẫu", "Hãng", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane6.setViewportView(tblQLSanPham);

        tblQLHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Ngày tạo", "Trạng thái", "Mã voucher", "Mã nhân viên", "Ngày hoàn thành", "Loại thanh toán", "Mã khách hàng", "Tổng tiền"
            }
        ));
        tblQLHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLHoaDonMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblQLHoaDon);

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Bắt đầu");

        jLabel11.setText("Kết thúc");

        btnLocHD.setBackground(new java.awt.Color(51, 153, 255));
        btnLocHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLocHD.setForeground(new java.awt.Color(255, 255, 255));
        btnLocHD.setText("Lọc");
        btnLocHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocHDActionPerformed(evt);
            }
        });

        btnBoLocHD.setBackground(new java.awt.Color(51, 153, 255));
        btnBoLocHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBoLocHD.setForeground(new java.awt.Color(255, 255, 255));
        btnBoLocHD.setText("Bỏ lọc");
        btnBoLocHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoLocHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBatDauHD, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKetThucHD, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnLocHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btnBoLocHD)
                .addGap(47, 47, 47))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBoLocHD, btnLocHD});

        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBatDauHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(23, 23, 23)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtKetThucHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLocHD)
                    .addComponent(btnBoLocHD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách hoá đơn", jPanel3);

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSearchHuy.setBackground(new java.awt.Color(51, 153, 255));
        btnSearchHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-interface-symbol.png"))); // NOI18N
        btnSearchHuy.setText("Tìm kiếm ");
        btnSearchHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHuyActionPerformed(evt);
            }
        });

        btnHienThiHuy.setBackground(new java.awt.Color(51, 153, 255));
        btnHienThiHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHienThiHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHienThiHuy.setText("Hiển thị");
        btnHienThiHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienThiHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnSearchHuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHienThiHuy, btnSearchHuy});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchHuy))
                .addGap(18, 18, 18)
                .addComponent(btnHienThiHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHienThiHuy, btnSearchHuy});

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Bắt đầu");

        jLabel7.setText("Kết thúc");

        btnLocHuy.setBackground(new java.awt.Color(51, 153, 255));
        btnLocHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLocHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnLocHuy.setText("Lọc");
        btnLocHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocHuyActionPerformed(evt);
            }
        });

        btnBoLocHuy.setBackground(new java.awt.Color(51, 153, 255));
        btnBoLocHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBoLocHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnBoLocHuy.setText("Bỏ lọc");
        btnBoLocHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoLocHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBatDauHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKetThucHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnLocHuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(btnBoLocHuy)
                .addGap(47, 47, 47))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBoLocHuy, btnLocHuy});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBatDauHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtKetThucHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLocHuy)
                    .addComponent(btnBoLocHuy))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tblQLHoaDonHuy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Ngày tạo", "Trạng thái", "Mã voucher", "Mã nhân viên", "Ngày hoàn thành", "Loại thanh toán", "Mã khách hàng", "Tổng tiền"
            }
        ));
        tblQLHoaDonHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLHoaDonHuyMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblQLHoaDonHuy);

        tblSanPhamHuy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sản phẩm", "Chất liệu", "Kích thước", "Màu sắc", "Mẫu", "Hãng", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane8.setViewportView(tblSanPhamHuy);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách hoá đơn đã huỷ", jPanel4);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản lý hoá đơn", jPanel6);

        jTabbedPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane4.setForeground(new java.awt.Color(0, 51, 255));
        jTabbedPane4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 153, 255));
        jLabel31.setText("Thông tin sản phẩm");

        jPanel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("Mã sản phẩm:");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setText("Tên sản phẩm:");

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Hình ảnh");
        jLabel34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Tên nhà cung cấp:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Đơn giá:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setText("Số lượng:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Màu sắc:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Kích thước:");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Mẫu:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setText("Chất liệu:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel32)
                                .addComponent(jLabel33)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setText("Tìm kiếm sản phẩm");

        jRadioButton4.setText("Sắp xếp theo mã");

        jRadioButton5.setText("Sắp xếp theo tên");

        jRadioButton6.setText("Sắp xếp theo ngày tạo");

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Tên NCC", "Đơn giá", "Số lượng", "Màu sắc", "Kích thước", "Mẫu", "Chất liệu", "Hình ảnh"
            }
        ));
        jScrollPane12.setViewportView(jTable7);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(txtTKUuDai1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton6)
                .addGap(101, 101, 101))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtTKUuDai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 153, 255));
        jLabel43.setText("Quản lý sản phẩm");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Thông tin chi tiết", jPanel24);

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 153, 255));
        jLabel44.setText("Thuộc tính sản phẩm");

        jPanel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setText("Tên thuộc tính:");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jRadioButton7.setText("Màu sắc");

        jRadioButton8.setText("Kích thước");

        jRadioButton9.setText("Mẫu");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        jRadioButton10.setText("Chất liệu");
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });

        jButton4.setText("Add");

        jButton5.setText("Update");

        jButton6.setText("Remove");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Loại thuộc tính", "Tên thuộc tính"
            }
        ));
        jScrollPane13.setViewportView(jTable8);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 153, 255));
        jLabel46.setText("Thông tin thuộc tính");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel44))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel46)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Thuộc tính sản phẩm", jPanel27);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 447, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản lý sản phẩm", jPanel9);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel11.setBackground(new java.awt.Color(255, 153, 153));

        jLabel5.setText("Tổng Doanh Thu");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(204, 255, 204));

        jLabel20.setText("Tổng Doanh Số Bán");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel20))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtTongDoanhSoBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongDoanhSoBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(153, 153, 255));
        jPanel19.setForeground(new java.awt.Color(255, 255, 255));

        jLabel24.setText("Tổng đơn hàng");

        jLabel25.setText("Đã TT");

        jLabel26.setText("Chưa TT");

        lblThanhCong.setText("jLabel21");

        lblCTT.setText("jLabel22");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24)
                                .addComponent(txtTongDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25))
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblThanhCong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCTT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblThanhCong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCTT))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel4.setText("Ngày Bắt Đầu");

        jLabel19.setText("Ngày Kết Thúc");

        btnTimKiem.setText("TiemKiem");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnHienThiBCTK.setBackground(new java.awt.Color(51, 51, 255));
        btnHienThiBCTK.setForeground(new java.awt.Color(255, 255, 255));
        btnHienThiBCTK.setText("Hiển Thị");
        btnHienThiBCTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiBCTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnHienThiBCTK, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnTimKiem))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel19))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnHienThiBCTK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblThongTinChiTietSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "SốLuong", "MãKhíchthước", "Mã màu sắc", "Đơngia", "NCC", "Chất liệu"
            }
        ));
        jScrollPane11.setViewportView(tblThongTinChiTietSanPham);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Thông tin chi tiết sản phẩm");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel30))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 161, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Sản phẩm", jPanel22);

        jLabel21.setText("Chi Tiết Hoá Đơn");

        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaHoaDon", "NgayTao", "TrangThai", "MaVourcher", "MNV", "NgayHoanThanh", "LoaiThanhToan", "MaSanPhamChiTiet", "soLuong"
            }
        ));
        jScrollPane10.setViewportView(tblChiTietHoaDon);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel21)
                .addContainerGap(421, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Chi tiết hoá đơn", jPanel18);

        jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        jTabbedPane6.addTab("Doanh thu", jPanel32);

        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblThongTinChiTietSanPham1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "SốLuong", "MãKhíchthước", "Mã màu sắc", "Đơngia", "NCC", "Chất liệu"
            }
        ));
        jScrollPane18.setViewportView(tblThongTinChiTietSanPham1);

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel75.setText("Thông tin chi tiết sản phẩm");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel75))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel75)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addGap(0, 161, Short.MAX_VALUE)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane6.addTab("Sản phẩm", jPanel33);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane3)
                    .addComponent(jTabbedPane6)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Báo cáo thống kê", jPanel8);

        jLabel1.setFont(new java.awt.Font("Segoe WP SemiLight", 3, 48)); // NOI18N
        jLabel1.setText("Đì dai by Nhóm Năm");

        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 153, 204));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(287, 287, 287))
        );

        jTabbedPane2.addTab("?", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBoLocHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoLocHuyActionPerformed
        // TODO add your handling code here:
        loadDataQuanLyHDHuy(ser.getAllQLHDHuy());
    }//GEN-LAST:event_btnBoLocHuyActionPerformed

    private void btnSearchHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHuyActionPerformed
        // TODO add your handling code here:
        listHoaDon.clear();
        String searchHuy = txtSearchHuy.getText();
        listHoaDon = ser.searchQLHuy(searchHuy);
//        System.out.println(listSearchHuy);
//        System.out.println(searchHD);
        if (searchHuy.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hoá đơn");
        } else {
            if (listHoaDon.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tồn tại hoá đơn này");
//                System.out.println(listSearchHD.get(0).getMaHoaDon());

            } else {
                loadDataQuanLyHDHuy(listHoaDon);

                loadDataQLHDSPHuy(ser.getAllQuanLyHDSP(searchHuy));
            }
        }
    }//GEN-LAST:event_btnSearchHuyActionPerformed

    private void btnSearchHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHDActionPerformed
        // TODO add your handling code here:
        String searchHD = txtSearchHD.getText();
        ArrayList<HoaDon> listSearchHD = ser.searchQLHD(searchHD);
        System.out.println(listSearchHD);
//        System.out.println(searchHD);
        if (searchHD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hoá đơn");
        } else {
            if (listSearchHD.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tồn tại hoá đơn này");
//                System.out.println(listSearchHD.get(0).getMaHoaDon());

            } else {
                loadDataQuanLyHD(ser.searchQLHD(searchHD));
                loadDataQLHDSP(ser.getAllQuanLyHDSP(searchHD));
            }
        }
    }//GEN-LAST:event_btnSearchHDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        ViewDangNhap viewDN = new ViewDangNhap();
        this.setVisible(false);
        viewDN.setVisible(true);
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked
        // TODO add your handling code here:
        int row = tblVoucher.getSelectedRow();
        if (row >= 0) {
            setFormVoucher(ser.getAllVoucher().get(row));
        }
    }//GEN-LAST:event_tblVoucherMouseClicked

    private void txtTKVoucherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTKVoucherKeyReleased
        // TODO add your handling code here:
        String search = txtTKVoucher.getText();
        rdAllVoucher.setSelected(false);
        if (search.isEmpty()) {
            loadDataVoucher(ser.getAllVoucher());
        } else {
            loadDataVoucher(ser.searchVoucher(search));
        }
    }//GEN-LAST:event_txtTKVoucherKeyReleased

    private void rdAllVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAllVoucherActionPerformed
        // TODO add your handling code here:
        loadDataVoucher(ser.getAllVoucher());
        txtTKVoucher.setText("");
    }//GEN-LAST:event_rdAllVoucherActionPerformed

    private void rdSXTMaVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSXTMaVoucherActionPerformed
        // TODO add your handling code here:
        loadDataVoucher(ser.sXMaVoucher());
        txtTKVoucher.setText("");
    }//GEN-LAST:event_rdSXTMaVoucherActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không");
        int count = 0;
        if (check == JOptionPane.YES_OPTION) {
            if (!checkNhanVien())
            {
                count++;
            }
            if (!checkTrungMaNhanVien(txtMaNV.getText())) {
                count++;
            }
            if (!emailNV()) {
                count++;
            }
            if (!checkTrungEmailNhanVien(txtEmail.getText())) {
                count++;
            }
            if (!checkTrungTenDNNhanVien(txtTenDN.getText())) {
                count++;
            }
            if (count == 0) {
                ser.add(getFormNhanVien());
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loadDataNhanVien(ser.getAllNhanVien());

            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:


    }//GEN-LAST:event_formWindowActivated

    private void tblQLHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblQLHoaDon.getSelectedRow();
        listHoaDon.clear();
        listHoaDon = ser.getAllQuanLyHD();
        if (row >= 0) {
            String maHoaDon = listHoaDon.get(row).getMaHoaDon();
            System.out.println(maHoaDon);
            loadDataQLHDSP(ser.getAllQuanLyHDSP(maHoaDon));
        }

    }//GEN-LAST:event_tblQLHoaDonMouseClicked

    private void btnAddNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNhanVienActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không");
        int count = 0, dem = 0;
        if (check == JOptionPane.YES_OPTION) {
            if (!checkNhanVien()) {
                count++;
                dem++;
            }
            if (dem == 0) {

                if (!checkTrungMaNhanVien(txtMaNV.getText())) {
                    count++;
                }
                if (!checkTuoiNV()) {
                    count++;
                }
                if (!emailNV()) {
                    count++;
                }
                if (!checkTrungEmailNhanVien(txtEmail.getText())) {
                    count++;
                }
                if (!checkTrungTenDNNhanVien(txtTenDN.getText())) {
                    count++;
                }
                if (count == 0) {
                    NguoiDung nd = getFormNhanVien();                              
                    ser.updateNV(nd);
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    loadDataNhanVien(ser.getAllNhanVien());
            }

            if (count == 0) {
//                System.out.println("tgkjggf");
                ser.addNhanVien(getFormNhanVien());
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loadDataNhanVien(ser.getAllNhanVien(true));
            } else {

                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }

        }
    }//GEN-LAST:event_btnAddNhanVienActionPerformed

    private void btnUpdateNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNhanVienActionPerformed
        // TODO add your handling code here:
        int count = 0, dem = 0;
        int i = tblNhanVien.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng");
        } else {
            int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không");
            if (check == JOptionPane.YES_OPTION) {
                if (!checkNhanVien()) {
                    count++;
                    dem++;
                }
                if (dem == 0) {
                    if (!checkTuoiNV()) {
                        count++;
                    }
                    if (!emailNV()) {
                        count++;
                    }

                    if (!checkTrungEmailTenDNNhanVien(txtMaNV.getText(), txtEmail.getText(), txtTenDN.getText())) {
                        count++;
                    }
                    if (count == 0) {
                        NguoiDung nd = getFormNhanVien();
                        boolean checkTrung = true;
                        for (NguoiDung nv : ser.getAllNhanVien(true)) {
                            if (nd == nv) {
                                checkTrung = true;
                                return;
                            } else {
                                checkTrung = false;
                            }
                        }
                        if (checkTrung == true) {
                            JOptionPane.showMessageDialog(this, "Chưa thay đổi dữ liệu");
                        } else {
                            ser.updateNV(nd);

                            JOptionPane.showMessageDialog(this, "Sửa thành công");
                            loadDataNhanVien(ser.getAllNhanVien(true));

                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }

                }
            }
        }
    }//GEN-LAST:event_btnUpdateNhanVienActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        int i = tblNhanVien.getSelectedRow();
        if (i >= 0) {
            setFormNhanVien(ser.getRowNhanVien(true, i));
            txtMaNV.setEnabled(false);
            //       ser.getRowNhanVien(i).inInf();

        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnDeleteNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNhanVienActionPerformed
        // TODO add your handling code here:
        int i = tblNhanVien.getSelectedRow();
        String maNhanVien = ser.getRowNhanVien(true, i).getMaNguoiDung();
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng để xoá");
        } else {
            int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không");
            if (check == JOptionPane.YES_OPTION) {

                // boolean trangThaiFalse = false;
                JOptionPane.showMessageDialog(this, ser.updateTrangThaiNhanVien(false, maNhanVien));

                loadDataNhanVien(ser.getAllNhanVien(true));
                loadDataNhanVienNghi(ser.getAllNhanVien(false));
            } else {
                JOptionPane.showMessageDialog(this, "Xoá thất bại");
            }
        }
    }//GEN-LAST:event_btnDeleteNhanVienActionPerformed

    private void btnNewNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewNhanVienActionPerformed
        // TODO add your handling code here:
        txtMaNV.setEnabled(true);
        setFormNhanVien(new NguoiDung(" ", " ", true, 0, " ", " ", "NV", " ", " ", true));
        txtTuoi.setText("");
        buttonGroup4.clearSelection();
    }//GEN-LAST:event_btnNewNhanVienActionPerformed

    private void rdTheoTuoiNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTheoTuoiNhanVienMouseClicked
        // TODO add your handling code here:
        loadDataNhanVien(ser.sapXepTheoTuoiNV());
    }//GEN-LAST:event_rdTheoTuoiNhanVienMouseClicked

    private void rdTheoTenNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTheoTenNVMouseClicked
        // TODO add your handling code here:
        loadDataNhanVien(ser.sapXepTheoTenNhVien());
    }//GEN-LAST:event_rdTheoTenNVMouseClicked

    private void rdTheoMaNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTheoMaNVMouseClicked
        // TODO add your handling code here:
        loadDataNhanVien(ser.sapXepTheoMaNhVien());
    }//GEN-LAST:event_rdTheoMaNVMouseClicked

    private void txtSearchNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNVKeyReleased
        // TODO add your handling code here:
        //        String searchNV = txtSearchNV.getText();
        //        ArrayList<NguoiDung> listSearchNV = ser.searchNguoiDung(searchNV);
        //        if (searchNV.isEmpty()) {
        //            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hoặc tên");
        //        } else {
        //            if (listSearchNV.isEmpty()) {
        //                JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên này");
        //                txtSearchNV.setText("");
        //                txtMaNV.setText("");
        //                txtTenNV.setText("");
        //                buttonGroup4.clearSelection();
        //                txtSDT.setText("");
        //                txtEmail.setText("");
        //                txtRoles.setText("");
        //                txtTenDN.setText("");
        //                txtPassword.setText("");
        //            } else {
        //                loadDataNguoiDung(ser.searchNguoiDung(searchNV));
        //            }
        //        }
    }//GEN-LAST:event_txtSearchNVKeyReleased

    private void txtSearchNVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchNVMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchNVMouseReleased

    private void btnSearchNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchNVActionPerformed
        // TODO add your handling code here:
        String searchNV = txtSearchNV.getText();
        String searchTen = txtSearchNV.getText();
        ArrayList<NguoiDung> listSearchNV = ser.searchNhanVien(searchNV, searchTen);
        if (searchNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã");
        } else {
            if (listSearchNV.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên này");
                txtSearchNV.setText("");
                txtMaNV.setText("");
                txtTenNV.setText("");
                buttonGroup4.clearSelection();
                txtSDT.setText("");
                txtEmail.setText("");
                lblRoles.setText("");
                txtTenDN.setText("");
                txtPassword.setText("");
            } else {
                loadDataNhanVien(ser.searchNhanVien(searchNV, searchTen));
            }
        }
    }//GEN-LAST:event_btnSearchNVActionPerformed

    private void btnHienThiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiNVActionPerformed
        // TODO add your handling code here:
        loadDataNhanVien(ser.getAllNhanVien(true));
    }//GEN-LAST:event_btnHienThiNVActionPerformed

    private void btnHienThiNVNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiNVNghiActionPerformed
        // TODO add your handling code here:
        loadDataNhanVienNghi(ser.getAllNhanVien(false));
    }//GEN-LAST:event_btnHienThiNVNghiActionPerformed

    private void btnSearchNVNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchNVNghiActionPerformed
        // TODO add your handling code here:
        String searchNV = txtSearchNVNghi.getText();
        String searchTen = txtSearchNVNghi.getText();
        ArrayList<NguoiDung> listSearchNVNghi = ser.searchNhanVienNghi(searchNV, searchTen);
        if (searchNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã");
        } else {
            if (listSearchNVNghi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên này");
                txtSearchNVNghi.setText("");
            } else {
                loadDataNhanVienNghi(ser.searchNhanVienNghi(searchNV, searchTen));
            }
        }

    }//GEN-LAST:event_btnSearchNVNghiActionPerformed

    private void txtSearchNVNghiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchNVNghiMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchNVNghiMouseReleased

    private void txtSearchNVNghiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNVNghiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchNVNghiKeyReleased

    private void rdTheoMaNVNghiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTheoMaNVNghiMouseClicked
        // TODO add your handling code here:
        loadDataNhanVienNghi(ser.sapXepTheoMaNhVienNghi());
    }//GEN-LAST:event_rdTheoMaNVNghiMouseClicked

    private void rdTheoTenNVNghiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTheoTenNVNghiMouseClicked
        // TODO add your handling code here:
        loadDataNhanVienNghi(ser.sapXepTheoTenNhVienNghi());

    }//GEN-LAST:event_rdTheoTenNVNghiMouseClicked

    private void rdTheoTuoiNhanVienNghiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTheoTuoiNhanVienNghiMouseClicked
        // TODO add your handling code here:
        loadDataNhanVienNghi(ser.sapXepTheoTuoiNVNghi());
    }//GEN-LAST:event_rdTheoTuoiNhanVienNghiMouseClicked

    private void btnKhoiPhucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucActionPerformed
        // TODO add your handling code here:
        int i = tblNhanVienNghi.getSelectedRow();
        String maNV = ser.getRowNhanVien(false, i).getMaNguoiDung();
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng");
        } else {
            int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn khôi phục nhân viên không");
            if (check == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, ser.updateTrangThaiNhanVien(true, maNV));
                loadDataNhanVienNghi(ser.getAllNhanVien(false));
                loadDataNhanVien(ser.getAllNhanVien(true));
            }
        }
    }//GEN-LAST:event_btnKhoiPhucActionPerformed

    private void tblQLHoaDonHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLHoaDonHuyMouseClicked
        // TODO add your handling code here:
        int row = tblQLHoaDonHuy.getSelectedRow();
        listHoaDon.clear();
        listHoaDon = ser.getAllQLHDHuy();
        if (row >= 0) {
            String maHoaDon = listHoaDon.get(row).getMaHoaDon();
            System.out.println(maHoaDon);
            loadDataQLHDSPHuy(ser.getAllQuanLyHDSP(maHoaDon));
        }
    }//GEN-LAST:event_tblQLHoaDonHuyMouseClicked
    private void btnTKTNVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKTNVoucherActionPerformed
        // TODO add your handling code here:
        String ngayBD = txtTKNBDVoucher.getText();
        String hanSD = txtTKNKTVoucher.getText();
        loadDataVoucher(ser.tKTNVoucher(ngayBD, hanSD));
        Voucher vc = new Voucher("", "", "", "", 0, 0.0, 0.0);
        setFormVoucher(vc);
        txtSoLuongVoucher.setText("");
        txtSoTienGiamVoucher.setText("");
        txtSoTienYCVoucher.setText("");
    }//GEN-LAST:event_btnTKTNVoucherActionPerformed

    private void tbnTKTKNKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnTKTKNKMActionPerformed
        // TODO add your handling code here:
        String ngayBD = txtTKNBDKhuyenMai.getText();
        String hanSD = txtTKNKTKhuyeMai.getText();
        loadDataKhuyenMai(ser.tKTNKhuyenMai(ngayBD, hanSD));
        setFormKhuyenMai(new KhuyenMai("", "", "", "", "", 0.0, 0));
        txtSoLuongKhuyenMai.setText("");
        txtGiamGiaKhuyenMai.setText("");
    }//GEN-LAST:event_tbnTKTKNKMActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        // TODO add your handling code here:
        int row = tblKhuyenMai.getSelectedRow();
        if (row >= 0) {
            setFormKhuyenMai(ser.getAllKhuyenMai().get(row));
        }
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnThemVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVoucherActionPerformed
        int row = tblVoucher.getSelectedRow();
        if (row >= 0) {
            ser.addVoucher(getFormVoucher());
            loadDataVoucher(ser.getAllVoucher());
        }

    }//GEN-LAST:event_btnThemVoucherActionPerformed

    private void btnXoaVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaVoucherActionPerformed
        int row = tblVoucher.getSelectedRow();
        if (row >= 0) {
            String mavc = txtMaVoucher.getText();
            ser.deleteVoucher(mavc);
            loadDataVoucher(ser.getAllVoucher());
        }
    }//GEN-LAST:event_btnXoaVoucherActionPerformed

    private void btnSuaVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaVoucherActionPerformed
        int row = tblVoucher.getSelectedRow();
        if (row >= 0) {
            ser.updateVoucher(getFormVoucher());
            loadDataVoucher(ser.getAllVoucher());
        }
    }//GEN-LAST:event_btnSuaVoucherActionPerformed

    private void btnHienThiHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiHDActionPerformed
        // TODO add your handling code here:
        loadDataQuanLyHD(ser.getAllQuanLyHD());
    }//GEN-LAST:event_btnHienThiHDActionPerformed

    private void btnHienThiHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiHuyActionPerformed
        // TODO add your handling code here:
        loadDataQuanLyHDHuy(ser.getAllQLHDHuy());
    }//GEN-LAST:event_btnHienThiHuyActionPerformed

    private void btnLocHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocHuyActionPerformed
        // TODO add your handling code here:
        int count = 0;
        String ngayBD = txtBatDauHuy.getText();
        String ngayKT = txtKetThucHuy.getText();

        if (ngayBD.isEmpty()) {
            JOptionPane.showMessageDialog(this, " Vui lòng nhập ngày bắt đầu");
            count++;
        }
        if (ngayKT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày kết thúc");
            count++;
        }

        if (count == 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            try {
                Date date1 = sdf.parse(ngayBD);
                System.out.println(ngayBD);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu không đúng định dạng");
//                return;
            }
            try {
                Date date2 = sdf.parse(ngayKT);
                System.out.println(ngayKT);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc không đúng định dạng");
//                return;
            }
            ArrayList<HoaDon> listLocHDHuy = ser.locHDHuyTheoNgay(ngayBD, ngayKT);
            if (listLocHDHuy.isEmpty()) {
                JOptionPane.showMessageDialog(this, " Không tìm thấy hoá đơn");
                txtBatDauHD.setText(" ");
                txtKetThucHD.setText(" ");
                ArrayList<HoaDon> listHD = new ArrayList<>();
                loadDataQuanLyHDHuy(listHD);
            } else {
                loadDataQuanLyHDHuy(ser.locHDHuyTheoNgay(ngayBD, ngayKT));
            }
        }

    }//GEN-LAST:event_btnLocHuyActionPerformed

    private void btnLocHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocHDActionPerformed
        // TODO add your handling code here:
        int count = 0;
        String ngayBD = txtBatDauHD.getText();
        String ngayKT = txtKetThucHD.getText();

        if (ngayBD.isEmpty()) {
            JOptionPane.showMessageDialog(this, " Vui lòng nhập ngày bắt đầu");
            count++;
        }
        if (ngayKT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày kết thúc");
            count++;
        }
        if (count == 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date1 = sdf.parse(ngayBD);
                System.out.println(ngayBD);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu không đúng định dạng");
//                return;
            }
            try {
                Date date2 = sdf.parse(ngayKT);
                System.out.println(ngayKT);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc không đúng định dạng");
//                return;
            }
            ArrayList<HoaDon> listLocHD = ser.locHDTheoNgay(ngayBD, ngayKT);
            if (listLocHD.isEmpty()) {
                JOptionPane.showMessageDialog(this, " Không tìm thấy hoá đơn");
                txtBatDauHD.setText(" ");
                txtKetThucHD.setText(" ");
                ArrayList<HoaDon> listHD = new ArrayList<>();
                loadDataQuanLyHD(listHD);
            } else {
                loadDataQuanLyHD(ser.locHDTheoNgay(ngayBD, ngayKT));
            }
        }
    }//GEN-LAST:event_btnLocHDActionPerformed

    private void btnBoLocHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoLocHDActionPerformed
        // TODO add your handling code here:
        loadDataQuanLyHD(ser.getAllQuanLyHD());
    }//GEN-LAST:event_btnBoLocHDActionPerformed

<<<<<<< HEAD
    private void txtSearchNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchNVFocusGained
        // TODO add your handling code here:
        if (txtSearchNV.getText().equals("Nhập mã hoặc tên nhân viên")) {
            txtSearchNV.setText("");
            txtSearchNV.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchNVFocusGained

    private void txtSearchNVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchNVFocusLost
        // TODO add your handling code here:
        if (txtSearchNV.getText().equals("")) {
            txtSearchNV.setText("Nhập mã hoặc tên nhân viên");
            txtSearchNV.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchNVFocusLost

    private void txtSearchNVNghiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchNVNghiFocusGained
        // TODO add your handling code here:
        if (txtSearchNVNghi.getText().equals("Nhập mã hoặc tên nhân viên")) {
            txtSearchNVNghi.setText("");
            txtSearchNVNghi.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchNVNghiFocusGained

    private void txtSearchNVNghiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchNVNghiFocusLost
        // TODO add your handling code here:
         if (txtSearchNV.getText().equals("")) {
            txtSearchNV.setText("Nhập mã hoặc tên nhân viên");
            txtSearchNV.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchNVNghiFocusLost

    private void txtSearchHDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchHDFocusGained
        // TODO add your handling code here:
        if (txtSearchHD.getText().equals("Nhập mã hoá đơn cần tìm")) {
            txtSearchHD.setText("");
            txtSearchHD.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchHDFocusGained

    private void txtSearchHDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchHDFocusLost
        // TODO add your handling code here:
        if (txtSearchHD.getText().equals("")) {
            txtSearchHD.setText("Nhập mã hoá đơn cần tìm");
            txtSearchHD.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchHDFocusLost

    private void txtSearchHuyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchHuyFocusGained
        // TODO add your handling code here:
        if (txtSearchHuy.getText().equals("Nhập mã hoá đơn cần tìm")) {
            txtSearchHuy.setText("");
            txtSearchHuy.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchHuyFocusGained

    private void txtSearchHuyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchHuyFocusLost
        // TODO add your handling code here:
        if (txtSearchHuy.getText().equals("")) {
            txtSearchHuy.setText("Nhập mã hoá đơn cần tìm");
            txtSearchHuy.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchHuyFocusLost

    private void txtBatDauHDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBatDauHDFocusGained
        // TODO add your handling code here:
        if (txtBatDauHD.getText().equals("dd-mm-yyyy")) {
            txtBatDauHD.setText("");
            txtBatDauHD.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtBatDauHDFocusGained

    private void txtBatDauHDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBatDauHDFocusLost
        // TODO add your handling code here:
         if (txtBatDauHD.getText().equals("")) {
            txtBatDauHD.setText("dd-mm-yyyy");
            txtBatDauHD.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtBatDauHDFocusLost

    private void txtKetThucHDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKetThucHDFocusGained
        // TODO add your handling code here:
         if (txtKetThucHD.getText().equals("dd-mm-yyyy")) {
            txtKetThucHD.setText("");
            txtKetThucHD.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtKetThucHDFocusGained

    private void txtKetThucHDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKetThucHDFocusLost
        // TODO add your handling code here:
         if (txtKetThucHD.getText().equals("")) {
            txtKetThucHD.setText("dd-mm-yyyy");
            txtKetThucHD.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtKetThucHDFocusLost

    private void txtBatDauHuyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBatDauHuyFocusGained
        // TODO add your handling code here:
          if (txtBatDauHuy.getText().equals("dd-mm-yyyy")) {
            txtBatDauHuy.setText("");
            txtBatDauHuy.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtBatDauHuyFocusGained

    private void txtBatDauHuyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBatDauHuyFocusLost
        // TODO add your handling code here:
        if (txtBatDauHuy.getText().equals("")) {
            txtBatDauHuy.setText("dd-mm-yyyy");
            txtBatDauHuy.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtBatDauHuyFocusLost

    private void txtKetThucHuyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKetThucHuyFocusGained
        // TODO add your handling code here:
        if (txtKetThucHuy.getText().equals("dd-mm-yyyy")) {
            txtKetThucHuy.setText("");
            txtKetThucHuy.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtKetThucHuyFocusGained

    private void txtKetThucHuyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKetThucHuyFocusLost
        // TODO add your handling code here:
         if (txtKetThucHuy.getText().equals("")) {
            txtKetThucHuy.setText("dd-mm-yyyy");
            txtKetThucHuy.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtKetThucHuyFocusLost

  private boolean isValidDate(String date) {
    return date.matches("\\d{4}-\\d{2}-\\d{2}");
}
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
     String ngayBatDau = txtNgayBatDau.getText();
    String NgayKetThuc = txtNgayKetThuc.getText();
    
    if (!isValidDate(ngayBatDau) || !isValidDate(NgayKetThuc)) {
        JOptionPane.showMessageDialog(this, "Ngày bắt đầu hoặc ngày kết thúc không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    int tongDonHang = ser.tonghoadon(ngayBatDau, NgayKetThuc);
    double tongDoanhThu = ser.tongDoanhThu(ngayBatDau, NgayKetThuc);
    int tongDoanhSoBanHang = ser.tongDoanhSo(ngayBatDau, NgayKetThuc);
    
    if (tongDonHang == 0 && tongDoanhThu == 0 && tongDoanhSoBanHang == 0) {
        JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    } else {
        txtTongDonHang.setText(String.valueOf(tongDonHang));
        txtTongDoanhThu.setText(String.valueOf(tongDoanhThu));
        txtTongDoanhSoBanHang.setText(String.valueOf(tongDoanhSoBanHang));
         lblThanhCong.setText(String.valueOf(ser.tongHoaDonThanhToan()));
        lblCTT.setText(String.valueOf(tongDonHang - ser.tongHoaDonThanhToan()));
    }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnHienThiBCTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiBCTKActionPerformed
        txtTongDonHang.setText(String.valueOf(ser.tongHoaDonMD()));
        txtTongDoanhThu.setText(String.valueOf(ser.tongDoanhThuMD()));
        txtTongDoanhSoBanHang.setText(String.valueOf(ser.tongDoanhSoMD()));
        lblThanhCong.setText(String.valueOf(ser.tongHoaDonThanhToan()));
        lblCTT.setText(String.valueOf(ser.tongHoaDonMD()-ser.tongHoaDonThanhToan()));
    }//GEN-LAST:event_btnHienThiBCTKActionPerformed

    

    // Các phần khác của lớp
=======
>>>>>>> parent of d5e60a7 (jj)
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        JFrame frame = new JFrame("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JLabel label = new JLabel("Tìm kiếm trên Google hoặc nhập một URL");
//        JTextField textField = new JTextField();
//        JButton button = new JButton("Tìm kiếm");
//
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Viết code xử lý chức năng tìm kiếm
//            }
//        });
//
//        frame.add(label);
//        frame.add(textField);
//        frame.add(button);
//
//        frame.setSize(400, 300);
//        frame.setVisible(true);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTrangChu_QuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNhanVien;
    private javax.swing.JButton btnBoLocHD;
    private javax.swing.JButton btnBoLocHuy;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHienThi;
    private javax.swing.JButton btnHienThiBCTK;
    private javax.swing.JButton btnDeleteNhanVien;
    private javax.swing.JButton btnHienThiHD;
    private javax.swing.JButton btnHienThiHuy;
    private javax.swing.JButton btnHienThiNV;
    private javax.swing.JButton btnHienThiNVNghi;
    private javax.swing.JButton btnKhoiPhuc;
    private javax.swing.JButton btnLocHD;
    private javax.swing.JButton btnLocHuy;
    private javax.swing.JButton btnNewNhanVien;
    private javax.swing.JButton btnSearchHD;
    private javax.swing.JButton btnSearchHuy;
    private javax.swing.JButton btnSearchNV;
    private javax.swing.JButton btnSearchNVNghi;
    private javax.swing.JButton btnSuaVoucher;
    private javax.swing.JButton btnTKTNVoucher;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnThemVoucher;
    private javax.swing.JButton btnUpdateNhanVien;
    private javax.swing.JButton btnXoaKhuyenMai;
    private javax.swing.JButton btnXoaVoucher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblCTT;
    private javax.swing.JLabel lblRoles;
    private javax.swing.JLabel lblThanhCong;
    private javax.swing.JRadioButton rdAllKhuyenMai;
    private javax.swing.JRadioButton rdAllVoucher;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JRadioButton rdSXTMaKhuyenMai;
    private javax.swing.JRadioButton rdSXTMaVoucher;
    private javax.swing.JRadioButton rdSXTNgayKhuyenMai;
    private javax.swing.JRadioButton rdSXTNgayVoucher;
    private javax.swing.JRadioButton rdSXTTenKhuyenMai;
    private javax.swing.JRadioButton rdSXTTenVoucher;
    private javax.swing.JRadioButton rdTheoMaNV;
    private javax.swing.JRadioButton rdTheoMaNVNghi;
    private javax.swing.JRadioButton rdTheoTenNV;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JRadioButton rdTheoTenNVNghi;
    private javax.swing.JRadioButton rdTheoTuoiNhanVien;
    private javax.swing.JRadioButton rdTheoTuoiNhanVienNghi;
    private javax.swing.JTable tblChiTietDoanhThu;
    private javax.swing.JTable tblKMChonSP;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblNhanVienNghi;
    private javax.swing.JTable tblQLHoaDon;
    private javax.swing.JTable tblQLHoaDonHuy;
    private javax.swing.JTable tblQLSanPham;
    private javax.swing.JTable tblQuanLy;
    private javax.swing.JTable tblSPKM;
    private javax.swing.JTable tblSanPhamHuy;
    private javax.swing.JTable tblThongTinChiTietSanPham;
    private javax.swing.JTable tblThongTinChiTietSanPham1;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JButton tbnSuaKhuyenMai;
    private javax.swing.JButton tbnTKTKNKM;
    private javax.swing.JButton tbnThemSPKM;
    private javax.swing.JButton tbnXoaSPKM;
    private javax.swing.JTextField txtBatDauHD;
    private javax.swing.JTextField txtBatDauHuy;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGiamGiaKMChonSP;
    private javax.swing.JTextField txtGiamGiaKhuyenMai;
    private javax.swing.JTextField txtKetThucHD;
    private javax.swing.JTextField txtKetThucHuy;
    private javax.swing.JTextField txtMaKMChonSP;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaSPThemKM;
    private javax.swing.JTextField txtMaVoucher;
    private javax.swing.JTextField txtNBatDauKhuyenMai;
    private javax.swing.JTextField txtNBatDauVoucher;
    private javax.swing.JTextField txtNKetThucKhuyenMai;
    private javax.swing.JTextField txtNKetThucVoucher;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearchHD;
    private javax.swing.JTextField txtSearchHuy;
    private javax.swing.JTextField txtSearchNV;
    private javax.swing.JTextField txtSearchNVNghi;
    private javax.swing.JTextField txtSoLuongKhuyenMai;
    private javax.swing.JTextField txtSoLuongVoucher;
    private javax.swing.JTextField txtSoTienGiamVoucher;
    private javax.swing.JTextField txtSoTienYCVoucher;
    private javax.swing.JTextField txtTKKhuyenMai;
    private javax.swing.JTextField txtTKMaSPKhuyenMai;
    private javax.swing.JTextField txtTKNBDKhuyenMai;
    private javax.swing.JTextField txtTKNBDVoucher;
    private javax.swing.JTextField txtTKNKTKhuyeMai;
    private javax.swing.JTextField txtTKNKTVoucher;
    private javax.swing.JTextField txtTKUuDai1;
    private javax.swing.JTextField txtTKVoucher;
    private javax.swing.JTextField txtTenDN;
    private javax.swing.JTextField txtTenKMChonSP;
    private javax.swing.JTextField txtTenKhuyenMai;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenVoucher;
    private javax.swing.JTextField txtTongDoanhSoBanHang;
    private javax.swing.JTextField txtTongDoanhThu;
    private javax.swing.JTextField txtTongDonHang;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables

    private void displayStatistics(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
