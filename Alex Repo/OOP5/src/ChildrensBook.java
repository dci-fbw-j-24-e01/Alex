public class ChildrensBook extends Book {
    private String recommendedAgeInfo;

    public ChildrensBook(String title, String author, int price, String recommendedAgeInfo, long id) {
        super(title, author, price, id);
        this.recommendedAgeInfo = recommendedAgeInfo;
    }

    public String getRecommendedAgeInfo() {
        return recommendedAgeInfo;
    }

    public void setRecommendedAgeInfo(String recommendedAgeInfo) {
        this.recommendedAgeInfo = recommendedAgeInfo;
    }

    public void printDetails() {
        System.out.println("ID: " + productID + ";");
        System.out.println("Title: " + getTitle() + ";");
        System.out.println("Author: " + getAuthor() + ";");
        System.out.println("Price: " + price + "€.");
        System.out.println(recommendedAgeInfo);
        System.out.println();
    }



}


