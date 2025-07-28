package Shape.core;

public abstract class SuperShape implements ShapeInterface {
    private static int shapeCount;
    
    protected SuperShape() {
        shapeCount++;
    }

    public int getShapeCount() {
        return shapeCount;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract double[] render();
}
