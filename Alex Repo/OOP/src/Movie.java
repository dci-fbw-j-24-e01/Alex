public class Movie extends Goods {
    MovieGenre genre;
    String director;

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

    public Movie(String title, MovieGenre genre, int price) {
        setTitle(title);
        this.genre = genre;
        setPrice(price);
    }

    public Movie(String title, MovieGenre genre, int price, String director) {
        this(title, genre, price);
        this.director = director;
    }
}
