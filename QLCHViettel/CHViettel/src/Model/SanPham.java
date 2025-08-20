package Model;

public class SanPham {
    private String maHang;
    private String maLoai;
    private String maNcc;
    private String tenSP;
    private String dvt;
    private String nuocSX;
    private double giaTien;
    private String anh;
    private String ghiChu;
    private int soLuong;
    
    public SanPham (String maHang, String maLoai, String maNcc, String tenSP, String dvt, String nuocSX,
            double giaTien, String anh, String ghichu, int soLuong) {
			this.maHang = maHang;
			this.maLoai = maLoai;
			this.maNcc = maNcc;
			this.tenSP = tenSP;
			this.dvt = dvt;
			this.nuocSX = nuocSX;
			this.giaTien = giaTien;
			this.anh = anh;
			this.ghiChu = ghichu;
			this.soLuong = soLuong;
}


	public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getNuocSX() {
        return nuocSX;
    }

    public void setNuocSX(String nuocSX) {
        this.nuocSX = nuocSX;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
