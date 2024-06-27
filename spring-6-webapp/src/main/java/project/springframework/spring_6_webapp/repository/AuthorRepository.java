package project.springframework.spring_6_webapp.repository;

import org.springframework.data.repository.CrudRepository;
import project.springframework.spring_6_webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
