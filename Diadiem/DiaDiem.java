package Diadiem;

import java.util.Scanner;

public class DiaDiem {
    Scanner sc = new Scanner(System.in);
    
    private String madd;
    private String tendd;
    private String sanbay;
    private String quocgia;
    private String thanhpho;

    //Constructor mặc định 
    public DiaDiem() {
        madd = "";
        tendd = "";
        sanbay = "";
        quocgia ="";
        thanhpho = "";
    }

    //Constructor tham so
    public DiaDiem(String madd, String tendd, String sanbay, String quocgia, String thanhpho){
        this.madd = madd;
        this.tendd = tendd;
        this.sanbay = sanbay;
        this.quocgia = quocgia;
        this.thanhpho = thanhpho;
    }

    public DiaDiem(DiaDiem other)
    {
        this.madd = other.madd;
        this.tendd = other.tendd;
        this.sanbay = other.sanbay;
        this.quocgia = other.quocgia;
        this.thanhpho = other.thanhpho;
    }

    //Get,Set

    public String getMadd(){
        return madd;
    }
    public void setMadd(String madd){
        this.madd = madd;
    }

    public String getTendd(){
        return tendd;
    }
    public void setTendd(String tendd){
        this.tendd = tendd;
    }

    public String getSanbay()
    {
        return sanbay;
    }
    public void setSanbay(String sanbay){
        this.sanbay = sanbay;
    } 

    public String getQuocgia(){
        return quocgia;
    }
    public void setQuocgia(String quocgia){
        this.quocgia = quocgia;
    }

    public String getThanhpho(){
        return thanhpho;
    }
    public void setThanhpho(String thanhpho)
    {
        this.thanhpho = thanhpho;
    }



    public void nhap()
    {
        System.out.print("\t - Ma dia diem : "); this.madd = sc.nextLine();
        System.out.print("\t - Ten dia diem : "); this.tendd = sc.nextLine();
        System.out.print("\t - San bay : "); this.sanbay = sc.nextLine();
        System.out.print("\t - Quoc gia : "); this.quocgia = sc.nextLine();
        System.out.print("\t - Thanh pho : "); this.thanhpho = sc.nextLine();
    }

    public void xuat()
    {
        System.out.println("\t=========================================");
        System.out.println("\t          CHI TIẾT ĐỊA ĐIỂM          ");
        System.out.println("\t=========================================");
        System.out.printf("\t| %-20s : %-15s |\n", "Mã địa điểm", this.madd);
        System.out.printf("\t| %-20s : %-15s |\n", "Tên địa điểm", this.tendd);
        System.out.printf("\t| %-20s : %-15s |\n","Sân Bay", this.sanbay); 
        System.out.printf("\t| %-20s : %-15s |\n", "Quốc Gia", this.quocgia);
        System.out.printf("\t| %-20s : %-15s |\n", "Thành Phố", this.thanhpho);
        System.out.println("\t=========================================");
    }

    public void sua()
    {
        System.out.print("\t - Ten dia diem : "); this.tendd = sc.nextLine();
        System.out.print("\t - San bay : "); this.sanbay = sc.nextLine();
        System.out.print("\t - Quoc gia : "); this.quocgia = sc.nextLine();
        System.out.print("\t - Thanh pho : "); this.thanhpho = sc.nextLine();
    }
}



