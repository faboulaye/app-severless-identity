package app.serverless.identity.service;

import app.serverless.identity.bean.Person;

import java.util.Optional;

public interface PersonService {
    String SERVICE_NAME = "appPersonService";

    Long create(Person person);
    void delete(Person person);

    Optional<Person> findById(Long id);

    Iterable<Person> list();
}
