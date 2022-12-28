/*
Proje: Spor kursu için seçilecek öğrencileri belirleyen
       bir uygulama yazınız.

       kurs gereklilikleri:
            erkekler: boy: 1.60 ve üstü
                      kilo:70-90 kg
            kızlar:   boy: 1.50 ve üstü
                      kilo:50-70 kg

       kullanıcıdan öğrenci sayısı ve herbir öğrenci
       için isim , cinsiyet, kilo ve boy bilgilerini girmesini
       isteyiniz.
 */


import java.util.Scanner;

public class SelectStudent {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Merhaba, lütfen formu doldurunuz");

        System.out.print("Ögrenci sayisini giriniz: ");
        int numStd = scan.nextInt();

        String[] students = new String[numStd];
        String[] gender = new String[numStd];
        double[] heigt = new double[numStd];
        double[] weight = new double[numStd];
        boolean isSuccess = true;
        do {
            for (int i = 0; i < numStd; i++) {
                System.out.print("Isim: ");
                students[i] = scan.next();

                System.out.print("Cinsiyet: ");
                String gen = scan.next().toUpperCase().substring(0, 1);
                if (gen.equals("K") || gen.equals("E")) {
                    gender[i] = gen;
                } else {
                    System.out.println("Hatali giris!");
                    isSuccess = false;
                    break;
                }

                System.out.print("Boy: ");
                heigt[i] = scan.nextDouble();

                System.out.print("Kilo: ");
                weight[i] = scan.nextDouble();
            }
        } while (!isSuccess);
        int counter =0;
        System.out.println("***** Kursa secilen ögrenciler *****");


        for (int i = 0; i < numStd; i++) {
            boolean chkW = gender[i].equals("K") && weight[i] >= 50 && weight[i] <= 70 && heigt[i] >= 1.50;
            boolean chkM = gender[i].equals("E") && weight[i] >= 70 && weight[i] <= 90 && heigt[i] >= 1.60;

            String message = "Isim: " + students[i] + " cinsiyet: " + gender[i] + " boy: " + heigt[i] + " kilo: " + weight[i];

            if (chkW) {
                System.out.println(message);
                counter++;
            } else if (chkM) {
                System.out.println(message);
                counter++;
            }
        }
        //kursa secilen ögrenci yoksa
        if (counter==0){
            System.out.println("Malesef kurs gereksinimlerini sağlayan öğrenci bulunamadı.");
        }
    }

}
