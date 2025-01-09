package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

/**
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

        Book bookDdd = new Book("Domain Driven Design", "123", "Random House");
        out.println("bookDdd = " + bookDdd);

        Book savedDdd = bookRepository.save(bookDdd);
        out.println("bookDdd (after save) = " + bookDdd);
        out.println("savedDdd = " + savedDdd);

        Book bookSia = new Book("Spring In Action", "234234", "Oriely");
        out.println("bookSia = " + bookSia);

        Book savedSia = bookRepository.save(bookSia);
        out.println("bookSia (after save) = " + bookSia);
        out.println("savedSia = " + savedSia);

        bookRepository.findAll().forEach(Book::print);

    }
}
