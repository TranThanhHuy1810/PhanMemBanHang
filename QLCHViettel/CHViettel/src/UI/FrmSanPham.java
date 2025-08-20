package UI;
import DAO.Function;
import java.awt.Color;
import Model.SanPham;
import Model.LoaiHang;
import Model.NhaCungCap;
import Model.NhanVien;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import DAO.DatabaseConnection;
import DAO.NhaCungCapDAO;
import DAO.SanPhamDAO;
public class FrmSanPham extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private JTextField textFieldTenSP;
    private JTextField textFieldGiaSP;
    private JTextField txtMaNhaCungCap;
    private JTextField txtTenSanPham;
    private JTextField txtDonViTinh;
    private JTextField txtNuocSX;
    private JTextField txtGia;
    private JTextField txtSoLuong;
    private JTextField txtAnh;
    private JTextField txtGhiChu;
    private JTextField txtMaLoai;
    private JTextField txtTenLoai;
    private JTable tbSanPham;
    private JTextField txtTuKhoa;
    private DefaultTableModel model;
    private SanPhamDAO sanPhamDao;
    private DefaultTableModel model1;
	private JTable tbFrmNhaCungCap;
	private JLabel lblHinh;
    public FrmSanPham() {
        
    	  setLayout(null);
          setBackground(new Color(173, 216, 230));
        LineBorder lineBorderSanPham = new LineBorder(Color.RED, 2);
        LineBorder lineBorderDanhMucLoai = new LineBorder(Color.BLUE, 2);

        JPanel panelGroupSanPham = new JPanel();
        panelGroupSanPham.setBorder(new TitledBorder(lineBorderSanPham, "Sản Phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panelGroupSanPham.setBounds(10, 10, 1114, 381);
        add(panelGroupSanPham);
        panelGroupSanPham.setLayout(null);

        JLabel lblTenSP = new JLabel("Mã Hàng");
        lblTenSP.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenSP.setBounds(40, 30, 78, 25);
        panelGroupSanPham.add(lblTenSP);

        textFieldTenSP = new JTextField();
        textFieldTenSP.setBounds(150, 31, 200, 25);
        panelGroupSanPham.add(textFieldTenSP);
        textFieldTenSP.setColumns(10);

        JLabel lblGiaSP = new JLabel("Mã Loại");
        lblGiaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblGiaSP.setBounds(40, 70, 65, 25);
        panelGroupSanPham.add(lblGiaSP);

        textFieldGiaSP = new JTextField();
        textFieldGiaSP.setBounds(150, 71, 200, 25);
        panelGroupSanPham.add(textFieldGiaSP);
        textFieldGiaSP.setColumns(10);
        
        JLabel lblMaNhaCungCap = new JLabel("Mã Nhà Cung Cấp");
        lblMaNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMaNhaCungCap.setBounds(20, 107, 111, 25);
        panelGroupSanPham.add(lblMaNhaCungCap);
        
        JLabel lblTenSanPham = new JLabel("Tên Sản Phẩm");
        lblTenSanPham.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenSanPham.setBounds(30, 140, 100, 25);
        panelGroupSanPham.add(lblTenSanPham);
        
        JLabel lblDonViTinh = new JLabel("Đơn Vị Tính");
        lblDonViTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDonViTinh.setBounds(31, 176, 89, 25);
        panelGroupSanPham.add(lblDonViTinh);
        
        JLabel lblNuocSanXuat = new JLabel("Nước Sản Xuất");
        lblNuocSanXuat.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNuocSanXuat.setBounds(20, 212, 100, 14);
        panelGroupSanPham.add(lblNuocSanXuat);
        
        JLabel lblGia = new JLabel("Giá");
        lblGia.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblGia.setBounds(55, 246, 54, 18);
        panelGroupSanPham.add(lblGia);
        
        JLabel lblSoLuong = new JLabel("Số Lượng");
        lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSoLuong.setBounds(33, 275, 98, 25);
        panelGroupSanPham.add(lblSoLuong);
        
        JLabel lblAnh = new JLabel("Ảnh");
        lblAnh.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAnh.setBounds(375, 180, 33, 16);
        panelGroupSanPham.add(lblAnh);
        
        JLabel lblGhiChu = new JLabel("Ghi Chú");
        lblGhiChu.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblGhiChu.setBounds(360, 248, 65, 14);
        panelGroupSanPham.add(lblGhiChu);
        
        txtMaNhaCungCap = new JTextField();
        txtMaNhaCungCap.setColumns(10);
        txtMaNhaCungCap.setBounds(150, 108, 200, 25);
        panelGroupSanPham.add(txtMaNhaCungCap);
        
        txtTenSanPham = new JTextField();
        txtTenSanPham.setColumns(10);
        txtTenSanPham.setBounds(150, 144, 200, 25);
        panelGroupSanPham.add(txtTenSanPham);
        
        txtDonViTinh = new JTextField();
        txtDonViTinh.setColumns(10);
        txtDonViTinh.setBounds(150, 177, 200, 25);
        panelGroupSanPham.add(txtDonViTinh);
        
        txtNuocSX = new JTextField();
        txtNuocSX.setColumns(10);
        txtNuocSX.setBounds(150, 208, 200, 25);
        panelGroupSanPham.add(txtNuocSX);
        
        txtGia = new JTextField();
        txtGia.setColumns(10);
        txtGia.setBounds(150, 244, 200, 25);
        panelGroupSanPham.add(txtGia);
        
        txtSoLuong = new JTextField();
        txtSoLuong.setColumns(10);
        txtSoLuong.setBounds(150, 276, 200, 25);
        panelGroupSanPham.add(txtSoLuong);
        
        txtAnh = new JTextField();
        txtAnh.setColumns(10);
        txtAnh.setBounds(431, 162, 135, 55);
        panelGroupSanPham.add(txtAnh);
        
        txtGhiChu = new JTextField();
        txtGhiChu.setColumns(10);
        txtGhiChu.setBounds(431, 229, 135, 55);
        panelGroupSanPham.add(txtGhiChu);
        
     
        
        JButton btnfile = new JButton("Mở");
        btnfile.setIcon(new ImageIcon("src/image/mofile.png"));
        btnfile.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnfile.setBounds(576, 161, 105, 55);
        panelGroupSanPham.add(btnfile);
        JLabel lblTim = new JLabel("Tìm");
        lblTim.setBounds(40, 311, 35, 14);
        panelGroupSanPham.add(lblTim);
        lblTim.setFont(new Font("Tahoma", Font.BOLD, 13));
        
          JComboBox<String> cbBoxTim = new JComboBox<>(new String[]{"Mã Hàng", "Mã Loại","Mã Nhà Cung Cấp","Tên Sản Phẩm"});
          cbBoxTim.setBounds(150, 308, 165, 22);
          panelGroupSanPham.add(cbBoxTim);
          
          JLabel lblTuKhoa = new JLabel("Từ Khóa");
          lblTuKhoa.setBounds(40, 343, 68, 14);
          panelGroupSanPham.add(lblTuKhoa);
          lblTuKhoa.setFont(new Font("Tahoma", Font.BOLD, 13));
          
          txtTuKhoa = new JTextField();
          txtTuKhoa.setBounds(150, 341, 165, 20);
          panelGroupSanPham.add(txtTuKhoa);
          txtTuKhoa.setColumns(10);
          
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBounds(347, 312, 130, 43);
		panelGroupSanPham.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon("src/image/timkiem.png"));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
        JPanel panelGroupDanhMucLoai = new JPanel();
        panelGroupDanhMucLoai.setBorder(new TitledBorder(lineBorderDanhMucLoai, "Danh Mục Loại", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panelGroupDanhMucLoai.setBounds(10, 438, 333, 105);
        add(panelGroupDanhMucLoai);
        panelGroupDanhMucLoai.setLayout(null);
        
        JLabel lblMaLoai = new JLabel("Mã Loại");
        lblMaLoai.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMaLoai.setBounds(10, 29, 69, 14);
        panelGroupDanhMucLoai.add(lblMaLoai);
        
        JLabel lblTenLoai = new JLabel("Tên Loại");
        lblTenLoai.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenLoai.setBounds(10, 75, 69, 14);
        panelGroupDanhMucLoai.add(lblTenLoai);
        
        txtMaLoai = new JTextField();
        txtMaLoai.setBounds(75, 27, 195, 20);
        panelGroupDanhMucLoai.add(txtMaLoai);
        txtMaLoai.setColumns(10);
        
        txtTenLoai = new JTextField();
        txtTenLoai.setBounds(75, 69, 195, 20);
        panelGroupDanhMucLoai.add(txtTenLoai);
        txtTenLoai.setColumns(10);
        
  
        
        ImageIcon loginIcon = new ImageIcon("src/image/them.png");
        
        ImageIcon fixIcon = new ImageIcon("src/image/sua.png");
        
        ImageIcon saveIcon = new ImageIcon("src/image/luu.png");
        
        ImageIcon deleteIcon = new ImageIcon("src/image/xoa.png");
        
        ImageIcon skipIcon = new ImageIcon("src/image/boqua.png");
        JButton btnBoQua = new JButton("Bỏ Qua", skipIcon);
        btnBoQua.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBoQua.setBounds(396, 398, 120, 35);
        add(btnBoQua);
        
        ImageIcon exitIcon = new ImageIcon("src/image/thoat.png");
        //LoadDataSanPham
        model = new DefaultTableModel(new String[]{"Mã SP", "Mã Loại", "Mã NCC", "Tên SP", "DVT", "Nước SX", "Giá", "Ảnh", "Ghi Chú", "SL"}, 0);
        tbSanPham = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbSanPham);
        scrollPane.setBounds(368, 11, 736, 136);
        panelGroupSanPham.add(scrollPane);
        
        lblHinh = new JLabel("");
        lblHinh.setBounds(691, 162, 282, 195);
        panelGroupSanPham.add(lblHinh);
       
        model1 =new DefaultTableModel(new String[]{"Mã Loại", "Tên Loại"}, 0);
        tbFrmNhaCungCap = new JTable(model1);
        JScrollPane scrollPane1 = new JScrollPane(tbFrmNhaCungCap);
        scrollPane1.setBounds(353, 437, 771, 105);
        add(scrollPane1);
        Connection conn = DatabaseConnection.getConnection();
        sanPhamDao = new SanPhamDAO(conn);
        loadDataToTable();
        loadDataToTable1();
        btnfile.addActionListener(this::openImageFile);
        btnBoQua.addActionListener(e -> {
        	textFieldTenSP.setText("");
            textFieldGiaSP.setText("");
            txtMaNhaCungCap.setText("");
            txtTenSanPham.setText("");
            txtDonViTinh.setText("");
            txtNuocSX.setText("");
            txtGia.setText("");
            txtAnh.setText("");
            txtGhiChu.setText("");
            txtSoLuong.setText("");
            txtMaLoai.setText("");
            txtTenLoai.setText("");
            loadDataToTable();
        });
        JButton btnXoa = new JButton("Xóa", deleteIcon);
        btnXoa.setBounds(261, 398, 103, 35);
        add(btnXoa);
        btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
        JButton btnThem = new JButton("Thêm", saveIcon);
        btnThem.setBounds(10, 398, 103, 35);
        add(btnThem);
        btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
        JButton btnSua = new JButton("Sửa", fixIcon);
        btnSua.setBounds(139, 398, 103, 35);
        add(btnSua);
        btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSua.addActionListener(this::updateSanPham);
        btnThem.addActionListener(this::themSanPham);
        btnXoa.addActionListener(this::XoaNhaCungCap);
        btnTimKiem.addActionListener(this::searchNhaCungCap);
    }

	private void loadDataToTable1() {
		
		 model1.setRowCount(0);
	        List<LoaiHang> danhSach =sanPhamDao.getAllLoaiHang() ;
	        for (LoaiHang lh : danhSach) {
	            model1.addRow(new Object[]{lh.getMaLoai(),lh.getTenLoai()});
	        }
			tbFrmNhaCungCap.getSelectionModel().addListSelectionListener(e -> {
	            int selectedRow = tbFrmNhaCungCap.getSelectedRow(); 
	            if (selectedRow >= 0) { 
	                String MaLoai = model1.getValueAt(selectedRow, 0).toString(); 
	                String TenLoai = model1.getValueAt(selectedRow, 1).toString();

	                txtMaLoai.setText(MaLoai);
	                txtTenLoai.setText(TenLoai);
	                
	            }
	        });
	}
	private void loadDataToTable()   {
		 model.setRowCount(0);
	        List<SanPham> danhSach =sanPhamDao.getAllSanPham() ;
	        for (SanPham sp : danhSach) {
	            model.addRow(new Object[]{sp.getMaHang(),sp.getMaLoai(),sp.getMaNcc(),sp.getTenSP(),sp.getDvt(),sp.getNuocSX(),sp.getGiaTien(),sp.getAnh(),sp.getGhiChu(),sp.getSoLuong()});
	        }
	        tbSanPham.getSelectionModel().addListSelectionListener(e -> {
	            int selectedRow = tbSanPham.getSelectedRow(); 
	            if (selectedRow >= 0) { 
	                // Lấy dữ liệu từ dòng đã chọn
	                String MaHang = model.getValueAt(selectedRow, 0).toString(); 
	                String MaLoai = model.getValueAt(selectedRow, 1).toString();
	                String MaNcc = model.getValueAt(selectedRow, 2).toString();
	                String TenSp = model.getValueAt(selectedRow, 3).toString();
	                String DVT = model.getValueAt(selectedRow, 4).toString();
	                String NuocSX = model.getValueAt(selectedRow, 5).toString();
	                String GiaTien = model.getValueAt(selectedRow, 6).toString();
	                String Anh = model.getValueAt(selectedRow, 7).toString();
	                String GhiChu = model.getValueAt(selectedRow, 8).toString();
	                String SoLuong = model.getValueAt(selectedRow, 9).toString();

	                // Truy vấn dữ liệu hình ảnh từ cơ sở dữ liệu
	                String sql = "SELECT ANH FROM MATHANG WHERE MAHANG=N'" + MaHang + "'";
	                String filePath = Function.getFieldValues(sql);

	                // Kiểm tra nếu tệp ảnh tồn tại và hợp lệ
	                if (filePath != null && !filePath.isEmpty() && new File(filePath).exists()) {
	                    try {
	                        // Đọc và hiển thị ảnh trong JLabel (lblHinh là JLabel để hiển thị ảnh)
	                        BufferedImage img = ImageIO.read(new File(filePath));
	                        int newWidth = 100;  // Chiều rộng mới
	                        int newHeight = 100; // Chiều cao mới
	                        Image scaledImg = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	                        lblHinh.setIcon(new ImageIcon(scaledImg));  // Đặt ảnh vào JLabel
	                    } catch (IOException e1) {
	                        e1.printStackTrace();  // Xử lý lỗi khi không đọc được ảnh
	                    }
	                }

	                // Điền thông tin vào các TextField
	                textFieldTenSP.setText(MaHang);
	                textFieldGiaSP.setText(MaLoai);
	                txtMaNhaCungCap.setText(MaNcc);
	                txtTenSanPham.setText(TenSp);
	                txtDonViTinh.setText(DVT);
	                txtNuocSX.setText(NuocSX);
	                txtGia.setText(GiaTien);
	                txtAnh.setText(Anh);
	                txtGhiChu.setText(GhiChu);
	                txtSoLuong.setText(SoLuong);
	            }
	        });
	}
	private void openImageFile(ActionEvent e) {
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setDialogTitle("Chọn ảnh minh hoạ cho sản phẩm");

	    // Chỉ cho phép chọn các file ảnh
	    fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "bmp", "jpg", "gif", "png"));

	    // Mở hộp thoại và kiểm tra kết quả
	    int result = fileChooser.showOpenDialog(null);
	    if (result == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();
	        
	        try {
	            BufferedImage image = ImageIO.read(selectedFile);
	            if (image != null) {
	                // Điều chỉnh kích thước ảnh cho vừa với JLabel
	                ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), java.awt.Image.SCALE_SMOOTH));
	                lblHinh.setIcon(imageIcon);

	                txtAnh.setText(selectedFile.getAbsolutePath());
	            } else {
	                JOptionPane.showMessageDialog(null, "Không thể đọc được ảnh này.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(null, "Lỗi khi mở tệp ảnh: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	private void themSanPham(ActionEvent e) {
	    String maHang = textFieldTenSP.getText().trim();
	    String maLoai = textFieldGiaSP.getText().trim();
	    String maNcc = txtMaNhaCungCap.getText().trim();
	    String tenSP = txtTenSanPham.getText().trim();
	    String dvt = txtDonViTinh.getText().trim();
	    String nuocSX = txtNuocSX.getText().trim();
	    String anh = txtAnh.getText().trim();
	    String ghiChu = txtGhiChu.getText().trim();
	    
	    if (maHang.isEmpty() || maLoai.isEmpty() || maNcc.isEmpty() || tenSP.isEmpty() || 
	        dvt.isEmpty() || nuocSX.isEmpty() || anh.isEmpty() || ghiChu.isEmpty() || 
	        txtGia.getText().trim().isEmpty() || txtSoLuong.getText().trim().isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
	        return;
	    }
	    
	    double giaTien;
	    try {
	        giaTien = Double.parseDouble(txtGia.getText().trim());
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Giá tiền không hợp lệ!");
	        return;
	    }
	    
	    int soLuong;
	    try {
	        soLuong = Integer.parseInt(txtSoLuong.getText().trim());
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
	        return;
	    }
	    
	    SanPham sp = new SanPham(maHang, maLoai, maNcc, tenSP, dvt, nuocSX, giaTien, anh, ghiChu, soLuong);
	    if (sanPhamDao.insertMatHang(sp)) {
	        JOptionPane.showMessageDialog(this, "Thêm Sản Phẩm thành công!");
	        loadDataToTable();
	    } else {
	        JOptionPane.showMessageDialog(this, "Thêm thất bại!");
	    }
	}
	private void updateSanPham(ActionEvent e) {
		String maHang = textFieldTenSP.getText().trim();
		String maLoai = textFieldGiaSP.getText().trim();
		String maNcc = txtMaNhaCungCap.getText().trim();
	    String tenSP = txtTenSanPham.getText().trim();
	    String dvt = txtDonViTinh.getText().trim();
	    String nuocSX = txtNuocSX.getText().trim();
	    String anh = txtAnh.getText().trim();
	    String ghiChu = txtGhiChu.getText().trim();
	    double giaTien;
	    try {
	        giaTien = Double.parseDouble(txtGia.getText().trim());
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Giá tiền không hợp lệ!");
	        return;
	    }
	    
	    int soLuong;
	    try {
	        soLuong = Integer.parseInt(txtSoLuong.getText().trim());
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
	        return;
	    }
	    SanPham sp = new SanPham(maHang, maLoai, maNcc, tenSP, dvt, nuocSX, giaTien, anh, ghiChu, soLuong);
	    if (sanPhamDao.updateSanPham(sp)) {
	        JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công!");
	        loadDataToTable();
	    } else {
	        JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
	    }
	}
	 private void XoaNhaCungCap(ActionEvent e) {
	        String maHang =textFieldTenSP.getText();
	        if (sanPhamDao.deleteSanPham(maHang)) {
	            JOptionPane.showMessageDialog(this, "Xóa thành công!");
	            loadDataToTable();
	        } else {
	            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
	        }
	    }
	 private void searchNhaCungCap(ActionEvent e) {
		 String tuKhoa = txtTuKhoa.getText();
		    List<SanPham> list = sanPhamDao.searchSanPham(tuKhoa); 
		    model.setRowCount(0);
		    for (SanPham sp : list) {
		        model.addRow(new Object[]{sp.getMaHang(),sp.getMaLoai(),sp.getMaNcc(),sp.getTenSP(),sp.getDvt(),sp.getNuocSX(),sp.getGiaTien(),sp.getAnh(),sp.getGhiChu(),sp.getSoLuong()});
		    }
		    tbSanPham.setModel(model);
	 }
}
