public class MovieWithDirector extends Movie {
    String director;

    public MovieWithDirector(String title, MovieGenre genre, int price, String director, long productID) {
        super(title, genre, price, productID);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void printDetails() {
        System.out.println("ID: " + productID + ";");
        System.out.println("Title: " + getTitle() + ";");
        System.out.println("Director: " + director + ";");
        System.out.println("Genre: " + getGenre() + ";");
        System.out.println("Price: " + price + "€.");
        System.out.println();
    }
}
