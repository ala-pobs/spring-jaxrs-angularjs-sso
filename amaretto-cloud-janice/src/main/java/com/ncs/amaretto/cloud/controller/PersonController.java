package com.ncs.amaretto.cloud.controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ncs.amaretto.cloud.dao.PersonDao;
import com.ncs.amaretto.cloud.model.Person;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PersonController {
    private PersonDao personDao;
	
	@POST
	public @ResponseBody Person createPerson(@RequestBody Person newPerson) {
		return personDao.createPerson(newPerson);
	}

	@GET
	public @ResponseBody List<Person> getAllPersons() {
		return personDao.getAllPersons();
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}
