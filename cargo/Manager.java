import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Predicate;

public class Manager {
    private final PriorityQueue<Cargo> deliveryQueue = new PriorityQueue<>(
            Comparator.comparing(Cargo::isHasHighPriority).reversed()
    );
    private final List<Ship> ships = new ArrayList<>();
    private final List<Cargo> completedDeliveries = new ArrayList<>();
    private final List<Cargo> pendingDeliveries = new ArrayList<>();

    public void processDeliveries() {
        System.out.println("\n=== Starting Delivery Processing ===");
        int initialCount = deliveryQueue.size();

        while (!deliveryQueue.isEmpty()) {
            Cargo cargo = deliveryQueue.poll();
            boolean assigned = false;

            for (Ship ship : ships) {
                if (ship.loadCargo(cargo)) {
                    cargo.setCompleted(true);
                    completedDeliveries.add(cargo);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                System.out.printf("No ship available for cargo: %s%n", cargo);
                pendingDeliveries.add(cargo);
            }
        }

        System.out.printf("=== Processing Complete: %d deliveries processed, %d completed, %d pending ===%n",
                initialCount, completedDeliveries.size(), pendingDeliveries.size());
    }

    public List<Cargo> searchDeliveries(Predicate<Cargo> filter) {
        return getAllCargo().stream().filter(filter).toList();
    }

    public List<Cargo> getAllCargo() {
        List<Cargo> allCargo = new ArrayList<>(completedDeliveries);
        allCargo.addAll(new ArrayList<>(deliveryQueue));
        return allCargo;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
        System.out.printf("Added Ship %d [%s Priority, Capacity %.1f]%n",
                ship.getShipId(), ship.isHasHighPriority() ? "High" : "Low", ship.getCapacity());
    }

    public void addCargo(Cargo cargo) {
        deliveryQueue.offer(cargo);
        System.out.printf("Added Cargo: %s%n", cargo);
    }

    public PriorityQueue<Cargo> getDeliveryQueue() { return deliveryQueue; }
    public List<Ship> getShips() { return ships; }
    public List<Cargo> getCompletedDeliveries() { return completedDeliveries; }
}
