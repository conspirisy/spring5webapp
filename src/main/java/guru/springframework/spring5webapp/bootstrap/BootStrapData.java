package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book bbb = new Book("Gege", "Jojo");
        Publisher publisher = new Publisher("Rerf");
        eric.getBooks().add(bbb);
        bbb.getAuthors().add(eric);
        publisher.getBooks().add(bbb);
        bbb.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(bbb);
        publisherRepository.save(publisher);

        System.out.println("bootstrap started");
        System.out.println("Authors count" + authorRepository.count());
        System.out.println("Publishers count" + publisherRepository.count());
    }
}
