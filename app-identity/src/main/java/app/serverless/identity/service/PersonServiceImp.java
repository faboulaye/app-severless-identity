package app.serverless.identity.service;

import app.serverless.identity.bean.Person;
import app.serverless.identity.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service(PersonService.SERVICE_NAME)
public class PersonServiceImp implements PersonService {

    private final static Logger log = LoggerFactory.getLogger(PersonServiceImp.class);

    @Autowired
    @Qualifier(PersonRepository.REPOSITORY_NAME)
    PersonRepository repository;

    @Override
    @Transactional
    public Long create(Person person) {
        return repository.save(person).getId();
    }

    @Override
    @Transactional
    public void delete(Person person) {
        Optional.ofNullable(person)
                .ifPresent(repository::delete);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }
    @Override
    public Iterable<Person> list() {
        return repository.findAll();
    }
}
