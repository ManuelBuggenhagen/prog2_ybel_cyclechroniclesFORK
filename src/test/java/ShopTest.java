import cyclechronicles.Shop;
import cyclechronicles.Type;
import cyclechronicles.Order;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ShopTest {
    Shop shop;
    Order order;

    /**
     *
     */
    @Test
    public void testgAK1() {
        order = mock(Order.class);
        shop = new Shop();
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Tim");
        assertTrue(shop.accept(order));
    }

    /**
     *
     */
    @Test
    public void testgAK2() {
        order = mock(Order.class);
        shop = new Shop();
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Mark");
        assertTrue(shop.accept(order));
    }

    /**
     *
     */
    @Test
    public void testgAK3() {
        order = mock(Order.class);
        shop = new Shop();
        when(order.getBicycleType()).thenReturn(Type.FIXIE);
        when(order.getCustomer()).thenReturn("Alex");
        assertTrue(shop.accept(order));
    }

    /**
     *
     */
    @Test
    public void testuAK1() {
        order = mock(Order.class);
        shop = new Shop();
        when(order.getBicycleType()).thenReturn(Type.EBIKE);
        when(order.getCustomer()).thenReturn("Alex");
        assertFalse(shop.accept(order));
    }

    /**
     *
     */
    @Test
    public void testuAK2() {
        order = mock(Order.class);
        shop = new Shop();
        when(order.getBicycleType()).thenReturn(Type.GRAVEL);
        when(order.getCustomer()).thenReturn("Alex");
        assertFalse(shop.accept(order));
    }

    /**
     *
     */
    @Test
    public void testuAK3() {
        order = mock(Order.class);
        shop = new Shop();
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Alex");
        shop.accept(order);
        assertFalse(shop.accept(order));
    }

    /**
     *
     */
    @Test
    public void testuAK4() {
        order = mock(Order.class);
        shop = new Shop();
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("alex");
        assertTrue(shop.accept(order));
    }
}
