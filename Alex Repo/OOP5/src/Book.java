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


    @Override
    public String toString() {
        return "Title: " + title + "; Author: " + author;
    }

    @Override
    public void printDetails() {
        System.out.println("ID: " + productID + ";");
        System.out.println("Title: " + getTitle() + ";");
        System.out.println("Author: " + getAuthor() + ";");
        System.out.println("Price: " + price + "€.");
        System.out.println();
    }
}
