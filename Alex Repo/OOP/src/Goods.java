public class Goods {
    private String title;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void printGoodsData() {
        System.out.println("Title: " + title + ";");
        if (this instanceof Book book) {
            System.out.println("Author: " + book.author + ";");
        } else {
            Movie movie = (Movie) this;
            System.out.println("Genre: " + movie.genre + ";");
            if (movie.director != null) {
                System.out.println("Director: " + movie.director + ";");
            }
        }
        System.out.println("Price: " + price + "€.");
        System.out.println();
    }
}
