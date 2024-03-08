Create database DB_ChanGaGoiDemAgoni
go
use DB_ChanGaGoiDemAgoni
go
drop database DB_ChanGaGoiDemAgoni
create table KhachHang(
MaKhachHang varchar(50) primary key,
TenKhachHang nvarchar(200) not null,
SDT varchar(15) not null,
DiaChi nvarchar(500) not null
);

create table Voucher(
MaVoucher varchar(50) primary key,
TenVoucher nvarchar(100) not null,
SoLuong int not null,
HanSuDung date not null,
NgayBatDau date not null
);

create table Roles(
Marole varchar(50) primary key,
TenRole nvarchar(200) not null
);

create table NguoiDung(
MaNguoiDung varchar(50) primary key,
TenNguoiDung nvarchar(200) not null,
SDT varchar(50) not null,
Email varchar(200) not null,
Roles varchar(50) not null references Roles(MaRole),
TenDangNhap varchar(200) not null,
MatKhau varchar(200)not null
);

create table NhaCungCap(
MaNCC varchar(50) primary key, 
TenNCC nvarchar(200) not null,
DiaChi nvarchar(200) not null,
SDT varchar(18) not null,
Email varchar(200) not null,
);

create table SanPham(
MaSanPham varchar(50) primary key,
TenSanPham nvarchar(200) not null,
ChatLieu nvarchar(200) not null,
Mau nvarchar(200) not null,
Hang nvarchar(50) not null
);

create table KichThuoc(
MaKichThuoc varchar(50) primary key,
KichThuoc float
);

create table HinhAnh(
MaHinhAnh varchar(200) primary key,
HinhAnh nvarchar(200)
);

create table MauSac(
MaMauSac varchar(200) primary key,
MauSac nvarchar(200)
);

create table KhuyenMai(
MaKhuyenMai varchar(50) primary key,
TenKhuyenMai nvarchar(200) not null,
SoLuong int not null,
HanSuDung date not null,
NgayBatDau date not null
);

create table LichSuDonGia(
MaDonGia varchar(50) primary key,
GiaDau decimal not null,
GiaSau decimal not null,
ThoiGianBatDau date not null,
ThoiGianKetThuc date not null
);

create table ChiTietSanPham(
MaSanPhamChiTiet varchar(200) primary key,
MaSanPham varchar(50) references SanPham(MaSanPham),
SoLuong int not null,
MaKichThuoc varchar(50) references KichThuoc(MaKichThuoc),
MaMauSac varchar(200) references MauSac(MaMauSac),
MaHinhAnh varchar(200) references HinhAnh(MaHinhAnh),
DonGia varchar(50) not null references LichSuDonGia(MaDonGia),
NCC varchar(50) references NhaCungCap(MaNCC)
);

create table HoaDon(
MaHoaDon varchar(100) primary key,
NgayTao date not null,
TrangThai nvarchar(100) not null,
MaVoucher varchar(50) references Voucher(MaVoucher),
MaNhanVien varchar(50) references NguoiDung(MaNguoiDung),
NgayHoanThanh date not null,
LoaiThanhToan nvarchar(100) not null,
MaKhachHang varchar(50) references KhachHang(MaKhachHang)
);

create table ChiTietKhuyenMai(
MaKhuyenMai varchar(50) references KhuyenMai(MaKhuyenMai),
MaSanPhamChiTiet varchar(200) references ChiTietSanPham(MaSanPhamChiTiet)
primary key(MaKhuyenMai, MaSanPhamChiTiet)
);

create table ChiTietHoaDon(
MaHoaDon varchar(100) references HoaDon(MaHoaDon),
MaSanPhamChiTiet varchar(200) references ChiTietSanPham(MaSanPhamChiTiet),
SoLuong int not null,
DonGia decimal
primary key(MaHoaDon, MaSanPhamChiTiet)
);

