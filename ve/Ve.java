package ve;

import java.util.Scanner;

public class Ve {
    Scanner sc = new Scanner(System.in);
    
    // Thuộc tính trung tâm
    private String mave;
    private String macb;
    private int giave;
    private String macho;

    //Constructor mặc định 
    public Ve() {
        mave = "";
        macb = "";
        giave = 0;
        macho = "";
    }

    //Constructor tham so
    public Ve(String mave, String macb, int giave, String macho){
        this.mave = mave;
        this.macb = macb;
        this.giave = giave;
        this.macho = macho;
    }

    public Ve(Ve other)
    {
        this.mave = other.mave;
        this.macb = other.macb;
        this.giave = other.giave;
        this.macho = other.macho;
    }

    //Get,Set

    public String getMave(){
        return mave;
    }
    public void setMave(String mave){
        this.mave = mave;
    }

    public String getMacb(){
        return macb;
    }
    public void setMacb(String macb){
        this.macb = macb;
    }

    public int getGiave(){
        return giave;
    }
    public void setGiave(int giave){
        this.giave = giave;
    } 

    public String getMacho(){
        return macho;
    }
    public void setMacho(String macho){
        this.macho = macho;
    }


   public void nhap()
{
    System.out.print("\t - Ma ve : "); this.mave = sc.nextLine();
    System.out.print("\t - Ma chuyen bay : "); this.macb = sc.nextLine();
    System.out.print("\t - Gia ve : "); this.giave = sc.nextInt();sc.nextLine();
    System.out.print("\t - Ma cho : "); this.macho = sc.nextLine();
}

   public void xuat()
{
    System.out.println("\t=========================================");
    System.out.println("\t          CHI TIẾT VÉ MÁY BAY           ");
    System.out.println("\t=========================================");
    System.out.printf("\t| %-20s : %-15s |\n", "Mã Vé", this.mave);
    System.out.printf("\t| %-20s : %-15s |\n", "Mã Chuyến Bay", this.macb);
    System.out.printf("\t| %-20s : %-15d |\n", "Giá Vé", this.giave); 
    System.out.printf("\t| %-20s : %-15s |\n", "Mã Chỗ", this.macho);
    System.out.println("\t=========================================");
}
}

