package UI;
import DAO.Function;
import DAO.HoaDonDAO;
import Model.CTHD;
import Model.ComboItem;
import Model.NhanVien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import DAO.DatabaseConnection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import DAO.CTHDDAO;
import java.awt.SystemColor;
public class FrmHoaDon extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSoHoaDon;
	private JTextField txtTenNhanVien;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtSoLuong;
	private JTextField txtTenHang;
	private JTextField txtGiamGia;
	private JTextField txtDonGia;
	private JTable tbChiTietHoaDon;
	private JTextField txtTriGia;
	private JTextField txtThanhTien;
	private Function funtion;
	private JComboBox<ComboItem> comboBoxMaNhanVien;
	    private JComboBox<ComboItem> comboBoxMaKhachHang;
	    private JComboBox<ComboItem> comboBoxMaHang;
	    private JComboBox<ComboItem>comboBoxSoHoaDon;
	    private DefaultTableModel model;
	    private Connection conn;
		private JLabel lblBangChu;
		private CTHDDAO CTHDDao;
		private JDateChooser dateChooser;
	public FrmHoaDon() {
		funtion = new DAO.Function(null);
		
		  setLayout(null);
	        setBackground(new Color(173, 216, 230));
		
		// Tạo LineBorder cho các GroupBox
		LineBorder lineBorderHoaDon = new LineBorder(Color.BLUE, 2);
		
		// Tạo GroupBox Sản Phẩm
		JPanel panelGroupHoaDon = new JPanel();
		panelGroupHoaDon.setBounds(10, 11, 943, 131);
		panelGroupHoaDon .setBorder(new TitledBorder(lineBorderHoaDon, "Thông Tin Hóa Đơn", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		add(panelGroupHoaDon );
		panelGroupHoaDon.setLayout(null);
		
		JLabel lblSoHoaDon = new JLabel("Số Hóa Đơn");
		lblSoHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoHoaDon.setBounds(10, 15, 84, 14);
		panelGroupHoaDon.add(lblSoHoaDon);
		
		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaNhanVien.setBounds(10, 48, 96, 14);
		panelGroupHoaDon.add(lblMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Tên Nhân Viên");
		lblTenNhanVien .setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenNhanVien .setBounds(10, 73, 107, 14);
		panelGroupHoaDon.add(lblTenNhanVien );
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng");
		lblMaKhachHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaKhachHang.setBounds(410, 11, 118, 22);
		panelGroupHoaDon.add(lblMaKhachHang);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenKhachHang.setBounds(410, 48, 119, 14);
		panelGroupHoaDon.add(lblTenKhachHang);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDiaChi.setBounds(420, 73, 56, 14);
		panelGroupHoaDon.add(lblDiaChi);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoDienThoai.setBounds(421, 98, 107, 14);
		panelGroupHoaDon.add(lblSoDienThoai);
		
		txtSoHoaDon = new JTextField();
		txtSoHoaDon.setBackground(SystemColor.text);
		txtSoHoaDon.setForeground(Color.RED);
		txtSoHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSoHoaDon.setEnabled(false);
		txtSoHoaDon.setBounds(127, 12, 215, 23);
		panelGroupHoaDon.add(txtSoHoaDon);
		txtSoHoaDon.setColumns(10);
		
		comboBoxMaNhanVien = new JComboBox<>();
		comboBoxMaNhanVien.setBounds(127, 42, 215, 28);
		panelGroupHoaDon.add(comboBoxMaNhanVien);
		funtion.fillCombo("SELECT MANV, HOTEN FROM NHANVIEN", comboBoxMaNhanVien, "MANV", "MANV");
		comboBoxMaNhanVien.setSelectedIndex(-1);
		comboBoxMaKhachHang = new JComboBox<>();
		comboBoxMaKhachHang.setBounds(539, 12, 202, 22);
		panelGroupHoaDon.add(comboBoxMaKhachHang);
		funtion.fillCombo("SELECT MAKH, HOTEN FROM KHACHHANG",comboBoxMaKhachHang , "MAKH", "MAKH");
		comboBoxMaKhachHang.setSelectedIndex(-1);

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBackground(SystemColor.text);
		txtTenNhanVien.setForeground(Color.RED);
		txtTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(127, 73, 215, 25);
		panelGroupHoaDon.add(txtTenNhanVien);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBackground(SystemColor.text);
		txtTenKhachHang.setForeground(Color.RED);
		txtTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(539, 45, 202, 22);
		panelGroupHoaDon.add(txtTenKhachHang);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBackground(SystemColor.text);
		txtDiaChi.setForeground(Color.RED);
		txtDiaChi.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(539, 70, 202, 22);
		panelGroupHoaDon.add(txtDiaChi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBackground(SystemColor.text);
		txtSoDienThoai.setForeground(Color.RED);
		txtSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(539, 95, 202, 22);
		panelGroupHoaDon.add(txtSoDienThoai);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(751, 40, 137, 22);
		panelGroupHoaDon.add(dateChooser);
		
		JLabel lblNgyLpHa = new JLabel("Ngày Lập Hóa Đơn");
		lblNgyLpHa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgyLpHa.setBounds(751, 15, 155, 14);
		panelGroupHoaDon.add(lblNgyLpHa);
		
		// Tạo GroupBox chi tiet hoa don
		JPanel panelGroupChiTietHoaDon = new JPanel();
		panelGroupChiTietHoaDon.setBounds(10, 143, 943, 425);
		panelGroupChiTietHoaDon.setBorder(new TitledBorder(lineBorderHoaDon, "Chi tiết hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		add(panelGroupChiTietHoaDon );
		panelGroupChiTietHoaDon.setLayout(null);

		JLabel lblMaHang = new JLabel("Mã hàng");
		lblMaHang .setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaHang.setBounds(28, 33, 67, 22);
		panelGroupChiTietHoaDon.add(lblMaHang);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoLuong.setBounds(28, 72, 67, 17);
		panelGroupChiTietHoaDon.add(lblSoLuong);
		
		JLabel lblTenHang = new JLabel("Tên Hàng");
		lblTenHang .setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenHang .setBounds(348, 35, 86, 18);
		panelGroupChiTietHoaDon.add(lblTenHang);
		
		JLabel lblGiamGia = new JLabel("Giảm Giá %");
		lblGiamGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiamGia.setBounds(348, 73, 80, 14);
		panelGroupChiTietHoaDon.add(lblGiamGia);
		
		JLabel lblDonGia = new JLabel("Đơn Giá");
		lblDonGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDonGia.setBounds(667, 37, 67, 14);
		panelGroupChiTietHoaDon.add(lblDonGia);
		
		JLabel lblThanhTien = new JLabel("Thành Tiền");
		lblThanhTien .setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThanhTien .setBounds(667, 73, 79, 14);
		panelGroupChiTietHoaDon.add(lblThanhTien);
		
		comboBoxMaHang = new JComboBox<>();
		comboBoxMaHang.setBounds(118, 33, 210, 23);
		panelGroupChiTietHoaDon.add(comboBoxMaHang);
		funtion.fillCombo("SELECT MAHANG, TENSP FROM MATHANG", comboBoxMaHang, "MAHANG", "MAHANG");
		comboBoxMaHang.setSelectedIndex(-1);
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(118, 67, 210, 24);
		panelGroupChiTietHoaDon.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		txtTenHang = new JTextField();
		txtTenHang.setBackground(SystemColor.text);
		txtTenHang.setForeground(Color.RED);
		txtTenHang.setBounds(430, 33, 210, 23);
		panelGroupChiTietHoaDon.add(txtTenHang);
		txtTenHang.setColumns(10);
		
		txtGiamGia = new JTextField();
		txtGiamGia.setBounds(430, 68, 210, 23);
		panelGroupChiTietHoaDon.add(txtGiamGia);
		txtGiamGia.setColumns(10);
		
		txtDonGia = new JTextField();
		txtDonGia.setBackground(SystemColor.text);
		txtDonGia.setForeground(Color.RED);
		txtDonGia.setBounds(744, 33, 176, 22);
		panelGroupChiTietHoaDon.add(txtDonGia);
		txtDonGia.setColumns(10);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setBackground(SystemColor.text);
		txtThanhTien.setForeground(Color.RED);
		txtThanhTien.setBounds(744, 72, 176, 19);
		panelGroupChiTietHoaDon.add(txtThanhTien);
		txtThanhTien.setColumns(10);
		model = new DefaultTableModel(new String[]{"Mã Hàng", "Tên Hàng", "Số Lượng", "Đơn Giá", "Giảm Giá %","Thành Tiền"}, 0);
		tbChiTietHoaDon = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(tbChiTietHoaDon);
	    scrollPane.setBounds(143, 114, 669, 193);
		panelGroupChiTietHoaDon.add(scrollPane);
		
		lblBangChu = new JLabel("Bằng Chữ:");
		lblBangChu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBangChu.setForeground(Color.BLUE);
		lblBangChu.setBounds(28, 312, 368, 20);
		panelGroupChiTietHoaDon.add(lblBangChu);
		
		JLabel lblTriGia = new JLabel("Trị giá");
		lblTriGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTriGia.setBounds(655, 318, 55, 22);
		panelGroupChiTietHoaDon.add(lblTriGia);
		
		txtTriGia = new JTextField();
		txtTriGia.setBackground(SystemColor.text);
		txtTriGia.setForeground(Color.RED);
		txtTriGia.setBounds(715, 318, 204, 27);
		panelGroupChiTietHoaDon.add(txtTriGia);
		txtTriGia.setColumns(10);
		
        
        ImageIcon loginIcon = new ImageIcon("src/image/them.png");
        JButton btnThemHoaDon = new JButton("Thêm Hóa Đơn", loginIcon);
		btnThemHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemHoaDon .setBounds(266, 369, 169, 35);
		panelGroupChiTietHoaDon.add(btnThemHoaDon);
		btnThemHoaDon.addActionListener(this::themHD);
		
        ImageIcon saveIcon = new ImageIcon("src/image/luu.png");
        JButton btnLuuHoaDon = new JButton("Lưu Hóa Đơn", saveIcon);
		btnLuuHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLuuHoaDon.setBounds(445, 369, 159, 35);
		panelGroupChiTietHoaDon.add(btnLuuHoaDon);
		btnLuuHoaDon.addActionListener(this::btnLuuActionPerformed);
		
        ImageIcon cancelIcon = new ImageIcon("src/image/huyhoadon.png");
		
		
	
		
		
		comboBoxSoHoaDon = new JComboBox<>();
		comboBoxSoHoaDon.setBounds(111, 338, 152, 26);
		panelGroupChiTietHoaDon.add(comboBoxSoHoaDon);
		funtion.fillCombo("SELECT SOHD FROM HOADON", comboBoxSoHoaDon, "SOHD", "SOHD");
		
		JLabel lblSoHoaDon1 = new JLabel("Số Hóa Đơn");
		lblSoHoaDon1.setBounds(28, 343, 89, 14);
		panelGroupChiTietHoaDon.add(lblSoHoaDon1);
		lblSoHoaDon1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
        JButton btnTimKiem = new JButton("Tìm Kiếm");
        btnTimKiem.setBounds(76, 375, 144, 29);
        panelGroupChiTietHoaDon.add(btnTimKiem);
        btnTimKiem.setIcon(new ImageIcon("src/image/timkiem.png"));
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnTimKiem.addActionListener(this::TimKiemHoaDon);
        JButton btnInHD = new JButton("In Hóa Đơn");
        btnInHD.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnInHD.setBounds(614, 369, 111, 35);
        panelGroupChiTietHoaDon.add(btnInHD);
        btnInHD.addActionListener(this::ExportExcel);
		
      
      
		comboBoxMaHang.addItemListener(this::cboMaHang_ItemStateChanged);
		comboBoxMaKhachHang.addItemListener(this::cboMaKH_ItemStateChanged);
		comboBoxMaNhanVien.addItemListener(this::cboMNV_ItemStateChanged);

		DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculateTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculateTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculateTotal();
            }
        };
        txtSoLuong.getDocument().addDocumentListener(listener);
        txtGiamGia.getDocument().addDocumentListener(listener);
        txtDonGia.getDocument().addDocumentListener(listener);
        if (!txtSoHoaDon.getText().isEmpty()) {
        	LoadInfoHoaDon();
        }
        LoadDataCTHD();
	}
	 private void themHD(ActionEvent e) {
		 txtSoHoaDon.setText(Function.createKey("FB"));
		 comboBoxMaNhanVien.setSelectedIndex(-1);
		 comboBoxMaKhachHang.setSelectedIndex(-1);
		 comboBoxMaHang.setSelectedIndex(-1);
		 txtTriGia.setText("");
		 lblBangChu.setText("Bằng Chữ:");
		 txtTenNhanVien.setText("");
		 txtTenKhachHang.setText("");
		 txtDiaChi.setText("");
		 txtSoDienThoai.setText("");
		 txtTenHang.setText("");
		 txtSoLuong.setText("");
		 txtGiamGia.setText("");
		 txtThanhTien.setText("");
		 txtDonGia.setText("");
		 LoadDataCTHD();
		 
	 }
	 private void cboMaHang_ItemStateChanged(ItemEvent e) {
		    if (e.getStateChange() == ItemEvent.SELECTED) {
		        String str;
		        if (comboBoxMaHang.getSelectedItem() == null || comboBoxMaHang.getSelectedItem().toString().isEmpty()) {
		            txtTenHang.setText("");
		            txtDonGia.setText("");
		        } else {
		            // When MaHang is selected, fetch details
		            str = "SELECT TENSP FROM MATHANG WHERE MAHANG = N'" + comboBoxMaHang.getSelectedItem().toString() + "'";
		            txtTenHang.setText(Function.getFieldValues(str));
		            str = "SELECT GIA FROM MATHANG WHERE MAHANG = N'" + comboBoxMaHang.getSelectedItem().toString() + "'";
		            txtDonGia.setText(Function.getFieldValues(str));
		        }
		    }
		}

		private void cboMaKH_ItemStateChanged(ItemEvent e) {
		    if (e.getStateChange() == ItemEvent.SELECTED) {
		        String str;
		        if (comboBoxMaKhachHang.getSelectedItem() == null || comboBoxMaKhachHang.getSelectedItem().toString().isEmpty()) {
		            txtTenKhachHang.setText("");
		        } else {
		            // When MaKH is selected, fetch customer details
		            str = "SELECT HOTEN FROM KHACHHANG WHERE MAKH = N'" + comboBoxMaKhachHang.getSelectedItem().toString() + "'";
		            txtTenKhachHang.setText(Function.getFieldValues(str));
		            str = "SELECT DCHI FROM KHACHHANG WHERE MAKH = N'" + comboBoxMaKhachHang.getSelectedItem().toString() + "'";
		            txtDiaChi.setText(Function.getFieldValues(str));
		            str = "SELECT SODT FROM KHACHHANG WHERE MAKH = N'" + comboBoxMaKhachHang.getSelectedItem().toString() + "'";
		            txtSoDienThoai.setText(Function.getFieldValues(str));
		        }
		    }
		}

		private void cboMNV_ItemStateChanged(ItemEvent e) {
		    if (e.getStateChange() == ItemEvent.SELECTED) {
		        String str;
		        if (comboBoxMaNhanVien.getSelectedItem() == null || comboBoxMaNhanVien.getSelectedItem().toString().isEmpty()) {
		            txtTenNhanVien.setText("");
		        } else {
		            // When MaNV is selected, fetch employee details
		            str = "SELECT HOTEN FROM NHANVIEN WHERE MANV = N'" + comboBoxMaNhanVien.getSelectedItem().toString() + "'";
		            txtTenNhanVien.setText(Function.getFieldValues(str));
		        }
		    }
		}
		  private void calculateTotal() {
		        try {
		            double sl = txtSoLuong.getText().isEmpty() ? 0 : Double.parseDouble(txtSoLuong.getText());
		            double gg = txtGiamGia.getText().isEmpty() ? 0 : Double.parseDouble(txtGiamGia.getText());
		            double dg = txtDonGia.getText().isEmpty() ? 0 : Double.parseDouble(txtDonGia.getText());
		            double tt = sl * dg - (sl * dg * gg / 100);
		            txtThanhTien.setText(String.valueOf(tt));
		        } catch (NumberFormatException e) {
		            txtThanhTien.setText("Lỗi");
		        }
		    }
		  public void btnLuuActionPerformed(ActionEvent e) {
			    try {
			        String soHD = txtSoHoaDon.getText().trim();
			        
			        // Lấy giá trị từ ComboBox
			        ComboItem selectedNV = (ComboItem) comboBoxMaNhanVien.getSelectedItem();
			        String maNV = selectedNV != null ? selectedNV.getValue() : "";

			        ComboItem selectedKH = (ComboItem) comboBoxMaKhachHang.getSelectedItem();
			        String maKH = selectedKH != null ? selectedKH.getValue() : "";

			        ComboItem selectedHang = (ComboItem) comboBoxMaHang.getSelectedItem();
			        String maHang = selectedHang != null ? selectedHang.getValue() : "";
			        java.util.Date utilDate = dateChooser.getDate();
			        if (utilDate == null) {
			            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày lập hóa đơn", "Thông báo", JOptionPane.WARNING_MESSAGE);
			            return;
			        }
			        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			        if (soHD.isEmpty() || maNV.isEmpty() || maKH.isEmpty() || maHang.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
			            return;
			        }

			        // Ensure that the fields are not empty before parsing
			        double gia = 0, donGia = 0, thanhTien = 0;
			        int soLuong = 0, giamGia = 0;

			        try {
			            if (!txtTriGia.getText().trim().isEmpty()) {
			                gia = Double.parseDouble(txtTriGia.getText().trim());
			            }
			            if (!txtSoLuong.getText().trim().isEmpty()) {
			                soLuong = Integer.parseInt(txtSoLuong.getText().trim());
			            }
			            if (!txtGiamGia.getText().trim().isEmpty()) {
			                giamGia = Integer.parseInt(txtGiamGia.getText().trim());
			            }
			            if (!txtDonGia.getText().trim().isEmpty()) {
			                donGia = Double.parseDouble(txtDonGia.getText().trim());
			            }
			            if (!txtThanhTien.getText().trim().isEmpty()) {
			                thanhTien = Double.parseDouble(txtThanhTien.getText().trim());
			            }
			        } catch (NumberFormatException e1) {
			            JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ", "Thông báo", JOptionPane.WARNING_MESSAGE);
			            return;
			        }

			        if (soLuong <= 0 || giamGia < 0 || thanhTien < 0) {
			            JOptionPane.showMessageDialog(null, "Số lượng, giảm giá và thành tiền không thể âm", "Thông báo", JOptionPane.WARNING_MESSAGE);
			            return;
			        }

			        try (PreparedStatement pstmtCheckHD = conn.prepareStatement("SELECT SOHD FROM HOADON WHERE SOHD = ?")) {
			            pstmtCheckHD.setString(1, soHD);
			            ResultSet rs = pstmtCheckHD.executeQuery();

			            if (!rs.next()) {
			                try (PreparedStatement pstmtInsertHD = conn.prepareStatement(
			                        "INSERT INTO HOADON (SOHD, MAKH, MANV, TRIGIA, Ngay) VALUES (?, ?, ?, ?,?)")) {
			                    pstmtInsertHD.setString(1, soHD);
			                    pstmtInsertHD.setString(2, maKH);
			                    pstmtInsertHD.setString(3, maNV);
			                    pstmtInsertHD.setDouble(4, gia);
			                    pstmtInsertHD.setDate(5, sqlDate);
			                    pstmtInsertHD.executeUpdate();
			                }
			            }
			        }

			        try (PreparedStatement pstmtCheckSL = conn.prepareStatement("SELECT SOLUONG FROM MATHANG WHERE MAHANG = ?")) {
			            pstmtCheckSL.setString(1, maHang);
			            ResultSet rs = pstmtCheckSL.executeQuery();

			            if (rs.next()) {
			                int slTon = rs.getInt("SOLUONG");
			                if (soLuong > slTon) {
			                    JOptionPane.showMessageDialog(null, "Số lượng mặt hàng này chỉ còn " + slTon, "Thông báo", JOptionPane.WARNING_MESSAGE);
			                    return;
			                }

			                try (PreparedStatement pstmtInsertCTHD = conn.prepareStatement(
			                        "INSERT INTO CTHD (SOHD, MAHANG, SL, DONGIA, GIAMGIA, THANHTIEN) VALUES (?, ?, ?, ?, ?, ?)")) {
			                    pstmtInsertCTHD.setString(1, soHD);
			                    pstmtInsertCTHD.setString(2, maHang);
			                    pstmtInsertCTHD.setInt(3, soLuong); // Chỉnh thành int
			                    pstmtInsertCTHD.setDouble(4, donGia);
			                    pstmtInsertCTHD.setInt(5, giamGia); // Chỉnh thành int
			                    pstmtInsertCTHD.setDouble(6, thanhTien);
			                    pstmtInsertCTHD.executeUpdate();
			                }

			                try (PreparedStatement pstmtUpdateSL = conn.prepareStatement("UPDATE MATHANG SET SOLUONG = ? WHERE MAHANG = ?")) {
			                    pstmtUpdateSL.setInt(1, slTon - soLuong);
			                    pstmtUpdateSL.setString(2, maHang);
			                    pstmtUpdateSL.executeUpdate();
			                }

			                double tongMoi;
			                try (PreparedStatement pstmtGetTotal = conn.prepareStatement("SELECT TRIGIA FROM HOADON WHERE SOHD = ?")) {
			                    pstmtGetTotal.setString(1, soHD);
			                    ResultSet rsTotal = pstmtGetTotal.executeQuery();
			                    double tong = rsTotal.next() ? rsTotal.getDouble("TRIGIA") : 0;
			                    tongMoi = tong + thanhTien;
			                }

			                try (PreparedStatement pstmtUpdateHD = conn.prepareStatement("UPDATE HOADON SET TRIGIA = ? WHERE SOHD = ?")) {
			                    pstmtUpdateHD.setDouble(1, tongMoi);
			                    pstmtUpdateHD.setString(2, soHD);
			                    pstmtUpdateHD.executeUpdate();
			                }

			                txtTriGia.setText(String.valueOf(tongMoi));
			                lblBangChu.setText("Bằng chữ: " + convertNumberToWords(tongMoi));
			            }
			        }
			    } catch (SQLException e1) {
			        JOptionPane.showMessageDialog(null, "Lỗi: " + e1.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
			    }
			}
			/**
			 * Chuyển số thành chuỗi số có định dạng tiếng Việt
			 */
		  public static String convertNumberToWords(double number) {
			    // Mảng số từ 0 đến 9
			    String[] ones = {"", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín"};
			    // Mảng số từ 10 đến 19
			    String[] teens = {"Mười", "Mười Một", "Mười Hai", "Mười Ba", "Mười Bốn", "Mười Lăm", "Mười Sáu", "Mười Bảy", "Mười Tám", "Mười Chín"};
			    // Mảng số từ 20 trở lên
			    String[] tens = {"", "Mươi", "Hai Mươi", "Ba mươi", "Bốn Mươi", "Năm Mươi", "Sáu Mươi", "Bảy Mươi", "Tám Mươi", "Chín Mươi"};
			    // Mảng các đơn vị như "nghìn", "triệu", "tỷ"
			    String[] powers = {"", "Nghìn", "Triệu", "Tỷ"};

			    // Kiểm tra nếu số là 0
			    if (number == 0) {
			        return "Không Đồng";
			    }

			    // Chuyển số thành chuỗi
			    long numberLong = Math.round(number);
			    String result = "";
			    int powerIndex = 0;

			    while (numberLong > 0) {
			        int part = (int) (numberLong % 1000);  // Lấy 3 chữ số cuối
			        if (part > 0) {
			            String partWords = convertPartToWords(part, ones, teens, tens);
			            if (powerIndex > 0) {
			                partWords += " " + powers[powerIndex];
			            }
			            result = partWords + " " + result;
			        }
			        numberLong /= 1000;
			        powerIndex++;
			    }

			    // Thêm từ "đồng" vào cuối
			    return result.trim() + " Đồng";
			}

			private static String convertPartToWords(int part, String[] ones, String[] teens, String[] tens) {
			    String words = "";
			    int hundred = part / 100;  // Lấy chữ số trăm
			    int ten = (part % 100) / 10;  // Lấy chữ số chục
			    int one = part % 10;  // Lấy chữ số đơn vị

			    if (hundred > 0) {
			        words += ones[hundred] + " Trăm";
			    }

			    if (ten > 1) {
			        words += " " + tens[ten];
			        if (one > 0) {
			            words += " " + ones[one];
			        }
			    } else if (ten == 1) {
			        words += " Mười";
			        if (one > 0) {
			            words += " " + ones[one];
			        }
			    } else if (one > 0) {
			        words += " " + ones[one];
			    }

			    return words.trim();
}
			private void LoadDataCTHD() {
				 model.setRowCount(0);
				 if (conn == null) {
					    conn = DatabaseConnection.getConnection();
					}
					CTHDDao = new CTHDDAO(conn);
			        List<CTHD> danhSach = CTHDDao.getAllCTHD(txtSoHoaDon.getText());
			        for (CTHD hd : danhSach) {
			            model.addRow(new Object[]{hd.getMAHANG(),hd.getSP(),hd.getSL(),hd.getDonGia(),hd.getGiamGia(),hd.getThanhTien()});
			        }
			}
			private void LoadInfoHoaDon() {
			    String soHD = txtSoHoaDon.getText().trim();
			    if (soHD.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Vui lòng nhập số hóa đơn!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    try {
			        HoaDonDAO hoaDonDAO = new HoaDonDAO(conn);

			        // Truy vấn và lấy mã nhân viên từ cơ sở dữ liệu
			        String query = "SELECT MANV FROM HOADON WHERE SOHD = ?";
			        String maNV = hoaDonDAO.getFieldValues(query, soHD);
			        
			        if (maNV != null && !maNV.isEmpty()) {
			            // Duyệt qua các phần tử của comboBoxMaNhanVien để tìm ComboItem có mã nhân viên trùng khớp
			            for (int i = 0; i < comboBoxMaNhanVien.getItemCount(); i++) {
			                ComboItem itemNV = comboBoxMaNhanVien.getItemAt(i);
			                if (itemNV.getValue().equals(maNV)) {
			                    comboBoxMaNhanVien.setSelectedItem(itemNV);
			                    break;
			                }
			            }
			        } else {
			            comboBoxMaNhanVien.setSelectedItem(null);
			            JOptionPane.showMessageDialog(null, "Không tìm thấy mã nhân viên!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			        }

			        // Truy vấn và lấy mã khách hàng
			        query = "SELECT MAKH FROM HOADON WHERE SOHD = ?";
			        String maKH = hoaDonDAO.getFieldValues(query, soHD);
			        
			        if (maKH != null && !maKH.isEmpty()) {
			            // Duyệt qua các phần tử của comboBoxMaKhachHang để tìm ComboItem có mã khách hàng trùng khớp
			            for (int i = 0; i < comboBoxMaKhachHang.getItemCount(); i++) {
			                ComboItem itemKH = comboBoxMaKhachHang.getItemAt(i);
			                if (itemKH.getValue().equals(maKH)) {
			                    comboBoxMaKhachHang.setSelectedItem(itemKH);
			                    break;
			                }
			            }
			        } else {
			            comboBoxMaKhachHang.setSelectedItem(null);
			            JOptionPane.showMessageDialog(null, "Không tìm thấy mã khách hàng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			        }

			        // Truy vấn và lấy trị giá hóa đơn
			        query = "SELECT TRIGIA FROM HOADON WHERE SOHD = ?";
			        String triGiaStr = hoaDonDAO.getFieldValues(query, soHD);
			        double triGia = 0;

			        if (triGiaStr != null && !triGiaStr.isEmpty()) {
			            try {
			                triGia = Double.parseDouble(triGiaStr);
			                txtTriGia.setText(String.valueOf(triGia));

			                // Hiển thị trị giá bằng chữ
			                lblBangChu.setText("Bằng chữ: " + convertNumberToWords((long) triGia));
			            } catch (NumberFormatException e) {
			                JOptionPane.showMessageDialog(null, "Lỗi chuyển đổi trị giá hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			            }
			        }
			        query = "SELECT Ngay FROM HOADON WHERE SOHD = ?";
			        String ngayLapStr = hoaDonDAO.getFieldValues(query, soHD);

			        if (ngayLapStr != null && !ngayLapStr.isEmpty()) {
			            try {
			                // Chuyển chuỗi ngày thành đối tượng java.util.Date
			                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // Định dạng ngày trong cơ sở dữ liệu
			                java.util.Date ngayLap = sdf.parse(ngayLapStr);

			                // Hiển thị ngày trên JDateChooser
			                dateChooser.setDate(ngayLap);  // dateChooser là đối tượng JDateChooser đã khởi tạo
			            } catch (ParseException e) {
			                JOptionPane.showMessageDialog(null, "Lỗi chuyển đổi ngày hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			            }
			        }
			    } catch (Exception e) {
			        JOptionPane.showMessageDialog(null, "Lỗi khi tải thông tin hóa đơn: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			    }
			    
			}



		private void TimKiemHoaDon(ActionEvent e) {
			if (comboBoxSoHoaDon.getSelectedItem() == null || comboBoxSoHoaDon.getSelectedItem().toString().isEmpty()) {
			    JOptionPane.showMessageDialog(null, "Bạn phải chọn một mã hóa đơn để tìm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			    comboBoxSoHoaDon.requestFocus();
			    return;
			}
			txtSoHoaDon.setText(comboBoxSoHoaDon.getSelectedItem().toString());
			LoadInfoHoaDon();
			LoadDataCTHD();
			comboBoxSoHoaDon.setSelectedIndex(-1); // Bỏ chọn mục đã chọn

		}
		private void ExportExcel(ActionEvent e) {
		    int selectedRow = tbChiTietHoaDon.getSelectedRow();
		    if (selectedRow == -1) {
		        JOptionPane.showMessageDialog(null, "Vui lòng chọn một hóa đơn để in!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		        return;
		    }

		    String invoiceId = model.getValueAt(selectedRow, 0).toString();
		    String filePath = "C:\\Users\\MY PC\\OneDrive\\Desktop\\HoaDonViettel\\HoaDon_" + invoiceId + ".xlsx";

		    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
		        XSSFSheet sheet = workbook.createSheet("Hóa Đơn Bán Hàng");

		        CellStyle boldStyle = workbook.createCellStyle();
		        XSSFFont boldFont = workbook.createFont();
		        boldFont.setBold(true);
		        boldFont.setFontHeightInPoints((short) 14);
		        boldStyle.setFont(boldFont);
		        boldStyle.setAlignment(HorizontalAlignment.CENTER);

		        XSSFRow row = sheet.createRow(0);
		        Cell cell = row.createCell(0);
		        cell.setCellValue("210 Trần Phú, Cái Khế, Ninh Kiều - Cần Thơ");
		        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		        
		        row = sheet.createRow(1);
		        cell = row.createCell(0);
		        cell.setCellValue("Điện thoại: 086332030");
		        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));

		        row = sheet.createRow(3);
		        cell = row.createCell(1);
		        cell.setCellValue("HÓA ĐƠN BÁN");
		        cell.setCellStyle(boldStyle);
		        sheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 3));

		        java.util.Date ngayLapHD = dateChooser.getDate();
		        SimpleDateFormat sdi = new SimpleDateFormat("dd 'tháng' MM 'năm' yyyy");
		        String formattedDate = sdi.format(ngayLapHD);
		        
		        row = sheet.createRow(5);
		        row.createCell(0).setCellValue("Mã sản phẩm:");
		        row.createCell(1).setCellValue(invoiceId);
		        row.createCell(2).setCellValue("Khách hàng:");
		        row.createCell(3).setCellValue(txtTenKhachHang.getText());
		        
		        row = sheet.createRow(6);
		        row.createCell(0).setCellValue("Địa chỉ:");
		        row.createCell(1).setCellValue(txtDiaChi.getText());
		        row.createCell(2).setCellValue("Điện thoại:");
		        row.createCell(3).setCellValue(txtSoDienThoai.getText());
		        row.createCell(4).setCellValue("Ngày lập hóa đơn: " + formattedDate);
		        // Tiêu đề bảng sản phẩm
		        row = sheet.createRow(8);
		        String[] columns = {"STT", "Tên hàng", "Số lượng", "Đơn giá", "Giảm giá", "Thành tiền"};
		        for (int i = 0; i < columns.length; i++) {
		            cell = row.createCell(i);
		            cell.setCellValue(columns[i]);
		            cell.setCellStyle(boldStyle);
		        }

		        int rowIndex = 9;
		        int stt = 1;
		        double total = 0;
		      
		        for (int i = 0; i < tbChiTietHoaDon.getRowCount(); i++) {
		            row = sheet.createRow(rowIndex++);
		            row.createCell(0).setCellValue(stt++);
		            row.createCell(1).setCellValue(tbChiTietHoaDon.getValueAt(i, 1).toString());

		            // Kiểm tra dữ liệu trước khi chuyển đổi số
		            int soLuong = 0;
		            double donGia = 0;
		            double totalPrice = 0;
		            String giamGia = "";

		            try {
		                soLuong = Integer.parseInt(tbChiTietHoaDon.getValueAt(i, 2).toString());
		            } catch (NumberFormatException ex) {
		                soLuong = 0; // Nếu không phải số, đặt giá trị mặc định
		            }

		            try {
		                donGia = Double.parseDouble(tbChiTietHoaDon.getValueAt(i, 3).toString());
		            } catch (NumberFormatException ex) {
		                donGia = 0.0;
		            }

		            try {
		                giamGia = tbChiTietHoaDon.getValueAt(i, 4).toString() + "%";
		            } catch (Exception ex) {
		                giamGia = "0%";
		            }

		            try {
		                totalPrice = Double.parseDouble(tbChiTietHoaDon.getValueAt(i, 5).toString());
		            } catch (NumberFormatException ex) {
		                totalPrice = 0.0;
		            }

		            row.createCell(2).setCellValue(soLuong);
		            row.createCell(3).setCellValue(donGia);
		            row.createCell(4).setCellValue(giamGia);
		            row.createCell(5).setCellValue(totalPrice);
		            total += totalPrice;
		        }

		        // Tổng tiền
		        row = sheet.createRow(rowIndex + 1);
		        row.createCell(4).setCellValue("Tổng tiền:");
		        row.createCell(5).setCellValue(total);

		        // Tổng tiền bằng chữ
		        row = sheet.createRow(rowIndex + 2);
		        row.createCell(0).setCellValue(lblBangChu.getText());
		      

		        // Ngày in hóa đơn
		        row = sheet.createRow(rowIndex + 4);
		        SimpleDateFormat sdf = new SimpleDateFormat("dd 'tháng' MM 'năm' yyyy");
		        row.createCell(3).setCellValue("Cần Thơ, " + sdf.format(new Date()));

		        // Nhân viên bán hàng
		        row = sheet.createRow(rowIndex + 5);
		        row.createCell(3).setCellValue("Nhân viên bán hàng");

		        row = sheet.createRow(rowIndex + 7);
		        row.createCell(3).setCellValue(txtTenNhanVien.getText());

		        // Lưu file
		        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
		            workbook.write(outputStream);
		            JOptionPane.showMessageDialog(null, "Xuất hóa đơn thành công: " + filePath, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        }
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    }
		}
	}