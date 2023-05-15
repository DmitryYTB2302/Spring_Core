package task13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private Cart cart;

    @Autowired
    private ProductService productService;

    public void makeOrder() {
        List<Product> productsInCart = cart.getProducts();
        double totalCost = productsInCart.stream().mapToDouble(Product::getCost).sum();

        System.out.println("Все продукты в корзине:");
        productsInCart.forEach(System.out::println);
        System.out.println("Итоговая цена: " + totalCost);
    }

    public void addProductToCart(String title) {
        Product product = productService.findByTitle(title);
        if (product != null) {
            cart.addProduct(product);
        }
    }

    public void printAll(){
        System.out.println("Все продукты в магазине: ");
        productService.printAll();
    }

    public void findByTitle(String title){
        Product product = productService.findByTitle(title);
        if(product != null) System.out.println(product);
        else System.out.println("Товар: " + title + " не найден!");
    }
}
