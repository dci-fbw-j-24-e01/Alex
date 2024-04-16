public class Book extends Product {
    String author;
    private String title;

    public Book(String title, String author, int price, long id) {
        super(price, id);
        setTitle(title);
        setAuthor(author);
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

    public void printBookDetails() {
        System.out.println("Title: " + title + ";");
        System.out.println("Author: " + author + ";");
        System.out.println("Price: " + price + "€.");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Title: " + title + "; Author: " + author;
    }
}
