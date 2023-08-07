package src;

public class Runner {

    /**
     * main METODUMUZ BURADA, DOLAYISIYLA PROGRAMIMIZ BURADAN ÇALIŞMAYA BAŞLIYOR.
     * BURADA DA Bİ DEĞİŞİKLİK YAPMANIZA GEREK YOK.
     * DEĞİŞİKLİKLERİ İLGİLİ METODLARA GİDEREK, O METODLAR İÇİNDE YAPMALISINIZ...
     */

    public static void main(String[] args) throws InterruptedException {

        //PROGRAM ÇALIŞINCA 5 KİŞİLİK Bİ ÖĞRETMEN LİSTESİ OLUŞUYOR
        Veritabani.baslangicOgretmenVeritabaniOlustur();

        //PROGRAM ÇALIŞINCA 5 KİŞİLİK Bİ ÖĞRENCİ LİSTESİ OLUŞUYOR
        Veritabani.baslangicOgrenciVeritabaniOlustur();

        //ANA MENÜ BAŞLATILIYOR
        Helper.anaMenu();

    }

}