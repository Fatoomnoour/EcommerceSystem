public class Product {
    String name;
    double price;
    int quantity;
    boolean expires;
    boolean requiresShipping;
    double weight; // in grams (only for shippable items)

    public Product(String name, double price, int quantity, boolean expires, boolean requiresShipping, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expires = expires;
        this.requiresShipping = requiresShipping;
        this.weight = weight;
    }

    public boolean isOutOfStock() {
        return quantity <= 0;
    }
}
