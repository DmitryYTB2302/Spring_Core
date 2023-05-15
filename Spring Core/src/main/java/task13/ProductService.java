package task13;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 10; i++) {
            products.add(new Product(String.valueOf(i), "Продукт № " + i, i * 10.0));
        }
    }

    public void printAll() {
        products.forEach(System.out::println);
    }

    public Product findByTitle(String title) {
        return products.stream().filter(product -> product.getTitle().equals(title)).findFirst().orElse(null);
    }
}
