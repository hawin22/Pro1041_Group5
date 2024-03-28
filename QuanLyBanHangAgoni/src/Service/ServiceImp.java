/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.*;
import java.util.ArrayList;
import java.sql.*;
import DbConnect.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    ArrayList<HoaDon> listHoaDon = new ArrayList<>();
    ArrayList<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
    ArrayList<LichSuGia> listLichSuGia = new ArrayList<>();
    ArrayList<NguoiDung> listQuanLy = new ArrayList<>();

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

    public void addKhachHang(KhachHang kh) {
        String sql = ("insert into KhachHang (MaKhachHang, TenKhachHang, SDT, DiaChi) values (?,?,?,?)");
        try {

            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, kh.getMaKhachHang());
            stm.setString(2, kh.getTenKhachHang());
            stm.setString(3, kh.getSDT());
            stm.setString(4, kh.getDiaChi());

            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateKhachHang(KhachHang kh) {
        String sql = "update KhachHang set TenKhachHang = ?, SDT = ?, DiaChi = ? where MaKhachHang = ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, kh.getTenKhachHang());
            stm.setString(2, kh.getSDT());
            stm.setString(3, kh.getDiaChi());
            stm.setString(4, kh.getMaKhachHang());

            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteKhachHang(String MaKhachHang) {
        String sql = "DELETE FROM KhachHang WHERE MaKhachHang=?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, MaKhachHang);

            stm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public KhachHang getRowKhachHang(int row) {
        return listKhachHang.get(row);
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
    public ArrayList<NguoiDung> getAllNhanVien(boolean trangThai) {
        String sql = "select * from NguoiDung where Roles = 'NV' and TrangThai = ?";
        listNguoiDung.clear();
        try {
            Connection conn = DBConnect1.getConnection();       
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setBoolean(1, trangThai);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setTenNguoiDung(rs.getString(2));
                nd.setGioiTinh(rs.getBoolean(3));
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                nd.setTrangThai(rs.getBoolean(10));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }

    public ArrayList<SanPham> getAllSanPham() {
        listSanPham.clear();
        String sql = "SELECT distinct\n"
                + "    c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + "	\n"
                + "    STRING_AGG(HinhAnh, ',') AS HinhAnh,\n"
                + " Hang,\n"
                + "	maKhuyenMai\n"
                + "FROM \n"
                + "    ChiTietSanPham c\n"
                + "JOIN \n"
                + "    SanPham s ON c.MaSanPham = s.MaSanPham\n"
                + "JOIN \n"
                + "    NhaCungCap n ON n.MaNCC = c.NCC\n"
                + "JOIN \n"
                + "    LichSuDonGia l ON l.MaDonGia = c.DonGia\n"
                + "JOIN \n"
                + "    MauSac m ON m.MaMauSac = c.MaMauSac\n"
                + "JOIN \n"
                + "    KichThuoc k ON k.MaKichThuoc = c.MaKichThuoc\n"
                + "JOIN \n"
                + "    ChatLieu cl ON cl.MaChatLieu = c.ChatLieu\n"
                + "left JOIN \n"
                + "    HinhAnh ha ON ha.MaSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "join \n"
                + "	chiTietKhuyenMai ctkm on ctkm.maSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "	group by  c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + " Hang,\n"
                + "	maKhuyenMai";
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
    public NguoiDung getRowNhanVien(boolean trangThai, int row){
        return getAllNhanVien(trangThai).get(row);
    }
    @Override
    public ArrayList<NguoiDung> searchNhanVien(String ma, String tenNV) {
        String sql = "select * from NguoiDung where Roles = 'NV' and MaNguoiDung like ? or TenNguoiDung like ? and TrangThai = 1";
        listNguoiDung.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + ma + "%");
            stm.setString(2, "%" + tenNV + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setTenNguoiDung(rs.getString(2));
                nd.setGioiTinh(rs.getBoolean(3));
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                nd.setTrangThai(rs.getBoolean(10));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }

    @Override
    public ArrayList<NguoiDung> sapXepTheoMaNhVien() {
        String sql = "select * from NguoiDung where Roles = 'NV' and TrangThai = 1 order by MaNguoiDung desc ";
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
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                nd.setTrangThai(rs.getBoolean(10));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNguoiDung;
    }

    @Override
    public ArrayList<Voucher> searchVoucher(String maVC) {
        listVoucher.clear();
        String sql = "select * from Voucher where MaVoucher like ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + maVC + "%");
            ResultSet rs = stm.executeQuery();
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

    public ArrayList<NguoiDung> sapXepTheoTenNhVien() {
        String sql = "select * from NguoiDung where Roles = 'NV' and TrangThai = 1 order by RIGHT(TenNguoiDung, CHARINDEX(' ', REVERSE(TenNguoiDung)) - 1)";
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
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                nd.setTrangThai(rs.getBoolean(10));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }

    @Override
    public Boolean addNhanVien(NguoiDung nd) {
        String sql = "insert into NguoiDung values(?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, nd.getMaNguoiDung());
            stm.setString(2, nd.getTenNguoiDung());
            stm.setBoolean(3, nd.isGioiTinh());
            stm.setInt(4, nd.getTuoi());
            stm.setString(5, nd.getSDT());
            stm.setString(6, nd.getEmail());
            stm.setString(7, nd.getRoles());
            stm.setString(8, nd.getTenDN());
            stm.setString(9, nd.getPassWord());
            stm.setBoolean(10, true);
            stm.executeUpdate();
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public ArrayList<NguoiDung> getAllNguoiDung() {
        String sql = "select * from NguoiDung";
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
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;

    }

    public ArrayList<HoaDon> getAllHoaDon() {
        String sql = "select * from HoaDon";
        listHoaDon.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString(1));
                hd.setMaNhanVien(rs.getString(5));
                hd.setNgayTao(rs.getString(2));
                hd.setLoaiThanhToan(rs.getString(7));
                hd.setMaKhachHang(rs.getString(8));
                hd.setMaVoucher(rs.getString(4));
                hd.setNgayHoanThanh(rs.getString(6));
                hd.setTrangThai(rs.getString(3));
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDonChiTiet> getAllHoaDonChiTiet(String maHoaDon) {
        String sql = "SELECT cthd.MaHoaDon, cthd.MaSanPhamChiTiet, sp.TenSanPham, cthd.SoLuong, ls.GiaDau,\n"
                + "    CASE\n"
                + "        WHEN ls.ThoiGianBatDau <= CURRENT_TIMESTAMP AND ls.ThoiGianKetThuc >= CURRENT_TIMESTAMP THEN ls.GiaSau\n"
                + "        ELSE ls.GiaDau\n"
                + "    END AS Gia\n"
                + "FROM ChiTietSanPham ct\n"
                + "JOIN LichSuDonGia ls ON ls.MaDonGia = ct.DonGia\n"
                + "JOIN SanPham sp ON sp.MaSanPham = ct.MaSanPham\n"
                + "JOIN ChiTietHoaDon cthd ON cthd.MaSanPhamChiTiet = ct.MaSanPhamChiTiet\n"
                + "WHERE cthd.MaHoaDon = ?;";
        listHoaDonChiTiet.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maHoaDon);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHoaDon(rs.getString(1));
                hdct.setMaSanPham(rs.getString(2));
                hdct.setTenSanPham(rs.getString(3));
                hdct.setSoLuong(rs.getInt(4));
                hdct.setDonGia(rs.getDouble(5));
                hdct.setDonGiaSau(rs.getDouble(6));
                listHoaDonChiTiet.add(hdct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    @Override
    public ArrayList<Voucher> sXMaVoucher() {
        listVoucher.clear();
        String sql = "select * from Voucher\n"
                + "order by MaVoucher desc";
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

    public ArrayList<LichSuGia> getAllLichSuGia() {
        String sql = "select MaSanPham, MaDonGia, GiaDau, GiaSau, ThoiGianBatDau, ThoiGianKetThuc from LichSuDonGia\n"
                + "join ChiTietSanPham on ChiTietSanPham.DonGia = LichSuDonGia.MaDonGia\n";
        listLichSuGia.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                LichSuGia lsg = new LichSuGia();
                lsg.setMaSanPham(rs.getString(1));
                lsg.setMaDonGia(rs.getString(2));
                lsg.setGiaDau(rs.getDouble(3));
                lsg.setGiaSau(rs.getDouble(4));
                lsg.setNgayBatDau(rs.getString(5));
                lsg.setNgayKetThuc(rs.getString(6));
                listLichSuGia.add(lsg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLichSuGia;
    }

    @Override
    public ArrayList<Voucher> sXTTTenVoucher() {
        listVoucher.clear();
        String sql = "select * from Voucher\n"
                + "order by TenVoucher desc";
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

    public ArrayList<HoaDonChiTiet> updateSoluongSanPhamBanHang(String maSanPham, Integer soLuong, String maHoaDon) {
        String sql = "update ChiTietHoaDon set SoLuong = SoLuong + ? where MaHoaDon = ? and MaSanPhamChiTiet = ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maHoaDon);
            stm.setString(3, maSanPham);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    public HoaDon getRowHoaDon(int row) {
        return listHoaDon.get(row);
    }

    public SanPham getRowSanPham(int row) {
        return listSanPham.get(row);
    }

    public String getMaSanPhamChiTietFromSanPham(String maSanPham) {
        String sql = "select MaSanPhamChiTiet from ChiTietSanPham join SanPham on SanPham.MaSanPham = ChiTietSanPham.MaSanPham where SanPham.MaSanPham = ?";
        String kq = "";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maSanPham);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                kq = rs.getString("MaSanPhamChiTiet");
            }
            System.out.println(kq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public void updateNV(NguoiDung nd) {
        String sql = "update NguoiDung set TenNguoiDung = ?, GioiTinh = ?, Tuoi = ?, SDT = ?, Email = ?, TenDangNhap = ?, MatKhau = ? where MaNguoiDung = ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, nd.getTenNguoiDung());
            stm.setBoolean(2, nd.isGioiTinh());
            stm.setInt(3, nd.getTuoi());
            stm.setString(4, nd.getSDT());
            stm.setString(5, nd.getEmail());
            stm.setString(6, nd.getTenDN());
            stm.setString(7, nd.getPassWord());
            stm.setString(8, nd.getMaNguoiDung());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SanPham> updateSanPhamTruBanHang(String maSanPham, Integer soLuong) {
        String sql = "update ChiTietSanPham set SoLuong = SoLuong - ? where MaSanPhamChiTiet = ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maSanPham);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public ArrayList<SanPham> updateSanPhamCongBanHang(String maSanPham, Integer soLuong) {
        String sql = "update ChiTietSanPham set SoLuong = SoLuong + ? where MaSanPhamChiTiet = ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maSanPham);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public ArrayList<HoaDonChiTiet> updateSoluongSanPhamBanHangTru(String maSanPham, Integer soLuong, String maHoaDon) {
        String sql = "update ChiTietHoaDon set SoLuong = SoLuong - ? where MaHoaDon = ? and MaSanPhamChiTiet = ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maHoaDon);
            stm.setString(3, maSanPham);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    @Override
    public ArrayList<HoaDonChiTiet> getAllHoaDonChiTiet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<NguoiDung> getAllQuanLy() {
        String sql = "select MaNguoiDung, Email, Roles, TenDangNhap from NguoiDung where Roles = 'QL'";
        listQuanLy.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setEmail(rs.getString(2));
                nd.setRoles(rs.getString(3));
                nd.setTenDN(rs.getString(4));
                listQuanLy.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listQuanLy;
    }

    public ArrayList<HoaDonChiTiet> addHoaDonChiTiet(HoaDonChiTiet hdct) {
        String sql = "insert into ChiTietHoaDon(MaHoaDon, MaSanPhamChiTiet, SoLuong) values(?,?,?)";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hdct.getMaHoaDon());
            stm.setString(2, hdct.getMaSanPham());
            stm.setInt(3, hdct.getSoLuong());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    public ArrayList<HoaDonChiTiet> deleteHoaDonChiTiet(String maSanPhamChiTiet, String maHoaDon) {
        String sql = "delete ChiTietHoaDon where MaHoaDon = ? and MaSanPhamChiTiet = ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maHoaDon);
            stm.setString(2, maSanPhamChiTiet);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    public String getMaSanPhamFromChiTietSanPham(String maSanPhamChiTiet) {
        String maSanPham = "";
        String sql = "select MaSanPham from ChiTietSanPham \n"
                + "where MaSanPhamChiTiet = ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maSanPhamChiTiet);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                maSanPham = rs.getString(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maSanPham;
    }

    public ArrayList<SanPham> sapXepSanPhamTheoTenBanHang() {
        listSanPham.clear();
        String sql = "SELECT distinct\n"
                + "    c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + "    STRING_AGG(HinhAnh, ',') AS HinhAnh,\n"
                + "	Hang,\n"
                + "	maKhuyenMai\n"
                + "FROM \n"
                + "    ChiTietSanPham c\n"
                + "JOIN \n"
                + "    SanPham s ON c.MaSanPham = s.MaSanPham\n"
                + "JOIN \n"
                + "    NhaCungCap n ON n.MaNCC = c.NCC\n"
                + "JOIN \n"
                + "    LichSuDonGia l ON l.MaDonGia = c.DonGia\n"
                + "JOIN \n"
                + "    MauSac m ON m.MaMauSac = c.MaMauSac\n"
                + "JOIN \n"
                + "    KichThuoc k ON k.MaKichThuoc = c.MaKichThuoc\n"
                + "JOIN \n"
                + "    ChatLieu cl ON cl.MaChatLieu = c.ChatLieu\n"
                + "left JOIN \n"
                + "    HinhAnh ha ON ha.MaSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "join \n"
                + "	chiTietKhuyenMai ctkm on ctkm.maSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "	group by  c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + "	Hang,\n"
                + "	maKhuyenMai\n"
                + "	order by TenSanPham";
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

    public ArrayList<SanPham> sapXepSanPhamTheoMaBanHang() {
        listSanPham.clear();
        String sql = "SELECT distinct\n"
                + "    c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + "    STRING_AGG(HinhAnh, ',') AS HinhAnh,\n"
                + "	Hang,\n"
                + "	maKhuyenMai\n"
                + "FROM \n"
                + "    ChiTietSanPham c\n"
                + "JOIN \n"
                + "    SanPham s ON c.MaSanPham = s.MaSanPham\n"
                + "JOIN \n"
                + "    NhaCungCap n ON n.MaNCC = c.NCC\n"
                + "JOIN \n"
                + "    LichSuDonGia l ON l.MaDonGia = c.DonGia\n"
                + "JOIN \n"
                + "    MauSac m ON m.MaMauSac = c.MaMauSac\n"
                + "JOIN \n"
                + "    KichThuoc k ON k.MaKichThuoc = c.MaKichThuoc\n"
                + "JOIN \n"
                + "    ChatLieu cl ON cl.MaChatLieu = c.ChatLieu\n"
                + "left JOIN \n"
                + "    HinhAnh ha ON ha.MaSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "join \n"
                + "	chiTietKhuyenMai ctkm on ctkm.maSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "	group by  c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + "	Hang,\n"
                + "	maKhuyenMai\n"
                + "	order by c.MaSanPham";
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

    public ArrayList<SanPham> sapXepSanPhamTheoGiaBanHang() {
        listSanPham.clear();
        String sql = "SELECT distinct\n"
                + "    c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + "    STRING_AGG(HinhAnh, ',') AS HinhAnh,\n"
                + "	Hang,\n"
                + "	maKhuyenMai\n"
                + "FROM \n"
                + "    ChiTietSanPham c\n"
                + "JOIN \n"
                + "    SanPham s ON c.MaSanPham = s.MaSanPham\n"
                + "JOIN \n"
                + "    NhaCungCap n ON n.MaNCC = c.NCC\n"
                + "JOIN \n"
                + "    LichSuDonGia l ON l.MaDonGia = c.DonGia\n"
                + "JOIN \n"
                + "    MauSac m ON m.MaMauSac = c.MaMauSac\n"
                + "JOIN \n"
                + "    KichThuoc k ON k.MaKichThuoc = c.MaKichThuoc\n"
                + "JOIN \n"
                + "    ChatLieu cl ON cl.MaChatLieu = c.ChatLieu\n"
                + "left JOIN \n"
                + "    HinhAnh ha ON ha.MaSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "join \n"
                + "	chiTietKhuyenMai ctkm on ctkm.maSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "	group by  c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + "	Hang,\n"
                + "	maKhuyenMai\n"
                + "	order by GiaDau";
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
    public void deleteNhanVien(String maNV) {
        String sql = " delete NguoiDung where MaNguoiDung = ? and TrangThai = 0";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maNV);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<NguoiDung> sapXepTheoTuoiNV() {
        String sql = "select * from NguoiDung where Roles = 'NV' and TrangThai = 1 order by Tuoi";
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
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                nd.setTrangThai(rs.getBoolean(10));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNguoiDung;
    }

    @Override
    public ArrayList<SanPham> TimKiemSanPhamTheoMaVaTenBanHang(String keyWord) {
        listSanPham.clear();
        String sql = "SELECT distinct\n"
                + "    c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + "    STRING_AGG(HinhAnh, ',') AS HinhAnh,\n"
                + "	Hang,\n"
                + "	maKhuyenMai\n"
                + "FROM \n"
                + "    ChiTietSanPham c\n"
                + "JOIN \n"
                + "    SanPham s ON c.MaSanPham = s.MaSanPham\n"
                + "JOIN \n"
                + "    NhaCungCap n ON n.MaNCC = c.NCC\n"
                + "JOIN \n"
                + "    LichSuDonGia l ON l.MaDonGia = c.DonGia\n"
                + "JOIN \n"
                + "    MauSac m ON m.MaMauSac = c.MaMauSac\n"
                + "JOIN \n"
                + "    KichThuoc k ON k.MaKichThuoc = c.MaKichThuoc\n"
                + "JOIN \n"
                + "    ChatLieu cl ON cl.MaChatLieu = c.ChatLieu\n"
                + "left JOIN \n"
                + "    HinhAnh ha ON ha.MaSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "join \n"
                + "	chiTietKhuyenMai ctkm on ctkm.maSanPhamChiTiet = c.MaSanPhamChiTiet\n"
                + "	group by  c.MaSanPham, \n"
                + "    TenSanPham, \n"
                + "    TenNCC, \n"
                + "    GiaDau, \n"
                + "    c.SoLuong, \n"
                + "    MauSac, \n"
                + "    KichThuoc, \n"
                + "    Mau, \n"
                + "    TenChatLieu,\n"
                + "	Hang,\n"
                + "	maKhuyenMai\n"
                + "having c.MaSanPham like ? or TenSanPham like ?";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%"+keyWord+"%");
            stm.setString(2, "%"+keyWord+"%");
            ResultSet rs = stm.executeQuery();
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
    public String updateTrangThaiNhanVien(boolean trangThai, String maNhanVien) {
        String sql = "update NguoiDung set TrangThai = ? where MaNguoiDung = ? and Roles = 'NV'";
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setBoolean(1, trangThai);
            stm.setString(2, maNhanVien);
            stm.executeUpdate();
            conn.close();
            return "Thành công";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thất bại";
    }

    @Override
    public ArrayList<NguoiDung> searchNhanVienNghi(String ma, String tenNV) {
     String sql = "select * from NguoiDung where Roles = 'NV' and TrangThai = 0 and MaNguoiDung like ? or TenNguoiDung like ?";
        listNguoiDung.clear();
        try {
            Connection conn = DBConnect1.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + ma + "%");
            stm.setString(2, "%" + tenNV + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setTenNguoiDung(rs.getString(2));
                nd.setGioiTinh(rs.getBoolean(3));
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                nd.setTrangThai(rs.getBoolean(10));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }
    @Override
    public ArrayList<NguoiDung> sapXepTheoMaNhVienNghi() {
String sql = "select * from NguoiDung where Roles = 'NV' and TrangThai = 0 order by MaNguoiDung desc ";
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
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                nd.setTrangThai(rs.getBoolean(10));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNguoiDung;
    }

    @Override
    public ArrayList<NguoiDung> sapXepTheoTenNhVienNghi() {
        String sql = "select * from NguoiDung where Roles = 'NV' and TrangThai = 0 order by RIGHT(TenNguoiDung, CHARINDEX(' ', REVERSE(TenNguoiDung)) - 1)";
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
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                nd.setTrangThai(rs.getBoolean(10));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }

    @Override
    public ArrayList<NguoiDung> sapXepTheoTuoiNVNghi() {
 String sql = "select * from NguoiDung where Roles = 'NV' and TrangThai = 0 order by Tuoi";
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
                nd.setTuoi(rs.getInt(4));
                nd.setSDT(rs.getString(5));
                nd.setEmail(rs.getString(6));
                nd.setRoles(rs.getString(7));
                nd.setTenDN(rs.getString(8));
                nd.setPassWord(rs.getString(9));
                nd.setTrangThai(rs.getBoolean(10));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNguoiDung;
    }

    
   
}
