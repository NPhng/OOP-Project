package diadiem;

import java.util.Scanner;

import ve.Ve;

public class Diadiem {
    private String madd;
    private String tendd;
    private String sanbay;
    private String quocgia;
    private String thanhpho;
    private String khuvuc;

    //Constructor mặc định 
    public Diadiem() {
        madd = "";
        tendd = "";
        sanbay = "";
        quocgia ="";
        thanhpho = "";
        khuvuc = "";
    }

    //Constructor tham so
    public Diadiem(String madd, String tendd, String sanbay, String quocgia, String thanhpho, String khuvuc){
        this.madd = madd;
        this.tendd = tendd;
        this.sanbay = sanbay;
        this.quocgia = quocgia;
        this.thanhpho = thanhpho;
        this.khuvuc = khuvuc;
    }

    public Diadiem(Diadiem other)
    {
        this.madd = other.madd;
        this.tendd = other.tendd;
        this.sanbay = other.sanbay;
        this.quocgia = other.quocgia;
        this.thanhpho = thanhpho;
        this.khuvuc = khuvuc;
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

    public String getKhuvuc(){
        return khuvuc;
    }
    public void setKhuvuc(String khuvuc){
        this.khuvuc = khuvuc;
    }



   public void nhap()
{
    Scanner sc = new Scanner(System.in);
    System.out.print("\t - Ma dia diem : "); this.madd = sc.nextLine();
    System.out.print("\t - Ten dia diem : "); this.tendd = sc.nextLine();
    System.out.print("\t - San bay : "); this.sanbay = sc.nextLine();
    System.out.print("\t - Quoc gia : "); this.quocgia = sc.nextLine();
    System.out.print("\t - Thanh pho : "); this.thanhpho = sc.nextLine();
    System.out.print("\t - Khu vuc : "); this.khuvuc = sc.nextLine();
}

   public void xuat()
{
    System.out.println("\t=========================================");
    System.out.println("\t          CHI TIẾT ĐỊA ĐIỂM          ");
    System.out.println("\t=========================================");
    System.out.printf("\t| %-20s : %-15s |\n", "Mã địa điểm : ", this.madd);
    System.out.printf("\t| %-20s : %-15s |\n", "Tên địa điểm : ", this.tendd);
    System.out.printf("\t| %-20s : %-15.0f |\n","Sân Bay : ", this.sanbay); 
    System.out.printf("\t| %-20s : %-15s |\n", "Quốc Gia : ", this.quocgia);
    System.out.printf("\t| %-20s : %-15s |\n", "Thành Phố : ", this.thanhpho);
    System.out.printf("\t| %-20s : %-15s |\n", "Khu Vực", this.khuvuc);
    System.out.println("\t=========================================");
}
}



