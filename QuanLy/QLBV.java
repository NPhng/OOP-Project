package QuanLy;

import Diadiem.DanhSachDD;
import ve.DanhsachVe;

public class QLBV {
    protected static DanhsachVe ds_Ve = new DanhsachVe();
    protected static DanhSachDD ds_DD = new DanhSachDD();
    public void docFile() {
        
        ds_Ve.docFile();
        ds_DD.docFile();

    }

     public void menuChinh(){}
}