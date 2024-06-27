package project.springframework.spring_6_webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.springframework.spring_6_webapp.domain.Author;
import project.springframework.spring_6_webapp.domain.Book;
import project.springframework.spring_6_webapp.domain.Publisher;
import project.springframework.spring_6_webapp.repository.AuthorRepository;
import project.springframework.spring_6_webapp.repository.BookRepository;
import project.springframework.spring_6_webapp.repository.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher macmillan = new Publisher();
        macmillan.setPublisherName("Macmillan Publishers");
        macmillan.setAddress("Brisket Street");
        macmillan.setCity("London");
        macmillan.setState("United Kingdom");
        macmillan.setZip("102938");

        Publisher macmillanSaved = publisherRepository.save(macmillan);

        Author alice = new Author();
        alice.setFirstName("Alice");
        alice.setLastName("Zakaria");

        Book pulp = new Book();
        pulp.setTitle("Pulp Fiction");
        pulp.setIsbn("190287463");

        Author aliceSaved = authorRepository.save(alice);
        Book pulpSaved = bookRepository.save(pulp);

        Author bob = new Author();
        bob.setFirstName("Bob");
        bob.setLastName("Vance");

        Book finance = new Book();
        finance.setTitle("How to get Rich");
        finance.setIsbn("379286486");

        Author bobSaved = authorRepository.save(bob);
        Book financeSaved = bookRepository.save(finance);

        pulpSaved.setPublisher(macmillanSaved);
        financeSaved.setPublisher(macmillanSaved);

        aliceSaved.getBooks().add(pulpSaved);
        bobSaved.getBooks().add(financeSaved);

        bookRepository.save(pulpSaved);
        bookRepository.save(financeSaved);
        authorRepository.save(aliceSaved);
        authorRepository.save(bobSaved);
        publisherRepository.save(macmillanSaved);

        System.out.println("On Bootstrap : ");
        System.out.println("Author count = " + authorRepository.count());
        System.out.println("Book count = " + bookRepository.count());
        System.out.println("Publisher count = " + publisherRepository.count());

        System.out.println("\nAuthors : ");
        System.out.println(aliceSaved.toString());
        System.out.println(bobSaved.toString());

        System.out.println("\nBooks : ");
        System.out.println(pulpSaved.toString());
        System.out.println(financeSaved.toString());

        System.out.println("\nPublishers : ");
        System.out.println(macmillanSaved.toString());
    }
}
