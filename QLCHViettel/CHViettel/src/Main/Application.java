package Main;

import DAO.DatabaseConnection;

import UI.Login;
import javax.swing.SwingUtilities;
import java.sql.Connection;
import UI.TrangChu;
public class Application {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Kết nối database thất bại!");
            return;
        }
        SwingUtilities.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("Đã đóng kết nối database.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
}
