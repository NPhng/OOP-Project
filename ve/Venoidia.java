package ve;


import java.util.Scanner;

public class Venoidia extends Ve{
    Scanner sc =new Scanner(System.in);
    
    private String cmnd_cccd;
    private String thanhpho;


    //Constructor mặc định
    public Venoidia(){
        super();
        this.cmnd_cccd = "";
        this.thanhpho = "";
    }

    //Constructor tham số
    public Venoidia( String mave, String macb, int giave, String macho, String cmnd_cccd , String thanhpho){
        super( mave, macb, giave, macho);
        this.cmnd_cccd = cmnd_cccd;
        this.thanhpho = thanhpho;
    }
    

    public Venoidia (Venoidia other)
    {
        super(other);
        this.cmnd_cccd = other.cmnd_cccd;
        this.thanhpho = other.thanhpho;
    }

    //Get,Set

    public String getCmnd_cccd(){
        return cmnd_cccd;
    }
    public void setCmnd_cccd(String cmnd_cccd){
        this.cmnd_cccd = cmnd_cccd;
    }

    public String getThanhpho(){
        return thanhpho;
    }
    public void setThanhpho(String thanhpho)
    {
        this.thanhpho = thanhpho;
    }


    @Override
    public void nhap()
    {
        super.nhap();
        System.out.print("\t CMND/CCCD : "); this.cmnd_cccd = sc.nextLine();
        System.out.print("\t Thanh Pho : "); this.thanhpho = sc.nextLine();
    }

    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("\t=========================================");
        System.out.println("\t          THÔNG TIN NỘI ĐỊA           ");
        System.out.println("\t=========================================");
        System.out.printf("\t| %-20s : %-15s |\n", "CMND/CCCD", this.cmnd_cccd);
        System.out.printf("\t| %-20s : %-15s |\n", "Thành phố cư trú", this.thanhpho);
        System.out.println("\t=========================================");
    }
}

