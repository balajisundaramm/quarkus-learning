package org.quarkus.starting.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import org.quarkus.starting.model.Book;
import org.quarkus.starting.repo.BookRepository;

import java.util.List;

/**
 * @author = mbalaji on 29-08-2023
 * @project = rest-book
 */
@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("get all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countBooks() {
        logger.info("get no of books");
        return bookRepository.getAllBooks().size();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookById(@PathParam("id") int id) {
        logger.info("get book by id " + id);
        return bookRepository.getBookById(id);
    }

}
