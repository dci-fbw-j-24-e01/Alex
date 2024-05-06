import java.util.ArrayList;

public class Movie implements Product, Comparable<Movie> {
    MovieGenre genre;
    private String title;
    protected long productID;
    protected int price;

    public Movie(String title, MovieGenre genre, int price, long productID) throws IllegalArgumentException {
        this.price = price;
        if (productID < 0) {
            throw new IllegalArgumentException("productID is less than 0");
        }
        this.productID = productID;
        setTitle(title);
        setGenre(genre);
    }

    public long getProductID() {
        return productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    @Override
    public void printDetails() {
        System.out.println("ID: " + productID + ";");
        System.out.println("Title: " + getTitle() + ";");
        System.out.println("Genre: " + getGenre() + ";");
        System.out.println("Price: " + price + "€.");
        System.out.println();
    }

    public static Movie findMoviesByID(long id, ArrayList<Product> movies) {
        for (Product product : movies) {
            if (product instanceof Movie movie) {
                if (id == movie.getProductID()) return movie;
            }
        }
        return null;
    }

    @Override
    public int compareTo(Movie movie) {

        if(productID < movie.productID) {
            return -1;
        } else if (productID > movie.productID) {
            return 1;
        }
        return 0;
    }
}
