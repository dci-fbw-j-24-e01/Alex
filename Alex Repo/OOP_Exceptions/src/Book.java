public class Book implements Product {
    protected String author;
    protected String title;
    protected long productID;
    protected int price;

    public Book(String title, String author, int price, long productID) throws IncorrectProductIdException {
        this.price = price;
        if (productID < 0) {
            throw new IncorrectProductIdException(productID);
        }
        this.productID = productID;
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
