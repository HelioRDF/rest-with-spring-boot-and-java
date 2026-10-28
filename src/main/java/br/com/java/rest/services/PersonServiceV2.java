package br.com.java.rest.services;

import br.com.java.rest.data.dto.PersonDTOV2;
import br.com.java.rest.exception.ResourceNotFoundException;
import br.com.java.rest.model.Person;
import br.com.java.rest.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import static br.com.java.rest.mapper.CustomMapper.DTOV2TOPerson;
import static br.com.java.rest.mapper.CustomMapper.ListDTOV2TOPerson;
import static br.com.java.rest.mapper.CustomMapper.listPersonToDTOV2;
import static br.com.java.rest.mapper.CustomMapper.personToDTOV2;

@Service
public class PersonServiceV2 {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServiceV2.class.getName());


    @Autowired
    PersonRepository repository;

    public PersonDTOV2 findById(long id) {
        logger.info("Finding one Person!" + id);
        logger.warn("warn Finding one Person!" + id);
        logger.debug("debug Finding one Person!" + id);
        logger.trace("trace Finding one Person!" + id);
        logger.error("error Finding one Person!" + id);

        var entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Não encontramos informações para o ID informado"));

        return personToDTOV2(entity);
    }

    public List<PersonDTOV2> findByAll() {
        logger.info("Finding all Person!");
        return listPersonToDTOV2(repository.findAll());
    }

    public PersonDTOV2 create(PersonDTOV2 person) {
        logger.info("Create Person!");
        var entity = DTOV2TOPerson(person);
        return personToDTOV2(repository.save(entity));
    }

    public PersonDTOV2 update(PersonDTOV2 person) {
        logger.info("Update Person!");
        repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Não encontramos informações para o ID informado"));
        var entity = DTOV2TOPerson(person);

        return personToDTOV2(repository.save(entity));
    }

    public void delete(Long id) {
        logger.info("Delete Person!");
        Person person = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Não encontramos informações para o ID informado"));
        repository.delete(person);
    }

}
