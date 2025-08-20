package Model;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String gioiTinhKh;
    private String diaChi;
    private String soDT;
    private String LoaiKH;

    public KhachHang() {}

    public KhachHang(String maKH, String tenKH,String gioiTinhKh, String diaChi, String soDT, String LoaiKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinhKh=gioiTinhKh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.LoaiKH =LoaiKH ;
    }

    public String getMaKH() { return maKH; }
    public void setMaKH(String maKH) { this.maKH = maKH; }

    public String getTenKH() { return tenKH; }
    public void setTenKH(String tenKH) { this.tenKH = tenKH; }
    
    public String getGioiTinh() { return gioiTinhKh; }
    public void setGioiTinh(String gioiTinhKh) { this.gioiTinhKh= gioiTinhKh; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getSoDT() { return soDT; }
    public void setSoDT(String soDT) { this.soDT = soDT; }

    public String getLoaiKH() { return LoaiKH; }
    public void setLoaiKH(String LoaiKH) { this.LoaiKH =LoaiKH; }
}
