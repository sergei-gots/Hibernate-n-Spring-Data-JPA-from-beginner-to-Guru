package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

/**
 * This class implements {@link CommandLineRunner}
 * It is why we can call it kinda `Bootstrap-Data-Initializer`
 * in order to set up some initial data to be persisted in the database.
 * Created by sergei on 26/05/2024
 */
@Profile({"default", "local"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        out.println("DataInitializer is being run!");

        bookRepository.deleteAll();

        Book book1 = new Book("Domain Driven Design", "123", "Random House");
        out.println("book1 = " + book1);

        Book savedBook1 = bookRepository.save(book1);
        out.println("book1 (after save) = " + book1);
        out.println("savedBook1 = " + savedBook1);

        Book book2 = new Book("Spring In Action", "234234", "Oriely");
        out.println("book2 = " + book2);

        Book savedBook2 = bookRepository.save(book2);
        out.println("book2 (after save) = " + book2);
        out.println("savedBook2 = " + savedBook2);

        bookRepository.findAll().forEach(Book::print);

    }
}
