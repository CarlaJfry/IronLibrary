package ironhack.IronLibrary.repository;

import ironhack.IronLibrary.model.Author;
import ironhack.IronLibrary.model.Book;
import ironhack.IronLibrary.model.Issue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueRepositoryTest {

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    BookRepository bookRepository;


    //TODO add student
//    @Autowired
//    StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        Book book = new Book("978-3-16-148410-0",  "The Notebook", "Romance", 4);
        bookRepository.save(book);
        //TODO add student
        Issue issue = new Issue("2023-12-03", "2023-12-15", book);
        issueRepository.save(issue);
    }

    @AfterEach
    public void tearDown() {
        issueRepository.deleteAll();
        bookRepository.deleteAll();

    }

    @Test
    public void findAll() {
        List<Issue> issueList = issueRepository.findAll();
        System.out.println(issueList);
        assertEquals(1, issueList.size());
    }

}