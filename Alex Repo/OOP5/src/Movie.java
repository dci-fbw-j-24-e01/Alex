import java.util.ArrayList;
import java.util.HashMap;


public class Movie extends Product {
    MovieGenre genre;
    String director;
    private String title;

    public Movie(String title, MovieGenre genre, int price, long productID) {
        super(price, productID);
        setTitle(title);
        setGenre(genre);
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

    public static Movie findMoviesByID(long id, HashMap<Long, Product> movies) {
        if (id > 2000000) return (Movie)movies.get(id);
        return null;
    }
}
