public class Book extends Goods {
    String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String title, String author, int price) {
        setTitle(title);
        this.author = author;
        setPrice(price);
    }
}
