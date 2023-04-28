package ironhack.IronLibrary.repository;

import ironhack.IronLibrary.model.Book;
import ironhack.IronLibrary.model.Issue;
import ironhack.IronLibrary.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        Student student = new Student("1234567890", "John");
        studentRepository.save(student);
    }

    @AfterEach
    public void tearDown() {
        studentRepository.deleteAll();

    }

    @Test
    public void findAll() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
        assertEquals(1, studentList.size());
    }

}