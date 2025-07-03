import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {
    private Invoice invoice;

    @Before
    public void setUp() {
        invoice = new Invoice("P001", "Product 1", 5, 10.0);
    }

    @Test
    public void testAmount() {
        Assert.assertEquals(50.0, invoice.amount(), 0.001);
    }

    @Test
    public void testAmountZeroQuantity() {
        invoice.setQuantity(0);
        Assert.assertEquals(0, invoice.amount(), 0.001);
    }

    @Test
    public void testAmountZeroPricePerItem() {
        invoice.setPricePerItem(0);
        Assert.assertEquals(0, invoice.amount(), 0.001);
    }

    @Test
    public void testAmountNegativeQuantity() {
        invoice.setQuantity(-5);
        Assert.assertEquals(0, invoice.amount(), 0.001);
    }

    @Test
    public void testAmountNegativePricePerItem() {
        invoice.setPricePerItem(-10.0);
        Assert.assertEquals(0, invoice.amount(), 0.001);
    }
}
