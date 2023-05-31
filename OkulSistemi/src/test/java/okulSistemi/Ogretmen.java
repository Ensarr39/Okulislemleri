package okulSistemi;

public class Ogretmen extends  Kisi {

   private  String brans;
    private String sicilNo;

    public Ogretmen() {

    }

    public Ogretmen(String adSoyad, String kimlikNo, int yas, String brans, String sicilNo) {
        super(adSoyad, kimlikNo, yas);
        this.brans = brans;
        this.sicilNo = sicilNo;
    }

    public String getBrans() {
        return brans;
    }

    public void setBrans(String brans) {
        this.brans = brans;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }
}
