public class Book {
    String author;
    private String title;
    private int price;

    public Book(String title, String author, int price) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printBookDetails() {
        System.out.println("Title: " + title + ";");
        System.out.println("Author: " + author + ";");
        System.out.println("Price: " + price + "€.");
        System.out.println();
    }
}
