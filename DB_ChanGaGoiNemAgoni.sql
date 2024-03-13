USE [DB_ChanGaGoiDemAgoni]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHoaDon] [varchar](15) NOT NULL,
	[MaSanPhamChiTiet] [varchar](200) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonGia] [decimal](18, 0) NULL,
 CONSTRAINT [PK__ChiTietH__731E43325CD6DB5A] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC,
	[MaSanPhamChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietKhuyenMai]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietKhuyenMai](
	[MaKhuyenMai] [varchar](50) NOT NULL,
	[MaSanPhamChiTiet] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKhuyenMai] ASC,
	[MaSanPhamChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[MaSanPhamChiTiet] [varchar](200) NOT NULL,
	[MaSanPham] [varchar](50) NULL,
	[SoLuong] [int] NOT NULL,
	[MaKichThuoc] [varchar](50) NULL,
	[MaMauSac] [varchar](200) NULL,
	[MaHinhAnh] [varchar](200) NULL,
	[DonGia] [varchar](50) NOT NULL,
	[NCC] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSanPhamChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhAnh]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhAnh](
	[MaHinhAnh] [varchar](200) NOT NULL,
	[HinhAnh] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHinhAnh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [varchar](15) NOT NULL,
	[NgayTao] [date] NOT NULL,
	[TrangThai] [nvarchar](100) NOT NULL,
	[MaVoucher] [varchar](50) NULL,
	[MaNhanVien] [varchar](50) NULL,
	[NgayHoanThanh] [date] NOT NULL,
	[LoaiThanhToan] [nvarchar](100) NOT NULL,
	[MaKhachHang] [varchar](50) NULL,
 CONSTRAINT [PK__HoaDon__835ED13BB13017F7] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [varchar](50) NOT NULL,
	[TenKhachHang] [nvarchar](200) NOT NULL,
	[SDT] [varchar](15) NOT NULL,
	[DiaChi] [nvarchar](500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[MaKhuyenMai] [varchar](50) NOT NULL,
	[TenKhuyenMai] [nvarchar](200) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[HanSuDung] [date] NOT NULL,
	[NgayBatDau] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichThuoc]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichThuoc](
	[MaKichThuoc] [varchar](50) NOT NULL,
	[KichThuoc] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKichThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichSuDonGia]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichSuDonGia](
	[MaDonGia] [varchar](50) NOT NULL,
	[GiaDau] [decimal](18, 0) NOT NULL,
	[GiaSau] [decimal](18, 0) NOT NULL,
	[ThoiGianBatDau] [date] NOT NULL,
	[ThoiGianKetThuc] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDonGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[MaMauSac] [varchar](200) NOT NULL,
	[MauSac] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaMauSac] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[MaNguoiDung] [varchar](50) NOT NULL,
	[TenNguoiDung] [nvarchar](200) NOT NULL,
	[SDT] [varchar](50) NOT NULL,
	[Email] [varchar](200) NOT NULL,
	[Roles] [varchar](50) NOT NULL,
	[TenDangNhap] [varchar](200) NOT NULL,
	[MatKhau] [varchar](200) NOT NULL,
	[Anh] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNguoiDung] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [varchar](50) NOT NULL,
	[TenNCC] [nvarchar](200) NOT NULL,
	[DiaChi] [nvarchar](200) NOT NULL,
	[SDT] [varchar](18) NOT NULL,
	[Email] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[Marole] [varchar](50) NOT NULL,
	[TenRole] [nvarchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Marole] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [varchar](50) NOT NULL,
	[TenSanPham] [nvarchar](200) NOT NULL,
	[ChatLieu] [nvarchar](200) NOT NULL,
	[Mau] [nvarchar](200) NOT NULL,
	[Hang] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 3/11/2024 19:04:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[MaVoucher] [varchar](50) NOT NULL,
	[TenVoucher] [nvarchar](100) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[HanSuDung] [date] NOT NULL,
	[NgayBatDau] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaVoucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD001', N'CTSP001', 2, CAST(90000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD002', N'CTSP002', 3, CAST(130000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD003', N'CTSP003', 4, CAST(180000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD004', N'CTSP004', 1, CAST(230000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD005', N'CTSP005', 2, CAST(280000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD006', N'CTSP006', 3, CAST(330000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD007', N'CTSP007', 4, CAST(380000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD008', N'CTSP008', 1, CAST(430000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD009', N'CTSP009', 2, CAST(480000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD010', N'CTSP010', 3, CAST(530000 AS Decimal(18, 0)))
GO
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM001', N'CTSP001')
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM002', N'CTSP002')
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM003', N'CTSP003')
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM004', N'CTSP004')
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM005', N'CTSP005')
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM006', N'CTSP006')
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM007', N'CTSP007')
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM008', N'CTSP008')
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM009', N'CTSP009')
INSERT [dbo].[ChiTietKhuyenMai] ([MaKhuyenMai], [MaSanPhamChiTiet]) VALUES (N'KM010', N'CTSP010')
GO
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP001', N'SP001', 100, N'KT001', N'MS001', N'HA001', N'DG001', N'NCC001')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP002', N'SP002', 150, N'KT002', N'MS002', N'HA002', N'DG002', N'NCC002')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP003', N'SP003', 200, N'KT003', N'MS003', N'HA003', N'DG003', N'NCC003')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP004', N'SP004', 250, N'KT004', N'MS004', N'HA004', N'DG004', N'NCC004')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP005', N'SP005', 300, N'KT005', N'MS005', N'HA005', N'DG005', N'NCC005')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP006', N'SP006', 120, N'KT006', N'MS006', N'HA006', N'DG006', N'NCC006')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP007', N'SP007', 180, N'KT007', N'MS007', N'HA007', N'DG007', N'NCC007')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP008', N'SP008', 220, N'KT008', N'MS008', N'HA008', N'DG008', N'NCC008')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP009', N'SP009', 270, N'KT009', N'MS009', N'HA009', N'DG009', N'NCC009')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [MaHinhAnh], [DonGia], [NCC]) VALUES (N'CTSP010', N'SP010', 320, N'KT010', N'MS010', N'HA010', N'DG010', N'NCC010')
GO
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA001', N'url1')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA002', N'url2')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA003', N'url3')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA004', N'url4')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA005', N'url5')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA006', N'url6')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA007', N'url7')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA008', N'url8')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA009', N'url9')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [HinhAnh]) VALUES (N'HA010', N'url10')
GO
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD001', CAST(N'2024-01-01' AS Date), N'Đã hoàn thành', N'VCH001', N'ND001', CAST(N'2024-01-02' AS Date), N'Thanh toán khi nhận hàng', N'KH001')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD002', CAST(N'2024-02-01' AS Date), N'Chưa hoàn thành', N'VCH002', N'ND002', CAST(N'2024-02-02' AS Date), N'Thanh toán qua thẻ', N'KH002')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD003', CAST(N'2024-03-01' AS Date), N'Đã hoàn thành', N'VCH003', N'ND003', CAST(N'2024-03-02' AS Date), N'Thanh toán khi nhận hàng', N'KH003')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD004', CAST(N'2024-04-01' AS Date), N'Chưa hoàn thành', N'VCH004', N'ND004', CAST(N'2024-04-02' AS Date), N'Thanh toán qua thẻ', N'KH004')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD005', CAST(N'2024-05-01' AS Date), N'Đã hoàn thành', N'VCH005', N'ND005', CAST(N'2024-05-02' AS Date), N'Thanh toán khi nhận hàng', N'KH005')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD006', CAST(N'2024-06-01' AS Date), N'Chưa hoàn thành', N'VCH006', N'ND006', CAST(N'2024-06-02' AS Date), N'Thanh toán qua thẻ', N'KH006')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD007', CAST(N'2024-07-01' AS Date), N'Đã hoàn thành', N'VCH007', N'ND007', CAST(N'2024-07-02' AS Date), N'Thanh toán khi nhận hàng', N'KH007')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD008', CAST(N'2024-08-01' AS Date), N'Chưa hoàn thành', N'VCH008', N'ND008', CAST(N'2024-08-02' AS Date), N'Thanh toán qua thẻ', N'KH008')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD009', CAST(N'2024-09-01' AS Date), N'Đã hoàn thành', N'VCH009', N'ND009', CAST(N'2024-09-02' AS Date), N'Thanh toán khi nhận hàng', N'KH009')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD010', CAST(N'2024-10-01' AS Date), N'Chưa hoàn thành', N'VCH010', N'ND010', CAST(N'2024-10-02' AS Date), N'Thanh toán qua thẻ', N'KH010')
GO
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH001', N'Nguyễn Văn A', N'0123456789', N'Hà Nội, Việt Nam')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH002', N'Trần Thị B', N'0987654321', N'Hồ Chí Minh, Việt Nam')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH003', N'Lê Văn C', N'0369876543', N'Đà Nẵng, Việt Nam')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH004', N'Phạm Thị D', N'0928374651', N'Cần Thơ, Việt Nam')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH005', N'Huỳnh Văn E', N'0778899000', N'Hải Phòng, Việt Nam')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH006', N'Lương Thị F', N'0976543210', N'Bình Dương, Việt Nam')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH007', N'Trần Văn G', N'0981234567', N'Hải Dương, Việt Nam')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH008', N'Nguyễn Thị H', N'0912345678', N'Đồng Nai, Việt Nam')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH009', N'Hoàng Văn I', N'0965432109', N'Quảng Nam, Việt Nam')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH010', N'Võ Thị K', N'0934567890', N'Quảng Ninh, Việt Nam')
GO
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM001', N'Khuyến mãi giảm 10%', 100, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM002', N'Khuyến mãi giảm 20%', 50, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM003', N'Khuyến mãi giảm 30%', 200, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM004', N'Khuyến mãi giảm 50%', 150, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM005', N'Khuyến mãi giảm 70%', 300, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM006', N'Khuyến mãi giảm 80%', 75, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM007', N'Khuyến mãi giảm 90%', 120, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM008', N'Khuyến mãi giảm 40%', 200, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM009', N'Khuyến mãi giảm 25%', 80, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'KM010', N'Khuyến mãi giảm 15%', 250, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
GO
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT001', 28)
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT002', 30)
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT003', 32)
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT004', 34)
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT005', 36)
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT006', 38)
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT007', 40)
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT008', 42)
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT009', 44)
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT010', 46)
GO
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG001', CAST(100000 AS Decimal(18, 0)), CAST(90000 AS Decimal(18, 0)), CAST(N'2024-01-01' AS Date), CAST(N'2024-02-01' AS Date))
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG002', CAST(150000 AS Decimal(18, 0)), CAST(130000 AS Decimal(18, 0)), CAST(N'2024-02-01' AS Date), CAST(N'2024-03-01' AS Date))
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG003', CAST(200000 AS Decimal(18, 0)), CAST(180000 AS Decimal(18, 0)), CAST(N'2024-03-01' AS Date), CAST(N'2024-04-01' AS Date))
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG004', CAST(250000 AS Decimal(18, 0)), CAST(230000 AS Decimal(18, 0)), CAST(N'2024-04-01' AS Date), CAST(N'2024-05-01' AS Date))
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG005', CAST(300000 AS Decimal(18, 0)), CAST(280000 AS Decimal(18, 0)), CAST(N'2024-05-01' AS Date), CAST(N'2024-06-01' AS Date))
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG006', CAST(350000 AS Decimal(18, 0)), CAST(330000 AS Decimal(18, 0)), CAST(N'2024-06-01' AS Date), CAST(N'2024-07-01' AS Date))
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG007', CAST(400000 AS Decimal(18, 0)), CAST(380000 AS Decimal(18, 0)), CAST(N'2024-07-01' AS Date), CAST(N'2024-08-01' AS Date))
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG008', CAST(450000 AS Decimal(18, 0)), CAST(430000 AS Decimal(18, 0)), CAST(N'2024-08-01' AS Date), CAST(N'2024-09-01' AS Date))
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG009', CAST(500000 AS Decimal(18, 0)), CAST(480000 AS Decimal(18, 0)), CAST(N'2024-09-01' AS Date), CAST(N'2024-10-01' AS Date))
INSERT [dbo].[LichSuDonGia] ([MaDonGia], [GiaDau], [GiaSau], [ThoiGianBatDau], [ThoiGianKetThuc]) VALUES (N'DG010', CAST(550000 AS Decimal(18, 0)), CAST(530000 AS Decimal(18, 0)), CAST(N'2024-10-01' AS Date), CAST(N'2024-11-01' AS Date))
GO
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS001', N'Den')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS002', N'Trắng')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS003', N'Xanh')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS004', N'Nâu')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS005', N'Đen')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS006', N'Xám')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS007', N'Hồng')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS008', N'Đỏ')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS009', N'Xanh')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS010', N'Đỏ')
GO
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND001', N'Nguyễn Văn An', N'0123456789', N'an@example.com', N'NV001', N'nv_an', N'password123', NULL)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND002', N'Trần Thị Bình', N'0987654321', N'binh@example.com', N'NV002', N'nv_binh', N'password123', NULL)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND003', N'Lê Văn Cường', N'0369876543', N'cuong@example.com', N'NV003', N'nv_cuong', N'password123', NULL)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND004', N'Phạm Thị Dung', N'0928374651', N'dung@example.com', N'NV004', N'nv_dung', N'password123', NULL)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND005', N'Huỳnh Văn Đạt', N'0778899000', N'dat@example.com', N'NV005', N'nv_dat', N'password123', NULL)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND006', N'Trần Văn Đức', N'0976543210', N'duc@example.com', N'QL001', N'ql_duc', N'password123', NULL)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND007', N'Nguyễn Thị Hương', N'0981234567', N'huong@example.com', N'QL002', N'ql_huong', N'password123', NULL)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND008', N'Võ Thị Lan', N'0912345678', N'lan@example.com', N'QL003', N'ql_lan', N'password123', NULL)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND009', N'Hoàng Văn Minh', N'0965432109', N'minh@example.com', N'QL004', N'ql_minh', N'password123', NULL)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau], [Anh]) VALUES (N'ND010', N'Lương Thị Ngọc', N'0934567890', N'ngoc@example.com', N'QL005', N'ql_ngoc', N'password123', NULL)
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC001', N'Công ty TNHH A', N'Hồ Chí Minh, Việt Nam', N'0123456789', N'info@a.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC002', N'Công ty TNHH B', N'Hà Nội, Việt Nam', N'0987654321', N'info@b.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC003', N'Công ty TNHH C', N'Đà Nẵng, Việt Nam', N'0369876543', N'info@c.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC004', N'Công ty TNHH D', N'Cần Thơ, Việt Nam', N'0928374651', N'info@d.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC005', N'Công ty TNHH E', N'Hải Phòng, Việt Nam', N'0778899000', N'info@e.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC006', N'Công ty TNHH F', N'Bình Dương, Việt Nam', N'0976543210', N'info@f.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC007', N'Công ty TNHH G', N'Hải Dương, Việt Nam', N'0981234567', N'info@g.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC008', N'Công ty TNHH H', N'Đồng Nai, Việt Nam', N'0912345678', N'info@h.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC009', N'Công ty TNHH I', N'Quảng Nam, Việt Nam', N'0965432109', N'info@i.com')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT], [Email]) VALUES (N'NCC010', N'Công ty TNHH K', N'Quảng Ninh, Việt Nam', N'0934567890', N'info@k.com')
GO
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'NV001', N'Nhân viên')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'NV002', N'Nhân viên')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'NV003', N'Nhân viên')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'NV004', N'Nhân viên')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'NV005', N'Nhân viên')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'QL001', N'Quản lý')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'QL002', N'Quản lý')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'QL003', N'Quản lý')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'QL004', N'Quản lý')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'QL005', N'Quản lý')
GO
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP001', N'Áo thun nam', N'Thun', N'Đen', N'Viettien')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP002', N'Áo sơ mi nam', N'Lụa', N'Trắng', N'Canifa')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP003', N'Quần jean nam', N'Jean', N'Xanh', N'Levis')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP004', N'Quần tây nam', N'Vải', N'Nâu', N'Zara')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP005', N'Áo khoác nam', N'Len', N'Xám', N'Uniqlo')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP006', N'Áo thun nữ', N'Thun', N'Xanh', N'Viettien')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP007', N'Áo sơ mi nữ', N'Lụa', N'Hồng', N'Canifa')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP008', N'Quần jean nữ', N'Jean', N'Đen', N'Levis')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP009', N'Quần tây nữ', N'Vải', N'Xanh', N'Zara')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [ChatLieu], [Mau], [Hang]) VALUES (N'SP010', N'Áo khoác nữ', N'Len', N'Đỏ', N'Uniqlo')
GO
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH001', N'Voucher Giảm Giá 10%', 100, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH002', N'Voucher Miễn Phí Vận Chuyển', 50, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH003', N'Voucher Giảm 50.000đ', 200, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH004', N'Voucher Mua 1 Tặng 1', 150, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH005', N'Voucher Quà Tặng 100.000đ', 300, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH006', N'Voucher Miễn Phí Cước', 75, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH007', N'Voucher Giảm 20%', 120, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH008', N'Voucher Tặng Quà', 200, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH009', N'Voucher Thanh Toán Trả Trước', 80, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau]) VALUES (N'VCH010', N'Voucher Đặc Biệt', 250, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date))
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK__ChiTietHo__MaHoa__534D60F1] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK__ChiTietHo__MaHoa__534D60F1]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK__ChiTietHo__MaSan__5441852A] FOREIGN KEY([MaSanPhamChiTiet])
REFERENCES [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK__ChiTietHo__MaSan__5441852A]
GO
ALTER TABLE [dbo].[ChiTietKhuyenMai]  WITH CHECK ADD FOREIGN KEY([MaKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([MaKhuyenMai])
GO
ALTER TABLE [dbo].[ChiTietKhuyenMai]  WITH CHECK ADD FOREIGN KEY([MaSanPhamChiTiet])
REFERENCES [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([DonGia])
REFERENCES [dbo].[LichSuDonGia] ([MaDonGia])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([MaHinhAnh])
REFERENCES [dbo].[HinhAnh] ([MaHinhAnh])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([MaKichThuoc])
REFERENCES [dbo].[KichThuoc] ([MaKichThuoc])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([MaMauSac])
REFERENCES [dbo].[MauSac] ([MaMauSac])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([NCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaKhachH__4CA06362] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaKhachH__4CA06362]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaNhanVi__4BAC3F29] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NguoiDung] ([MaNguoiDung])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaNhanVi__4BAC3F29]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaVouche__4AB81AF0] FOREIGN KEY([MaVoucher])
REFERENCES [dbo].[Voucher] ([MaVoucher])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaVouche__4AB81AF0]
GO
ALTER TABLE [dbo].[NguoiDung]  WITH CHECK ADD FOREIGN KEY([Roles])
REFERENCES [dbo].[Roles] ([Marole])
GO
