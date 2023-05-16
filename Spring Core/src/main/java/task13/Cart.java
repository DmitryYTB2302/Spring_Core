package task13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<Product> products = new ArrayList<>();
    private ProductService productService;

    private List<String> productsList = new ArrayList<>();

    public List<String> getProductsList() {
        return productsList;
    }

    public void addProduct(String title) {
        Product product = productService.findByTitle(title);
        if(product != null)products.add(product);
        else System.out.println("Товара: " + title + " нет на складе.");
    }

    public void addProduct(Product product) {
        if(productService.findByTitle(product.getTitle()) != null) this.products.add(product);
        else System.out.println("Продукта: " + product.getTitle() + " нет на складе.");
    }

    public List<Product> getProducts() {
        return products;
    }

    @Autowired
    public Cart(ProductService productService){
        this.productService = productService;
    }
}
