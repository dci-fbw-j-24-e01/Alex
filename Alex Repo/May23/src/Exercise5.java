public class Exercise5 {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setAuthor("J. R. R. Tolkien");
        book1.setTitle("Lord of the Rings");
        book1.setPrice(49.95);

        Book book2 = new Book();
        book2.setAuthor("J. K. Rowling");
        book2.setTitle("Harry Potter und der Stein der Weisen");
        book2.setPrice(34.95);

        Book book3 = new Book();
        book3.setAuthor("J. Orwell");
        book3.setTitle("Animal Farm");
        book3.setPrice(28.95);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
    }
}
