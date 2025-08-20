package UI;
import org.jfree.chart.ChartFactory;
import DAO.DatabaseConnection;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
public class ThongKe extends JPanel {
	 private JTable tableTopProducts, tableBills;
     private DefaultTableModel modelTopProducts, modelBills;
     private JPanel chartPanel;
     private Connection conn;
     public ThongKe() {
         setLayout(new BorderLayout());
         // Panel biểu đồ
         chartPanel = new JPanel(new BorderLayout());
         chartPanel.setPreferredSize(new Dimension(600, 400));
         add(chartPanel, BorderLayout.NORTH);
         conn=DatabaseConnection.getConnection();
         // Bảng sản phẩm bán chạy
         modelTopProducts = new DefaultTableModel();
         modelTopProducts.setColumnIdentifiers(new String[]{"Tên mặt hàng", "Số lượng bán"});
         tableTopProducts = new JTable(modelTopProducts);

         // Bảng hóa đơn
         modelBills = new DefaultTableModel();
         modelBills.setColumnIdentifiers(new String[]{"Mã HĐ", "Ngày", "Tổng tiền"});
         tableBills = new JTable(modelBills);

         // Chia khu vực bảng
         JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                 new JScrollPane(tableTopProducts), new JScrollPane(tableBills));
         splitPane.setResizeWeight(0.5);
         add(splitPane, BorderLayout.CENTER);
         loadRevenueChart();
         loadTopProducts();
         loadBills();
         // Tải dữ liệu
     }
     private void loadRevenueChart() {
    	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	    String query = "SELECT Ngay, SUM(TRIGIA) AS DoanhThu FROM HOADON  GROUP BY Ngay";
    	    
    	    try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
    	        while (rs.next()) {
    	            String ngay = rs.getString("Ngay");
    	            int doanhThu = rs.getInt("DoanhThu");
    	            
    	            if (ngay != null) {
    	                dataset.addValue(doanhThu, "Doanh thu", ngay);
    	            } else {
    	                System.out.println("Lỗi: Ngày null trong kết quả truy vấn.");
    	            }
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    
    	    JFreeChart chart = ChartFactory.createBarChart(
    	            "Doanh thu theo ngày", "Ngày", "Doanh thu",
    	            dataset);
    	    
    	    CategoryPlot plot = (CategoryPlot) chart.getPlot();
    	    chartPanel.removeAll();
    	    chartPanel.add(new ChartPanel(chart));
    	    chartPanel.revalidate();
    	}

     private void loadTopProducts() {
    	    modelTopProducts.setRowCount(0);
    	    String query = "SELECT TOP 10 MAHANG, SUM(SL) AS THANHTIEN FROM CTHD GROUP BY MAHANG ORDER BY THANHTIEN DESC";

    	    try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
    	        while (rs.next()) {
    	            Vector<Object> row = new Vector<>();
    	            row.add(rs.getString("MAHANG"));
    	            row.add(rs.getInt("THANHTIEN"));
    	            modelTopProducts.addRow(row);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	}
     private void loadBills() {
    	    modelBills.setRowCount(0);
    	    String query = "SELECT SOHD, Ngay, TRIGIA FROM HOADON WHERE Ngay IS NOT NULL ORDER BY Ngay DESC";

    	    try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
    	        while (rs.next()) {
    	            Vector<Object> row = new Vector<>();
    	            row.add(rs.getString("SOHD")); // Sử dụng getString() cho SOHD vì kiểu nvarchar
    	            row.add(rs.getDate("Ngay")); // Sử dụng getDate() cho Ngay kiểu Date
    	            row.add(rs.getBigDecimal("TRIGIA")); // Sử dụng getBigDecimal() cho TRIGIA kiểu money
    	            modelBills.addRow(row);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	}

    
}
