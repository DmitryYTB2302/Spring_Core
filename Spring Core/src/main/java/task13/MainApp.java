package task13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);

        orderService.printAll();

        orderService.addProductToCart("Продукт № 1");
        orderService.addProductToCart("Продукт № 3");
        orderService.addProductToCart("Продукт № 5");
        orderService.addProductToCart("Продукт № 10");

        orderService.findByTitle("Продукт № 2");

        orderService.makeOrder();

        ((AnnotationConfigApplicationContext)context).close();
    }
}
