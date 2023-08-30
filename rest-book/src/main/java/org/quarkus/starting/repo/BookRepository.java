package org.quarkus.starting.repo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.quarkus.starting.model.Book;

import java.util.List;

/**
 * @author = mbalaji on 29-08-2023
 * @project = rest-book
 */
@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "DEFAULT")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Quarkus", "Balaji", 2023, genre),
                new Book(2, "Automic Habits", "Balaji", 2013, genre)
        );
    }

    public Book getBookById(@PathParam("id") int id) {
        return getAllBooks().stream().filter(book -> book.getId() == id).findFirst().get();
    }
}
