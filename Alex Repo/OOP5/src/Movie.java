import java.util.HashMap;


public class Movie extends Product {
    MovieGenre genre;
    private String title;

    public Movie(String title, MovieGenre genre, int price, long productID) {
        super(price, productID);
        setTitle(title);
        setGenre(genre);
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

    public static Movie findMoviesByID(long id, HashMap<Long, Product> movies) {
        if (id > 2000000) return (Movie) movies.get(id);
        return null;
    }
}
