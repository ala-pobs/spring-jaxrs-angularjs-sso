package com.ncs.amaretto.cloud.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ncs.amaretto.cloud.model.Role;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoleController {

	List<Role> listRoles = new ArrayList<>();

	@POST
	public @ResponseBody Role createRole(@RequestBody Role newRole) {
		listRoles.add(newRole);
		return newRole;
	}

	@GET
	public @ResponseBody List<Role> retriveAllRoles() {
		return listRoles;
	}

}
