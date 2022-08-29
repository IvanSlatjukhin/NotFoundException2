package Repository;

import Exception.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] plusOne = new Product[length];
        System.arraycopy(products, 0, plusOne, 0, products.length);
        int last = plusOne.length - 1;
        plusOne[last] = product;
        products = plusOne;
    }

    public Product[] getAll() {
        return products;
    }

    public Product findById(int id) {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] removeById(int id) {
        if (findById(id) == null) throw new NotFoundException("Please, try again. Your id [" + id + "] is not found. =(");
        int length = products.length - 1;
        Product[] plusOne = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                plusOne[index] = product;
                index++;
            }
        }
        products = plusOne;
        return products;
    }
}
