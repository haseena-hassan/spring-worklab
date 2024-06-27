package project.springframework.spring_6_webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.springframework.spring_6_webapp.domain.Author;
import project.springframework.spring_6_webapp.domain.Book;
import project.springframework.spring_6_webapp.repository.AuthorRepository;
import project.springframework.spring_6_webapp.repository.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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

        aliceSaved.getBooks().add(pulpSaved);
        bobSaved.getBooks().add(financeSaved);

        authorRepository.save(aliceSaved);
        authorRepository.save(bobSaved);

        System.out.println("On Bootstrap : ");
        System.out.println("Author count = " + authorRepository.count());
        System.out.println("Book count = " + bookRepository.count());

        System.out.println("\nAuthors : ");
        System.out.println(aliceSaved.toString());
        System.out.println(bobSaved.toString());

        System.out.println("\nBooks : ");
        System.out.println(pulpSaved.toString());
        System.out.println(financeSaved.toString());
    }
}
