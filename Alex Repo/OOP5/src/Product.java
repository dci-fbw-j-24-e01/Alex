public abstract      class Product {
    protected long productID;
    protected int price;

    public Product(int price, long productID) {
        this.productID = productID;
        this.price = price;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void printDetails();
}
