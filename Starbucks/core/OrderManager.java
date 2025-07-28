package core;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orderList = new ArrayList<>();

    public boolean placeOrder(Order order) {
        for (Order existingOrder: orderList) {
            if(existingOrder.getId() == order.getId()) {
                System.out.println("Order has alredy been placed");
                return false;
            }
        }

        orderList.add(order);
        return true;
    }

    public double getTotalRevenue() {
        double total = 0;
        for(Order order: orderList) {
            total += order.getOrderItem().getPrice();
        }
        return total;
    }

    public double getAvgOrerVlalue() {
        double total = this.getTotalRevenue();

        if (orderList.isEmpty()) return 0.0;
        return (total / orderList.size());
    }

    public int getTotalTypeItemsSold(Type type) {
        int ct = 0;
        for (Order order: orderList) {
            if (order.getOrderItem().getType() == type) {
                ct += 1;
            }
        }

        return ct;
    }

    public Type getMostPopularCategory() {
        int vegItems = getTotalTypeItemsSold(Type.VEG);
        int nonVegItems = getTotalTypeItemsSold(Type.NON_VEG);
        int beverageItems = getTotalTypeItemsSold(Type.BEVRAGE);

        if (vegItems >= nonVegItems && vegItems >= beverageItems) {
            return Type.VEG;
        } else if (nonVegItems >= beverageItems) {
            return Type.NON_VEG;
        } else {
            return Type.BEVRAGE;
        }
    }

}