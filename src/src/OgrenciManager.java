package src;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgrenciManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    public static void ogrenciMenu() throws InterruptedException {


        String tercih = "";
        do {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================== OGRENCI MENU =================\n" +
                            "\t   1- Ogrenci Listesi Yazdir\n" +
                            "\t   2- Soyisimden Ogrenci Bulma\n" +
                            "\t   3- Sinif ve Sube Ile Ogrenci Bulma\n" +
                            "\t   4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS");
            System.out.print("Lutfen Menuden tercihinizi yapiniz:");
            tercih = scan.nextLine();
            switch (tercih.toUpperCase()) {
                case "1":
                    ogrenciListeYazdir();
                    break;

                case "2":
                    soyisimdenOgrenciBulma();
                    break;

                case "3":
                    sinifVeSubeIleOgrenciBulma();
                    break;

                case "4":
                    ogrenciEkle();
                    break;

                case "5":
                    tcNoIleOgrenciSilme();
                    break;

                case "A":
                    System.out.println("Ana Menü'ye geri dönülüyor...");
                    for (int i = 0; i < 20; i++) {
                        Thread.sleep(100);
                        System.out.print(">");
                    }
                    Helper.anaMenu();
                    return;

                case "Q":
                    Helper.projeDurdur();
                    break;

                default:
                    System.out.println("Lutfen gecerli tercih yapiniz:");
            }
        } while (true);

    }

    private static void tcNoIleOgrenciSilme() throws InterruptedException {
        System.out.print("Silinecek ogrenci kimlik no giriniz");
        String silinecekOgrenci = scan.nextLine();

        String silinecekValue = ogrenciMap.get(silinecekOgrenci);
        String sonucValue = ogrenciMap.remove(silinecekOgrenci);

        System.out.print(silinecekOgrenci+" "+"Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        // Bu scope u önemsemeyin, sadece programın çalışmaya devam etmesi için gerekli... Daha sonra görülecek.
        //////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz TC numarasi ile ogrenci bulunamadi");
        }/////////////////////////////////////////////////////////////////////////////////////////////////
    }

    private static void ogrenciEkle() {
        Scanner oku = new Scanner(System.in);
        System.out.print("Ogrenci Tc giriniz");
        String ogrenciTC = oku.nextLine();

        System.out.print("Ad, Soyad, Doğum Tarihi, Okul No, Sınıf ve Şube Giriniz (Ör : Ahmet, Demir, 1980, 5002, 11, B) : ");
        String genelbilgiler = oku.nextLine();
        Veritabani.ogrenciMap.put(ogrenciTC, genelbilgiler);
    }

    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {

        System.out.println("///// KONSOLDAN ALDIGINIZ BILGILERLE, ARANAN OGEYI (SINIF VE SUBE) ICEREN MAP ELEMANLARINI LISTELEYINIZ ////////");
        System.out.print("Aradığınız Sınıf No: ");
        String Sinif = scan.nextLine();
        System.out.print("Aradığınız Şube No: ");
        String Sube = scan.nextLine();


        System.out.print("=== ÖĞRENCİLER LİSTELENİYOR ===");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogrenciEntrySet = ogrenciMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============SINIF VE SUBE ILE OGRENCI ARAMA ============\n" +
                        "OGRENCI SUBE VE SINIF");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> X : ogrenciEntrySet) {
            String SubeVeSinifKey = X.getKey();
            String subeVeSinifValue = X.getValue();

            String[] subeVeSinifValuarr = subeVeSinifValue.split(", ");
            if (Sinif.equalsIgnoreCase(subeVeSinifValuarr[4]) && Sube.equalsIgnoreCase(subeVeSinifValuarr[5])){
                System.out.println(SubeVeSinifKey + " : " + subeVeSinifValue + " | ");
            }
        }
    }


    private static void soyisimdenOgrenciBulma() throws InterruptedException {
        System.out.print("Aradığınız öğrencinin soyadı: ");
        String Aranan = scan.nextLine();
        System.out.println("Öğrenciler Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        Set<Map.Entry<String, String>> ogrenciEntrySet = ogrenciMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============SOYISIM ILE OGRENCI ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Brans");
        for (Map.Entry<String, String> each : ogrenciEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (Aranan.equalsIgnoreCase(eachValuarr[1])) {
                System.out.println(eachKey + " : " + eachValue + " | ");

            }
        }


    }

    private static void ogrenciListeYazdir() throws InterruptedException {
        Set<Map.Entry<String, String>> Ogrenciler = ogrenciMap.entrySet();
        System.out.println("=== ÖĞRENCİLER ===");
        for (int i = 0; i < 25; i++) {
            Thread.sleep(150);
            System.out.print(">");

        }
        System.out.println();
        for (Map.Entry<String, String> p : Ogrenciler) {
            System.out.println(p.getKey()+" "+p.getValue());
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
    }
}
