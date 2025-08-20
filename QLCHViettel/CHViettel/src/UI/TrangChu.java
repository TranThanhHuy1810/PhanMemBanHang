package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class TrangChu extends JFrame {
    private String username;
    private JPanel mainPanel;
    private JLabel lblTitle; // Thêm biến để thay đổi tiêu đề

    public TrangChu() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("src/image/giaodien.png"));
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Mở full màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        // 🟢 Panel menu bên trái
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(10, 1, 5, 5));
        menuPanel.setBackground(new Color(0, 128, 128));

        // Danh sách các nút menu
        String[][] buttons = {
            {"Trang chủ", "src/image/giaodien.png"},
            {"Nhân viên", "src/image/nhanvien.png"},
            {"Khách hàng", "src/image/khachhang.png"},
            {"Nhà Cung Cấp", "src/image/nhacc.png"},
            {"Sản Phẩm", "src/image/sanpham.png"},
            {"Hóa Đơn", "src/image/hoadon.png"},
            {"Thống kê", "src/image/category.jpg"} 
        };

        // Xử lý sự kiện bằng switch-case
        ActionListener menuListener = new MenuActionListener();

        for (String[] btnData : buttons) {
            JButton button = createButton(btnData[0], btnData[1]);
            button.setActionCommand(btnData[0]);
            button.addActionListener(menuListener);
            menuPanel.add(button);
        }

        // 🔴 Nút Thoát (đỏ)
//        JButton btnExit = createButton("Thoát", "src/images/exit.png");
//        btnExit.setBackground(Color.RED);
//        btnExit.setForeground(Color.WHITE);
//        btnExit.setActionCommand("Thoát");
//        btnExit.addActionListener(menuListener);
//        menuPanel.add(btnExit);

        // 🟦 Panel tiêu đề (Header)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 128, 128));

        // 🔍 Logo bên trái
        ImageIcon logoIcon = new ImageIcon("src/image/logo.jpg");
        Image logoImage = logoIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(logoImage));

        // 📝 Tiêu đề
        lblTitle = new JLabel("Trang chủ - Chào, " + username + "!", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(Color.WHITE);

        // 🔄 Nút Đăng xuất (phải)
        JButton btnLogout = new JButton();
        ImageIcon iconLogout = new ImageIcon("src/image/dangxuat.png");
        Image img = iconLogout.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        btnLogout.setIcon(new ImageIcon(img));
        btnLogout.setPreferredSize(new Dimension(80, 50));
        btnLogout.setBackground(Color.WHITE);
        btnLogout.setActionCommand("Đăng xuất");
        btnLogout.addActionListener(menuListener);

        // 🏗 Thêm các thành phần vào header
        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitle, BorderLayout.CENTER);
        headerPanel.add(btnLogout, BorderLayout.EAST);

        // 🎨 Panel chính hiển thị nội dung
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(152, 251, 152));
        updateMainPanel("Trang chủ"); // Hiển thị giao diện ban đầu

        // 🏗 Thêm các thành phần vào JFrame
        getContentPane().add(menuPanel, BorderLayout.WEST);
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    // 📌 Hàm tạo nút có hình và chữ
    private JButton createButton(String text, String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JButton button = new JButton(text, new ImageIcon(scaledImage));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setPreferredSize(new Dimension(150, 50));
        return button;
    }

    private void updateMainPanel(String command) {
        mainPanel.removeAll();
        lblTitle.setText(command); // Cập nhật tiêu đề

        switch (command) {
            case "Trang chủ":
            	// Tải ảnh gốc
            	ImageIcon logoIcon = new ImageIcon("src/image/backgr.jpg");
            	Image originalImage = logoIcon.getImage();

            	// Tạo một BufferedImage mới với kích thước mong muốn
            	BufferedImage resizedImage = new BufferedImage(1130, 600, BufferedImage.TYPE_INT_ARGB);

            	// Dùng Graphics2D để vẽ lại ảnh với chất lượng cao
            	Graphics2D g2d = resizedImage.createGraphics();
            	g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            	g2d.drawImage(originalImage, 0, 0, 1130, 600, null);
            	g2d.dispose();

            	// Tạo JLabel và thêm vào mainPanel
            	JLabel lblLogo = new JLabel(new ImageIcon(resizedImage), SwingConstants.CENTER);
            	mainPanel.add(lblLogo, BorderLayout.CENTER);

                break;

            case "Nhân viên":
                mainPanel.add(new FrmNhanVien(), BorderLayout.CENTER);
                break;
                
            case "Khách hàng":
                mainPanel.add(new FrmKhachHang(), BorderLayout.CENTER);
                break;
                
            case "Nhà Cung Cấp":
                mainPanel.add(new FrmNhaCungCap(), BorderLayout.CENTER);
                break;
                
            case "Sản Phẩm":
                mainPanel.add(new FrmSanPham(), BorderLayout.CENTER);
                break;
                
            case "Hóa Đơn":
                mainPanel.add(new FrmHoaDon(), BorderLayout.CENTER);
                break;
                
            case "Thống kê":
                mainPanel.add(new ThongKe(), BorderLayout.CENTER); // FrmThongKe là JPanel thống kê bạn tạo
                break;
                
            case "Đăng xuất":
                int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    this.dispose();
                    new Login().setVisible(true);
                }
                return;

            case "Thoát":
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                return;

            default:
                mainPanel.add(new JLabel("Giao diện " + command + " đang phát triển...", SwingConstants.CENTER), BorderLayout.CENTER);
                break;
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // 🎯 Xử lý sự kiện menu bằng switch-case
    private class MenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateMainPanel(e.getActionCommand());
        }
    }

}