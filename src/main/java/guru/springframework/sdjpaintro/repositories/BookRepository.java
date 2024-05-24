package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by goc on 24/05/2024
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
