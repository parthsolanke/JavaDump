package core;

import java.util.Arrays;
import java.util.List;

public class Position {
    private int x = 0;
    private int y = 0;
    
    public void updatePosition(char command, char head) {
        int step = (command == 'F') ? 1 : -1;
        switch(head) {
            case 'N' : this.y += step; break;
            case 'S' : this.y -= step; break;
            case 'E' : this.x += step; break;
            case 'W' : this.x -= step; break;
        } 
    }

    public List<Integer> getPosition() {
        return Arrays.asList(this.x, this.y);
    }
}
