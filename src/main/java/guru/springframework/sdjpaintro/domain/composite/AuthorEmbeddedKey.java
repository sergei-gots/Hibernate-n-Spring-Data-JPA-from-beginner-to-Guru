package guru.springframework.sdjpaintro.domain.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * Created by sergei on 17/02/2025
 */
@Entity
@Table(name = "author_composite_key")
public class AuthorEmbeddedKey {
    @EmbeddedId
    NameId nameId;
    String country;

    public AuthorEmbeddedKey() {
    }

    public AuthorEmbeddedKey(NameId nameId, String country) {
        this.nameId = nameId;
        this.country = country;
    }

    public NameId getNameId() {
        return nameId;
    }

    public void setNameId(NameId nameId) {
        this.nameId = nameId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AuthorEmbeddedKey that)) return false;
        return Objects.equals(nameId, that.nameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameId);
    }

    @Override
    public String toString() {
        return "AuthorEmbeddedKey{" +
                "name{'" + nameId + '}' +
                ", country='" + country + '\'' +
                '}';
    }
}
