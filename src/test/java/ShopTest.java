import cyclechronicles.Order;
import cyclechronicles.Shop;
import cyclechronicles.Type;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShopTest {
    Order order;
    Shop shop;

    /**
     * pending order is empty so empty optional is expected
     */
    @Test
    public void testrepair1() {
        shop = mock(Shop.class);
        when(shop.repair()).thenReturn(Optional.empty());
        assertTrue(shop.repair().isEmpty());
    }

    /**
     * pending order is available
     */
    @Test
    public void testrepair2() {
        shop = mock(Shop.class);
        order = mock(Order.class);
        when(shop.repair()).thenReturn(Optional.of(order));
        assertTrue(shop.repair().isPresent());
    }

    /**
     * no order by customer "test" found
     */
    @Test
    public void testdeliver1() {
        shop = mock(Shop.class);
        order = mock(Order.class);
        when(shop.deliver("test")).thenReturn(Optional.empty());
        assertTrue(shop.deliver("test").isEmpty());
    }

    /**
     *  order by customer "test" found
     */
    @Test
    public void testdeliver2() {
        shop = mock(Shop.class);
        order = mock(Order.class);
        when(shop.deliver("test")).thenReturn(Optional.of(order));
        assertTrue(shop.deliver("test").isPresent());
    }
}
