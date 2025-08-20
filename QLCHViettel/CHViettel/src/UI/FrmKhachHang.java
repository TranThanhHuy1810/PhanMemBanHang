package UI;
import DAO.KhachHangDAO;
import Model.KhachHang;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DatabaseConnection;
import DAO.NhanVienDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmKhachHang extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtLoaiKH;
	private JTextField txtTuKhoa;
	private JTable tbFromKhachHang;
	private JComboBox<String> cboGioiTinh; 
	private DefaultTableModel model;
	 private KhachHangDAO khachHangDAO;
	public FrmKhachHang() {
		 setBackground(new Color(173, 216, 230));
	       setLayout(null);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng");
		lblMaKhachHang.setBounds(48, 30, 100, 20);
		add(lblMaKhachHang);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng");
		lblTenKhachHang.setBounds(48, 80, 100, 20);
		add(lblTenKhachHang);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setBounds(48, 127, 100, 20);
		add(lblGioiTinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setBounds(578, 130, 46, 14);
		add(lblDiaChi);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại");
		lblSoDienThoai.setBounds(550, 33, 96, 14);
		add(lblSoDienThoai);
		
		JLabel lblLoaiKhachHang = new JLabel("Loại KH");
		lblLoaiKhachHang.setBounds(578, 82, 68, 16);
		add(lblLoaiKhachHang);
		
		JLabel lblTim = new JLabel("Tìm");
		lblTim.setBounds(75, 234, 46, 14);
		add(lblTim);
		
		JLabel lblTuKhoa = new JLabel("Từ Khóa");
		lblTuKhoa.setBounds(334, 240, 68, 14);
		add(lblTuKhoa);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBounds(189, 27, 195, 25);
		add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(189, 77, 195, 25);
		add(txtTenKhachHang);
		
		 cboGioiTinh = new JComboBox<>(new String[]{"Nam", "Nữ"}); 
	     cboGioiTinh.setBounds(189, 125, 195, 25);
	  add(cboGioiTinh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(640, 125, 215, 25);
		add(txtDiaChi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(640, 27, 174, 25);
		add(txtSoDienThoai);
		
		txtLoaiKH = new JTextField();
		txtLoaiKH.setColumns(10);
		txtLoaiKH.setBounds(640, 78, 174, 25);
		add(txtLoaiKH);
		
		txtTuKhoa = new JTextField();
		txtTuKhoa.setColumns(10);
		txtTuKhoa.setBounds(388, 229, 179, 25);
		add(txtTuKhoa);
		
		JComboBox<String> cbBoxTim = new JComboBox<>(new String[]{"Mã Khách Hàng", "Tên Khách Hàng"});
		cbBoxTim.setBounds(131, 229, 182, 25);
		add(cbBoxTim);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
        btnTimKiem.setIcon(new ImageIcon("src/image/timkiem.png"));
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnTimKiem.setBounds(607, 220, 131, 41);
		add(btnTimKiem);
		
		ImageIcon saveIcon = new ImageIcon("src/image/luu.png");
		JButton btnThem = new JButton("Thêm",saveIcon);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem .setBounds(48, 177, 117, 41);
		add(btnThem );
		
		ImageIcon fixIcon = new ImageIcon("src/image/sua.png");
		JButton btnSua = new JButton("Sửa",fixIcon);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setBounds(206, 177, 107, 41);
		add(btnSua);
		
		
		ImageIcon deleteIcon = new ImageIcon("src/image/xoa.png");
		JButton btnXoa = new JButton("Xóa",deleteIcon);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa .setBounds(352, 177, 109, 41);
		add(btnXoa);
		
		ImageIcon skipIcon = new ImageIcon("src/image/boqua.png");
		JButton btnBoQua = new JButton("Bỏ Qua",skipIcon);
		btnBoQua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBoQua.setBounds(507, 177, 117, 41);
		add(btnBoQua);
		
		
		model = new DefaultTableModel(new String[]{"Mã KH", "Tên KH", "Giới Tính","Địa Chỉ", "SĐT", "Loại KH"}, 0);
		tbFromKhachHang = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(tbFromKhachHang);
		 scrollPane.setBounds(10, 263, 918, 152);
	     add(scrollPane);
	     
	     Connection conn = DatabaseConnection.getConnection();
	      khachHangDAO = new KhachHangDAO(conn);
	      loadDataToTable();
	      	btnThem.addActionListener(this::addKhachHang);
	        btnSua.addActionListener(this::updateKhachHang);
	        btnXoa.addActionListener(this::deleteKhachHang);
	        btnTimKiem.addActionListener(this::searchKhachHang);
	
	        btnBoQua.addActionListener(e -> {
	            txtMaKhachHang.setText("");
	            txtTenKhachHang.setText("");
	            txtSoDienThoai.setText("");
	            txtLoaiKH.setText("");
	            txtDiaChi.setText("");
	            cboGioiTinh.setSelectedIndex(0); 
	            loadDataToTable();
	            txtTuKhoa.setText("");
	        });
	}
	private void loadDataToTable() {
		model.setRowCount(0);
		 List<KhachHang> list = khachHangDAO.getAllKhachHang();
	        for (KhachHang kh : list) {
	            model.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getGioiTinh(), kh.getDiaChi(), kh.getSoDT(), kh.getLoaiKH()});
	        }
	        tbFromKhachHang.setModel(model);
	        tbFromKhachHang.getSelectionModel().addListSelectionListener(e -> {
	            int selectedRow = tbFromKhachHang.getSelectedRow(); 
	            if (selectedRow >= 0) { 
	                String makh = model.getValueAt(selectedRow, 0).toString(); 
	                String tenkh = model.getValueAt(selectedRow, 1).toString();
	                String gioiTinh = model.getValueAt(selectedRow, 2).toString(); 
	                String DiaChi=model.getValueAt(selectedRow,3).toString();
	                String soDT = model.getValueAt(selectedRow, 4).toString();  
	                String loaikh = model.getValueAt(selectedRow, 5).toString(); 
	                txtMaKhachHang.setText(makh);
	                txtTenKhachHang.setText(tenkh);
	                cboGioiTinh.setSelectedItem(gioiTinh);
	                txtDiaChi.setText(DiaChi);
	                txtSoDienThoai.setText(soDT);
	                txtLoaiKH.setText(loaikh);
	            }
	        });
	}
	private void addKhachHang(ActionEvent e) {
	    String maKH = txtMaKhachHang.getText().trim();
	    String tenKH = txtTenKhachHang.getText().trim();
	    String gioiTinh = (String) cboGioiTinh.getSelectedItem();
	    String diaChi = txtDiaChi.getText().trim();
	    String soDT = txtSoDienThoai.getText().trim();
	    String loaiKH = txtLoaiKH.getText().trim();
	    
	    if (maKH.isEmpty() || tenKH.isEmpty() || gioiTinh == null || diaChi.isEmpty() || soDT.isEmpty() || loaiKH.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
	        return;
	    }
	    
	    if (!soDT.matches("\\d{10,11}")) {
	        JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! (Phải có 10-11 chữ số)");
	        return;
	    }
	    
	    KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, diaChi, soDT, loaiKH);
	    if (khachHangDAO.themKhachHang(kh)) {
	        JOptionPane.showMessageDialog(this, "Thêm thành công!");
	        loadDataToTable();
	    } else {
	        JOptionPane.showMessageDialog(this, "Thêm thất bại!");
	    }
	}

	private void updateKhachHang(ActionEvent e) {
        KhachHang kh = new KhachHang(
                txtMaKhachHang.getText(),
                txtTenKhachHang.getText(),
                (String) cboGioiTinh.getSelectedItem(),
                txtDiaChi.getText(),
                txtSoDienThoai.getText(),
                txtLoaiKH.getText()
        );
        if (khachHangDAO.suaKhachHang(kh)) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
        }
    }
	 private void deleteKhachHang(ActionEvent e) {
	        String maKhachHang = txtMaKhachHang.getText();
	        if (khachHangDAO.xoaKhachHang(maKhachHang)) {
	            JOptionPane.showMessageDialog(this, "Xóa thành công!");
	            loadDataToTable();
	        } else {
	            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
	        }
	    }
	 private void searchKhachHang(ActionEvent e) {
		 String tuKhoa = txtTuKhoa.getText();
		    List<KhachHang> list = khachHangDAO.searchKhachHang(tuKhoa); 
		    model.setRowCount(0);
		    for (KhachHang kh : list) {
		        model.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getGioiTinh(), kh.getDiaChi(), kh.getSoDT(), kh.getLoaiKH()});
		    }
		    tbFromKhachHang.setModel(model);
	 }
}
