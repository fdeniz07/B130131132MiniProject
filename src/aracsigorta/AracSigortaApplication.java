package aracsigorta;

import java.util.Scanner;

public class AracSigortaApplication {

    /*
        Proje: Araç Sigorta Prim Hesaplama
           Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                        -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
           Tarife dönemi:Aralık 2022,Haziran 2022
           1.dönemi  : Haziran 2022               2.dönem : Aralik 2022
              otomobil: 2000                       otomobil: 2500
              kamyon:   3000                       kamyon:   3500
              otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
              motosiklet: 1500                     motosiklet: 1750
            Hatalı girişte hesaplama başarısız uyarsı verip tekrar menü gösterilsin.
            Yeni islem yapilabilmesi icin secenek sunulsun

 */

    public static void main(String[] args) {

    }

    public static void  start(){

        boolean isFail;
        Scanner input = new Scanner(System.in);


        do{

            isFail=false;
            //menü ve tarif dönemi secimi
            System.out.println("--- Zorunlu Arac Sigorta Primi Hesaplama ---");
            System.out.println("Tarife dönemi seciniz: ");
            System.out.println("1. Haziran 2022");
            System.out.println("2. Aralik 2022");
            int term = input.nextInt();

            //Tarif dönemi dgogru girilmisse isleme devam et, degilse uyari ver ve uygulamayi yeniden yap
            if (term==1 || term==2){

                //Arac olustur
                Arac arac = new Arac();
                System.out.println("Arac tipini giriniz: ");
                System.out.println("otomobil,kamyon,otobüs,motosiklet");
                arac.type=input.next();
                arac.prim= arac.countPrim(term);

                //prim 0 dan büyükse hesaplama basarili, sonucu görüntüle
                //prim 0 veya negatifse hatali giris ve yeni islem secenegi

                int select;
                if (arac.prim>0){

                }else{
                    System.out.println("Hesaplama basarisiz, tekrar deneyiniz.");
                    System.out.println("Yeni islem icin 1, cikis icin 0 giriniz:");
                    select=input.nextInt();

                    isFail= select == 1;
//                    if (select==1)
//                        isFail=true;
//                    else {
//                        isFail=false;
//                    }
                }
            }else {
                System.out.println("Hatali giris");
                isFail=true;
            }

        }while (isFail);

    }
}
