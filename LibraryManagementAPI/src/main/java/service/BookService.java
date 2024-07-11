package service;

import dto.Book;
import lombok.Data;
import org.springframework.stereotype.Service;
import repositories.BookRepositories;

import java.util.List;

@Service
@Data
public class BookService {

    private final BookRepositories bookRepositories;

    public List<Book> getAllBooks() {
        return bookRepositories.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepositories.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepositories.save(book);
    }

    public void deleteBook(Long id) {
        bookRepositories.deleteById(id);
    }

    // Additional methods for updating book, searching by author, etc.
    public void updateBook(Book book, Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Book ID cannot be null");
        }
        book.setId(id);
        bookRepositories.save(book);
    }

    public List<Book> getBooksByAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author name cannot be null");
        }
        return bookRepositories.findByAuthor(author);
    }
    public List<Book> findByCategory(String category) {
        if (category == null) {
            throw new IllegalArgumentException("Category name cannot be null");
        }
        return bookRepositories.findByCategory(category);
    }
}
