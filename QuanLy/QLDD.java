package QuanLy;

import java.util.Scanner;

public class QLDD extends QLBV {
    Scanner sc =new Scanner(System.in);

    @Override
    public void menuChinh() {
        int luaChon;
        
        do {
        	 System.out.println("\n=================================");
             System.out.println("    MENU QUẢN LÝ DANH SÁCH ĐỊA ĐIỂM ");
             System.out.println("=================================");
             System.out.println("1. Nhập danh sách địa điểm (thêm nhiều)");
             System.out.println("2. Xuất danh sách địa điểm ra màn hình");
             System.out.println("3. Xuất danh sách địa điểm ra file");
             System.out.println("4. Thêm địa điểm");
             System.out.println("5. Sửa địa điểm");
             System.out.println("6. Tìm kiếm địa điểm theo mã");
             System.out.println("7. Tìm kiếm địa điểm theo quốc gia");
             System.out.println("8. Thống kê theo thành phố");
             System.out.println("0. Thoát chương trình (Tự động lưu)");
             System.out.print("Nhập lựa chọn của bạn: ");
            
            try {
                String input = sc.nextLine();
                luaChon = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập một số.");
                luaChon = -1;
                continue; 
            }

            switch (luaChon) {
            case 1:
                ds_DD.nhap(); 
                break;
            case 2:
                ds_DD.xuat();
                break;
            case 3:
                ds_DD.ghiFile();
                break;
            case 4:
                ds_DD.them();
                break;
            case 5:
                ds_DD.sua();
                break;
            case 6:
                ds_DD.timKiemTheoMaDiaDiem();
                break;
            case 7:
                ds_DD.timKiemTheoQuocGia();
                break;
            case 8:
                int[] resultThongKeTheoThanhPho = ds_DD.thongKeTheoThanhPho();
                System.out.println("--- Thông kê theo thành phố ---");
                System.out.println("Thành phố Hồ Chí Minh (tphcm): " + resultThongKeTheoThanhPho[0]);
                System.out.println("Hà nội (hanoi): " + resultThongKeTheoThanhPho[1]);
                System.out.println("Hải phòng (haiphong): " + resultThongKeTheoThanhPho[2]);
                break;
            case 0:
                ds_DD.luuFile();
                System.out.println("Đã lưu và thoát chương trình. Tạm biệt!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        } while (luaChon != 0);
    }
}
