public class Main {
    public static void main(String[] args) {
        try {
            // Create Products
            Product cheese = new Product("Cheese", 200, 5, true, true, 400);
            Product tv = new Product("TV", 2000, 3, false, true, 5000);
            Product biscuits = new Product("Biscuits", 150, 10, true, true, 700);
            Product mobile = new Product("Mobile", 5000, 2, false, false, 0);
            Product scratchCard = new Product("Scratch Card", 100, 20, false, false, 0);

            // Create Customer
            Customer customer = new Customer(5000); // Customer has 5000 balance

            // Create Cart and add Products
            Cart cart = new Cart();
            cart.add(cheese, 2); // Adding 2 Cheese
            cart.add(tv, 3); // Adding 3 TV
            cart.add(scratchCard, 1); // Adding 1 Scratch Card

            // Checkout process
            cart.checkout(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
