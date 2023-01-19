package companymanagementsystem.entities.concretes;

import companymanagementsystem.entities.abstracts.Order;
import restaurantBillGenerator.Dish;

public class RestaurantOrder extends Order {


    public RestaurantOrder(Dish dish, int numOfDish) {
        super(dish, numOfDish);
    }
}
