package ve;

import java.util.Scanner;

public class Vequocte extends Ve{
    Scanner sc =new Scanner(System.in);
    
    private String visa;
    private String hochieu;
    private String quocgia;

    //Constructor mặc định
    public Vequocte(){
        super();
        this.visa = "";
        this.hochieu = "";
        this.quocgia="";
    }

    //Constructor tham so
    public Vequocte( String mave, String macb, int giave, String macho, String visa, String hochieu, String quocgia){
        super(mave,macb,giave,macho);
        this.visa = visa;
        this.hochieu = hochieu;
        this.quocgia = quocgia;
    }

    public Vequocte(Vequocte other){
        super(other);
        this.visa = other.visa;
        this.hochieu = other.hochieu;
        this.quocgia = other.quocgia;
    }

    //Get,Set
    public String getVisa(){
        return visa;
    }
    public void setVisa(String visa){
        this.visa = visa;
    }

    public String getHochieu(){
        return hochieu;
    }
    public void setHochieu(String hochieu){
        this.hochieu = hochieu;
    }

    public String getQuocgia(){
        return quocgia;
    }
    public void setQuocgia(String quocgia)
    {
        this.quocgia = quocgia;
    }

    @Override
    public void nhap(){
        super.nhap();
        System.out.print("\t Visa : "); this.visa = sc.nextLine();
        System.out.print("\t Ho Chieu : "); this.hochieu = sc.nextLine();
        System.out.print("\t Quoc Gia : "); this.quocgia = sc.nextLine();
    }

    @Override 
    public void xuat()
    {
    super.xuat(); 
    
    System.out.println("\t=========================================");
    System.out.println("\t      THÔNG TIN HỘ CHIẾU & VISA      ");
    System.out.println("\t=========================================");
    System.out.printf("\t| %-20s : %-15s |\n", "Visa", this.visa);
    System.out.printf("\t| %-20s : %-15s |\n", "Hộ Chiếu", this.hochieu);
    System.out.printf("\t| %-20s : %-15s |\n", "Quốc Gia", this.quocgia);
    System.out.println("\t=========================================");
    }
}
