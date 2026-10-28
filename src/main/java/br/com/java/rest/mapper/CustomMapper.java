package br.com.java.rest.mapper;

import br.com.java.rest.data.dto.PersonDTOV2;
import br.com.java.rest.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CustomMapper {


    public static PersonDTOV2 personToDTOV2(Person person) {
        PersonDTOV2 personDTOV2 = new PersonDTOV2(
                "admin123",
                person.getGender(),
                person.getAddress(),
                person.getLastName(),
                person.getFirstName(),
                person.getId()
        );
        return personDTOV2;
    }

    public static Person DTOV2TOPerson(PersonDTOV2 personDTOV2) {
        Person person = new Person();
        person.setGender(personDTOV2.getGender());
        person.setAddress(personDTOV2.getAddress());
        person.setLastName(personDTOV2.getLastName());
        person.setFirstName(personDTOV2.getFirstName());
        person.setId(personDTOV2.getId());
        return person;
    }

    public static List<PersonDTOV2> listPersonToDTOV2(List<Person> people) {
        List<PersonDTOV2> peopleDTO = new ArrayList<PersonDTOV2>();
        for (int i = 0; i < people.size(); i++) {
            PersonDTOV2 personDTOV2 = new PersonDTOV2(
                    "admin123",
                    people.get(i).getGender(),
                    people.get(i).getAddress(),
                    people.get(i).getLastName(),
                    people.get(i).getFirstName(),
                    people.get(i).getId()
            );
            peopleDTO.add(personDTOV2);
        }
        return peopleDTO;
    }

    public static List<Person> ListDTOV2TOPerson(List<PersonDTOV2> peopleDTOV2) {
        List<Person> people = new ArrayList<Person>();

        for (int i = 1; i < peopleDTOV2.size(); i++) {
            Person person = new Person();
            person.setGender(peopleDTOV2.get(i).getGender());
            person.setAddress(peopleDTOV2.get(i).getAddress());
            person.setLastName(peopleDTOV2.get(i).getLastName());
            person.setFirstName(peopleDTOV2.get(i).getFirstName());
            person.setId(peopleDTOV2.get(i).getId());

            people.add(person);
        }
        return people;
    }
}
