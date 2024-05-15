import java.util.List;

public class AreaCalculator {
    List<Shape> shapeList;

    public AreaCalculator(List shapeList) {
        this.shapeList = shapeList;
    }

    public double sum() {
        double sum = 0;
        for (Shape shape: shapeList) {
            sum += shape.getArea();
        }
        return sum;
    }
}
