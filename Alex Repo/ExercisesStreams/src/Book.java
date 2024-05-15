public class Book {
    private final String ISBN;
    private final String TITLE;
    private final String AUTHOR;
    private final Category CATEGORY;

    public Book(String ISBN, String TITLE, String AUTHOR, Category CATEGORY) {
        this.ISBN = ISBN;
        this.TITLE = TITLE;
        this.AUTHOR = AUTHOR;
        this.CATEGORY = CATEGORY;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getAUTHOR() {
        return AUTHOR;
    }

    public Category getCATEGORY() {
        return CATEGORY;
    }
}
