public class Rectangle implements Shape {
    int x;
    int y;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getArea() {
        return 1.0 * x * y;
    }
}
