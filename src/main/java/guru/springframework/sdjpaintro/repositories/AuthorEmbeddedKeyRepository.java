package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.composite.AuthorEmbeddedKey;
import guru.springframework.sdjpaintro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sergei on 17/02/2025
 */
public interface AuthorEmbeddedKeyRepository extends JpaRepository<AuthorEmbeddedKey, NameId> {
}
