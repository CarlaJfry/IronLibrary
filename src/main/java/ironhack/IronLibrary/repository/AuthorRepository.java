package ironhack.IronLibrary.repository;

import ironhack.IronLibrary.model.Author;
import ironhack.IronLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.authorName) = LOWER(:authorName)")
    Optional<Book> findBookByAuthor(@Param("authorName") String authorName);
    Optional<Author> findAuthorByName(String authorName);
}
