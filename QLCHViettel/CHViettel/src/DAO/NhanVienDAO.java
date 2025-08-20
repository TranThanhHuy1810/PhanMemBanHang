package DAO;

import Model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    private static Connection conn;

    public NhanVienDAO(Connection conn) {
        this.conn = conn;
    }

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new NhanVien(
                    rs.getString("MANV"),
                    rs.getString("HOTEN"),
                    rs.getString("GIOITINHNV"),
                    rs.getString("SODT"),
                    rs.getString("LOAINV")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean themNhanVien(NhanVien nv) {
        String sql = "INSERT INTO NHANVIEN (MANV, HOTEN, GIOITINHNV, SODT, LOAINV) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nv.getMaNV());
            pstmt.setString(2, nv.getTenNV());
            pstmt.setString(3, nv.getGioiTinh());
            pstmt.setString(4, nv.getSoDT());
            pstmt.setString(5, nv.getLoaiNV());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean suaNhanVien(NhanVien nv) {
        String sql = "UPDATE NHANVIEN SET HOTEN=?, GIOITINHNV=?, SODT=?, LOAINV=? WHERE MANV=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nv.getTenNV());
            pstmt.setString(2, nv.getGioiTinh());
            pstmt.setString(3, nv.getSoDT());
            pstmt.setString(4, nv.getLoaiNV());
            pstmt.setString(5, nv.getMaNV());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean xoaNhanVien(String maNV) {
        String sql = "DELETE FROM NHANVIEN WHERE MANV=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maNV);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public static List<NhanVien> loadDataNhanVien() {
		List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new NhanVien(
                    rs.getString("MANV"),
                    rs.getString("HOTEN"),
                    rs.getString("GIOITINHNV"),
                    rs.getString("SODT"),
                    rs.getString("LOAINV") 
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}