package project.springframework.spring_6_webapp.services;

import project.springframework.spring_6_webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
