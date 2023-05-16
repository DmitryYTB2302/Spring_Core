package task13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        ArrayList<String> products = new ArrayList<String>();
        products.add("Продукт № 1");
        products.add("Продукт № 2");

        orderService.addProductToCart(products);

        orderService.makeOrder();

        ((AnnotationConfigApplicationContext)context).close();
    }
}
