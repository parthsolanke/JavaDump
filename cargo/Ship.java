import java.util.ArrayList;
import java.util.List;

public class Ship {
    private float capWeight;
    private boolean available;
    private boolean hasHighPriority;
    private List<Cargo> deliveries = new ArrayList<>();

    public Ship(float capacity, boolean hasHighPriority) {
        this.capWeight = capacity;
        this.available = true;
        this.hasHighPriority = hasHighPriority;
    }

    public float getCapacity() { return capWeight; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public boolean loadCargo(Cargo cargo) {
        int totalWeight = deliveries.stream().mapToInt(c -> (int) c.getWeight()).sum();
        if (totalWeight + cargo.getWeight() <= capWeight && available) {
            deliveries.add(cargo);
            return true;
        }
        return false;
    }

    public boolean isHasHighPriority() {
        return hasHighPriority;
    }

    public List<Cargo> getDeliveries() { return deliveries; }

}