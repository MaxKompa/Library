import com.example.Book;
import com.example.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Book Title 1", "Author 1");
        book2 = new Book("Book Title 2", "Author 2");
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    public void testAddDuplicateBook() {
        library.addBook(book1);
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
    }

    @Test
    public void testAddNullBook() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    public void testRemoveBook() {
        library.addBook(book1);
        assertTrue(library.removeBook(book1));
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void testRemoveNonExistentBook() {
        assertFalse(library.removeBook(book1));
    }

    @Test
    public void testRemoveNullBook() {
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(null));
    }

    @Test
    public void testGetBooks() {
        library.addBook(book1);
        library.addBook(book2);
        List<Book> books = library.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    public void testGetBookCount() {
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
    }

    @Test
    public void testGetBookCountWhenEmpty() {
        assertEquals(0, library.getBookCount());
    }
}

