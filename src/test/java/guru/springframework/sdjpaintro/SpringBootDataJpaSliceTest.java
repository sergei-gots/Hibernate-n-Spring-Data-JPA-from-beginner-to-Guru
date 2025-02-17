package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Author;
import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.AuthorRepository;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sergei on 06/02/2025
 */
@ComponentScan("guru.springframework.sdjpaintro.bootstrap")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class SpringBootDataJpaSliceTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Commit
    @Order(1)
    @Test
    void testJpaBookTestSlice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        String isbn = "ISBN-Lesson-29";
        Book savedBook = bookRepository.save(new Book("Spring Boot Slice Test in action. Bootstrap for data", isbn, "MySelf", null));
        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
        assertThat(savedBook.getId()).isNotNull();

        Book gotBook = bookRepository.getReferenceById(savedBook.getId());
        assertThat(gotBook).isNotNull();
        assertThat(gotBook.getId()).isEqualTo(savedBook.getId());
        assertThat(gotBook.getIsbn()).isEqualTo(isbn);
    }

    @Order(2)
    @Test
    void testJpaTestSliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }

    @Test
    void testJpaAuthorTestSplice() {

        String firstName = "Jaques";
        Author author = new Author(firstName, "Derrida");

        long countBefore = authorRepository.count();
        Author savedAuthor = authorRepository.save(author);
        long countAfter = authorRepository.count();

        assertThat(countAfter).isEqualTo(countBefore+1);
        assertThat(savedAuthor).isNotNull();
        assertThat(savedAuthor.getId()).isNotNull();
        assertThat(savedAuthor.getFirstName()).isEqualTo(firstName);

        Author gotAuthor = authorRepository.getReferenceById(savedAuthor.getId());

        assertThat(gotAuthor).isEqualTo(savedAuthor);
        assertThat(gotAuthor.getFirstName()).isEqualTo(firstName);
    }
}
