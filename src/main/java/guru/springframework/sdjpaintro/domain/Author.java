package guru.springframework.sdjpaintro.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by sergei on 14/02/2025
 */
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(value=Types.VARCHAR)
    @Column(length = 36, columnDefinition = "VARCHAR(36)", updatable = false, nullable = false)
    private UUID id;
    private String firstName;
    private String lastName;

    public Author() {}

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Author author)) return false;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
