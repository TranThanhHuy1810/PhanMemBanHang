package UI;

import DAO.DatabaseConnection;
import DAO.NhanVienDAO;
import Model.NhanVien;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.List;

public class FrmNhanVien extends JPanel { // Thay đổi từ JFrame sang JPanel
    private JTextField txtMaNhanVien, txtTenNhanVien, txtSoDienThoai, txtLoaiNhanVien;
    private JTable tblFrmNhanVien;
    private DefaultTableModel model;
    private NhanVienDAO nhanVienDAO;
    private JComboBox<String> cboGioiTinh; 

    public FrmNhanVien() {
        setLayout(null);
        setBackground(new Color(173, 216, 230));

        JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên");
        lblMaNhanVien.setBounds(20, 20, 100, 20);
        add(lblMaNhanVien);

        txtMaNhanVien = new JTextField();
        txtMaNhanVien.setBounds(130, 20, 200, 25);
        add(txtMaNhanVien);

        JLabel lblTenNhanVien = new JLabel("Tên Nhân Viên");
        lblTenNhanVien.setBounds(20, 60, 100, 20);
        add(lblTenNhanVien);

        txtTenNhanVien = new JTextField();
        txtTenNhanVien.setBounds(130, 60, 200, 25);
        add(txtTenNhanVien);

        JLabel lblGioiTinh = new JLabel("Giới Tính");
        lblGioiTinh.setBounds(20, 100, 100, 20);
        add(lblGioiTinh);

        cboGioiTinh = new JComboBox<>(new String[]{"Nam", "Nữ"}); 
        cboGioiTinh.setBounds(130, 100, 200, 25);
        add(cboGioiTinh);

        JLabel lblSoDienThoai = new JLabel("Số Điện Thoại");
        lblSoDienThoai.setBounds(400, 20, 100, 20);
        add(lblSoDienThoai);

        txtSoDienThoai = new JTextField();
        txtSoDienThoai.setBounds(510, 20, 200, 25);
        add(txtSoDienThoai);

        JLabel lblLoaiNhanVien = new JLabel("Loại Nhân Viên");
        lblLoaiNhanVien.setBounds(400, 60, 100, 20);
        add(lblLoaiNhanVien);

        txtLoaiNhanVien = new JTextField();
        txtLoaiNhanVien.setBounds(510, 60, 200, 25);
        add(txtLoaiNhanVien);

        ImageIcon saveIcon = new ImageIcon("src/image/luu.png");
        JButton btnThem = new JButton("Thêm",saveIcon);
        btnThem.setBounds(10, 150, 120, 30);
        add(btnThem);

        ImageIcon fixIcon = new ImageIcon("src/image/sua.png");
        JButton btnSua = new JButton("Sửa",fixIcon);
        btnSua.setBounds(140, 150, 129, 30);
        add(btnSua);

        ImageIcon deleteIcon = new ImageIcon("src/image/xoa.png");
        JButton btnXoa = new JButton("Xóa",deleteIcon);
        btnXoa.setBounds(279, 150, 130, 30);
        add(btnXoa);


        ImageIcon skipIcon = new ImageIcon("src/image/boqua.png");
        JButton btnBoQua = new JButton("Bỏ Qua",skipIcon);
        btnBoQua.setBounds(419, 150, 130, 30);
        add(btnBoQua);

        model = new DefaultTableModel(new String[]{"Mã NV", "Tên NV", "Giới Tính", "SĐT", "Loại NV"}, 0);
        tblFrmNhanVien = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tblFrmNhanVien);
        scrollPane.setBounds(20, 200, 776, 216);
        add(scrollPane);

        Connection conn = DatabaseConnection.getConnection();
        nhanVienDAO = new NhanVienDAO(conn);
        loadDataToTable();

        btnThem.addActionListener(this::themNhanVien);
        btnSua.addActionListener(this::suaNhanVien);
        btnXoa.addActionListener(this::xoaNhanVien);
  
        btnBoQua.addActionListener(e -> {
            txtMaNhanVien.setText("");
            txtTenNhanVien.setText("");
            txtSoDienThoai.setText("");
            txtLoaiNhanVien.setText("");
            cboGioiTinh.setSelectedIndex(0); 
            loadDataToTable();
        });
    }

    private void loadDataToTable() {
        model.setRowCount(0);
        List<NhanVien> danhSach = nhanVienDAO.loadDataNhanVien();
        for (NhanVien nv : danhSach) {
            model.addRow(new Object[]{nv.getMaNV(), nv.getTenNV(), nv.getGioiTinh(), nv.getSoDT(), nv.getLoaiNV()});
        }
        tblFrmNhanVien.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tblFrmNhanVien.getSelectedRow(); 
            if (selectedRow >= 0) { 
                String maNV = model.getValueAt(selectedRow, 0).toString(); 
                String tenNV = model.getValueAt(selectedRow, 1).toString();
                String gioiTinh = model.getValueAt(selectedRow, 2).toString(); 
                String soDT = model.getValueAt(selectedRow, 3).toString();  
                String loaiNV = model.getValueAt(selectedRow, 4).toString(); 
                txtMaNhanVien.setText(maNV);
                txtTenNhanVien.setText(tenNV);
                cboGioiTinh.setSelectedItem(gioiTinh);
                txtSoDienThoai.setText(soDT);
                txtLoaiNhanVien.setText(loaiNV);
            }
        });
    }

    private void themNhanVien(ActionEvent e) {
        String maNV = txtMaNhanVien.getText().trim();
        String tenNV = txtTenNhanVien.getText().trim();
        String gioiTinh = (String) cboGioiTinh.getSelectedItem(); 
        String soDT = txtSoDienThoai.getText().trim();
        String loaiNV = txtLoaiNhanVien.getText().trim();

        if (maNV.isEmpty() || tenNV.isEmpty() || gioiTinh == null || soDT.isEmpty() || loaiNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        if (!soDT.matches("\\d{10,11}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! (Phải có 10-11 chữ số)");
            return;
        }

        NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, soDT, loaiNV);
        if (nhanVienDAO.themNhanVien(nv)) {
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại!");
        }
    }

    private void suaNhanVien(ActionEvent e) {
        try {
            String maNV = txtMaNhanVien.getText();
            String tenNV = txtTenNhanVien.getText();
            String gioiTinh = (String) cboGioiTinh.getSelectedItem(); 
            String soDienThoai = txtSoDienThoai.getText();
            String loaiNV = txtLoaiNhanVien.getText();

            if (maNV.isEmpty() || tenNV.isEmpty() || soDienThoai.isEmpty() || loaiNV.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, soDienThoai, loaiNV);
            boolean isUpdated = nhanVienDAO.suaNhanVien(nv);

            if (isUpdated) {
                JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại. Vui lòng thử lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void xoaNhanVien(ActionEvent e) {
        int selectedRow = tblFrmNhanVien.getSelectedRow();
        if (selectedRow >= 0) {
            String maNV = model.getValueAt(selectedRow, 0).toString();
            if (nhanVienDAO.xoaNhanVien(maNV)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                loadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa.");
        }
    }
}
