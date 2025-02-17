package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Author;
import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.domain.BookNatural;
import guru.springframework.sdjpaintro.repositories.AuthorRepository;
import guru.springframework.sdjpaintro.repositories.BookNaturalRepository;
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

    @Autowired
    BookNaturalRepository bookNaturalRepository;

    @Commit
    @Order(1)
    @Test
    void testJpaBookTestSlice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        String isbn = "ISBN-Lesson-29";
        Book saved = bookRepository.save(new Book("Spring Boot Slice Test in action. Bootstrap for data", isbn, "MySelf", null));
        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();

        Book fetched = bookRepository.getReferenceById(saved.getId());
        assertThat(fetched).isNotNull();
        assertThat(fetched.getId()).isEqualTo(saved.getId());
        assertThat(fetched.getIsbn()).isEqualTo(isbn);
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
        Author saved = authorRepository.save(author);
        long countAfter = authorRepository.count();

        assertThat(countAfter).isEqualTo(countBefore+1);
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getFirstName()).isEqualTo(firstName);

        Author fetched = authorRepository.getReferenceById(saved.getId());

        assertThat(fetched).isNotNull();
        assertThat(fetched).isEqualTo(saved);
        assertThat(fetched.getFirstName()).isEqualTo(firstName);
    }

    @Test
    void testJpaBookNaturalTestSplice() {

        String firstName = "Jaques";
        BookNatural bookNatural = new BookNatural(
                "Structure, Sign and Play in the Discourse of the Human Sciences",
                "ISBN-1996-001",
                "Science Publisher"
        );

        long countBefore = bookNaturalRepository.count();
        BookNatural saved = bookNaturalRepository.save(bookNatural);
        long countAfter = bookNaturalRepository.count();

        assertThat(countAfter).isEqualTo(countBefore+1);
        assertThat(saved).isNotNull();
        assertThat(saved.getIsbn()).isNotNull();
        assertThat(saved).isEqualTo(bookNatural);

        BookNatural fetched = bookNaturalRepository.getReferenceById(saved.getIsbn());

        assertThat(fetched).isNotNull();
        assertThat(fetched).isEqualTo(saved);
    }
}
