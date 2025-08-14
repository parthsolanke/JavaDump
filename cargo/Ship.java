import java.util.ArrayList;
import java.util.List;

public class Ship {
    private static int idCounter = 1;
    private final int shipId;
    private final float capWeight;
    private boolean available;
    private final boolean hasHighPriority;
    private final List<Cargo> deliveries = new ArrayList<>();

    public Ship(float capacity, boolean hasHighPriority) {
        this.capWeight = capacity;
        this.available = true;
        this.hasHighPriority = hasHighPriority;
        this.shipId = idCounter++;
    }

    public int getShipId() { return shipId; }
    public float getCapacity() { return capWeight; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public float getTotalWeight() {
        return (float) deliveries.stream().mapToDouble(Cargo::getWeight).sum();
    }

    public boolean canAccept(Cargo cargo) {
        if (!available) return false;
        if (cargo.isHasHighPriority() != isHasHighPriority()) return false;
        return getTotalWeight() + cargo.getWeight() <= capWeight;
    }

    public void checkIfFull() {
        if (getTotalWeight() >= capWeight) {
            available = false;
            System.out.printf("Ship %d is now FULL (%.1f/%.1f)%n", shipId, getTotalWeight(), capWeight);
        }
    }

    public boolean loadCargo(Cargo cargo) {
        if (!canAccept(cargo)) return false;
        deliveries.add(cargo);
        System.out.printf("Cargo %s assigned to Ship %d (%.1f/%.1f)%n",
                cargo.getDescription(), shipId, getTotalWeight(), capWeight);
        checkIfFull();
        return true;
    }

    public boolean isHasHighPriority() {
        return hasHighPriority;
    }

    public List<Cargo> getDeliveries() { return deliveries; }
}
