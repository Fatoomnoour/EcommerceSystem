public class ProductTest {
    public static void main(String[] args) {
        Product product = new Product("Book", 10, 2, false, false, 0);
        if (product.isOutOfStock()) throw new AssertionError("Product should be in stock");
        product.quantity = 0;
        if (!product.isOutOfStock()) throw new AssertionError("Product should be out of stock");
        System.out.println("ProductTest passed");
    }
}
