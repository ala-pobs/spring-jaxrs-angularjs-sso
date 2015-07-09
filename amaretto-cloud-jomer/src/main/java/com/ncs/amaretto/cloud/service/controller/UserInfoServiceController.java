package com.ncs.amaretto.cloud.service.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ncs.amaretto.cloud.dao.UserInfoDao;
import com.ncs.amaretto.cloud.exception.UserInfoException;
import com.ncs.amaretto.cloud.model.UserInfo;

@Path("/userInfo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserInfoServiceController {

	private UserInfoDao userInfoDao;

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@POST
	public @ResponseBody UserInfo createUser(@RequestBody UserInfo newUser) throws UserInfoException {
		return userInfoDao.createUser(newUser);
	}

	@GET
	public @ResponseBody List<UserInfo> retriveAllUsers() throws UserInfoException {
		return userInfoDao.retrieveAllUsers();
	}

	@GET
	@Path("{userName}")
	public @ResponseBody UserInfo retrieveUserByUsername(@PathParam("userName") String userName)
			throws UserInfoException {
		UserInfo user = userInfoDao.retriveUserByUsername(userName);
		return user;
	}

	@DELETE
	@Path("{userName}")
	public @ResponseBody UserInfo delete(@PathParam("userName") String userName) throws UserInfoException {
		return userInfoDao.deleteUserByUsername(userName);
	}

}
