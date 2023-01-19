package companymanagementsystem.entities.concretes;


import companymanagementsystem.entities.abstracts.Order;
import restaurantBillGenerator.Dish;

public class CafeOrder extends Order {

    public CafeOrder(Dish dish, int numOfDish) {
        super(dish, numOfDish);
    }
}
