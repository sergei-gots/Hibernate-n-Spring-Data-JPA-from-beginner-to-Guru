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

        Book bookDDD = new Book("Domain Driven Design", "123", "Random House");
        out.println("bookDDD = " + bookDDD);

        Book savedDDD = bookRepository.save(bookDDD);
        out.println("bookDDD (after save) = " + bookDDD);
        out.println("savedDDD = " + savedDDD);

        Book bookSIA = new Book("Spring In Action", "234234", "Oriely");
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(out::print);

    }
}
