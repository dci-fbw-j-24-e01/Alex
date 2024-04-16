import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) {

        HashMap<Long, Product> products = new HashMap<>();

        products.put(1000001L, new Book("World War Two", "Winston Churchill", 40, 1000001));
        products.put(1000002L, new Book("War and Peace", "Lev Tolstoy", 80, 1000002));
        products.put(1000003L, new ChildrensBook("Grimms' Fairy Tales", "The Brothers Grimm", 100, "From 6 years", 1000003));

        products.put(2000001L, new Movie("Police Academy", MovieGenre.COMEDY, 10, 1000004));
        products.put(2000002L, new Movie("Terminator", MovieGenre.ACTION, 20, 1000005));
        products.put(2000003L, new MovieWithDirector("Oppenheimer", MovieGenre.DRAMA, 35, "Christopher Nolan", 1000006));

        for (Product product : products.values()) {
            product.printDetails();
        }


        long id = 2000002;
        Movie search = Movie.findMoviesByID(id, products);
        if (search == null) {
            System.out.println("Didn't find a movie with productId: " + id + ".");
        } else {
            System.out.println("Found this movie: ");
            search.printDetails();
        }

        id = 20000004;
        search = Movie.findMoviesByID(id, products);
        if (search == null) {
            System.out.println("Didn't find a movie with productId: " + id + ".");
        } else {
            System.out.println("Found this movie: ");
            search.printDetails();
        }

        System.out.println("\n" + products.get(1000002L));
    }
}
