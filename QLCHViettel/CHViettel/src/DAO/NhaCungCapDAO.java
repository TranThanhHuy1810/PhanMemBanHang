package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.NhaCungCap;
public class NhaCungCapDAO {
	 private static Connection conn;
	 public NhaCungCapDAO(Connection conn) {
	        this.conn = conn;
	    }
	 public List<NhaCungCap> getAllNhaCungCap() {
	        List<NhaCungCap> list = new ArrayList<>();
	        String sql = "SELECT * FROM NHACC";

	        try (Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                list.add(new NhaCungCap(
	                        rs.getString("MANCC"),
	                        rs.getString("TENNCC"),
	                        rs.getString("TENGIAODICH"),
	                        rs.getString("DIACHI"),
	                        rs.getString("DIENTHOAI"),
	                        rs.getString("EMAIL")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    public boolean ThemNhaCungCap(NhaCungCap ncc) {
	        String sql = "INSERT INTO NHACC(MANCC,TENNCC,TENGIAODICH,DIACHI,DIENTHOAI,EMAIL) VALUES (?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, ncc.getMaNCC());
	            stmt.setString(2, ncc.getTenNCC());
	            stmt.setString(3, ncc.getTenGiaoDich());
	            stmt.setString(4, ncc.getDiaChi());
	            stmt.setString(5, ncc.getDienThoai());
	            stmt.setString(6, ncc.getEmail());

	            return stmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public boolean suaNhaCungCap(NhaCungCap ncc) {
	        String sql = "UPDATE NHACC SET TENNCC=?, TENGIAODICH=?, DIACHI=?, DIENTHOAI=?, EMAIL=? WHERE MANCC=?";

	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, ncc.getTenNCC());
	            stmt.setString(2, ncc.getTenGiaoDich());
	            stmt.setString(3, ncc.getDiaChi());
	            stmt.setString(4, ncc.getDienThoai());
	            stmt.setString(5, ncc.getEmail());
	            stmt.setString(6, ncc.getMaNCC());

	            return stmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public boolean xoaNhaCungCap(String maNCC) {
	        String sql = "DELETE FROM NHACC WHERE MANCC=?";

	        try (  PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, maNCC);
	            return stmt.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public List<NhaCungCap> searchNhaCungCap(String keyword) {
	        List<NhaCungCap> list = new ArrayList<>();
	        String sql = "SELECT * FROM NHACC WHERE MANCC LIKE ? OR TENNCC LIKE ?";

	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, "%" + keyword + "%");
	            stmt.setString(2, "%" + keyword + "%");

	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                list.add(new NhaCungCap(
	                        rs.getString("MANCC"),
	                        rs.getString("TENNCC"),
	                        rs.getString("TENGIAODICH"),
	                        rs.getString("DIACHI"),
	                        rs.getString("DIENTHOAI"),
	                        rs.getString("EMAIL")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
}
