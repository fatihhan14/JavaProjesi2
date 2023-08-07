package src;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgretmenManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    ///////////////////////////////////////////////////////////////////
    // METODLARIN YANINDAKİ "throws InterruptedException" I SİLMEYİN!!!
    // DAHA SONRA GÖRÜLECEK, PROGRAMIN DÜZGÜN ÇALIŞMASI İÇİN GEREKLİ...
    ///////////////////////////////////////////////////////////////////
    public static void ogretmenMenu() throws InterruptedException {

        String tercih = "";
        do {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================= OGRETMEN MENU =================\n" +
                            "\n" +
                            "\t   1- Ogretmenler Listesi Yazdir\t\n" +
                            "\t   2- Soyisimden Ogretmen Bulma\n" +
                            "\t   3- Branstan Ogretmen Bulma\n" +
                            "\t   4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS\n");
            System.out.print("Lutfen Menuden tercihinizi yapiniz: ");
            tercih = scan.nextLine();
            switch (tercih.toUpperCase()) {
                case "1":
                    ogretmenListesiYazdir();
                    break;

                case "2":
                    soyisimdenOgretmenBulma();
                    break;

                case "3":
                    branstanOgretmenBulma();
                    break;

                case "4":
                    ogretmenEkleme();
                    break;

                case "5":
                    tcNoIleOgretmenSil();
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


    public static void tcNoIleOgretmenSil() throws InterruptedException {
        System.out.print("Silinecek ogretmen kimlik no giriniz: ");
        String silinecekOgretmen = scan.nextLine();

        String silinecekValue = ogretmenlerMap.get(silinecekOgretmen);
        String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);

        System.out.print(silinecekOgretmen + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //////////////////////////////////////////////////////////////////////////////
        // BU BLOĞU DEĞİŞTİRMEYİN, DİKKATE ALMAYIN...                               //
        // SİLİNECEK KİMLİK NO YOKSA VEYA BAŞKA BEKLENMEDİK                         //
        // ŞEYLER OLURSA KODUN DEVAMINI SAĞLAYACAK... DAHA SONRA GÖRÜLECEK.         //
        try {                                                                       //
            boolean sonuc = sonucValue.equals(silinecekValue);                      //
        } catch (Exception e) {                                                     //
            System.out.println("Istediginiz Tc numarasi ile ogretmen bulunamadi");  //
        }                                                                           //
        //////////////////////////////////////////////////////////////////////////////
    }

    public static void ogretmenEkleme() {
        Scanner oku = new Scanner(System.in);
        System.out.print("Öğretmen TC No giriniz : ");
        String tcNo = oku.nextLine();

        System.out.print("Ad, Soyad, Doğum Tarihi ve Branş Giriniz (Ör : Ahmet, Demir, 1980, Kimya) : ");
        String digerBilgiler = oku.nextLine();
        Veritabani.ogretmenlerMap.put(tcNo, digerBilgiler);
    }

    /////////////// İPUCU METODU    ////////////////////////////////////////////////
    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.print("Aradiginiz Ogretmenin Bransini Giriniz:");
        String istenenBrans = scan.nextLine();

        System.out.print(istenenBrans + " Ogretmenleri Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============BRANS ILE OGRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Brans");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuarr[3])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }
    }

    public static void soyisimdenOgretmenBulma() throws InterruptedException {

        System.out.print("Aradiginiz Ogretmenin Soyadini Giriniz:");
        String soyadiBul = scan.nextLine();

        System.out.print(soyadiBul + " Soyadli Ogretmenler Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        Set<Map.Entry<String, String>> ogretmenSoyad = ogretmenlerMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============BRANS ILE OGRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Brans");


        for (Map.Entry<String, String> a : ogretmenSoyad) {
            String eachKey = a.getKey();
            String eachValue = a.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (soyadiBul.equalsIgnoreCase(eachValuarr[1])) {
                System.out.println(eachKey + " : " + eachValue + " | ");

            }
        }
    }

    public static void ogretmenListesiYazdir() throws InterruptedException {
        Set<Map.Entry<String, String>> Ogretmenler = ogretmenlerMap.entrySet();
        System.out.println("=== ÖĞRETMENLER ===");
        for (int i = 0; i < 25; i++) {
            Thread.sleep(150);
            System.out.print(">");

        }
        System.out.println();
        for (Map.Entry<String, String> p : Ogretmenler) {
            System.out.println(p.getKey()+" "+p.getValue());
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
    }
}