/*INSERT INTO KhachHang (MaKhachHang, TenKhachHang, SDT, DiaChi) 
VALUES 
('KH001', N'Nguyễn Văn A', '0123456789', N'Hà Nội, Việt Nam'),
('KH002', N'Trần Thị B', '0987654321', N'Hồ Chí Minh, Việt Nam'),
('KH003', N'Lê Văn C', '0369876543', N'Đà Nẵng, Việt Nam'),
('KH004', N'Phạm Thị D', '0928374651', N'Cần Thơ, Việt Nam'),
('KH005', N'Huỳnh Văn E', '0778899000', N'Hải Phòng, Việt Nam');

INSERT INTO Voucher (MaVoucher, TenVoucher, SoLuong, HanSuDung, NgayBatDau) 
VALUES 
('VCH001', N'Voucher Giảm Giá 10%', 100, '2024-11-30', '2024-01-01'),
('VCH002', N'Voucher Miễn Phí Vận Chuyển', 50, '2024-11-30', '2024-01-01'),
('VCH003', N'Voucher Giảm 50.000đ', 200, '2024-11-30', '2024-01-01'),
('VCH004', N'Voucher Mua 1 Tặng 1', 150, '2024-11-30', '2024-01-01'),
('VCH005', N'Voucher Quà Tặng 100.000đ', 300, '2024-11-30', '2024-01-01');*/

-----insert lại
-- Chèn dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, SDT, DiaChi) 
VALUES 
('KH001', N'Nguyễn Văn A', '0123456789', N'Hà Nội, Việt Nam'),
('KH002', N'Trần Thị B', '0987654321', N'Hồ Chí Minh, Việt Nam'),
('KH003', N'Lê Văn C', '0369876543', N'Đà Nẵng, Việt Nam'),
('KH004', N'Phạm Thị D', '0928374651', N'Cần Thơ, Việt Nam'),
('KH005', N'Huỳnh Văn E', '0778899000', N'Hải Phòng, Việt Nam'),
('KH006', N'Lương Thị F', '0976543210', N'Bình Dương, Việt Nam'),
('KH007', N'Trần Văn G', '0981234567', N'Hải Dương, Việt Nam'),
('KH008', N'Nguyễn Thị H', '0912345678', N'Đồng Nai, Việt Nam'),
('KH009', N'Hoàng Văn I', '0965432109', N'Quảng Nam, Việt Nam'),
('KH010', N'Võ Thị K', '0934567890', N'Quảng Ninh, Việt Nam');

-- Chèn dữ liệu vào bảng Voucher
INSERT INTO Voucher (MaVoucher, TenVoucher, SoLuong, HanSuDung, NgayBatDau) 
VALUES 
('VCH001', N'Voucher Giảm Giá 10%', 100, '2024-12-31', '2024-01-01'),
('VCH002', N'Voucher Miễn Phí Vận Chuyển', 50, '2024-12-31', '2024-01-01'),
('VCH003', N'Voucher Giảm 50.000đ', 200, '2024-12-31', '2024-01-01'),
('VCH004', N'Voucher Mua 1 Tặng 1', 150, '2024-12-31', '2024-01-01'),
('VCH005', N'Voucher Quà Tặng 100.000đ', 300, '2024-12-31', '2024-01-01'),
('VCH006', N'Voucher Miễn Phí Cước', 75, '2024-12-31', '2024-01-01'),
('VCH007', N'Voucher Giảm 20%', 120, '2024-12-31', '2024-01-01'),
('VCH008', N'Voucher Tặng Quà', 200, '2024-12-31', '2024-01-01'),
('VCH009', N'Voucher Thanh Toán Trả Trước', 80, '2024-12-31', '2024-01-01'),
('VCH010', N'Voucher Đặc Biệt', 250, '2024-12-31', '2024-01-01');

-- Chèn dữ liệu vào bảng Roles
INSERT INTO Roles (Marole, TenRole)
VALUES 
('NV001', N'Nhân viên'),
('NV002', N'Nhân viên'),
('NV003', N'Nhân viên'),
('NV004', N'Nhân viên'),
('NV005', N'Nhân viên'),
('QL001', N'Quản lý'),
('QL002', N'Quản lý'),
('QL003', N'Quản lý'),
('QL004', N'Quản lý'),
('QL005', N'Quản lý');

