package project.springframework.spring_6_webapp.services;

import org.springframework.stereotype.Service;
import project.springframework.spring_6_webapp.domain.Author;
import project.springframework.spring_6_webapp.repositories.AuthorRepository;
import project.springframework.spring_6_webapp.repositories.BookRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
