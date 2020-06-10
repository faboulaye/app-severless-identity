package app.serverless.identity.repository;

import app.serverless.identity.bean.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(PersonRepository.REPOSITORY_NAME)
public interface PersonRepository extends CrudRepository<Person, Long> {
    String REPOSITORY_NAME = "appPersonRepository";
}
