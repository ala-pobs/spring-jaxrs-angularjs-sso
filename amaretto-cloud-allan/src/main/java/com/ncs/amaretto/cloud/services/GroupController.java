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

import com.ncs.amaretto.cloud.dao.GroupDao;
import com.ncs.amaretto.cloud.dao.GroupDaoException;
import com.ncs.amaretto.cloud.model.Group;
import com.ncs.amaretto.cloud.model.UpdateField;

@Path("/groups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupController {
    private GroupDao groupDao;

    @POST
    public @ResponseBody
    Group createGroup(@RequestBody
    		Group newGroup) throws GroupDaoException {
        return groupDao.createGroup(newGroup);
    }

    @GET
    public @ResponseBody
    List<Group> retriveAllGroups() throws GroupDaoException {
        return groupDao.retrieveAllGroups();
    }

    @GET
    @Path("{groupname}")
    public @ResponseBody
    Group retrieveUserByGroupname(@PathParam("groupname")
    String username) throws GroupDaoException {
        Group group = groupDao.retriveGroupByGroupname(username);
        return group;
    }

    @PUT
    @Path("{groupname}")
    public @ResponseBody
    Group updateGroupByUsername(@RequestBody
    UpdateField updateField, @PathParam("groupname")
    String groupname) throws GroupDaoException {
        return groupDao.updateGroupByGroupname(groupname, updateField);
    }

    @DELETE
    @Path("{groupname}")
    public @ResponseBody
    Group delete(@PathParam("groupname")
    String groupname) throws GroupDaoException {
        return groupDao.deleteGroupByGroupname(groupname);
    }

    public void setGroupDao(final GroupDao userDao) {
        this.groupDao = userDao;
    }
}