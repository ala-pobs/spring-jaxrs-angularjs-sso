package com.ncs.amaretto.cloud.dao;

import java.util.List;

import com.ncs.amaretto.cloud.model.Person;

public interface PersonDao {

	public Person createPerson(Person newPerson);
	
	public List<Person> getAllPersons();
	
}
