package ve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class DanhsachVe {
    Scanner sc = new Scanner(System.in);
    private int soluongVe;
    private Ve[] dsVe; 

    // Constructors
    public DanhsachVe() {
        soluongVe = 0;
        dsVe = new Ve[0];
    }

    public DanhsachVe(Ve[] dsVe, int soluongve)
    {
        this.soluongVe = soluongve; 
        this.dsVe = Arrays.copyOf(dsVe, soluongve);
    }

    public DanhsachVe(DanhsachVe other) {
        this.soluongVe = other.soluongVe;
        this.dsVe = Arrays.copyOf(other.dsVe, other.soluongVe);
    }

    // Getters and Setters
    public Ve[] getDsVe()
    {
        return Arrays.copyOf(this.dsVe,this.soluongVe);
    }

    public void setDsVe(Ve[] dsVe) {
        if (dsVe != null) {
            this.dsVe = Arrays.copyOf(dsVe, dsVe.length);           
            this.soluongVe = dsVe.length; 
        } else {
            this.dsVe = new Ve[0];
            this.soluongVe = 0;
        }
    }
    
    public int getSoluongVe(){
        return soluongVe;
    }
    public void setSoluongVe(int soluongVe){
        this.soluongVe = soluongVe;
    }

    
    // Phương thức tìm vị trí vé theo mã
    private int timViTriVe(String maVe) {
        for (int i = 0; i < soluongVe; i++) {
            if (dsVe[i].getMave().equalsIgnoreCase(maVe)) {
                return i;
            }
        }
        return -1;
    }

    
    public boolean veDaTonTai(String maVe) { 
        return timViTriVe(maVe) != -1;
    }

    // --- Các Phương thức File ---

    // CẬP NHẬT: docFile() gọi themVe(Ve veMoi)
    public void docFile(){
        String filePath = "Data/ds-ve.txt"; 
        this.dsVe = new Ve[0];
        this.soluongVe = 0;

        try {
            Path path = Paths.get(filePath);

            if (!Files.exists(path) || !Files.isRegularFile(path) || Files.size(path) == 0) {
                System.out.println("File dữ liệu vé " + filePath + " không tồn tại hoặc rỗng. Bắt đầu với danh sách trống.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            
            String line = reader.readLine();
            if (line == null) {
                 reader.close();
                 return; 
            }
            int n = Integer.parseInt(line.trim());
            
            for (int i = 0; i < n; i++){
                int loaiVe = Integer.parseInt(reader.readLine().trim());
                
                String
                    mave = reader.readLine().trim(),
                    macb = reader.readLine().trim(),
                    macho = reader.readLine().trim();

                int
                    giave = Integer.parseInt(reader.readLine().trim());
                
                
                if (loaiVe == 1){ // Vé nội địa
                    String
                        cmnd_cccd = reader.readLine().trim(),
                        thanhpho = reader.readLine().trim();

                    // GỌI HÀM LÕI MỚI themVe(Ve veMoi)
                    this.themVe(new Venoidia(mave, macb, giave, macho, cmnd_cccd, thanhpho));
                }
                else if (loaiVe == 2){ // Vé quốc tế
                    String
                        visa = reader.readLine().trim(),
                        hochieu = reader.readLine().trim(),
                        quocgia = reader.readLine().trim();
                    
                    // GỌI HÀM LÕI MỚI themVe(Ve veMoi)
                    this.themVe(new Vequocte(mave, macb, giave, macho, visa, hochieu, quocgia));
                }
            }

            reader.close();
             System.out.println("Đã đọc thành công " + this.soluongVe + " vé từ file: " + filePath);
        } catch (IOException e) {
            System.err.println("Lỗi I/O khi đọc file vé: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.err.println("Lỗi định dạng số khi đọc file vé: Dữ liệu file không đúng cấu trúc.");
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi đọc file vé: " + e.getMessage());
        }
    }

    public void luuFile(){
        String filePath = "Data/ds-ve.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(soluongVe));
            
            for (Ve ve : dsVe){
                writer.newLine(); 
                
                if (ve instanceof Venoidia){
                    writer.write("1");
                }
                else if (ve instanceof Vequocte){
                    writer.write("2");
                }
                
                writer.newLine();
                writer.write(ve.getMave());
                writer.newLine();
                writer.write(ve.getMacb());
                writer.newLine();
                writer.write(ve.getMacho());
                writer.newLine();
                writer.write(String.valueOf(ve.getGiave()));

                if (ve instanceof Venoidia veND){
                    writer.newLine();
                    writer.write(veND.getCmnd_cccd());
                    writer.newLine();
                    writer.write(veND.getThanhpho());
                }
                else if (ve instanceof Vequocte veQT){
                    writer.newLine();
                    writer.write(veQT.getVisa());
                    writer.newLine();
                    writer.write(veQT.getHochieu());
                    writer.newLine();
                    writer.write(veQT.getQuocgia());
                }
            }
            
            System.out.println("Đã lưu dữ liệu vào file: " + filePath);
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu danh sách vé vào file: " + e.getMessage());
        }
    }
    
    // Giữ nguyên hàm xem()
    public void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Output/Danhsachve.txt"));
            Formatter formatter = new Formatter(writer)) {
            
            formatter.format("===[Danh sách ve]===\n");
            formatter.format("Số lượng: " + soluongVe + "\n\n");

            if (soluongVe > 0){
                formatter.format("-".repeat(156));
                formatter.format("\n| %-4s | %-6s | %-7s | %-15s | %-8s | %-8s | %-11s | %-15s | %-7s | %-15s | 15s |\n",
                                      "STT", "Loại ", "Mã Vé", "Mã Chuyến Bay", "Giá vé", "Mã chỗ", "CMND_CCCD", "Thành phố", "Visa", " Hộ Chiếu ", "Quốc Gia");
                formatter.format("-".repeat(156) + "\n");

                for (int i = 0; i < soluongVe; i++){
                    if (dsVe[i] instanceof Venoidia){
                        formatter.format("\n| %-4s | %-6s | %-7s | %-15s | %-8s | %-8s | %-11s | %-15s | %-7s | %-15s | 15s |\n",
                                i+1,
                                "Venoidia",
                                dsVe[i].getMave(),
                                dsVe[i].getMacb(),
                                dsVe[i].getGiave() + "đ",
                                dsVe[i].getMacho(),
                                ((Venoidia)dsVe[i]).getCmnd_cccd(),
                                ((Venoidia)dsVe[i]).getThanhpho(),
                                "",
                                "",
                                "");
                    }
                    else if (dsVe[i] instanceof Vequocte){
                        formatter.format("\n| %-4s | %-6s | %-7s | %-15s | %-8s | %-8s | %-11s | %-15s | %-7s | %-15s | 15s |\n",
                                i+1,
                                "Vequocte",
                                dsVe[i].getMave(),
                                dsVe[i].getMacb(),
                                dsVe[i].getGiave() + "đ",
                                dsVe[i].getMacho(),
                                "",
                                "",
                                ((Vequocte)dsVe[i]).getVisa(),
                                ((Vequocte)dsVe[i]).getHochieu(),
                                ((Vequocte)dsVe[i]).getQuocgia());
                    }
                }
                formatter.format("-".repeat(156));
            }

            System.out.println("Đã ghi dữ liệu vào file: DanhSachSanPham.txt");

        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        }
    }

    public void nhap(){
        System.out.print("Nhập số lượng vé: ");
        int sl = 0;
        try {
            sl = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ.");
            return;
        }
        
        soluongVe = 0;
        dsVe = new Ve[0];

        for (int i = 0; i < sl; i++) {
            System.out.println("\nNhập thông tin vé thứ " + (i + 1) + ":");
            Ve ve = null;
            int choice;
            
            do {
                System.out.print("Loại vé (1: Ve nội địa, 2: Ve quốc tế): "); 
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Vui lòng nhập số 1 hoặc 2.");
                    continue;
                }

                if (choice == 1) {
                    ve = new Venoidia();
                } else if (choice == 2) {
                    ve = new Vequocte();
                } else {
                    System.out.println("Vui lòng nhập số từ khoảng 1-2: ");
                }
            } while (ve == null);
            
            // Nhập thông tin và kiểm tra trùng lặp mã vé
            boolean isMaVeUnique = false;
            while(!isMaVeUnique){
                ve.nhap();
                String maVeMoi = ve.getMave();
                if (veDaTonTai(maVeMoi)) {
                    System.out.println("Lỗi: Mã vé " + maVeMoi + " đã tồn tại trong danh sách. Vui lòng nhập lại.");
                } else {
                    isMaVeUnique = true;
                }
            }
            
            themVe(ve);
        }
    }

    // Hàm xuat() đã được khôi phục về logic ban đầu
    public void xuat() {
        System.out.println("===[Danh sách Vé]===");
        System.out.println("Số lượng: " + soluongVe + '\n');
        for (int i = 0; i < soluongVe; i++) {
            System.out.println("Vé thứ " + (i + 1) + ":");
            dsVe[i].xuat();
        }
    }

    // Đã cập nhật hàm them() để sử dụng themVe(Ve ve) và kiểm tra trùng lặp
    public void them() {
        System.out.println("\n--- THÊM VÉ ---");
        Ve ve = null;
        int loaive = 0;
        
        do {
            System.out.print("\tLoại vé (1: Vé nội địa , 2: Vé quốc tế ): "); 
            try {
                loaive = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số 1 hoặc 2.");
                continue;
            }

            if (loaive == 1)
                ve = new Venoidia();
            else if (loaive == 2)
                ve = new Vequocte();
            else 
                System.out.println("Lỗi: Vui lòng nhập số 1 hoặc 2.");
        } while (loaive != 1 && loaive != 2);
        
        // Nhập và kiểm tra trùng lặp mã vé
        do {
            ve.nhap();
            if (veDaTonTai(ve.getMave())) {
                System.out.println("Lỗi: Mã vé " + ve.getMave() + " đã tồn tại. Vui lòng nhập lại.");
            }
        } while (veDaTonTai(ve.getMave()));

        // Thêm vé bằng hàm themVe(Ve veMoi)
        this.themVe(ve);
        System.out.println("Đã thêm thành công vé có mã: " + ve.getMave() + " vào danh sách.");
        luuFile(); // Ghi lại toàn bộ file sau khi thêm
    }

    // Đổi tên từ them(Ve ve) thành themVe(Ve veMoi)
    // CÓ BỔ SUNG KIỂM TRA TRÙNG LẶP MÃ VÉ
    public void themVe(Ve veMoi) {
       
        if (veDaTonTai(veMoi.getMave())) {
            
            return;
        }

        dsVe = Arrays.copyOf(dsVe, soluongVe + 1);
        
        if (veMoi instanceof Venoidia)
            dsVe[soluongVe] = new Venoidia((Venoidia)veMoi);
        else if (veMoi instanceof Vequocte)
            dsVe[soluongVe] = new Vequocte((Vequocte)veMoi);
        else
            dsVe[soluongVe] = new Ve(veMoi); // Trường hợp lớp Ve cơ sở
        
        soluongVe++;
    }

    
    // Hàm xóa vé có tham số: Giữ nguyên (Vì đã gọi luuFile() ở cuối hàm)
    public boolean xoaVe(String maVeCanXoa) {
        int viTri = timViTriVe(maVeCanXoa);

        if (viTri != -1) {
            for (int i = viTri; i < soluongVe - 1; i++) {
                dsVe[i] = dsVe[i + 1];
            }
            soluongVe--;
            dsVe = Arrays.copyOf(dsVe, soluongVe);
            
            luuFile(); // Ghi lại toàn bộ file dữ liệu sau khi xóa

            return true;
        } else {
            return false;
        }
    }

    // Hàm xoaVe() không tham số sử dụng xoaVe(String maVeCanXoa)
    public void xoaVe() {
        System.out.println("\n--- XÓA VÉ ---");
        if (soluongVe == 0) {
            System.out.println("Danh sách vé trống, không thể xóa.");
            return;
        }

        System.out.print("Nhập mã vé cần xóa: ");
        String maVeCanXoa = sc.nextLine();
        
        // Sử dụng hàm xoaVe(String maVeCanXoa) để xóa khỏi mảng và ghi file
        if (xoaVe(maVeCanXoa)) {
            System.out.println(" Đã xóa vé có mã: " + maVeCanXoa + " khỏi danh sách.");
        } else {
            System.out.println("Không tìm thấy vé với mã: " + maVeCanXoa);
        }
    }
    
    // --- PHƯƠNG THỨC SỬA VÉ ---
    
    // Hàm sửa vé có tham số
    public boolean suaVe(String maVeCanSua) {
        int viTri = timViTriVe(maVeCanSua);
        
        if (viTri == -1) {
            return false; // Không tìm thấy vé
        }

        Ve veHienTai = dsVe[viTri];
        
        System.out.println("--- SỬA THÔNG TIN VÉ CÓ MÃ: " + maVeCanSua + " ---");
        System.out.println("Lưu ý: Bạn không thể sửa Mã Vé.");

        try {
            System.out.printf("\t - Mã chuyến bay (Hiện tại: %s, Nhập mới hoặc Enter để giữ nguyên): ", veHienTai.getMacb());
            String macbMoi = sc.nextLine();
            if (!macbMoi.trim().isEmpty()) {
                veHienTai.setMacb(macbMoi);
            }

            System.out.printf("\t - Giá vé (Hiện tại: %d, Nhập mới hoặc Enter để giữ nguyên): ", veHienTai.getGiave());
            String giaveStr = sc.nextLine();
            if (!giaveStr.trim().isEmpty()) {
                veHienTai.setGiave(Integer.parseInt(giaveStr));
            }

            System.out.printf("\t - Mã chỗ (Hiện tại: %s, Nhập mới hoặc Enter để giữ nguyên): ", veHienTai.getMacho());
            String machoMoi = sc.nextLine();
            if (!machoMoi.trim().isEmpty()) {
                veHienTai.setMacho(machoMoi);
            }

            if (veHienTai instanceof Venoidia veND) {
                System.out.println("--- Thông tin Vé Nội địa ---");
                System.out.printf("\t - CMND/CCCD (Hiện tại: %s, Nhập mới hoặc Enter để giữ nguyên): ", veND.getCmnd_cccd());
                String cmndMoi = sc.nextLine();
                if (!cmndMoi.trim().isEmpty()) {
                    veND.setCmnd_cccd(cmndMoi);
                }

                System.out.printf("\t - Thành phố (Hiện tại: %s, Nhập mới hoặc Enter để giữ nguyên): ", veND.getThanhpho());
                String tpMoi = sc.nextLine();
                if (!tpMoi.trim().isEmpty()) {
                    veND.setThanhpho(tpMoi);
                }
            } else if (veHienTai instanceof Vequocte veQT) {
                System.out.println("--- Thông tin Vé Quốc tế ---");
                System.out.printf("\t - Visa (Hiện tại: %s, Nhập mới hoặc Enter để giữ nguyên): ", veQT.getVisa());
                String visaMoi = sc.nextLine();
                if (!visaMoi.trim().isEmpty()) {
                    veQT.setVisa(visaMoi);
                }

                System.out.printf("\t - Hộ Chiếu (Hiện tại: %s, Nhập mới hoặc Enter để giữ nguyên): ", veQT.getHochieu());
                String hochieuMoi = sc.nextLine();
                if (!hochieuMoi.trim().isEmpty()) {
                    veQT.setHochieu(hochieuMoi);
                }

                System.out.printf("\t - Quốc gia (Hiện tại: %s, Nhập mới hoặc Enter để giữ nguyên): ", veQT.getQuocgia());
                String quocgiaMoi = sc.nextLine();
                if (!quocgiaMoi.trim().isEmpty()) {
                    veQT.setQuocgia(quocgiaMoi);
                }
            }

            luuFile(); // Ghi lại toàn bộ file dữ liệu sau khi sửa
            return true;

        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Giá vé phải là một số nguyên. Việc sửa đổi bị hủy.");
            return false;
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi sửa vé: " + e.getMessage());
            return false;
        }
    }

    // Hàm suaVe() không tham số
    public void suaVe() {
        System.out.println("\n--- SỬA VÉ ---");
        if (soluongVe == 0) {
            System.out.println("Danh sách vé trống, không thể sửa.");
            return;
        }

        System.out.print("Nhập mã vé cần sửa: ");
        String maVeCanSua = sc.nextLine();
        
        if (suaVe(maVeCanSua)) {
            System.out.println("Đã sửa thành công vé có mã: " + maVeCanSua);
        } else {
            System.out.println("Không tìm thấy vé với mã: " + maVeCanSua);
        }
    }
    
    // --- PHƯƠNG THỨC TÌM KIẾM ---

    // 1. Tìm kiếm theo Mã Vé (có tham số)
    public Ve timKiemTheoMa(String maVe) {
        int viTri = timViTriVe(maVe);
        if (viTri != -1) {
            return dsVe[viTri];
        }
        return null;
    }

    // 1. Tìm kiếm theo Mã Vé (không tham số) - Dùng xuat()
    public void timKiemTheoMa() {
        System.out.println("\n--- TÌM KIẾM VÉ THEO MÃ VÉ ---");
        System.out.print("Nhập mã vé cần tìm: ");
        String maVe = sc.nextLine();
        
        Ve ketQua = timKiemTheoMa(maVe);
        
        if (ketQua != null) {
            System.out.println("Đã tìm thấy vé có mã: " + maVe);
            ketQua.xuat(); // Gọi hàm xuat() của đối tượng Ve
        } else {
            System.out.println("Không tìm thấy vé với mã: " + maVe);
        }
    }

    // 2. Tìm kiếm theo Giá Vé (có tham số)
    public Ve[] timKiemTheoGia(int giaMin, int giaMax) {
        Ve[] ketQua = new Ve[0];
        for (Ve ve : dsVe) {
            if (ve.getGiave() >= giaMin && ve.getGiave() <= giaMax) {
                ketQua = Arrays.copyOf(ketQua, ketQua.length+1);
                ketQua[ketQua.length - 1] = ve;
            }
        }
        return ketQua;
    }

    // 2. Tìm kiếm theo Giá Vé (không tham số) - Dùng xuat()
    public void timKiemTheoGia() {
        System.out.println("\n--- TÌM KIẾM VÉ THEO KHOẢNG GIÁ ---");
        int giaMin = -1, giaMax = -1;
        try {
            System.out.print("Nhập giá tối thiểu: ");
            giaMin = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập giá tối đa: ");
            giaMax = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Giá phải là một số nguyên hợp lệ.");
            return;
        }
        
        if (giaMin < 0 || giaMax < giaMin) {
            System.out.println("Lỗi: Khoảng giá không hợp lệ. Vui lòng nhập lại.");
            return;
        }

        Ve[] ketQua = timKiemTheoGia(giaMin, giaMax);
        if (ketQua.length > 0) {
            System.out.println("Tìm thấy " + ketQua.length + " vé trong khoảng giá.");
            for (int i = 0; i < ketQua.length; i++) {
                System.out.println("\n--- Vé thứ " + (i + 1) + " ---");
                ketQua[i].xuat(); // Gọi hàm xuat() của đối tượng Ve
            }
        } else {
            System.out.println("Không tìm thấy vé nào phù hợp.");
        }
    }
    
    // 3. Tìm kiếm theo Mã Chỗ (có tham số)
    public Ve[] timKiemTheoMaCho(String maCho) {
        Ve[] ketQua = new Ve[0];
        for (Ve ve : dsVe) {
            if (ve.getMacho().equalsIgnoreCase(maCho)) {
                ketQua = Arrays.copyOf(ketQua, ketQua.length+1);
                ketQua[ketQua.length - 1] = ve;
            }
        }
        return ketQua;
    }

    // 3. Tìm kiếm theo Mã Chỗ (không tham số) - Dùng xuat()
    public void timKiemTheoMaCho() {
        System.out.println("\n--- TÌM KIẾM VÉ THEO MÃ CHỖ ---");
        System.out.print("Nhập mã chỗ cần tìm: ");
        String maCho = sc.nextLine();
        
        Ve[] ketQua = timKiemTheoMaCho(maCho);
        if (ketQua.length > 0) {
            System.out.println("Tìm thấy " + ketQua.length + " vé với mã chỗ " + maCho + ".");
            for (int i = 0; i < ketQua.length; i++) {
                System.out.println("\n--- Vé thứ " + (i + 1) + " ---");
                ketQua[i].xuat(); // Gọi hàm xuat() của đối tượng Ve
            }
        } else {
            System.out.println("Không tìm thấy vé nào phù hợp.");
        }
    }
    
    // 4. Tìm kiếm theo Mã Chuyến Bay (có tham số)
    public Ve[] timKiemTheoMaChuyenBay(String maCB) {
        Ve[] ketQua = new Ve[0];
        for (Ve ve : dsVe) {
            if (ve.getMacb().equalsIgnoreCase(maCB)) {
                ketQua = Arrays.copyOf(ketQua, ketQua.length+1);
                ketQua[ketQua.length - 1] = ve;
            }
        }
        return ketQua;
    }

    // 4. Tìm kiếm theo Mã Chuyến Bay (không tham số) - Dùng xuat()
    public void timKiemTheoMaChuyenBay() {
        System.out.println("\n--- TÌM KIẾM VÉ THEO MÃ CHUYẾN BAY ---");
        System.out.print("Nhập mã chuyến bay cần tìm: ");
        String maCB = sc.nextLine();
        
        Ve[] ketQua = timKiemTheoMaChuyenBay(maCB);
        if (ketQua.length > 0) {
            System.out.println("Tìm thấy " + ketQua.length + " vé thuộc chuyến bay " + maCB + ".");
            for (int i = 0; i < ketQua.length; i++) {
                System.out.println("\n--- Vé thứ " + (i + 1) + " ---");
                ketQua[i].xuat(); // Gọi hàm xuat() của đối tượng Ve
            }
        } else {
            System.out.println("Không tìm thấy vé nào phù hợp.");
        }
    }
    
    // --- PHƯƠNG THỨC THỐNG KÊ ---
    
    public void thongKe() {
        System.out.println("\n--- THỐNG KÊ DANH SÁCH VÉ ---");
        
        int tongSoVe = soluongVe;
        int soVeNoiDia = 0;
        int soVeQuocTe = 0;
        long tongGiaTriVe = 0;
        
        for (Ve ve : dsVe) {
            tongGiaTriVe += ve.getGiave();
            if (ve instanceof Venoidia) {
                soVeNoiDia++;
            } else if (ve instanceof Vequocte) {
                soVeQuocTe++;
            }
        }
        
        double phanTramNoiDia = (tongSoVe > 0) ? ((double) soVeNoiDia / tongSoVe) * 100 : 0;
        double phanTramQuocTe = (tongSoVe > 0) ? ((double) soVeQuocTe / tongSoVe) * 100 : 0;
        
        System.out.println("=========================================");
        System.out.printf("| %-25s | %-15s |\n", "Chỉ số", "Giá trị");
        System.out.println("=========================================");
        System.out.printf("| %-25s | %-15d |\n", "Tổng số lượng vé", tongSoVe);
        System.out.printf("| %-25s | %-15d |\n", "Số lượng Vé Nội địa", soVeNoiDia);
        System.out.printf("| %-25s | %-15.2f%% |\n", "Tỷ lệ Vé Nội địa", phanTramNoiDia);
        System.out.printf("| %-25s | %-15d |\n", "Số lượng Vé Quốc tế", soVeQuocTe);
        System.out.printf("| %-25s | %-15.2f%% |\n", "Tỷ lệ Vé Quốc tế", phanTramQuocTe);
        System.out.printf("| %-25s | %-15d |\n", "Tổng giá trị tất cả vé (vnđ)", tongGiaTriVe);
        System.out.println("=========================================");
    }
}