package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sergei on 08/02/2025
 */
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"})
@DataJpaTest
public class SpringBootDataJpaMySqlIntegrationSliceTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void mySqlTest() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }
}
