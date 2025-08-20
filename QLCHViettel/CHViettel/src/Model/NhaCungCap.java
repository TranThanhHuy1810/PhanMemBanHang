package Model;
public class NhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String tenGiaoDich;
    private String diaChi;
    private String dienThoai;
    private String email;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String tenNCC, String tenGiaoDich, String diaChi, String dienThoai, String email) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.tenGiaoDich = tenGiaoDich;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.email = email;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getTenGiaoDich() {
        return tenGiaoDich;
    }

    public void setTenGiaoDich(String tenGiaoDich) {
        this.tenGiaoDich = tenGiaoDich;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
