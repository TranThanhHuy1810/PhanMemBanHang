package DAO;

import Model.KhachHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {
    private static Connection conn;

    public KhachHangDAO(Connection conn) {
        this.conn = conn;
    }

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new KhachHang(
                    rs.getString("MAKH"),
                    rs.getString("HOTEN"),
                    rs.getString("GIOITINHKH"),
                    rs.getString("DCHI"),
                    rs.getString("SODT"),
                    rs.getString("LOAIKH")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean themKhachHang(KhachHang kh) {
        String sql = "INSERT INTO KHACHHANG (MAKH, HOTEN,GIOITINHKH, DCHI, SODT, LOAIKH) VALUES (?, ?, ?, ?, ?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kh.getMaKH());
            pstmt.setString(2, kh.getTenKH());
            pstmt.setString(3, kh.getGioiTinh());
            pstmt.setString(4, kh.getDiaChi());
            pstmt.setString(5, kh.getSoDT());
            pstmt.setString(6, kh.getLoaiKH());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean suaKhachHang(KhachHang kh) {
        String sql = "UPDATE KHACHHANG SET HOTEN=?,  GIOITINHKH=? ,DCHI=?,SODT=?, LOAIKH=? WHERE MAKH=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kh.getTenKH());
            pstmt.setString(2, kh.getGioiTinh());
            pstmt.setString(3, kh.getDiaChi());
            pstmt.setString(4, kh.getSoDT());
            pstmt.setString(5, kh.getLoaiKH());
            pstmt.setString(6, kh.getMaKH());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean xoaKhachHang(String maKH) {
        String sql = "DELETE FROM KHACHHANG WHERE MAKH=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maKH);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<KhachHang> loadDataKhachHang() {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new KhachHang(
                    rs.getString("MAKH"),
                    rs.getString("HOTEN"),
                    rs.getString("GIOITINHKH"),
                    rs.getString("DCHI"),
                    rs.getString("SODT"),
                    rs.getString("LOAIKH")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<KhachHang> searchKhachHang(String keyword) {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE ? OR HOTEN LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String maKH = rs.getString("MAKH");
                    String tenKH = rs.getString("HOTEN");
                    String gioiTinh = rs.getString("GIOITINHKH");
                    String diaChi = rs.getString("DCHI");
                    String soDT = rs.getString("SODT");
                    String loaiKH = rs.getString("LOAIKH");
                    list.add(new KhachHang(maKH, tenKH, gioiTinh, diaChi, soDT, loaiKH));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
