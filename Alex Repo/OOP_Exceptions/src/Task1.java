import java.util.ArrayList;
import java.util.Collections;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        Book book1 = null, book2 = null, book3 = null;
        try {
            book1 = new Book("World War Two", "Winston Churchill", 40, -1000001);
            book2 = new Book("War and Peace", "Lev Tolstoy", 80, 1000002);
            book3 = new ChildrensBook("Grimms' Fairy Tales", "The Brothers Grimm", 100, "From 6 years", 1000003);
        } catch (IncorrectProductIdException e) {
            System.out.println(e.getMessage());
        }
        products.add(book1);
        products.add(book2);
        products.add(book3);

        Movie movie1 = null, movie2 = null, movie3 = null;
        try {
            movie1 = new Movie("Police Academy", MovieGenre.COMEDY, 10, -1000006);
            movie2 = new Movie("Terminator", MovieGenre.ACTION, 20, 1000005);
            movie3 = new MovieWithDirector("Oppenheimer", MovieGenre.DRAMA, 35, "Christopher Nolan", 1000004);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        products.addAll(movies);

        for (int i = movies.size() - 1; i >= 0; i--) {
            if (movies.get(i) == null) {
                movies.remove(i);
            }
        }
        Collections.sort(movies);

        for (Movie movie : movies) {
            System.out.println(movie.getProductID());
        }

        for (int i = products.size() - 1; i >= 0; i--) {
            if (products.get(i) == null) {
                products.remove(i);
            }
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

    }
}
