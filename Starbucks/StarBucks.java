import core.Type;
import core.Dashboard;
import core.Menu;
import core.MenuItem;
import core.Order;
import core.OrderManager;

public class StarBucks {
    public static void main(String[] args) {
        // Create OrderManager
        OrderManager orderManager = new OrderManager();

        // // Show menu
        // System.out.println("====================== MENU =======================");
        // for (MenuItem item : Menu.getMenu()) {
        //     System.out.printf("🍽️  %-10s | %-10s | ₹%.2f\n", 
        //         item.getName(), 
        //         item.getType(), 
        //         item.getPrice());
        // }
        // System.out.println("===================================================");

        // Simulate placing orders
        orderManager.placeOrder(new Order(101, new MenuItem("burger", Type.NON_VEG, 180.0)));
        orderManager.placeOrder(new Order(102, new MenuItem("pizza", Type.VEG, 220.0)));
        orderManager.placeOrder(new Order(103, new MenuItem("coffe", Type.BEVRAGE, 95.5)));
        orderManager.placeOrder(new Order(104, new MenuItem("pasta", Type.VEG, 210.0)));
        orderManager.placeOrder(new Order(105, new MenuItem("burger", Type.NON_VEG, 180.0)));
        orderManager.placeOrder(new Order(106, new MenuItem("pizza", Type.VEG, 220.0)));

        // Trying to place a duplicate order (should be rejected)
        orderManager.placeOrder(new Order(101, new MenuItem("burger", Type.NON_VEG, 180.0)));

        // Show dashboard
        Dashboard dashboard = new Dashboard(orderManager);
        dashboard.printDashboard();
    }
}