package core;

public class Order {
    private long id;
    private MenuItem orderItem;
    
    public Order(long id, MenuItem orderItem) {
        this.id = id;
        this.orderItem = orderItem;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MenuItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(MenuItem orderItem) {
        this.orderItem = orderItem;
    }
}