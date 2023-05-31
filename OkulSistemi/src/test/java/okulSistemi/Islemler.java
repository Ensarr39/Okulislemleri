package okulSistemi;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Islemler {

   static List<Kisi> ogrenciList = new ArrayList<>();
   static List<Kisi> ogretmeniList = new ArrayList<>();
   static Scanner scan = new Scanner(System.in);
   static String kisiTuru;

   public static void anaMenu(){

      System.out.println("*****OGRENCI VE OGRETMEN ISLEMLERI MENUSU*****");
      System.out.println("1-OGRENCI ISLEMLERI\n2-OGRETMEN ISLEMLERI\nQ-CIKIS");
      System.out.println("ISLEMINIZI SECINIZ");

      String secim= scan.next().toUpperCase();

      switch (secim){
         
         case "1":
            kisiTuru= "OGRENCI";
            islemMenusu();
            break;
         case "2":
            kisiTuru="OGRETMEN";
            islemMenusu();
            break;
         case "Q":
            cikis();
            break;
         default:
            System.out.println("HATAKLI SECIM YAPTINIZ");
      }

      


   }

   private static void cikis() {
   }

   private static void islemMenusu() {

      System.out.println("**********ISLEMLER**********");
      System.out.println("1-EKLEME\n2-ARAMA\n3-LISTELEME\n4-SILME\n5-ANA MENU\n0-CIKIS");
      System.out.println("Islem tervihinizi giriniz: ");
      int islemTercihi=scan.nextInt();
      switch (islemTercihi){

         case 0:
            islemcikis();
            anaMenu();
            break;
         case 1:
            ekleme();
            islemMenusu();
            break;
         case 2:
            arama();
            islemMenusu();
            break;
         case 3:
            listeleme();
            islemMenusu();
            break;
         case 4:
            silme();
            islemMenusu();
            break;
         default:
            System.out.println("Hatali giris yaptiniz");


      }







   }

   private static void silme() {
      System.out.println("******* " +kisiTuru+ "silme sayfasi *******");
      boolean kontrol = true;

      if(kisiTuru.equalsIgnoreCase("OGRENCI")){
         System.out.println("silinecek ogrenci kimlik no giriniz: ");
         String silOgrcKimlik = scan.next();
         for (Kisi k: ogrenciList) {
            if(k.getKimlikNo().equals(silOgrcKimlik)){
               System.out.println("sildiginiz ogrenci :" + k.getAdSoyad());
               ogrenciList.remove(k);
               kontrol=false;

            }

         }
         if (kontrol) {
            System.out.println("Aradigibiz ogrenci mevcut degil");
         }

      }else {
         System.out.println("silinecek ogretmen kimlik no giriniz :");
         String silOgrtKimlik = scan.nextLine();
         scan.next();
         for (Kisi k:ogretmeniList) {
            if(k.getKimlikNo().contains(silOgrtKimlik)){
               System.out.println("sildiginiz ogretmen :" +k.getAdSoyad());
               ogretmeniList.remove(k);
               kontrol=false;
            }
         }
      }


   }

   private static void listeleme() {

      System.out.println("******* " +kisiTuru+ "arama sayfasi *******");
      if(kisiTuru.equalsIgnoreCase("OGRENCI")){
         for (Kisi k: ogrenciList) {
            System.out.println(k.toString());
            
         }
      }else {
         for (Kisi k: ogretmeniList ) {
            System.out.println(k.toString());

         }
      }

   }

   private static void arama() {
      System.out.println("******* " +kisiTuru+ "arama sayfasi *******");
      if(kisiTuru.equals("OGRENCI")){
         System.out.println("Aradiginiz ogrencinin kimlik numarasını giriniz :");
         String ogrenciKimlik = scan.next();
         for (Kisi k: ogrenciList) {
            if (k.getKimlikNo().equals(ogrenciKimlik)){

               System.out.println("aradiginiz ogenci : "+ k.getAdSoyad());

            }else System.out.println("aradiginiz ogrenci mevcut degil");

         }
      }


   }

   private static void ekleme() {
      System.out.println("******* " +kisiTuru+ "ekleme sayfasi *******");
      System.out.println("Ad Soyad giriniz : ");
      scan.next();
      String adSoyad = scan.nextLine();
      System.out.println("kimlik no giriniz: ");
      String kimlikNo = scan.next();
      System.out.println("yas giriniz :");
      int yas= scan.nextInt();
      if (kisiTuru.equals("OGRENCI")){
         System.out.println("Ogrenci numarasi giriniz");
         String ogrenciNo= scan.next();
         System.out.println("Sinifinizi giriniz");
         String sinif = scan.next();

         Ogrenci ogrenci = new Ogrenci(adSoyad,kimlikNo,yas,ogrenciNo,sinif);
         ogrenciList.add(ogrenci);
         System.out.println( "ogrenci eklendi");


      }

else if(kisiTuru.equals("OGRETMEN")){
         System.out.println("Sicil no giriniz: ");
         String sicilNo =scan.next();
         System.out.println("Bolum giriniz");
         String bolum= scan.next();
         Ogretmen ogrt=new Ogretmen(adSoyad,kimlikNo,yas,sicilNo,bolum);
         ogretmeniList.add(ogrt);
         System.out.println("ogrtmen eklendi");




      }






   }

   private static void islemcikis() {
      System.out.println("Uygulamayi kullandiginiz icin tesekkırler :))");
   }

}
