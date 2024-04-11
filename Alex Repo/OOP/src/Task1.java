import java.util.ArrayList;
import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("World War Two", "Winston Churchill", 40));
        books.add(new Book("War and Peace", "Lev Tolstoy", 80));

        HashMap<Long, Movie> movieMap = new HashMap<>();

        long id = 100000654987L;
        movieMap.put(id, new Movie("Police Academy", MovieGenre.COMEDY, 10, id));

        id = 100000321654L;
        movieMap.put(id, new Movie("Terminator", MovieGenre.ACTION, 20, id));

        id = 100000987654L;
        movieMap.put(id, new Movie("Oppenheimer", MovieGenre.DRAMA, 35, "Christopher Nolan", id));

        for (Book book : books) {
            book.printBookDetails();
        }

        for (Movie movie : movieMap.values()) {
            movie.printMovieDetails();
        }

        id = 100000321654L;
        Movie search = Movie.findMoviesByID(id, movieMap);
        if (search == null) {
            System.out.println("Didn't find a movie with productId: " + id + ".");
        } else {
            System.out.println("Found this movie: ");
            search.printMovieDetails();
        }

        id = 1100000321654L;
        search = Movie.findMoviesByID(id, movieMap);
        if (search == null) {
            System.out.println("Didn't find a movie with productId: " + id + ".");
        } else {
            System.out.println("Found this movie: ");
            search.printMovieDetails();
        }
    }
}
