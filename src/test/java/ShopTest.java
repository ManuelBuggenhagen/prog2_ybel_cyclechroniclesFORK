import cyclechronicles.Shop;
import cyclechronicles.Type;
import cyclechronicles.Order;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;
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
        shop = new Shop();
        order = mock(Order.class);
        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);
        Order order3 = mock(Order.class);
        Order order4 = mock(Order.class);
        Order order5 = mock(Order.class);
        when(order1.getBicycleType()).thenReturn(Type.RACE);
        when(order1.getCustomer()).thenReturn("testA");
        assertTrue(shop.accept(order1));

        when(order2.getBicycleType()).thenReturn(Type.RACE);
        when(order2.getCustomer()).thenReturn("testB");
        assertTrue(shop.accept(order2));

        when(order3.getBicycleType()).thenReturn(Type.RACE);
        when(order3.getCustomer()).thenReturn("testC");
        assertTrue(shop.accept(order3));

        when(order4.getBicycleType()).thenReturn(Type.RACE);
        when(order4.getCustomer()).thenReturn("testD");
        assertTrue(shop.accept(order4));

        when(order5.getBicycleType()).thenReturn(Type.RACE);
        when(order5.getCustomer()).thenReturn("testE");
        assertTrue(shop.accept(order5));

        when(order.getBicycleType()).thenReturn(Type.FIXIE);
        when(order.getCustomer()).thenReturn("testF");
        assertFalse(shop.accept(order));
    }

    /**
     *
     */
    @Test
    public void testuAK3u() {
        shop = new Shop();
        order = mock(Order.class);
        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);
        Order order3 = mock(Order.class);
        Order order4 = mock(Order.class);
        when(order1.getBicycleType()).thenReturn(Type.RACE);
        when(order1.getCustomer()).thenReturn("testA");
        shop.accept(order1);

        when(order2.getBicycleType()).thenReturn(Type.RACE);
        when(order2.getCustomer()).thenReturn("testB");
        shop.accept(order2);

        when(order3.getBicycleType()).thenReturn(Type.RACE);
        when(order3.getCustomer()).thenReturn("testC");
        shop.accept(order3);

        when(order4.getBicycleType()).thenReturn(Type.RACE);
        when(order4.getCustomer()).thenReturn("testD");
        shop.accept(order4);

        when(order.getBicycleType()).thenReturn(Type.FIXIE);
        when(order.getCustomer()).thenReturn("testE");
        assertTrue(shop.accept(order));
    }


}
