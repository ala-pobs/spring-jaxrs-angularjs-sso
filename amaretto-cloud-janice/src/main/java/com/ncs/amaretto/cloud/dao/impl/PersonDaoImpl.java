package com.ncs.amaretto.cloud.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.ncs.amaretto.cloud.dao.PersonDao;
import com.ncs.amaretto.cloud.model.Person;

public class PersonDaoImpl implements PersonDao{
	private Map<String, Person> personMap = new HashMap<String, Person>();
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

	@Override
	public Person createPerson(Person newPerson) {
		newPerson.setId(ID_GENERATOR.incrementAndGet());
		personMap.put(newPerson.getFirstName(), newPerson);
		
		return personMap.get(newPerson.getFirstName());
	}

	@Override
	public List<Person> getAllPersons() {
		return new ArrayList<Person>(personMap.values());
	}

}
