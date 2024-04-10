public class Task1 {
    public static void main(String[] args) {
        Book warAndPeace = new Book("War and Peace", "Lev Tolstoy", 80);
        /* warAndPeace.setTitle("War and Peace");
        warAndPeace.setAuthor("Lev Tolstoy");
        warAndPeace.setPrice(80);*/

        Book ww2 = new Book("World War Two", "Winston Churchill", 40);
        /* ww2.setTitle("World War Two");
        ww2.setAuthor("Winston Churchill");
        ww2.setPrice(40);*/

        Movie policeAcademy = new Movie("Police Academy", MovieGenre.COMEDY, 10);
        /* policeAcademy.setTitle("Police Academy");
        policeAcademy.setGenre(MovieGenre.COMEDY);
        policeAcademy.setPrice(10);*/

        Movie terminator = new Movie("Terminator", MovieGenre.ACTION, 20);
        /* terminator.setTitle("Terminator");
        terminator.setGenre(MovieGenre.ACTION);
        terminator.setPrice(20);*/

        Movie oppenheimer = new Movie("Oppenheimer", MovieGenre.DRAMA, 35, "Christopher Nolan");

        warAndPeace.printGoodsData();
        ww2.printGoodsData();

        policeAcademy.printGoodsData();
        terminator.printGoodsData();

        Goods[] goods = new Goods[5];
        goods[0] = warAndPeace;
        goods[1] = ww2;
        goods[2] = policeAcademy;
        goods[3] = terminator;
        goods[4] = oppenheimer;

        for (Goods good : goods) {
            good.printGoodsData();
        }


        /*printGoodsData(ww2);
        printGoodsData(warAndPeace);

        printGoodsData(policeAcademy);
        printGoodsData(terminator);

        Goods[] goods = new Goods[4];
        goods[0] = warAndPeace;
        goods[1] = ww2;
        goods[2] = policeAcademy;
        goods[3] = terminator;

        for (Goods good : goods) {
            printGoodsData(good);
        }
    }

    private static void printGoodsData(Goods product) {
        System.out.println("Title: " + product.title + ";");
        if (product instanceof Book) {
            Book book = (Book) product;
            System.out.println("Author: " + book.author + ";");
        }
        else {
            Movie movie = (Movie) product;
            System.out.println("Genre: " + movie.genre + ";");

        }
        System.out.println("Price: " + product.price + "€.");
        System.out.println();*/
    }
}
