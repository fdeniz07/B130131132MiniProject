package restaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    Scanner input = new Scanner(System.in);

    List<Order> orderList = new ArrayList<>();

    public void createOrder(DishService dishService) {

        int dishCode = -1;

        while (dishCode != 0) { // Tekrar tekrar siparis verebilmesi icin döngüye sokuyoruz

            System.out.println("Lütfen ürün kodu giriniz: (CIKIS:0)"); //100, //500
            dishCode = input.nextInt();

            Dish dish = dishService.findDishByCode(dishCode); //100,Adana kebabi,220 //bulamazsa 0,"",0

            if (dish.getCode() > 0) { //Bu ürün kodu gecerliyse
                System.out.println("Adet giriniz: ");
                int num = input.nextInt(); //2 adet
                Order order = new Order(dish, num); //yemek ve adet veriyoruz
                order.setPrice();//ücreti hesapla ve orderPrice field'ina ata. //440
                order.setOrderCode(1000 + this.orderList.size()); //1000,1001
                this.orderList.add(order);
            }else{
                System.out.println("Lütfen gecerli bir adet giriniz!");
            }
            for (Order order : this.orderList) {
                System.out.printf("Siparis kodu: %-5s   lezzet kodu: %-3s adi: %-20s adet: %-3s\n", order.orderCode, order.dish.getCode(), order.dish.getName(), order.numOfDish);
            }

        }

    }

    public void deleteOrder() {

        boolean isValid = true;

        if (this.orderList.isEmpty()) {
            System.out.println("Siparisiniz bulunmamaktadir.");
        } else {
            System.out.println("Iptal etmek istediginiz siparisin kodunu giriniz:");
            int code = input.nextInt();//1000
            for (Order siparis : this.orderList) {
                if (siparis.orderCode == code) {
                    this.orderList.remove(siparis);
                    System.out.println("Siparisiniz iptal edildi " + siparis.orderCode + " " + siparis.dish.toString());
                    isValid = true;
                    break;
                } else {
                    isValid = false;
                }
            }
            if (!isValid) {
                System.out.println("Hatali bir siparis kodu girdiniz");
            }

        }
    }

    public void printBill() {

        double totalPrice = 0.0;

        System.out.println("           Lezzet Fisiniz                ");

        for (Order order : this.orderList) {
            System.out.printf("Lezzet kodu:%-5s adi:%-20s adet:%-5s siparis tutari:%-5s Lira\n", order.dish.getCode(), order.dish.getName(), order.numOfDish, order.orderPrice);
            totalPrice += order.orderPrice;
        }
        System.out.println("Toplam tutar: " + totalPrice + " Lira");
        System.out.println("Afiyet olsun...");
        this.orderList = new ArrayList<>();
    }


}
















