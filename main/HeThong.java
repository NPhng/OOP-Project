package main;

import QuanLy.*;
import java.util.Scanner;

public class HeThong {
    
    public void menuChinh(){
        
        // Khởi tạo QLBV để truy cập DanhsachVe static và đọc file lần đầu
        QLBV qlbv = new QLBV(); 
        qlbv.docFile(); // Đọc dữ liệu từ file khi hệ thống khởi động

        Scanner sc = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n===[ CHƯƠNG TRÌNH QUẢN LÝ DANH SÁCH VÉ ]===");
            System.out.println("\nHãy chọn menu quản lý");
            System.out.println("\t1) Quản lý Danh sách Vé");
            System.out.println("\t2) Quản lý địa điểm");
            System.out.println("\t0) Thoát Chương trình");
            
            System.out.print("Hãy nhập lựa chọn của bạn (0-2): ");

            try{
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    luaChon = -1; 
                    continue; 
                }
                luaChon = Integer.parseInt(input);
            }
            catch (NumberFormatException e){
                System.out.println("Hãy nhập số hợp lệ.");
                luaChon = -1;
                continue; // Quay lại đầu vòng lặp
            }
            
            switch (luaChon){
                case 1: // Quản lý Danh sách Vé
                    System.out.println("\n--- BẮT ĐẦU QUẢN LÝ VÉ ---");
                    // SỬA LỖI: Cần khởi tạo QLV (lớp con chứa menuChinh chi tiết)
                    QLV qlve = new QLV(); 
                    qlve.menuChinh();
                    System.out.println("--- KẾT THÚC QUẢN LÝ VÉ ---");
                    break;
                case 2: // Quản lý địa điểm
                    System.out.println("\n--- BẮT ĐẦU QUẢN LÝ ĐỊA ĐIỂM ---");
                    QLDD qldd = new QLDD(); 
                    qldd.menuChinh();
                    System.out.println("--- KẾT THÚC QUẢN LÝ ĐỊA ĐIỂM ---");
                    break;
                case 0: // Thoát Chương trình
                    System.out.println("\nĐã thoát khỏi Hệ thống Quản lý Vé. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                    break;
            }
        } while (luaChon != 0);
        
        // Đóng Scanner khi thoát chương trình
        sc.close(); 
    }

    public static void main(String args[]){
        HeThong hethong = new HeThong();
        hethong.menuChinh();
    }

}


