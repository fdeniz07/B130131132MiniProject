package biletFiyatHesaplama;

public class Ticket {

    public int distance;

    public int typeNo;

    public int seatNo;

    public double price;

    public void printTicket(Bus bus) {
        System.out.println("Toplam tutar: " + price);
        System.out.println("---Bilet Detay---");
        System.out.println("Otobüs Plaka : " + bus.numberPlate);
        System.out.println("Mesafe : " + distance);
        System.out.println("Yolculuk tipi : " + (typeNo == 1 ? "Tek Yön" : "Gidis-Dönüs"));
        System.out.println("Keyifli yolculuklar dileriz...");
    }
}
