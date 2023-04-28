package ironhack.IronLibrary.repository;

import ironhack.IronLibrary.model.Issue;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
