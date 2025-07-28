package core;

import java.util.List;

public class Robo {
    private Position position = new Position();
    private Direction direction  = new Direction();

    public void processInput(String input) {
        for (char command : input.toCharArray()) {
            if (command == 'L' || command == 'R') {
                direction.updateDirection(command);
            } else if (command == 'F' || command == 'B') {
                char head = direction.getHead();
                position.updatePosition(command, head);
            }
        }
    }

    public void showPosition() {
        List<Integer> coordinates = position.getPosition();
        int x = coordinates.get(0);
        int y = coordinates.get(1);
        char head = direction.getHead();
        System.out.println("The robot is at {X: " + x + " Y: " + y + "}, facing the " + head + " direction.");
    }
}
