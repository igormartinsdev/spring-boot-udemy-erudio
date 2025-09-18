package br.com.igormartinsdev.services;

import br.com.igormartinsdev.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all people!");

        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        
        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person!");

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFisrtName("Igor");
        person.setLastName("Martins");
        person.setAddress("Belém - Pará - Brasil");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person){
        logger.info("Creating one person!");

        return person;
    }

    public Person update(String id, Person person){
        return person;
    }

    private Person mockPerson(int i) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFisrtName("firstName " + i);
        person.setLastName("lastName" + i);
        person.setAddress("Some Address in Brasil");
        person.setGender("Male");

        return person;
    }

}
