package Manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Phone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Вино из одуванчиков", 3, "Рэй Брэдбери");
    Product book1 = new Book(2, "Kolobok", 450, "Ushinskiy");
    Product phone = new Phone(3, "One Plus 6", 30_000, "BBK Electronics");
    Product book3 = new Book(3, "Putin", 0, "Constitution of RF");

    @BeforeEach
    public void SetUp() {
        manager.add(book);
        manager.add(book1);
        manager.add(phone);
        manager.add(book3);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = {book};
        Product[] actual = manager.searchBy("рэй брэдбери");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("kolobok");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneName() {
        Product[] expected = {phone};
        Product[] actual = manager.searchBy("one plus 6");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneManufacturer() {
        Product[] expected = {phone};
        Product[] actual = manager.searchBy("BBK Electronics");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Лев Тостой");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNull() {
        Product[] expected = {};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }

}