package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Model.DanhSachTaiKhoan;
import Model.TaiKhoan;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtTenTaiKhoan;
    private JPasswordField txtMatKhau; 

   
    public Login() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/image/home.png"));
        setTitle("FrmDangNhap");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 742, 421);
        setResizable(false);
        setLocationRelativeTo(null); 

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTenTaiKhoan = new JLabel("Tên tài khoản");
        lblTenTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenTaiKhoan.setBounds(396, 65, 100, 25);
        contentPane.add(lblTenTaiKhoan);

        txtTenTaiKhoan = new JTextField();
        txtTenTaiKhoan.setBounds(517, 66, 176, 25);
        contentPane.add(txtTenTaiKhoan);

        JLabel lblMatKhau = new JLabel("Mật khẩu");
        lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMatKhau.setBounds(411, 138, 100, 25);
        contentPane.add(lblMatKhau);

        txtMatKhau = new JPasswordField();
        txtMatKhau.setBounds(517, 139, 176, 25);
        contentPane.add(txtMatKhau);
        
        JButton btnDangNhap = new JButton("Đăng Nhập");
        btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDangNhap.setBounds(453, 191, 125, 40);
        contentPane.add(btnDangNhap);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnThoat.setBounds(616, 191, 102, 40);
        contentPane.add(btnThoat);
        
        JLabel lblDangNhap = new JLabel("Đăng Nhập");
        lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblDangNhap.setForeground(Color.BLUE);
        lblDangNhap.setBounds(533, 11, 160, 30);
        contentPane.add(lblDangNhap);
        ImageIcon Icon = new ImageIcon("src/image/logo.jpg");
        Image img = Icon.getImage();
        Image resizedImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        Icon = new ImageIcon(resizedImg);

        // Create JLabel and set the image icon
        JLabel lblNewLabel = new JLabel(Icon);
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setBounds(10, 11, 340, 362);  // Position and size of JLabel
        contentPane.add(lblNewLabel);

        // Xử lý sự kiện đăng nhập
        btnDangNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtTenTaiKhoan.getText();
                String password = new String(txtMatKhau.getPassword());

                if (kiemTraDangNhap(username, password)) {
                    JOptionPane.showMessageDialog(Login.this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    TrangChu TrangChu = new TrangChu();
                    TrangChu.setVisible(true);
                    dispose(); // Đóng cửa sổ đăng nhập
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Sai tài khoản hoặc mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Thoát chương trình khi bấm nút "Thoát"
        btnThoat.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(Login.this, "Bạn có muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0); 
            }
        });
    }

    private boolean kiemTraDangNhap(String username, String password) {
        for (TaiKhoan tk : DanhSachTaiKhoan.getInstance().getListTaiKhoan()) {
            if (tk.getUsername().equals(username) && tk.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
