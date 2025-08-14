public class InterstellarCargo {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.addShip(new Ship(100, true));
        manager.addShip(new Ship(200, false));

        manager.addCargo(new Cargo(12, true, CargoType.ESSENTIAL));
        manager.addCargo(new Cargo(13, false, CargoType.ELECTRONICS));
        manager.addCargo(new Cargo(2, false, CargoType.ESSENTIAL));
        manager.addCargo(new Cargo(19, true, CargoType.ELECTRONICS));
        manager.addCargo(new Cargo(20, true, CargoType.FASHION));
        manager.addCargo(new Cargo(13, false, CargoType.FASHION));

        // queued deliveries
        System.out.println(manager.getDeliveryQueue().stream().toList());

        // process deliveries

        // search cargo
}
}