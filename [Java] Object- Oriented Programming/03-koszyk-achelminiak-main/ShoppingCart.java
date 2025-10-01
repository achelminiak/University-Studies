import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        sortProductsByPrice();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        sortProductsByPrice();
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateOrderValue() {
        double total = 0;
        for (Product product : products) {
            total += product.getDiscountPrice();
        }
        return total;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void sortProductsByPrice() {
        products.sort(Comparator.comparing(Product::getPrice).reversed()
                .thenComparing(Product::getName));
    }

    public void sortProductsByName() {
        products.sort(Comparator.comparing(Product::getName)
                .thenComparing(Product::getPrice).reversed());
    }

    public void applyPromotions() {
        applyFivePercentDiscount();
        applyThirdProductFree();
        applyFreeMug();
    }

    private void applyFivePercentDiscount() {
        if (calculateOrderValue() > 300) {
            for (Product product : products) {
                product.setDiscountPrice(product.getPrice() * 0.95);
            }
        }
    }

    private void applyThirdProductFree() {
        if (products.size() >= 3) {
            products.sort(Comparator.comparing(Product::getPrice));
            Product thirdCheapest = products.get(2);
            thirdCheapest.setDiscountPrice(0.0);
            sortProductsByPrice();
        }
    }

    private void applyFreeMug() {
        if (calculateOrderValue() > 200) {
            products.add(new Product("MUG", "Firmowy Kubek", 0));
            sortProductsByPrice();
        }
    }

    public void displayCart() {
        for (Product product : products) {
            System.out.printf("Code: %s, Name: %s, Price: %.2f, Discount Price: %.2f%n",
                    product.getCode(), product.getName(), product.getPrice(), product.getDiscountPrice());
        }
    }

    public Optional<Product> findCheapestProduct() {
        return products.stream().min(Comparator.comparing(Product::getPrice));
    }

    public Optional<Product> findMostExpensiveProduct() {
        return products.stream().max(Comparator.comparing(Product::getPrice));
    }

    public List<Product> findNMostExpensiveProducts(int n) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Product> findNCheapestProducts(int n) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(n)
                .collect(Collectors.toList());
    }
}