-- Chèn dữ liệu vào bảng NguoiDung
INSERT INTO NguoiDung (MaNguoiDung, TenNguoiDung, SDT, Email, Roles, TenDangNhap, MatKhau)
VALUES 
('ND001', N'Nguyễn Văn An', '0123456789', 'an@example.com', 'NV001', 'nv_an', 'password123'),
('ND002', N'Trần Thị Bình', '0987654321', 'binh@example.com', 'NV002', 'nv_binh', 'password123'),
('ND003', N'Lê Văn Cường', '0369876543', 'cuong@example.com', 'NV003', 'nv_cuong', 'password123'),
('ND004', N'Phạm Thị Dung', '0928374651', 'dung@example.com', 'NV004', 'nv_dung', 'password123'),
('ND005', N'Huỳnh Văn Đạt', '0778899000', 'dat@example.com', 'NV005', 'nv_dat', 'password123'),
('ND006', N'Trần Văn Đức', '0976543210', 'duc@example.com', 'QL001', 'ql_duc', 'password123'),
('ND007', N'Nguyễn Thị Hương', '0981234567', 'huong@example.com', 'QL002', 'ql_huong', 'password123'),
('ND008', N'Võ Thị Lan', '0912345678', 'lan@example.com', 'QL003', 'ql_lan', 'password123'),
('ND009', N'Hoàng Văn Minh', '0965432109', 'minh@example.com', 'QL004', 'ql_minh', 'password123'),
('ND010', N'Lương Thị Ngọc', '0934567890', 'ngoc@example.com', 'QL005', 'ql_ngoc', 'password123');

-- Chèn dữ liệu vào bảng NhaCungCap
INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, SDT, Email)
VALUES 
('NCC001', N'Công ty TNHH A', N'Hồ Chí Minh, Việt Nam', '0123456789', 'info@a.com'),
('NCC002', N'Công ty TNHH B', N'Hà Nội, Việt Nam', '0987654321', 'info@b.com'),
('NCC003', N'Công ty TNHH C', N'Đà Nẵng, Việt Nam', '0369876543', 'info@c.com'),
('NCC004', N'Công ty TNHH D', N'Cần Thơ, Việt Nam', '0928374651', 'info@d.com'),
('NCC005', N'Công ty TNHH E', N'Hải Phòng, Việt Nam', '0778899000', 'info@e.com'),
('NCC006', N'Công ty TNHH F', N'Bình Dương, Việt Nam', '0976543210', 'info@f.com'),
('NCC007', N'Công ty TNHH G', N'Hải Dương, Việt Nam', '0981234567', 'info@g.com'),
('NCC008', N'Công ty TNHH H', N'Đồng Nai, Việt Nam', '0912345678', 'info@h.com'),
('NCC009', N'Công ty TNHH I', N'Quảng Nam, Việt Nam', '0965432109', 'info@i.com'),
('NCC010', N'Công ty TNHH K', N'Quảng Ninh, Việt Nam', '0934567890', 'info@k.com');

-- Chèn dữ liệu vào bảng SanPham
INSERT INTO SanPham (MaSanPham, TenSanPham, ChatLieu, Mau, Hang)
VALUES 
('SP001', N'Áo thun nam', N'Thun', N'Đen', N'Viettien'),
('SP002', N'Áo sơ mi nam', N'Lụa', N'Trắng', N'Canifa'),
('SP003', N'Quần jean nam', N'Jean', N'Xanh', N'Levis'),
('SP004', N'Quần tây nam', N'Vải', N'Nâu', N'Zara'),
('SP005', N'Áo khoác nam', N'Len', N'Xám', N'Uniqlo'),
('SP006', N'Áo thun nữ', N'Thun', N'Xanh', N'Viettien'),
('SP007', N'Áo sơ mi nữ', N'Lụa', N'Hồng', N'Canifa'),
('SP008', N'Quần jean nữ', N'Jean', N'Đen', N'Levis'),
('SP009', N'Quần tây nữ', N'Vải', N'Xanh', N'Zara'),
('SP010', N'Áo khoác nữ', N'Len', N'Đỏ', N'Uniqlo');

-- Chèn dữ liệu vào bảng KichThuoc
INSERT INTO KichThuoc (MaKichThuoc, KichThuoc)
VALUES 
('KT001', 28),
('KT002', 30),
('KT003', 32),
('KT004', 34),
('KT005', 36),
('KT006', 38),
('KT007', 40),
('KT008', 42),
('KT009', 44),
('KT010', 46);

