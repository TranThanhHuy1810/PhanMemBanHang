package Model;
public class NhanVien {
    private String maNV;
    private String tenNV;
    private String gioiTinh;
    private String soDT;
    private String loaiNV;
    public NhanVien() {}
    public NhanVien(String maNV, String tenNV, String gioiTinh, String soDT, String loaiNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.loaiNV = loaiNV;
    }
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getTenNV() { return tenNV; }
    public void setTenNV(String tenNV) { this.tenNV = tenNV; }
    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }
    public String getSoDT() { return soDT; }
    public void setSoDT(String soDT) { this.soDT = soDT; }
    public String getLoaiNV() { return loaiNV; }
    public void setLoaiNV(String loaiNV) { this.loaiNV = loaiNV; }
}