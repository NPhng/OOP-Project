package sanbay;

import java.util.Scanner;

public class Sanbay {
    private String masb;
    private String tensb;
    private String thanhpho;
    private String quocgia;

    //Constructor mac dinh
    public Sanbay(){
        masb="";
        tensb="";
        thanhpho="";
        quocgia="";
    }

    //Constructor tham so
    public Sanbay(String masb,String tensb,String thanhpho,String quocgia){
        this.masb = masb;
        this.tensb = tensb;
        this.thanhpho = thanhpho;
        this.quocgia = quocgia;
    }

    public Sanbay (Sanbay other){
        this.masb = other.masb;
        this.tensb = other.tensb;
        this.thanhpho = other.thanhpho;
        this.quocgia = other.quocgia;
    }

    public String getMasb(){
        return masb;
    }
    public void setMasb(String masb){
        this.masb = masb;
    }

    public String getTensb(){
        return tensb;
    }
    public void setTensb(String tensb){
        this.tensb = tensb;
    }

    public String getThanhpho(){
        return tensb;
    }
    public void setThanhpho(String thanhpho){
        this.thanhpho = thanhpho;
    }

    public String getQuocgia(){
        return quocgia;
    }
    public void setQuocgia(String quocgia){
        this.quocgia = quocgia;
    }


    public void nhap()
    {
    Scanner sc = new Scanner(System.in);
    System.out.print("\t - Ma San Bay : "); this.masb = sc.nextLine();
    System.out.print("\t - Ten san bay : "); this.tensb = sc.nextLine();
    System.out.print("\t - Thanh Pho : "); this.thanhpho = sc.nextLine();
    System.out.print("\t - Quoc Gia : "); this.quocgia = sc.nextLine();
    }

      public void xuat()
    {
    System.out.println("\t" + "=".repeat(41));
    System.out.println("\t          CHI TIẾT SAN BAY          ");
    System.out.println("\t" + "=".repeat(41));
    System.out.printf("\t| %-20s : %-15s |\n", "Ma San Bay", this.masb);
    System.out.printf("\t| %-20s : %-15s |\n", "Ten San Bay", this.tensb);
    System.out.printf("\t| %-20s : %-15.0f |\n", "Thanh Pho", this.thanhpho); 
    System.out.printf("\t| %-20s : %-15s |\n", "Quoc Gia", this.quocgia);
    System.out.println("\t=========================================");
    }
            

}
