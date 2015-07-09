package com.ncs.amaretto.cloud.dao;

import java.util.List;

import com.ncs.amaretto.cloud.model.Group;
import com.ncs.amaretto.cloud.model.UpdateField;

public interface GroupDao {

    // create group
    public Group createGroup(Group newGroup) throws GroupDaoException;

    // retrieve all group
    public List<Group> retrieveAllGroups() throws GroupDaoException;

    // retrieve group by groupname
    public Group retriveGroupByGroupname(String groupname) throws GroupDaoException;

    // update group by groupname
    public Group updateGroupByGroupname(String groupname, UpdateField updateField) throws GroupDaoException;

    // delete group by groupname
    public Group deleteGroupByGroupname(String groupname) throws GroupDaoException;

}
