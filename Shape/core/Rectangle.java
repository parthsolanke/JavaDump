import Shape.core.ShapeInterface;
import Shape.core.SuperShape;

public class Rectangle extends SuperShape implements ShapeInterface {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super();
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return (2 * length) + (2 * width);
    }

    public double[] render() {
        return new double[] {length, width};
    }
}
