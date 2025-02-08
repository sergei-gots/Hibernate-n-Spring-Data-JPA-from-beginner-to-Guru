package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lesson 29 `Bootstrap data for spliced tests: the {@link ComponentScan
 * Spring Boot Slice Test for Database Layer with bootstrap data initializing
 * ·Demonstration the @{@link ComponentScan} ("<package-name>") annotation for class
 * to pick up additional components. This annotation brings up all the components placed
 * in the specified package. So we can now have our {@link guru.springframework.sdjpaintro.bootstrap.DataInitializer#run(String...)}
 * being run even within executing a @DataJpaTest class methods.
 * Created by sergei on 06/02/2025
 */
@ComponentScan("guru.springframework.sdjpaintro.bootstrap")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class SpringBootDataJpaSliceOrderedTest {

    @Autowired
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    void testJpaTestSlice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("Spring Boot Slice Test in action. Bootstrap for data", "ISBN-Lesson-29", "MySelf"));
        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }
}
