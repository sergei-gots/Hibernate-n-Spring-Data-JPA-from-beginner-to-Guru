package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by goc on 24/05/2024
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
