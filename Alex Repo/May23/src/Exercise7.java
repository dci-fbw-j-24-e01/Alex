import java.util.ArrayList;
import java.util.List;

public class Exercise7 {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.8));
        shapes.add(new Rectangle(5.2, 8.1));

        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
    }
}