-- Chèn dữ liệu vào bảng HinhAnh
INSERT INTO HinhAnh (MaHinhAnh, HinhAnh)
VALUES 
('HA001', 'url1'),
('HA002', 'url2'),
('HA003', 'url3'),
('HA004', 'url4'),
('HA005', 'url5'),
('HA006', 'url6'),
('HA007', 'url7'),
('HA008', 'url8'),
('HA009', 'url9'),
('HA010', 'url10');

-- Chèn dữ liệu vào bảng MauSac
INSERT INTO MauSac (MaMauSac, MauSac)
VALUES 
('MS001', N'Den'),
('MS002', N'Trắng'),
('MS003', N'Xanh'),
('MS004', N'Nâu'),
('MS005', N'Đen'),
('MS006', N'Xám'),
('MS007', N'Hồng'),
('MS008', N'Đỏ'),
('MS009', N'Xanh'),
('MS010', N'Đỏ');

-- Chèn dữ liệu vào bảng KhuyenMai
INSERT INTO KhuyenMai (MaKhuyenMai, TenKhuyenMai, SoLuong, HanSuDung, NgayBatDau) 
VALUES 
('KM001', N'Khuyến mãi giảm 10%', 100, '2024-12-31', '2024-01-01'),
('KM002', N'Khuyến mãi giảm 20%', 50, '2024-12-31', '2024-01-01'),
('KM003', N'Khuyến mãi giảm 30%', 200, '2024-12-31', '2024-01-01'),
('KM004', N'Khuyến mãi giảm 50%', 150, '2024-12-31', '2024-01-01'),
('KM005', N'Khuyến mãi giảm 70%', 300, '2024-12-31', '2024-01-01'),
('KM006', N'Khuyến mãi giảm 80%', 75, '2024-12-31', '2024-01-01'),
('KM007', N'Khuyến mãi giảm 90%', 120, '2024-12-31', '2024-01-01'),
('KM008', N'Khuyến mãi giảm 40%', 200, '2024-12-31', '2024-01-01'),
('KM009', N'Khuyến mãi giảm 25%', 80, '2024-12-31', '2024-01-01'),
('KM010', N'Khuyến mãi giảm 15%', 250, '2024-12-31', '2024-01-01');

-- Chèn dữ liệu vào bảng LichSuDonGia
INSERT INTO LichSuDonGia (MaDonGia, GiaDau, GiaSau, ThoiGianBatDau, ThoiGianKetThuc) 
VALUES 
('DG001', 100000, 90000, '2024-01-01', '2024-02-01'),
('DG002', 150000, 130000, '2024-02-01', '2024-03-01'),
('DG003', 200000, 180000, '2024-03-01', '2024-04-01'),
('DG004', 250000, 230000, '2024-04-01', '2024-05-01'),
('DG005', 300000, 280000, '2024-05-01', '2024-06-01'),
('DG006', 350000, 330000, '2024-06-01', '2024-07-01'),
('DG007', 400000, 380000, '2024-07-01', '2024-08-01'),
('DG008', 450000, 430000, '2024-08-01', '2024-09-01'),
('DG009', 500000, 480000, '2024-09-01', '2024-10-01'),
('DG010', 550000, 530000, '2024-10-01', '2024-11-01');

-- Chèn dữ liệu vào bảng ChiTietSanPham
INSERT INTO ChiTietSanPham (MaSanPhamChiTiet, MaSanPham, SoLuong, MaKichThuoc, MaMauSac, MaHinhAnh, DonGia, NCC) 
VALUES 
('CTSP001', 'SP001', 100, 'KT001', 'MS001', 'HA001', 'DG001', 'NCC001'),
('CTSP002', 'SP002', 150, 'KT002', 'MS002', 'HA002', 'DG002', 'NCC002'),
('CTSP003', 'SP003', 200, 'KT003', 'MS003', 'HA003', 'DG003', 'NCC003'),
('CTSP004', 'SP004', 250, 'KT004', 'MS004', 'HA004', 'DG004', 'NCC004'),
('CTSP005', 'SP005', 300, 'KT005', 'MS005', 'HA005', 'DG005', 'NCC005'),
('CTSP006', 'SP006', 120, 'KT006', 'MS006', 'HA006', 'DG006', 'NCC006'),
('CTSP007', 'SP007', 180, 'KT007', 'MS007', 'HA007', 'DG007', 'NCC007'),
('CTSP008', 'SP008', 220, 'KT008', 'MS008', 'HA008', 'DG008', 'NCC008'),
('CTSP009', 'SP009', 270, 'KT009', 'MS009', 'HA009', 'DG009', 'NCC009'),
('CTSP010', 'SP010', 320, 'KT010', 'MS010', 'HA010', 'DG010', 'NCC010');

