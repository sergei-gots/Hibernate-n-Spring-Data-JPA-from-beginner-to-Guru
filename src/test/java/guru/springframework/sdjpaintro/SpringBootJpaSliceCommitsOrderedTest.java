package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lesson 28 `Spring Test Transaction`
 * Spring Boot Slice Test for Database Layer with committing data
 * ·Demonstration the @{@link TestMethodOrder} (MethodOrder.OrderAnnotation.class) annotation for class
 * and the  @{@link Order} annotation for methods.DataJpaTest annotation
 * ·Demonstration the @{@link Commit} annotation for methods.
 * Note that the @{@link Commit} annotation equals the @{@link Rollback}(false) annotation
 * Created by sergei on 06/02/2025
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class SpringBootJpaSliceCommitsOrderedTest {

    @Autowired
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    void testJpaTestSlice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(0);

        bookRepository.save(new Book("Spring Boot Slice Test in action", "ISBN-Lesson-27", "MySelf"));
        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(1);
    }
}
