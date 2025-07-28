import Shape.core.ShapeInterface;

public class Square extends Rectangle implements ShapeInterface{
    private double side;

    public Square(double side) {
        super(side, side);
    }
}
