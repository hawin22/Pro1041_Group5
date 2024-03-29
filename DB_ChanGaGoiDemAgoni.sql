USE [master]
GO
/****** Object:  Database [DB_ChanGaGoiDemAgoni]    Script Date: 3/27/2024 7:04:11 PM ******/
CREATE DATABASE [DB_ChanGaGoiDemAgoni]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DB_ChanGaGoiDemAgoni', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DB_ChanGaGoiDemAgoni.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DB_ChanGaGoiDemAgoni_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DB_ChanGaGoiDemAgoni_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DB_ChanGaGoiDemAgoni].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET ARITHABORT OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET RECOVERY FULL 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET  MULTI_USER 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'DB_ChanGaGoiDemAgoni', N'ON'
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET QUERY_STORE = OFF
GO
USE [DB_ChanGaGoiDemAgoni]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 3/27/2024 7:04:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[MaChatLieu] [varchar](50) NOT NULL,
	[TenChatLieu] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaChatLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 3/27/2024 7:04:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHoaDon] [varchar](100) NOT NULL,
	[MaSanPhamChiTiet] [varchar](200) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonGia] [decimal](18, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC,
	[MaSanPhamChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietKhuyenMai]    Script Date: 3/27/2024 7:04:12 PM ******/
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
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 3/27/2024 7:04:12 PM ******/
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
	[DonGia] [varchar](50) NOT NULL,
	[NCC] [varchar](50) NULL,
	[ChatLieu] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSanPhamChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhAnh]    Script Date: 3/27/2024 7:04:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhAnh](
	[MaHinhAnh] [varchar](200) NOT NULL,
	[MaSanPhamChiTiet] [varchar](200) NULL,
	[HinhAnh] [varchar](200) NULL,
 CONSTRAINT [PK__HinhAnh__A9C37A9B8C8B56E7] PRIMARY KEY CLUSTERED 
(
	[MaHinhAnh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 3/27/2024 7:04:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [varchar](100) NOT NULL,
	[NgayTao] [date] NOT NULL,
	[TrangThai] [nvarchar](100) NOT NULL,
	[MaVoucher] [varchar](50) NULL,
	[MaNhanVien] [varchar](50) NULL,
	[NgayHoanThanh] [date] NOT NULL,
	[LoaiThanhToan] [nvarchar](100) NOT NULL,
	[MaKhachHang] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 3/27/2024 7:04:12 PM ******/
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
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 3/27/2024 7:04:12 PM ******/
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
	[PTKhuyenMai] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichThuoc]    Script Date: 3/27/2024 7:04:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichThuoc](
	[MaKichThuoc] [varchar](50) NOT NULL,
	[KichThuoc] [varchar](80) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKichThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichSuDonGia]    Script Date: 3/27/2024 7:04:12 PM ******/
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
/****** Object:  Table [dbo].[MauSac]    Script Date: 3/27/2024 7:04:12 PM ******/
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
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 3/27/2024 7:04:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[MaNguoiDung] [varchar](50) NOT NULL,
	[TenNguoiDung] [nvarchar](200) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[Tuoi] [int] NOT NULL,
	[SDT] [varchar](50) NOT NULL,
	[Email] [varchar](200) NOT NULL,
	[Roles] [varchar](50) NOT NULL,
	[TenDangNhap] [varchar](200) NOT NULL,
	[MatKhau] [varchar](200) NOT NULL,
 CONSTRAINT [PK__NguoiDun__C539D762C09F64F3] PRIMARY KEY CLUSTERED 
(
	[MaNguoiDung] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 3/27/2024 7:04:12 PM ******/
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
/****** Object:  Table [dbo].[Roles]    Script Date: 3/27/2024 7:04:12 PM ******/
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
/****** Object:  Table [dbo].[SanPham]    Script Date: 3/27/2024 7:04:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [varchar](50) NOT NULL,
	[TenSanPham] [nvarchar](200) NOT NULL,
	[Mau] [nvarchar](200) NOT NULL,
	[Hang] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 3/27/2024 7:04:12 PM ******/
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
	[SoTienGiam] [decimal](18, 0) NULL,
	[SoTienYeuCau] [decimal](18, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaVoucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChatLieu] ([MaChatLieu], [TenChatLieu]) VALUES (N'CL001', N'Cotton')
INSERT [dbo].[ChatLieu] ([MaChatLieu], [TenChatLieu]) VALUES (N'CL002', N'Vải gấm thun')
INSERT [dbo].[ChatLieu] ([MaChatLieu], [TenChatLieu]) VALUES (N'CL003', N'Bông tinh khiết kháng khuẩn')
GO
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD001', N'CTSP001', 24, CAST(90000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD001', N'CTSP002', 10, CAST(200000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD001', N'CTSP003', 2, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD001', N'CTSP007', 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD001', N'CTSP010', 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD002', N'CTSP002', 3, CAST(130000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD002', N'CTSP007', 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD003', N'CTSP001', 2, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD003', N'CTSP003', 4, CAST(180000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD003', N'CTSP007', 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD004', N'CTSP004', 1, CAST(230000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD005', N'CTSP005', 2, CAST(280000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD006', N'CTSP006', 3, CAST(330000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD007', N'CTSP006', 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD007', N'CTSP007', 4, CAST(380000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD007', N'CTSP010', 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD008', N'CTSP008', 3, CAST(430000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD009', N'CTSP009', 2, CAST(480000 AS Decimal(18, 0)))
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD010', N'CTSP004', 1, NULL)
INSERT [dbo].[ChiTietHoaDon] ([MaHoaDon], [MaSanPhamChiTiet], [SoLuong], [DonGia]) VALUES (N'HD010', N'CTSP008', 1, NULL)
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
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP001', N'SP001', 90, N'KT001', N'MS001', N'DG001', N'NCC001', N'CL001')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP002', N'SP002', 150, N'KT002', N'MS002', N'DG002', N'NCC002', N'CL002')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP003', N'SP003', 197, N'KT003', N'MS003', N'DG003', N'NCC003', N'CL001')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP004', N'SP004', 249, N'KT004', N'MS004', N'DG004', N'NCC004', N'CL003')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP005', N'SP005', 300, N'KT005', N'MS005', N'DG005', N'NCC005', N'CL001')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP006', N'SP006', 119, N'KT006', N'MS006', N'DG006', N'NCC006', N'CL003')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP007', N'SP007', 179, N'KT007', N'MS007', N'DG007', N'NCC007', N'CL002')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP008', N'SP008', 217, N'KT008', N'MS008', N'DG008', N'NCC008', N'CL001')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP009', N'SP009', 270, N'KT009', N'MS009', N'DG009', N'NCC009', N'CL003')
INSERT [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet], [MaSanPham], [SoLuong], [MaKichThuoc], [MaMauSac], [DonGia], [NCC], [ChatLieu]) VALUES (N'CTSP010', N'SP010', 318, N'KT010', N'MS010', N'DG010', N'NCC010', N'CL001')
GO
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA001', N'CTSP001', N'url1')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA0010', N'CTSP001', N'url10')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA002', N'CTSP002', N'url2')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA003', N'CTSP003', N'url3')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA004', N'CTSP002', N'url4')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA005', N'CTSP004', N'url5')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA006', N'CTSP005', N'url6')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA007', N'CTSP005', N'url7')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA008', N'CTSP004', N'url8')
INSERT [dbo].[HinhAnh] ([MaHinhAnh], [MaSanPhamChiTiet], [HinhAnh]) VALUES (N'HA009', N'CTSP006', N'url9')
GO
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD001', CAST(N'2024-01-01' AS Date), N'Đã hoàn thành', N'VCH001', N'ND001', CAST(N'2024-01-02' AS Date), N'Thanh toán khi nhận hàng, Thanh toán qua thẻ', N'KH001')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD002', CAST(N'2024-02-01' AS Date), N'Chưa hoàn thành', N'VCH002', N'ND002', CAST(N'2024-02-02' AS Date), N'Thanh toán qua thẻ', N'KH002')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD003', CAST(N'2024-03-01' AS Date), N'Đã huỷ', N'VCH003', N'ND003', CAST(N'2024-03-02' AS Date), N'Thanh toán khi nhận hàng', N'KH003')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD004', CAST(N'2024-04-01' AS Date), N'Chưa hoàn thành', N'VCH004', N'ND004', CAST(N'2024-04-02' AS Date), N'Thanh toán qua thẻ', N'KH004')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD005', CAST(N'2024-05-01' AS Date), N'Đã hoàn thành', N'VCH005', N'ND005', CAST(N'2024-05-02' AS Date), N'Thanh toán khi nhận hàng', N'KH005')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD006', CAST(N'2024-06-01' AS Date), N'Đã huỷ', N'VCH006', N'ND006', CAST(N'2024-06-02' AS Date), N'Thanh toán qua thẻ', N'KH006')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD007', CAST(N'2024-07-01' AS Date), N'Đã hoàn thành', N'VCH007', N'ND007', CAST(N'2024-07-02' AS Date), N'Thanh toán khi nhận hàng', N'KH007')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD008', CAST(N'2024-08-01' AS Date), N'Chưa hoàn thành', N'VCH008', N'ND008', CAST(N'2024-08-02' AS Date), N'Thanh toán qua thẻ', N'KH008')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD009', CAST(N'2024-09-01' AS Date), N'Đã hoàn thành', N'VCH009', N'ND009', CAST(N'2024-09-02' AS Date), N'Thanh toán khi nhận hàng', N'KH009')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayTao], [TrangThai], [MaVoucher], [MaNhanVien], [NgayHoanThanh], [LoaiThanhToan], [MaKhachHang]) VALUES (N'HD010', CAST(N'2024-10-01' AS Date), N'Chưa hoàn thành', N'VCH010', N'ND010', CAST(N'2024-10-02' AS Date), N'Thanh toán qua thẻ', N'KH010')
GO
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [SDT], [DiaChi]) VALUES (N'KH001', N'Nguyễn Văn A', N'78978967899', N'Hà Nội, Việt Nam')
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
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM001', N'Khuyến mãi giảm 10%', 100, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 10)
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM002', N'Khuyến mãi giảm 20%', 50, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 15)
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM003', N'Khuyến mãi giảm 30%', 200, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 5)
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM004', N'Khuyến mãi giảm 50%', 150, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 7)
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM005', N'Khuyến mãi giảm 70%', 300, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 40)
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM006', N'Khuyến mãi giảm 80%', 75, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 50)
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM007', N'Khuyến mãi giảm 90%', 120, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 99)
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM008', N'Khuyến mãi giảm 40%', 200, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 50)
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM009', N'Khuyến mãi giảm 25%', 80, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 20)
INSERT [dbo].[KhuyenMai] ([MaKhuyenMai], [TenKhuyenMai], [SoLuong], [HanSuDung], [NgayBatDau], [PTKhuyenMai]) VALUES (N'KM010', N'Khuyến mãi giảm 15%', 250, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), 1)
GO
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT001', N'Size 1')
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT002', N'Size 2')
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT003', N'Size 3')
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT004', N'Size 4')
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT005', N'Size 5')
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT006', N'Size 6')
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT007', N'Size 7')
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT008', N'Size 8')
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT009', N'Size 8')
INSERT [dbo].[KichThuoc] ([MaKichThuoc], [KichThuoc]) VALUES (N'KT010', N'Size 10')
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
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS001', N'Đen')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS002', N'Trắng')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS003', N'Xanh Dương')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS004', N'Nâu')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS005', N'Tím')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS006', N'Xám')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS007', N'Hồng')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS008', N'Đỏ')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS009', N'Vàng')
INSERT [dbo].[MauSac] ([MaMauSac], [MauSac]) VALUES (N'MS010', N'Xanh lá')
GO
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND001', N'Nguyễn Văn An', 1, 25, N'0123456789', N'an@example.com', N'NV', N'nv_an', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND002', N'Trần Thị Bình', 0, 24, N'0987654321', N'binh@example.com', N'NV', N'nv_binh', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND003', N'Lê Văn Cường', 1, 25, N'0369876543', N'cuong@example.com', N'NV', N'nv_cuong', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND004', N'Phạm Thị Dung', 0, 26, N'0928374651', N'dung@example.com', N'NV', N'nv_dung', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND005', N'Huỳnh Văn Đạt', 1, 24, N'0778899000', N'dat@example.com', N'NV', N'nv_dat', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND006', N'Trần Văn Đức', 1, 29, N'0976543210', N'duc@example.com', N'QL', N'ql_duc', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND007', N'Nguyễn Thị Hương', 0, 30, N'0981234567', N'huong@example.com', N'QL', N'ql_huong', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND008', N'Võ Thị Lan', 0, 26, N'0912345678', N'lan@example.com', N'QL', N'ql_lan', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND009', N'Hoàng Văn Minh', 1, 31, N'0965432109', N'minh@example.com', N'QL', N'ql_minh', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'ND010', N'Lương Thị Ngọc', 0, 30, N'0934567890', N'ngoc@example.com', N'QL', N'ql_ngoc', N'password123')
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [GioiTinh], [Tuoi], [SDT], [Email], [Roles], [TenDangNhap], [MatKhau]) VALUES (N'NV0011', N'Hữu Nghĩa', 1, 28, N'0123456789', N'nghia8@gmail.com', N'NV', N'hehehe', N'1')
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
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'NV', N'Nhân viên')
INSERT [dbo].[Roles] ([Marole], [TenRole]) VALUES (N'QL', N'Quản lý')
GO
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP001', N'Gối siêu êm mềm mịn xịn sang', N'Mẫu 1', N'Viettien')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP002', N'Đệm êm ái không ái cũng ngấp ngoái', N'Mẫu 1', N'Canifa')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP003', N'Nệm foam Nhật Bản nâng đỡ cơ thể Aeroflow Standard', N'Mẫu 2', N'Levis')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP004', N'Nệm foam cân bằng trọng lực Comfy Cloud 3.0', N'Mẫu 3', N'Zara')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP005', N'Nệm foam cao cấp kháng khuẩn kép Comfy Lux 1.0', N'Mẫu 2', N'Uniqlo')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP006', N'Nệm foam Nhật Bản massage toàn diện Aeroflow Wave', N'Mẫu 1', N'Viettien')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP007', N'Nệm foam 3 vùng massage kháng khuẩn Goodnight Luna', N'Mẫu 4', N'Canifa')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP008', N'Nệm foam siêu đàn hồi Comfy Cloud 2.0', N'Mẫu 5', N'Levis')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP009', N'Nệm foam hỗ trợ cột sống Comfy Cloud 1.0', N'Mẫu 1', N'Zara')
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Mau], [Hang]) VALUES (N'SP010', N'Nệm foam Nhật massage Goodnight Osaka', N'Mẫu 5', N'Uniqlo')
GO
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH001', N'Voucher Giảm Giá 10%', 100, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(20000 AS Decimal(18, 0)), CAST(999999 AS Decimal(18, 0)))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH002', N'Voucher Miễn Phí Vận Chuyển', 50, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(10000 AS Decimal(18, 0)), CAST(200000 AS Decimal(18, 0)))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH003', N'Voucher Giảm 50.000đ', 200, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(5000 AS Decimal(18, 0)), CAST(1000000 AS Decimal(18, 0)))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH004', N'Voucher Mua 1 Tặng 1', 150, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(60000 AS Decimal(18, 0)), CAST(2000000 AS Decimal(18, 0)))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH005', N'Voucher Quà Tặng 100.000đ', 300, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(100000 AS Decimal(18, 0)), CAST(500000 AS Decimal(18, 0)))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH006', N'Voucher Miễn Phí Cước', 75, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(10000 AS Decimal(18, 0)), CAST(5000000 AS Decimal(18, 0)))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH007', N'Voucher Giảm 20%', 120, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(500000 AS Decimal(18, 0)), CAST(6000000 AS Decimal(18, 0)))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH008', N'Voucher Tặng Quà', 200, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(50000 AS Decimal(18, 0)), CAST(700000 AS Decimal(18, 0)))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH009', N'Voucher Thanh Toán Trả Trước', 80, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(40000 AS Decimal(18, 0)), CAST(450000 AS Decimal(18, 0)))
INSERT [dbo].[Voucher] ([MaVoucher], [TenVoucher], [SoLuong], [HanSuDung], [NgayBatDau], [SoTienGiam], [SoTienYeuCau]) VALUES (N'VCH010', N'Voucher Đặc Biệt', 250, CAST(N'2024-12-31' AS Date), CAST(N'2024-01-01' AS Date), CAST(5000 AS Decimal(18, 0)), CAST(4000 AS Decimal(18, 0)))
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaSanPhamChiTiet])
REFERENCES [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet])
GO
ALTER TABLE [dbo].[ChiTietKhuyenMai]  WITH CHECK ADD FOREIGN KEY([MaKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([MaKhuyenMai])
GO
ALTER TABLE [dbo].[ChiTietKhuyenMai]  WITH CHECK ADD FOREIGN KEY([MaSanPhamChiTiet])
REFERENCES [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([ChatLieu])
REFERENCES [dbo].[ChatLieu] ([MaChatLieu])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([DonGia])
REFERENCES [dbo].[LichSuDonGia] ([MaDonGia])
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
ALTER TABLE [dbo].[HinhAnh]  WITH CHECK ADD  CONSTRAINT [FK_HinhAnh_ChiTietSanPham] FOREIGN KEY([MaSanPhamChiTiet])
REFERENCES [dbo].[ChiTietSanPham] ([MaSanPhamChiTiet])
GO
ALTER TABLE [dbo].[HinhAnh] CHECK CONSTRAINT [FK_HinhAnh_ChiTietSanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaNhanVi__4CA06362] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NguoiDung] ([MaNguoiDung])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaNhanVi__4CA06362]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaVoucher])
REFERENCES [dbo].[Voucher] ([MaVoucher])
GO
ALTER TABLE [dbo].[NguoiDung]  WITH CHECK ADD  CONSTRAINT [FK__NguoiDung__Roles__4E88ABD4] FOREIGN KEY([Roles])
REFERENCES [dbo].[Roles] ([Marole])
GO
ALTER TABLE [dbo].[NguoiDung] CHECK CONSTRAINT [FK__NguoiDung__Roles__4E88ABD4]
GO
USE [master]
GO
ALTER DATABASE [DB_ChanGaGoiDemAgoni] SET  READ_WRITE 
GO
