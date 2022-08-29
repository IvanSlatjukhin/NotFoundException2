package Manager;

import Repository.ProductRepository;
import ru.netology.domain.Product;

import javax.management.openmbean.CompositeData;

public class ProductManager {
    private ProductRepository Repository;

    public ProductManager(ProductRepository repository) {

        this.Repository = repository;
    }

    public void add(Product product) {
        Repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : Repository.getAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}