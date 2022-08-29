package Repository;

import Exception.NotFoundException;
import Manager.ProductManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Вино из одуванчиков", 3, "Рэй Брэдбери");
    Product book1 = new Book(2, "Kolobok", 450, "Ushinskiy");

    @BeforeEach
    public void SetUp() {
        manager.add(book);
        manager.add(book1);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(1);
        Product[] expected = {book1};
        assertArrayEquals(repository.getAll(), expected);
    }

    @Test
    void shouldThrowNotFoundException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(14));
    }
    @Test
    void shouldThrowNotFoundExceptionWithMessage() {
        NotFoundException exception = assertThrows(NotFoundException.class, () -> repository.removeById(14));
        assertEquals("Please, try again. Your id [14] is not found. =(", exception.getMessage());

    }

}
