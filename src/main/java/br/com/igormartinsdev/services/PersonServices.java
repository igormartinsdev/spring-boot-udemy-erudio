package br.com.igormartinsdev.services;

import br.com.igormartinsdev.exception.ResourceNotFoundException;
import br.com.igormartinsdev.model.Person;
import br.com.igormartinsdev.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all people!");

        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one Person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person){
        logger.info("Creating one person!");

        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person!");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));

        entity.setFisrtName(person.getFisrtName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting one person!");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));

        repository.delete(entity);
    }

}
