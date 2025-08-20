package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDonDAO {
    private Connection conn;

    // Constructor để truyền kết nối từ ngoài vào
    public HoaDonDAO(Connection connection) {
        this.conn = connection; // Gán kết nối được truyền vào
    }

    // Phương thức để lấy giá trị từ cơ sở dữ liệu
    public String getFieldValues(String sql, String param) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String result = "";

        try {
            // Kiểm tra kết nối có hợp lệ hay không
            if (conn == null || conn.isClosed()) {
                throw new SQLException("Kết nối CSDL không hợp lệ.");
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, param); 

            // Thực thi truy vấn
            rs = pstmt.executeQuery();

            // Nếu có dữ liệu, lấy kết quả
            if (rs.next()) {
                result = rs.getString(1); // Lấy giá trị cột đầu tiên
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn CSDL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng tài nguyên đúng cách
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
