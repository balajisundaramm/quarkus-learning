package org.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;


/**
 * @author = mbalaji on 29-08-2023
 * @project = rest-book
 */
@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().get("/api/books")
                .then()
                .statusCode(200)
                .body("size()", is(2));
    }

    @Test
    public void shouldGetCountOfBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN);
        when().get("/api/books/count")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    public void shouldGetBookById() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when().get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body("title", is("Quarkus"))
                .body("genre", is("IT"));
    }
}
