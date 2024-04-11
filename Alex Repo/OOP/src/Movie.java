import java.util.HashMap;

public class Movie {
    MovieGenre genre;
    String director;
    private long productID;
    private String title;
    private int price;

    public Movie(String title, MovieGenre genre, int price, long productID) {
        setTitle(title);
        setGenre(genre);
        setPrice(price);
        setProductID(productID);
    }

    public Movie(String title, MovieGenre genre, int price, String director, long productID) {
        this(title, genre, price, productID);
        setDirector(director);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public void printMovieDetails() {
        System.out.println("ID: " + productID + ";");
        System.out.println("Title: " + title + ";");
        System.out.println("Genre: " + genre + ";");
        if (director != null) {
            System.out.println("Director: " + director + ";");
        }

        System.out.println("Price: " + price + "€.");
        System.out.println();
    }

    public static Movie findMoviesByID(long id, HashMap<Long, Movie> movies) {
        Movie movie;
        try {
            movie = movies.get(id);
        }
        catch (Exception e) {
            return null;
        }
        return movie;
    }
}
