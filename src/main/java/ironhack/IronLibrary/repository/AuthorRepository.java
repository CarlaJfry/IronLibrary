package ironhack.IronLibrary.repository;

import ironhack.IronLibrary.model.Author;
import ironhack.IronLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findAuthorByName(String authorName);
}
