package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by goc on 24/05/2024
 */
public interface BookNaturalRepository extends JpaRepository<BookNatural, String> {
}
