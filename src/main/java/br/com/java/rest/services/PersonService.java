package br.com.java.rest.services;

import br.com.java.rest.data.dto.PersonDTO;
import br.com.java.rest.exception.ResourceNotFoundException;

import static br.com.java.rest.mapper.ObjectMapper.parseListObjects;
import static br.com.java.rest.mapper.ObjectMapper.parseObject;

import br.com.java.rest.mapper.ObjectMapper;
import br.com.java.rest.model.Person;
import br.com.java.rest.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());


    @Autowired
    PersonRepository repository;

    public PersonDTO findById(long id) {
        logger.info("Finding one Person!" + id);
        logger.warn("warn Finding one Person!" + id);
        logger.debug("debug Finding one Person!" + id);
        logger.trace("trace Finding one Person!" + id);
        logger.error("error Finding one Person!" + id);

        var entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Não encontramos informações para o ID informado"));

        return parseObject(entity, PersonDTO.class);
    }

    public List<PersonDTO> findByAll() {
        logger.info("Finding all Person!");
        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Create Person!");
        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Update Person!");
        repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Não encontramos informações para o ID informado"));
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Delete Person!");
        Person person = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Não encontramos informações para o ID informado"));
        repository.delete(person);
    }

}
