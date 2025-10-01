import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ShoppingCartTest {
    private ShoppingCart cart;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;

    @Before
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("P1", "Product 1", 100);
        product2 = new Product("P2", "Product 2", 150);
        product3 = new Product("P3", "Product 3", 50);
        product4 = new Product("P4", "Product 4", 200);
        product5 = new Product("P5", "Product 5", 10);
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1);
        Assert.assertEquals(1, cart.getProducts().size());
        Assert.assertTrue(cart.getProducts().contains(product1));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.removeProduct(product1);
        Assert.assertEquals(1, cart.getProducts().size());
        Assert.assertFalse(cart.getProducts().contains(product1));
        Assert.assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testCalculateOrderValue() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        Assert.assertEquals(300.0, cart.calculateOrderValue(), 0.001);
    }

    @Test
    public void testSortProductsByPrice() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.sortProductsByPrice();
        Assert.assertEquals(product2, cart.getProducts().get(0)); // Product 2 - cena 150
        Assert.assertEquals(product1, cart.getProducts().get(1)); // Product 1 - cena 100
        Assert.assertEquals(product3, cart.getProducts().get(2)); // Product 3 - cena 50
    }

    @Test
    public void testSortProductsByName() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.sortProductsByName();
        Assert.assertEquals(product1, cart.getProducts().get(0)); // Product 1 - name "Product 1"
        Assert.assertEquals(product2, cart.getProducts().get(1)); // Product 2 - name "Product 2"
        Assert.assertEquals(product3, cart.getProducts().get(2)); // Product 3 - name "Product 3"
    }

    @Test
    public void testApplyFivePercentDiscount() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.applyPromotions();
        Assert.assertEquals(95.0, product1.getDiscountPrice(), 0.001); // 5% zniżki na Product 1 (100 * 0.95 = 95)
        Assert.assertEquals(142.5, product2.getDiscountPrice(), 0.001); // 5% zniżki na Product 2 (150 * 0.95 = 142.5)
        Assert.assertEquals(50.0, product3.getDiscountPrice(), 0.001); // Cena Product 3 bez zmian
    }

    @Test
    public void testApplyThirdProductFree() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.applyPromotions();
        Assert.assertEquals(0.0, product3.getDiscountPrice(), 0.001); // Trzeci najtańszy produkt za darmo
    }

    @Test
    public void testApplyFreeMug() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.applyPromotions();
        boolean containsMug = cart.getProducts().stream()
                .anyMatch(product -> product.getCode().equals("MUG"));
        Assert.assertTrue(containsMug); // Kubek firmowy gratis
    }

    @Test
    public void testDisplayCart() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.displayCart();
    }

    @Test
    public void testFindCheapestProduct() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        Product cheapest = cart.findCheapestProduct().orElse(null);
        Assert.assertNotNull(cheapest);
        Assert.assertEquals(product3, cheapest);
    }

    @Test
    public void testFindMostExpensiveProduct() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        Product mostExpensive = cart.findMostExpensiveProduct().orElse(null);
        Assert.assertNotNull(mostExpensive);
        Assert.assertEquals(product2, mostExpensive);
    }

    @Test
    public void testFindNCheapestProducts() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);
        cart.addProduct(product5);
        List<Product> cheapestProducts = cart.findNCheapestProducts(3);
        Assert.assertEquals(3, cheapestProducts.size());
        Assert.assertEquals(product5, cheapestProducts.get(0));
        Assert.assertEquals(product3, cheapestProducts.get(1));
        Assert.assertEquals(product1, cheapestProducts.get(2));
    }

    @Test
    public void testFindNMostExpensiveProducts() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);
        cart.addProduct(product5);
        List<Product> mostExpensiveProducts = cart.findNMostExpensiveProducts(3);
        Assert.assertEquals(3, mostExpensiveProducts.size());
        Assert.assertEquals(product4, mostExpensiveProducts.get(0));
        Assert.assertEquals(product2, mostExpensiveProducts.get(1));
        Assert.assertEquals(product1, mostExpensiveProducts.get(2));
    }
}
