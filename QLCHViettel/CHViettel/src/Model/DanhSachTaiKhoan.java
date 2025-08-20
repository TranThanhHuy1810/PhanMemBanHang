package Model;

import java.util.ArrayList;
import java.util.List;

public class DanhSachTaiKhoan {
    private static DanhSachTaiKhoan instance;

    public static DanhSachTaiKhoan getInstance() {
        if (instance == null) {
            instance = new DanhSachTaiKhoan();
        }
        return instance;
    }

    public static void setInstance(DanhSachTaiKhoan newInstance) {
        instance = newInstance;
    }

    private List<TaiKhoan> listTaiKhoan;
    public List<TaiKhoan> getListTaiKhoan() {
        return listTaiKhoan;
    }

    public void setListTaiKhoan(List<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

    private DanhSachTaiKhoan() {
        listTaiKhoan = new ArrayList<>();
        listTaiKhoan.add(new TaiKhoan("admin", "123456"));
    }
}
