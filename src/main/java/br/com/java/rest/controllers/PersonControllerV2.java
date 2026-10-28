package br.com.java.rest.controllers;

import br.com.java.rest.data.dto.PersonDTO;
import br.com.java.rest.data.dto.PersonDTOV2;
import br.com.java.rest.services.PersonService;
import br.com.java.rest.services.PersonServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v2")
public class PersonControllerV2 {

    @Autowired
    PersonServiceV2 serviceV2;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 findByIdV2(@PathVariable("id") long id) {
        return serviceV2.findById(id);
    }

    @GetMapping("/all")
    public List<PersonDTOV2> findByAllV2() {
        return serviceV2.findByAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 createV2(@RequestBody PersonDTOV2 person) {
        return serviceV2.create(person);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 updateV2(@RequestBody PersonDTOV2 person) {
        return serviceV2.update(person);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteV2(@PathVariable("id") long id) {
        serviceV2.delete(id);
        return ResponseEntity.noContent().build();
    }
}