-- Chèn dữ liệu vào bảng HoaDon
INSERT INTO HoaDon (MaHoaDon, NgayTao, TrangThai, MaVoucher, MaNhanVien, NgayHoanThanh, LoaiThanhToan, MaKhachHang) 
VALUES 
('HD001', '2024-01-01', N'Đã hoàn thành', 'VCH001', 'ND001', '2024-01-02', N'Thanh toán khi nhận hàng', 'KH001'),
('HD002', '2024-02-01', N'Chưa hoàn thành', 'VCH002', 'ND002', '2024-02-02', N'Thanh toán qua thẻ', 'KH002'),
('HD003', '2024-03-01', N'Đã hoàn thành', 'VCH003', 'ND003', '2024-03-02', N'Thanh toán khi nhận hàng', 'KH003'),
('HD004', '2024-04-01', N'Chưa hoàn thành', 'VCH004', 'ND004', '2024-04-02', N'Thanh toán qua thẻ', 'KH004'),
('HD005', '2024-05-01', N'Đã hoàn thành', 'VCH005', 'ND005', '2024-05-02', N'Thanh toán khi nhận hàng', 'KH005'),
('HD006', '2024-06-01', N'Chưa hoàn thành', 'VCH006', 'ND006', '2024-06-02', N'Thanh toán qua thẻ', 'KH006'),
('HD007', '2024-07-01', N'Đã hoàn thành', 'VCH007', 'ND007', '2024-07-02', N'Thanh toán khi nhận hàng', 'KH007'),
('HD008', '2024-08-01', N'Chưa hoàn thành', 'VCH008', 'ND008', '2024-08-02', N'Thanh toán qua thẻ', 'KH008'),
('HD009', '2024-09-01', N'Đã hoàn thành', 'VCH009', 'ND009', '2024-09-02', N'Thanh toán khi nhận hàng', 'KH009'),
('HD010', '2024-10-01', N'Chưa hoàn thành', 'VCH010', 'ND010', '2024-10-02', N'Thanh toán qua thẻ', 'KH010');

-- Chèn dữ liệu vào bảng ChiTietKhuyenMai
INSERT INTO ChiTietKhuyenMai (MaKhuyenMai, MaSanPhamChiTiet) 
VALUES 
('KM001', 'CTSP001'),
('KM002', 'CTSP002'),
('KM003', 'CTSP003'),
('KM004', 'CTSP004'),
('KM005', 'CTSP005'),
('KM006', 'CTSP006'),
('KM007', 'CTSP007'),
('KM008', 'CTSP008'),
('KM009', 'CTSP009'),
('KM010', 'CTSP010');

-- Chèn dữ liệu vào bảng ChiTietHoaDon
INSERT INTO ChiTietHoaDon (MaHoaDon, MaSanPhamChiTiet, SoLuong, DonGia) 
VALUES 
('HD001', 'CTSP001', 2, 90000),
('HD002', 'CTSP002', 3, 130000),
('HD003', 'CTSP003', 4, 180000),
('HD004', 'CTSP004', 1, 230000),
('HD005', 'CTSP005', 2, 280000),
('HD006', 'CTSP006', 3, 330000),
('HD007', 'CTSP007', 4, 380000),
('HD008', 'CTSP008', 1, 430000),
('HD009', 'CTSP009', 2, 480000),
('HD010', 'CTSP010', 3, 530000);


/*INSERT INTO Roles (Marole, TenRole)
VALUES 
('NV001', N'Nhân viên'),
('NV002', N'Nhân viên'),
('NV003', N'Nhân viên'),
('QL001', N'Quản lý');*/