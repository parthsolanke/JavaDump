import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Manager {
    private PriorityQueue<Cargo> deliveryQueue = new PriorityQueue<>(
            Comparator.comparing(Cargo::isHasHighPriority).reversed()
    );
    private List<Ship> ships = new ArrayList<>();
    private List<Cargo> completedDeliveries = new ArrayList<>();

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void addCargo(Cargo cargo) {
        deliveryQueue.offer(cargo);
    }

    public PriorityQueue<Cargo> getDeliveryQueue() {
        return deliveryQueue;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Cargo> getCompletedDeliveries() {
        return completedDeliveries;
    }
}