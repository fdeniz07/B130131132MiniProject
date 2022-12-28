/*
Proje2: Sayısal Loto Uygulaması
       bilet için rastgele n tane sayı üretilsin.
       loto sonucu rastgele n tane sayı ile üretilsin.
       sayısal lotoda tekrarlı sayılar olmamalı.

       n(hane sayısı), sayılar için min ve max değerler
       kullanıcıdan alınsın.

       sonuç ve bilet karşılaştırılsın, kaç eşleşme olduğu
       kullanıcıya bildirilsin.

*/

import java.util.Random;
import java.util.Scanner;

public class SayisalLoto {

    // ctrl + alt + m secili kodlari bir method icerisine atar

    public static void main(String[] args) {

        startLotto();

    }

    private static void startLotto() {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayisal loto icin hane sayisini giriniz: ");
        int slots = input.nextInt();
        System.out.print("Sayilar icin minimum deger giriniz: ");
        int min = input.nextInt();
        System.out.print("Sayilar icin maximum deger giriniz: ");
        int max = input.nextInt();

        //loto ve bilet icin
        int[] lottoArr = new int[slots];
        int[] ticketArr = new int[slots];

        int randomNumber1 = 0;
        int randomNumber2 = 0;

        Random random = new Random();
        boolean isRepeated;

        for (int i = 0; i < slots; i++) {

            //Loto icin tekrarli giris kontrolü
            do {
                isRepeated = false;
                //0 ile deger arasinda rastgele sayi, deger dahil degil
                // randomNumber1=random.nextInt(10+1-5)+5; //--> 0,1,2,3,4,5 --> 5,6,7,8,9,10
                randomNumber1 = random.nextInt(max + 1 - min) + min;

                for (int j = 0; j < slots; j++) {
                    if (lottoArr[j] == randomNumber1) {
                        isRepeated = true;
                        break;
                    }
                }
            } while (isRepeated);
            lottoArr[i] = randomNumber1;


            //Bilet icin tekrarli giris kontrolü
            do {
                isRepeated = false;
                //0 ile deger arasinda rastgele sayi, deger dahil degil
                // randomNumber1=random.nextInt(10+1-5)+5; //--> 0,1,2,3,4,5 --> 5,6,7,8,9,10
                randomNumber2 = random.nextInt(max + 1 - min) + min;

                for (int j = 0; j < slots; j++) {
                    if (ticketArr[j] == randomNumber2) {
                        isRepeated = true;
                        break;
                    }
                }
            } while (isRepeated);
            ticketArr[i] = randomNumber2;
        }
        System.out.print("Benim biletim: ");
        for (int i = 0; i < ticketArr.length; i++) {
            System.out.print(ticketArr[i] + " ");
        }

        System.out.println();

        System.out.print("Loto sonucu: ");
        for (int i = 0; i < lottoArr.length; i++) {
            System.out.print(lottoArr[i] + " ");
        }

        System.out.println();

        int result = compareArr(lottoArr, ticketArr);
        if (result > 0) {
            System.out.println("Tebrikler! " + result + " eşleşme var.");
        } else {
            System.out.println("Malesef eşleşme yok, bir dahaki sefere:)");
        }

    }

    public static int compareArr(int[] arr, int[] brr) {

        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < brr.length; j++) {
                if (arr[i] == brr[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
