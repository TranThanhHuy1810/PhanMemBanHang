package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.CTHD;
public class CTHDDAO {
	private Connection conn;
	public CTHDDAO(Connection conn) {
        this.conn = conn;
    }
	public List<CTHD> getAllCTHD(String sohd) {  
	    List<CTHD> list = new ArrayList<>();  
	    String sql = "SELECT a.MAHANG, b.TENSP, a.SL, b.GIA, a.GIAMGIA, a.THANHTIEN FROM CTHD AS a, MATHANG AS b WHERE a.SOHD = ? AND a.MAHANG = b.MAHANG";  

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {  
	        pstmt.setString(1, sohd);  // Truyền giá trị SOHD vào dấu ?
	        try (ResultSet rs = pstmt.executeQuery()) {  
	            while (rs.next()) {  
	                list.add(new CTHD(
	                    rs.getString("MAHANG"),
	                    rs.getString("TENSP"),
	                    rs.getInt("SL"),
	                    rs.getDouble("GIA"),  // Đổi DONGIA thành GIA
	                    rs.getInt("GIAMGIA"),
	                    rs.getDouble("THANHTIEN")
	                ));
	            }  
	        }  
	    } catch (SQLException e) {  
	        e.printStackTrace();  
	    }  
	    return list;  
	}

}
