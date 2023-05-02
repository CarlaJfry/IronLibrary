package ironhack.IronLibrary.repository;

import ironhack.IronLibrary.model.Issue;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
//    List<Issue> findAllByStudentId(String studentUsn);
    @Query(value="SELECT * FROM issue i JOIN student s ON s.usn=i.student_id WHERE s.usn =:studentUsn", nativeQuery=true)
        List<Issue> findAllByStudentUsn(@Param("studentUsn") String studentUsn);

}
