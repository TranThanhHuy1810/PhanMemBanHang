package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DatabaseConnection;
import DAO.NhaCungCapDAO;
import Model.KhachHang;
import Model.NhaCungCap;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.List;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import DAO.NhaCungCapDAO;
public class FrmNhaCungCap extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaNhaCungCap;
    private JTextField txtTenNhaCungCap;
    private JTextField txtTenGiaoDich;
    private JTextField txtDiaChi;
    private JTextField txtDienThoai;
    private JTextField txtEmail;
    private JTextField txtTuKhoa;
    private JTable tbFrmNhaCungCap;
    private DefaultTableModel model;
    private NhaCungCapDAO nhaCungCapDAO;
    public FrmNhaCungCap() {
    	 setLayout(null);
         setBackground(new Color(173, 216, 230));
        
        // Tạo LineBorder với màu đỏ và độ dày 2
        LineBorder lineBorderTTNCC = new LineBorder(Color.BLUE, 2);

        // Tạo TitledBorder và đặt màu tiêu đề
        TitledBorder titledBorderTTNCC = new TitledBorder(lineBorderTTNCC, "Thông tin nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK);
        titledBorderTTNCC.setTitleColor(Color.BLUE); 

        // Áp dụng TitledBorder vào panelGroupTTNCC
       
       

        
        JLabel lblNhaCungCap = new JLabel("Mã Nhà Cung Cấp");
        lblNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNhaCungCap.setBounds(23, 23, 111, 14);
       add(lblNhaCungCap);
        
        JLabel lblTenNhaCungCap = new JLabel("Tên Nhà Cung Cấp");
        lblTenNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenNhaCungCap.setBounds(23, 67, 127, 14);
       add(lblTenNhaCungCap);
        
        JLabel lblTenGiaoDich = new JLabel("Tên Giao Dịch");
        lblTenGiaoDich.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenGiaoDich.setBounds(39, 114, 111, 14);
       add(lblTenGiaoDich);
        
        JLabel lblDiaChi = new JLabel("Địa Chỉ");
        lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDiaChi.setBounds(49, 158, 46, 14);
       add(lblDiaChi);
        
        JLabel lblDienThoai = new JLabel("Điện Thoại");
        lblDienThoai.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDienThoai.setBounds(413, 23, 68, 14);
        add(lblDienThoai);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEmail.setBounds(416, 67, 46, 14);
        add(lblEmail);
        
        JLabel lblTim = new JLabel("Tìm");
        lblTim.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTim.setBounds(416, 114, 46, 14);
        add(lblTim);
        
        JLabel lblTuKhoa = new JLabel("Từ Khóa");
        lblTuKhoa.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTuKhoa.setBounds(413, 158, 63, 14);
        add(lblTuKhoa);
        
        txtMaNhaCungCap = new JTextField();
        txtMaNhaCungCap.setBounds(159, 22, 172, 22);
       add(txtMaNhaCungCap);
        txtMaNhaCungCap.setColumns(10);
        
        txtTenNhaCungCap = new JTextField();
        txtTenNhaCungCap.setColumns(10);
        txtTenNhaCungCap.setBounds(160, 67, 171, 22);
        add(txtTenNhaCungCap);
        
        txtTenGiaoDich = new JTextField();
        txtTenGiaoDich.setColumns(10);
        txtTenGiaoDich.setBounds(161, 112, 170, 22);
        add(txtTenGiaoDich);
        
        txtDiaChi = new JTextField();
        txtDiaChi.setColumns(10);
        txtDiaChi.setBounds(159, 156, 172, 21);
       add(txtDiaChi);
        
        txtDienThoai = new JTextField();
        txtDienThoai.setColumns(10);
        txtDienThoai.setBounds(507, 21, 181, 23);
        add(txtDienThoai);
        
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(507, 65, 181, 24);
       add(txtEmail);
        
        txtTuKhoa = new JTextField();
        txtTuKhoa.setColumns(10);
        txtTuKhoa.setBounds(507, 155, 181, 22);
        add(txtTuKhoa);
        
        JButton btnTimKiem = new JButton("Tìm Kiếm");
        btnTimKiem.setIcon(new ImageIcon("src/image/timkiem.png"));
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnTimKiem.setBounds(712, 125, 141, 46);
        add(btnTimKiem);
        
        JComboBox<String> cbBoxTim = new JComboBox<>(new String[]{"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp"});
        cbBoxTim.setBounds(506, 110, 182, 25);
       add(cbBoxTim);
        
       
        ImageIcon fixIcon = new ImageIcon("src/image/sua.png");
		JButton btnSua = new JButton("Sửa",fixIcon);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setBounds(159, 211, 113, 41);
		add(btnSua);
        
        ImageIcon saveIcon = new ImageIcon("src/image/luu.png");
		JButton btnThem = new JButton("Thêm",saveIcon);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnThem.setBounds(39, 211, 104, 41);
       add(btnThem);
        
    	ImageIcon deleteIcon = new ImageIcon("src/image/xoa.png");
		JButton btnXoa = new JButton("Xóa",deleteIcon);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setBounds(298, 211, 111, 41);
		add(btnXoa);
        
        ImageIcon skipIcon = new ImageIcon("src/image/boqua.png");
		JButton btnBoQua = new JButton("Bỏ Qua",skipIcon);
		btnBoQua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBoQua.setBounds(440, 211, 123, 41);
		add(btnBoQua);
        
      
        
        model = new DefaultTableModel(new String[]{"Mã NCC", "Tên NCC", "Tên Giao Dịch", "Địa Chỉ", "SĐT","Email"}, 0);
        tbFrmNhaCungCap = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbFrmNhaCungCap);
        scrollPane.setBounds(10, 275, 875, 156);
       add(scrollPane);

        Connection conn = DatabaseConnection.getConnection();
        nhaCungCapDAO = new NhaCungCapDAO(conn);
        loadDataToTable();
       
        btnThem.addActionListener(this::addNhaCungCap);
        btnSua.addActionListener(this::updateNhaCungCap);
        btnXoa.addActionListener(this::XoaNhaCungCap);
        btnTimKiem.addActionListener(this::searchNhaCungCap);
        btnBoQua.addActionListener(e -> {
        	 txtMaNhaCungCap.setText("");
             txtTenNhaCungCap.setText("");
             txtTenGiaoDich.setText("");
             txtDiaChi.setText("");
             txtDienThoai.setText("");
             txtEmail.setText("");
            loadDataToTable();
            txtTuKhoa.setText("");
        });
        
      
    }
    private void loadDataToTable() {
        model.setRowCount(0);
        List<NhaCungCap> danhSach =nhaCungCapDAO.getAllNhaCungCap() ;
        for (NhaCungCap ncc : danhSach) {
            model.addRow(new Object[]{ncc.getMaNCC(),ncc.getTenNCC(),ncc.getTenGiaoDich(),ncc.getDiaChi(),ncc.getDienThoai(),ncc.getEmail()});
        }
        tbFrmNhaCungCap.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tbFrmNhaCungCap.getSelectedRow(); 
            if (selectedRow >= 0) { 
                String maNCC = model.getValueAt(selectedRow, 0).toString(); 
                String tenNCC = model.getValueAt(selectedRow, 1).toString();
                String tenGiaoDich = model.getValueAt(selectedRow, 2).toString(); 
                String diaChi = model.getValueAt(selectedRow, 3).toString();  
                String soDT = model.getValueAt(selectedRow, 4).toString(); 
                String email = model.getValueAt(selectedRow, 5).toString(); 

                txtMaNhaCungCap.setText(maNCC);
                txtTenNhaCungCap.setText(tenNCC);
                txtTenGiaoDich.setText(tenGiaoDich);
                txtDiaChi.setText(diaChi);
                txtDienThoai.setText(soDT);
                txtEmail.setText(email);
            }
        });
    }
    private void addNhaCungCap(ActionEvent e) {
        String maNCC = txtMaNhaCungCap.getText().trim();
        String tenNCC = txtTenNhaCungCap.getText().trim();
        String tenGiaoDich = txtTenGiaoDich.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String dienThoai = txtDienThoai.getText().trim();
        String email = txtEmail.getText().trim();
        
        if (maNCC.isEmpty() || tenNCC.isEmpty() || tenGiaoDich.isEmpty() || diaChi.isEmpty() || dienThoai.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        
        if (!dienThoai.matches("\\d{10,11}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! (Phải có 10-11 chữ số)");
            return;
        }
        
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!");
            return;
        }
        
        NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, tenGiaoDich, diaChi, dienThoai, email);
        if (nhaCungCapDAO.ThemNhaCungCap(ncc)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại!");
        }
    }

    private void updateNhaCungCap(ActionEvent e) {
    	 NhaCungCap ncc = new NhaCungCap(
        		txtMaNhaCungCap.getText(),
        		txtTenNhaCungCap.getText(),
        		txtTenGiaoDich.getText(),
                txtDiaChi.getText(),
                txtDienThoai.getText(),
                txtEmail.getText()
        );
        if (nhaCungCapDAO.suaNhaCungCap(ncc)) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
        }
    }
	 private void XoaNhaCungCap(ActionEvent e) {
	        String maNhaCungCap = 	txtMaNhaCungCap.getText();
	        if (nhaCungCapDAO.xoaNhaCungCap(maNhaCungCap)) {
	            JOptionPane.showMessageDialog(this, "Xóa thành công!");
	            loadDataToTable();
	        } else {
	            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
	        }
	    }
	 private void searchNhaCungCap(ActionEvent e) {
		 String tuKhoa = txtTuKhoa.getText();
		    List<NhaCungCap> list = nhaCungCapDAO.searchNhaCungCap(tuKhoa); 
		    model.setRowCount(0);
		    for (NhaCungCap ncc : list) {
		        model.addRow(new Object[]{ncc.getMaNCC(),ncc.getTenNCC(),ncc.getTenGiaoDich(),ncc.getDiaChi(),ncc.getDienThoai(),ncc.getEmail()});
		    }
		    tbFrmNhaCungCap.setModel(model);
	 }
 }