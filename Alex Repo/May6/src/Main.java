import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(2, 4));
        shapes.add(new Square(3));
        shapes.add(new Square(4));
        shapes.add(new Rectangle(2, 6));
        shapes.add(new Circle(3));
        shapes.add(new Circle(4));

        List<Shape> rectangles = new ArrayList<>();
        for (Shape shape: shapes) {
            if (!(shape instanceof Circle)) {
                rectangles.add(shape);
            }
        }

        System.out.println(new AreaCalculator(shapes).sum());
        System.out.println(new AreaCalculator(rectangles).sum());

    }

}
