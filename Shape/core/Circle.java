import Shape.core.ShapeInterface;
import Shape.core.SuperShape;

public class Circle extends SuperShape implements ShapeInterface {
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI* (radius * radius);
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double[] render() {
        return new double[] {radius};
    }
}
