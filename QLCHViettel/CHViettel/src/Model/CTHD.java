package Model;

public class CTHD {
    private String TenSP;
    private String MAHANG;
    private int SL;
    private double DonGia;
    private int GiamGia;
    private double ThanhTien;

    public CTHD( String MaHang,String TenSP, int SL, double DonGia, int GiamGia, double ThanhTien) {
    	this.MAHANG = MaHang;
    	this.TenSP = TenSP;
        this.SL = SL;
        this.DonGia = DonGia;
        this.GiamGia = GiamGia;
        this.ThanhTien = ThanhTien;
    }

    public String getSP() {
        return TenSP;
    }

    public void setSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMAHANG() {
        return MAHANG;
    }

    public void setMAHANG(String MAHANG) {
        this.MAHANG = MAHANG;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public int getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(int GiamGia) {
        this.GiamGia = GiamGia;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
}