public class InterstellarCargo {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.addShip(new Ship(100, true));
        manager.addShip(new Ship(200, false));
        manager.addShip(new Ship(150, true));
        manager.addShip(new Ship(250, false));

        manager.addCargo(new Cargo(1200, true, CargoType.ESSENTIAL));
        manager.addCargo(new Cargo(13, false, CargoType.ELECTRONICS));
        manager.addCargo(new Cargo(2, false, CargoType.ESSENTIAL));
        manager.addCargo(new Cargo(19, true, CargoType.ELECTRONICS));
        manager.addCargo(new Cargo(20, true, CargoType.FASHION));
        manager.addCargo(new Cargo(13, false, CargoType.FASHION));
        manager.addCargo(new Cargo(60, true, CargoType.ELECTRONICS));
        manager.addCargo(new Cargo(90, false, CargoType.ESSENTIAL));

        // Process deliveries
        manager.processDeliveries();

        // Summary search
        System.out.println("\n=== Search: Heavy Cargo (>50) ===");
        var heavyCargo = manager.searchDeliveries(c -> c.getWeight() > 50);
        heavyCargo.forEach(System.out::println);
    }
}
