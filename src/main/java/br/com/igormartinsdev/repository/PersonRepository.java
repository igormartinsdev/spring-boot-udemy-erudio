package br.com.igormartinsdev.repository;

import br.com.igormartinsdev.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
