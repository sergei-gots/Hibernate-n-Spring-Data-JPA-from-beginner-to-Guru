package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

/**
 * This class implements {@link CommandLineRunner}
 * It is why we can call it kinda `Bootstrap-Data-Initializer`.
 * Created by sergei on 26/05/2024
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        out.println("Hello World with DataInitializer!");

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
