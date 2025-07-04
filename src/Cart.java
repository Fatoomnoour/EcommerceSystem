import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();
    private List<Product> shippableItems = new ArrayList<>();

    public void add(Product product, int quantity) throws Exception {
        if (quantity > product.quantity) {
            throw new Exception("Not enough stock for " + product.name);
        }
        if (product.isOutOfStock()) {
            throw new Exception("Product " + product.name + " is out of stock.");
        }
        if (product.expires && quantity > product.quantity) {
            throw new Exception("Product " + product.name + " has expired.");
        }

        product.quantity -= quantity;
        products.add(product);
        if (product.requiresShipping) {
            shippableItems.add(product);
        }
    }

    public void checkout(Customer customer) throws Exception {
        if (products.isEmpty()) {
            throw new Exception("Cart is empty.");
        }

        double subtotal = 0;
        double shippingFees = 0;
        for (Product product : products) {
            subtotal += product.price;
            if (product.requiresShipping) {
                shippingFees += calculateShippingFee(product);
            }
        }

        double totalAmount = subtotal + shippingFees;

        if (customer.getBalance() < totalAmount) {
            throw new Exception("Insufficient balance.");
        }

        customer.deductBalance(totalAmount);

        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Product product : shippableItems) {
            System.out.println("1x " + product.name + " " + product.weight + "g");
            totalWeight += product.weight;
        }
        System.out.println("Total package weight " + totalWeight / 1000 + "kg");

        System.out.println("** Checkout receipt **");
        for (Product product : products) {
            System.out.println("1x " + product.name + " " + product.price);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFees);
        System.out.println("Amount " + totalAmount);
        System.out.println("Customer balance after payment: " + customer.getBalance());
    }

    private double calculateShippingFee(Product product) {
        return product.weight * 0.1; // For simplicity, assume shipping is calculated per gram
    }
}
