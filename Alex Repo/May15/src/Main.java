import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> myMovies = new ArrayList<>();

        myMovies.add(new Movie(1, "The Matrix", "Bros"));
        myMovies.add(new Movie(2, "The Incredibles", "Someone at Pixar"));
        myMovies.add(new Movie(3, "Pirates of the Caribbean", "What Inda said"));
        myMovies.add(new Movie(4, "Star Wars Episode IV: A new hope", "George Lucas"));

        List<Movie> sortedMovies = myMovies.stream()
                .filter(movie -> movie.getId() > 2)
                .sorted(Comparator.comparing(Movie::getTitle))
                .limit(2)
                .toList();

        System.out.println(myMovies);
        System.out.println(sortedMovies);

        myMovies.forEach(System.out::println);
    }
}
