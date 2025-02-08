package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Lesson 26
 * · `Spring Boot Test`
 * · `AssertJ` library
 * Created by sergei on 04/02/2025
 */
@SpringBootTest
class SpringBootAppTest {

	@Autowired
	BookRepository bookRepository;

	/**
	 * Tests that all the book entities created and stored, i.e. set up,  within our bootstrap
	 * with an instance of {@link guru.springframework.sdjpaintro.bootstrap.DataInitializer}
	 * are got done.
	 *
	 */
	@Test
	void testBookRepository() {
		long count = bookRepository.count();
		assertThat(count).isGreaterThan(0);
	}

	/**
	 * Tests that all the context is loaded
	 * That is what we get out of the box with Spring Initializer
	 */
	@Test
	void contextLoads() {
	}

}
