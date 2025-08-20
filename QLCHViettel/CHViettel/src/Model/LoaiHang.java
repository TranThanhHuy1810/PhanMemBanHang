package Model;

public class LoaiHang {
	private String MaLoai;
	private String TenLoai;
	
	public LoaiHang(String MaLoai, String TenLoai) {
        this.MaLoai=MaLoai;
        this.TenLoai=TenLoai;
    }
	 public String getMaLoai() {
	        return MaLoai;
	    }
	    public void setMaLoai(String maLoai) {
	        this.MaLoai = maLoai;
	    }
		 public String getTenLoai() {
		        return TenLoai;
		    }
		 public void setTenLoai(String tenLoai) {
		        this.TenLoai = tenLoai;
	   }
}
