package Diadiem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class DanhSachDD {
    Scanner sc = new Scanner(System.in);

    private int soluongDD;
    private DiaDiem[] dsDD; 

    // Constructors
    public DanhSachDD() {
        soluongDD = 0;
        dsDD = new DiaDiem[0];
    }

    public DanhSachDD(DiaDiem[] dsDD, int soluongDD)
    {
        this.soluongDD = soluongDD; 
        this.dsDD = Arrays.copyOf(dsDD, soluongDD);
    }

    public DanhSachDD(DanhSachDD other) {
        this.soluongDD = other.soluongDD;
        this.dsDD = Arrays.copyOf(other.dsDD, other.soluongDD);
    }

    // Getters and Setters
    public DiaDiem[] getDsVe()
    {
        return dsDD;
    }

    public void setDsVe(DiaDiem[] dsDD) {
        if (dsDD != null) {
            this.dsDD = Arrays.copyOf(dsDD, dsDD.length);           
            this.soluongDD = dsDD.length; 
        } else {
            this.dsDD = new DiaDiem[0];
            this.soluongDD = 0;
        }
    }
    
    public int getSoluongDD(){
        return soluongDD;
    }
    public void setSoluongVe(int soluongDD){
        this.soluongDD = soluongDD;
    }

    public void docFile(){
        String filePath = "Data/ds-diadiem.txt"; 
        this.dsDD = new DiaDiem[0];
        this.soluongDD = 0;

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
                String
                    madd = reader.readLine().trim(),
                    tendd = reader.readLine().trim(),
                    sanbay = reader.readLine().trim(),
                    quocgia = reader.readLine().trim(),
                    thanhpho = reader.readLine().trim();
                
                
                this.them(new DiaDiem(madd, tendd, sanbay, quocgia, thanhpho));
            }

            reader.close();
             System.out.println("Đã đọc thành công " + this.soluongDD + " vé từ file: " + filePath);
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
        String filePath = "Data/ds-diadiem.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(soluongDD));
            
            for (DiaDiem dd : dsDD){
                writer.newLine(); 
                
                writer.write(dd.getMadd());
                writer.newLine();
                writer.write(dd.getTendd());
                writer.newLine();
                writer.write(dd.getSanbay());
                writer.newLine();
                writer.write(dd.getQuocgia());
                writer.newLine();
                writer.write(dd.getThanhpho());
            }
            
            System.out.println("Đã lưu dữ liệu vào file: " + filePath);
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu danh sách vé vào file: " + e.getMessage());
        }
    }
    
    // Đọc file
    public void ghiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Output/Danhsachdiadiem.txt"));
            Formatter formatter = new Formatter(writer)) {
            
            formatter.format("===[Danh sách địa điểm]===\n");
            formatter.format("Số lượng: " + soluongDD + "\n\n");

            if (soluongDD > 0){
                formatter.format("-".repeat(69));
                formatter.format("\n| %-3s | %-11s | %-12s | %-7s | %-8s | %-9s |\n",
                                      "STT", "Mã địa điểm", "Tên địa điểm", "Sân bay", "Quốc gia", "Thành phố");
                formatter.format("-".repeat(69) + "\n");

                for (int i = 0; i < soluongDD; i++){
                    formatter.format("| %-3s | %-11s | %-12s | %-7s | %-8s | %-9s |\n",
                                      i+1,
                                      dsDD[i].getMadd(),
                                      dsDD[i].getTendd(),
                                      dsDD[i].getSanbay(),
                                      dsDD[i].getQuocgia(),
                                      dsDD[i].getThanhpho());
                }
                formatter.format("-".repeat(69));
            }

            System.out.println("Đã ghi dữ liệu vào file: Danhsachdiadiem.txt");

        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        }
    }

    public void them(){
        DiaDiem newDD = new DiaDiem();
        System.out.println("Nhập thông tin địa điểm cần thêm:");
        newDD.nhap();

        them(newDD);
    }

    public void them(DiaDiem dd){
        dsDD = Arrays.copyOf(dsDD, soluongDD + 1);
        dsDD[soluongDD] = new DiaDiem(dd);
        soluongDD++;
    }

    public void sua() {
        System.out.println("\n--- SỬA ĐỊA ĐIỂM ---");
        if (soluongDD == 0) {
            System.out.println("Danh sách địa điểm trống, không thể sửa.");
            return;
        }

        System.out.print("Nhập mã địa điểm cần sửa: ");
        String maDDcansua = sc.nextLine();
        
        DiaDiem ddcansua = timKiemTheoMaDiaDiem(maDDcansua);
        
        if (ddcansua != null){
            System.out.println("--- SỬA THÔNG TIN ĐỊA ĐIỂM CÓ MÃ: " + maDDcansua + " ---");
            ddcansua.sua();
        }
        else
            System.out.println("Không tìm thấy địa điểm có mã " + maDDcansua);
    }

    public void nhap(){
        System.out.print("Nhập số lượng địa điểm: ");
        int sl = 0;
        try {
            sl = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ.");
            return;
        }
        
        soluongDD = 0;
        dsDD = new DiaDiem[0];

        for (int i = 0; i < sl; i++) {
            System.out.println("\nNhập thông tin địa điểm thứ " + (i + 1) + ":");
            DiaDiem dd = new DiaDiem();

            dd.nhap();
            
            them(dd);
        }
    }

    public void xuat() {
        System.out.println("===[Danh sách địa điểm]===");
        System.out.println("Số lượng: " + soluongDD + '\n');
        for (int i = 0; i < soluongDD; i++) {
            System.out.println("Địa điểm thứ " + (i + 1) + ":");
            dsDD[i].xuat();
        }
    }

    public void timKiemTheoMaDiaDiem(){
        System.out.print("Nhập mã địa điểm cần tìm kiếm: "); String maDD = sc.nextLine().trim();
        
        DiaDiem resultTimKiemMaDD = timKiemTheoMaDiaDiem(maDD);

        if (resultTimKiemMaDD != null){
            System.out.println("Đã tìm thấy địa điểm có mã " + maDD + ":");
            resultTimKiemMaDD.xuat();
        }
        else
            System.out.println("Không tìm thấy địa điểm có mã " + maDD + ".");
    }

    public DiaDiem timKiemTheoMaDiaDiem(String maDD){
        for (DiaDiem dd : dsDD){
            if (dd.getMadd().equals(maDD))
                return dd;
        }

        return null;
    }

    public void timKiemTheoQuocGia(){
        System.out.print("Nhập quốc gia cần tìm kiếm: "); String quocgia = sc.nextLine().trim();
        
        DiaDiem[] resultTimKiemQuocGia = timKiemTheoQuocGia(quocgia);

        if (resultTimKiemQuocGia != null){
            System.out.println("Đã tìm thấy " + resultTimKiemQuocGia.length + " địa điểm ở quốc gia " + quocgia + ":");
            for (int i = 0; i < resultTimKiemQuocGia.length; i++){
                System.out.println("Địa điểm thứ " + (i+1) + ":");
                resultTimKiemQuocGia[i].xuat();
            }
        }
        else
            System.out.println("Không tìm thấy địa điểm ở quốc gia " + quocgia + ".");
    }

    public DiaDiem[] timKiemTheoQuocGia(String quocgia){
        DiaDiem[] result = new DiaDiem[0];

        for (DiaDiem dd : dsDD){
            if (dd.getQuocgia().equals(quocgia)){
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length-1] = dd;
            }
        }

        return result;
    }

    public int[] thongKeTheoThanhPho(){
        int[] result = new int[3];
        // 0 : tphcm, 1: hanoi, 2: haiphong

        for (DiaDiem dd : dsDD){
            if (dd.getThanhpho().equalsIgnoreCase("tphcm"))
                result[0]++;
            else if (dd.getThanhpho().equalsIgnoreCase("hanoi"))
                result[1]++;
            else if (dd.getThanhpho().equalsIgnoreCase("haiphong"))
                result[2]++;
        }

        return result;
    }
}
