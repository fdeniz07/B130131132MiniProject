package biletfiyathesaplama;

/*
Project: mesafeye ve şartlara göre otobüs bileti fiyatı hesaplayan uygulama
         Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
         koltuk no  bilgilerini alın.
         Mesafe başına ücret 1 TL / km olarak alın.(Gidiş-Dönüş için *2)
         İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;

        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
       1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
       2-Yaş indirimi:
        Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
       3-Tekli Koltuk ücreti:
        Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 artırılır.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketReservation {

    public static void main(String[] args) {

        List<String> seatNo = new ArrayList<>();
        for (int i = 1; i < 33; i++) {
            seatNo.add(String.valueOf(i)); //["1","3","4"....]
        }

        Ticket ticket = new Ticket();
        Bus bus = new Bus("34 IST 34", seatNo);
        start(ticket, bus);
    }

    public static void start(Ticket ticket, Bus bus) {

        Scanner input = new Scanner(System.in);
        int select;

        do {
            System.out.println("Bilet Rezervasyon Sistemine Hosgeldiniz.");
            System.out.println("Gidilicek mesafeyi km olarak giriniz: ");

            ticket.distance = input.nextInt();

            System.out.println("Yolculuk tipini seciniz: ");
            System.out.println("1)Tek yön\n2)Gidis-Dönüs");

            ticket.typeNo = input.nextInt();

            System.out.println("Lütfen yasinizi girin: ");
            int age = input.nextInt();

            System.out.println("Koltuk no seciniz: ");
            System.out.println("(Tekli koltuk ücreti %20 daha fazladir.)");
            System.out.println(bus.seats);
            ticket.seatNo = input.nextInt();

            //kullanicinin sectigi koltugu listeden kaldir.
            bus.seats.remove(String.valueOf(ticket.seatNo));

            boolean check = ticket.typeNo == 1 || ticket.typeNo == 2;
            // boolean check = (ticket.typeNo==1 ||ticket.typeNo==2) && ticket.distance>0 && age>0;
            // if(check)

            if (ticket.distance > 0 && age > 0 && check) {
                ticket.price = getTotal(ticket, age);
                ticket.printTicket(bus);
            } else {
                System.out.println("Yeni islem icin 1, cikis icin 0 giriniz: ");
            }
            System.out.println("Yeni işlem için 1, çıkış için 0 giriniz:");
            select = input.nextInt();
        } while (select != 0);
        System.out.println("Iyi günler dileriz.");
    }

    public static double getTotal(Ticket ticket, int age) {
        int dist = ticket.distance;
        int type = ticket.typeNo;
        int seatNo = ticket.seatNo;
        double total = 0;

        switch (type) {
            case 1:
                if (seatNo % 3 == 0) {
                    total = dist * 1.2;
                } else {
                    total = dist;
                }
                System.out.println("Tutar : " + total);
                break;
            case 2:
                if (seatNo % 3 == 0) {
                    total = dist * 2.4;
                } else {
                    total = dist * 2;
                }
                System.out.println("Tutar : " + total);
                total = total * 0.8;
                System.out.println("Cift yön indirimli tutar: " + total);
                break;
        }
        if (age < 13) {
            total /= 2;
            System.out.println("Yas indirimli tutar = " + total);
        } else if (age > 12 && age < 24) {
            total = total * 0.9;
            System.out.println("Yas indirimli tutar = " + total);
        } else if (age > 65) {
            total = total * 0.7;
            System.out.println("Yas indirimli tutar = " + total);
        }
        return total;
    }
}
