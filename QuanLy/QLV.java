package QuanLy;

import java.util.Scanner;

public class QLV extends QLBV {
    Scanner sc =new Scanner(System.in);

    // Ghi đè phương thức menuChinh từ QLBV
    @Override
    public void menuChinh() {
        // ds_Ve đã được khởi tạo và đọc file trong constructor của QLBV
        
        int luaChon;
        
        do {
        	 System.out.println("\n=================================");
             System.out.println("    MENU QUẢN LÝ DANH SÁCH VÉ ");
             System.out.println("=================================");
             System.out.println("1. Nhập danh sách vé (thêm nhiều)");
             System.out.println("2. Thêm 1 vé mới");
             System.out.println("3. Xuất danh sách vé ra màn hình");
             System.out.println("4. Xuất danh sách vé ra file");
             System.out.println("5. Sửa thông tin vé theo mã");
             System.out.println("6. Xóa vé theo mã");
             System.out.println("7. Tìm kiếm vé theo mã");
             System.out.println("8. Tìm kiếm vé theo giá tối thiểu");
             System.out.println("9. Tìm kiếm vé theo Mã chuyến bay");
             System.out.println("10. Tìm kiếm vé theo Mã chỗ");
             System.out.println("11. Thống kê tổng số lượng và doanh thu");
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
                ds_Ve.nhap(); 
                break;
            case 2:
                ds_Ve.them(); 
                break;
            case 3:
                ds_Ve.xuat();
                break;
            case 4:
                ds_Ve.ghiFile(); 
                break;
            case 5:
                ds_Ve.suaVe(); 
                break;
            case 6:
                ds_Ve.xoaVe(); 
                break;
            case 7:
                ds_Ve.timKiemTheoMa(); 
                break;
            case 8:
                ds_Ve.timKiemTheoGia(); 
                break;
            case 9:
                ds_Ve.timKiemTheoMaChuyenBay(); 
                break;
            case 10:
                ds_Ve.timKiemTheoMaCho(); 
                break;
            case 11:
                ds_Ve.thongKe(); 
                break;
            case 0:
                ds_Ve.ghiFile(); 
                System.out.println("Đã lưu và thoát chương trình. Tạm biệt!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
        }
    } while (luaChon != 0);

    // Không đóng Scanner sc ở đây nếu menuChinh được gọi bởi một menu lớn hơn.
    }
}