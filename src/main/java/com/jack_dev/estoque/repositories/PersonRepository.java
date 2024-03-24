package com.jack_dev.estoque.repositories;

import com.jack_dev.estoque.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
//	public List<Person> findByActiveTrue();
}
