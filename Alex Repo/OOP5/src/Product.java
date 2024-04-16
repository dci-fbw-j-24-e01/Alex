public class Product {
    protected long productID;
    protected int price;

    public Product(int price, long productID) {
        this.productID = productID;
        this.price = price;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printProductDetails() {

        System.out.println("ID: " + productID + ";");

        if (this instanceof Movie movie) {
            System.out.println("Title: " + movie.getTitle() + ";");
            System.out.println("Genre: " + movie.getGenre() + ";");
            if (movie.getDirector() != null) {
                System.out.println("Director: " + movie.getDirector() + ";");
            }

        } else {
            Book book = (Book)this;
            System.out.println("Title: " + book.getTitle() + ";");
            System.out.println("Author: " + book.getAuthor() + ";");
        }
        System.out.println("Price: " + price + "€.");
        System.out.println();

    }
}
