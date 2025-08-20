package DAO;
import Model.LoaiHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.SanPham;
public class SanPhamDAO {
    private Connection conn;

    public SanPhamDAO(Connection conn) {
        this.conn = conn;
    }
    public List<LoaiHang> getAllLoaiHang() {
        List<LoaiHang> loaiHang = new ArrayList<>();
        String sql = "SELECT * FROM LOAIHANG";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                LoaiHang loaiHang1 = new LoaiHang(
                    rs.getString("MALOAI"),
                    rs.getString("TENLOAI")
          
                );
                loaiHang.add(loaiHang1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiHang;
    }
    public List<SanPham> getAllSanPham() {
        List<SanPham> sanPhamList = new ArrayList<>();
        String sql = "SELECT * FROM MATHANG";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                SanPham sanPham = new SanPham(
                    rs.getString("MAHANG"),
                    rs.getString("MALOAI"),
                    rs.getString("MANCC"),
                    rs.getString("TENSP"),
                    rs.getString("DVT"),
                    rs.getString("NUOCSX"),
                    rs.getDouble("GIA"),
                    rs.getString("ANH"),
                    rs.getString("GHICHU"),
                    rs.getInt("SOLUONG")
                );
                sanPhamList.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }

    public boolean insertMatHang(SanPham sp) {
				String sql = "INSERT INTO MATHANG (MAHANG, MALOAI, MANCC, TENSP, DVT, NUOCSX, GIA, ANH, GHICHU, SOLUONG) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
				
				pstmt.setString(1, sp.getMaHang());
				pstmt.setString(2, sp.getMaLoai());
				pstmt.setString(3, sp.getMaNcc());
				pstmt.setString(4, sp.getTenSP());
				pstmt.setString(5, sp.getDvt());
				pstmt.setString(6, sp.getNuocSX());
				pstmt.setDouble(7, sp.getGiaTien());
				pstmt.setString(8, sp.getAnh());
				pstmt.setString(9, sp.getGhiChu());
				pstmt.setInt(10, sp.getSoLuong());
				
				
				int rowsAffected = pstmt.executeUpdate();
				return rowsAffected > 0; 
				
				} catch (SQLException e) {
				e.printStackTrace();
				return false; 
				}
	}
    // Method to update SanPham

    public boolean updateSanPham(SanPham sanPham) {
        String sql = "UPDATE MATHANG SET MALOAI=?,MANCC=?,TENSP=?, DVT=?, NUOCSX=?, GIA=?, ANH=?, GHICHU=?, SOLUONG=? WHERE MAHANG=?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, sanPham.getMaLoai());
        	stmt.setString(2, sanPham.getMaNcc());
        	stmt.setString(3, sanPham.getTenSP());
            stmt.setString(4, sanPham.getDvt());
            stmt.setString(5, sanPham.getNuocSX());
            stmt.setDouble(6, sanPham.getGiaTien());
            stmt.setString(7, sanPham.getAnh());
            stmt.setString(8, sanPham.getGhiChu());
            stmt.setInt(9, sanPham.getSoLuong());
            stmt.setString(10, sanPham.getMaHang());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSanPham(String maHang) {
        String sql = "DELETE FROM MATHANG WHERE MAHANG=?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maHang);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<SanPham> searchSanPham(String keyword) {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM MATHANG WHERE MAHANG LIKE ? OR MALOAI LIKE ? OR MANCC LIKE ? OR TENSP LIKE ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + keyword + "%");
            stmt.setString(4, "%" + keyword + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(
                    rs.getString("MAHANG"),
                    rs.getString("MALOAI"),
                    rs.getString("MANCC"),
                    rs.getString("TENSP"),
                    rs.getString("DVT"),
                    rs.getString("NUOCSX"),
                    rs.getDouble("GIA"),
                    rs.getString("ANH"),
                    rs.getString("GHICHU"),
                    rs.getInt("SOLUONG")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

