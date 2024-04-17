import java.util.ArrayList;
import java.util.Collections;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();

        products.add(new Book("World War Two", "Winston Churchill", 40, 1000001));
        products.add(new Book("War and Peace", "Lev Tolstoy", 80, 1000002));
        products.add(new ChildrensBook("Grimms' Fairy Tales", "The Brothers Grimm", 100, "From 6 years", 1000003));

        movies.add(new Movie("Police Academy", MovieGenre.COMEDY, 10, 1000006));
        movies.add(new Movie("Terminator", MovieGenre.ACTION, 20, 1000005));
        movies.add(new MovieWithDirector("Oppenheimer", MovieGenre.DRAMA, 35, "Christopher Nolan", 1000004));

        products.addAll(movies);
        Collections.sort(movies);

        for (Movie movie : movies) {
            System.out.println(movie.getProductID());
        }
        for (Product product : products) {
            product.printDetails();
        }

        long id = 1000002;
        Movie search = Movie.findMoviesByID(id, products);
        if (search == null) {
            System.out.println("Didn't find a movie with productId: " + id + ".");
        } else {
            System.out.println("Found this movie: ");
            search.printDetails();
        }

        id = 1000004;
        search = Movie.findMoviesByID(id, products);
        if (search == null) {
            System.out.println("Didn't find a movie with productId: " + id + ".");
        } else {
            System.out.println("Found this movie: ");
            search.printDetails();
        }

        System.out.println(products.get(1));
    }
}
