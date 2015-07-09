package com.ncs.amaretto.cloud.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ncs.amaretto.cloud.dao.UserDao;
import com.ncs.amaretto.cloud.dao.UserDaoException;
import com.ncs.amaretto.cloud.model.UpdateField;
import com.ncs.amaretto.cloud.model.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
	private UserDao userDao;

	@POST
	public @ResponseBody User createUser(@RequestBody User newUser) throws UserDaoException {
		return userDao.createUser(newUser);
	}

	@GET
	public @ResponseBody List<User> retriveAllUsers() throws UserDaoException {
		return userDao.retrieveAllUsers();
	}

	@GET
	@Path("{username}")
	public @ResponseBody User retrieveUserByUsername(@PathParam("username") String username) throws UserDaoException {
		User user = userDao.retriveUserByUsername(username);
		return user;
	}

	@PUT
	@Path("{username}")
	public @ResponseBody User updateUserByUsername(@RequestBody UpdateField updateField,
			@PathParam("username") String username) throws UserDaoException {
		return userDao.updateUserByUsername(username, updateField);
	}

	@DELETE
	@Path("{username}")
	public @ResponseBody User delete(@PathParam("username") String username) throws UserDaoException {
		return userDao.deleteUserByUsername(username);
	}

	public void setUserDao(final UserDao userDao) {
		this.userDao = userDao;
	}

}
