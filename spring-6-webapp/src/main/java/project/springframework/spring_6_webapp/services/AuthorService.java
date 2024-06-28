package project.springframework.spring_6_webapp.services;

import project.springframework.spring_6_webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
