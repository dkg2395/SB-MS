package com.trans.database.JdbcJpaH2.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.trans.database.JdbcJpaH2.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	// connect to the database
		@PersistenceContext
		EntityManager entityManager;
		
		public List<Person> findAll() {
			TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
			return namedQuery.getResultList();
		}
		
		public Person findById(int id) {
			return entityManager.find(Person.class, id);// JPA
		}
		
		public Person update(Person person) {
			return entityManager.merge(person);
		}

		public Person insert(Person person) {
			return entityManager.merge(person);
		}
		
		public void deleteById(int id) {
			Person person = findById(id);//finding id by using above fun findById and storing that in var
			entityManager.remove(person);
		}

}
