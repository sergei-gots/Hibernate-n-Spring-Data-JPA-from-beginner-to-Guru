package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.composite.AuthorCompositeKey;
import guru.springframework.sdjpaintro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sergei on 17/02/2025
 */
public interface AuthorCompositeKeyRepository extends JpaRepository<AuthorCompositeKey, NameId> {
}
