package com.ncs.amaretto.cloud.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.reflect.FieldUtils;

import com.ncs.amaretto.cloud.dao.GroupDao;
import com.ncs.amaretto.cloud.dao.GroupDaoException;
import com.ncs.amaretto.cloud.model.UpdateField;
import com.ncs.amaretto.cloud.model.Group;

public class GroupDaoMapImpl implements GroupDao {
    private Map<String, Group> groupMap = new HashMap<String, Group>();
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    @Override
    public Group createGroup(Group newGroup) throws GroupDaoException {
        newGroup.setGroupId(ID_GENERATOR.incrementAndGet());
        groupMap.put(newGroup.getGroupname(), newGroup);
        
        return groupMap.get(newGroup.getGroupname());
    }

    @Override
    public List<Group> retrieveAllGroups() throws GroupDaoException {
        return new ArrayList<Group>(groupMap.values());
    }

    @Override
    public Group retriveGroupByGroupname(String groupname) throws GroupDaoException {
        return groupMap.get(groupname);
    }

    @Override
    public Group updateGroupByGroupname(String groupname, UpdateField updateField) throws GroupDaoException {
        Group groupToBeUpdated = groupMap.get(groupname);
        if (groupToBeUpdated == null) {
            throw new GroupDaoException("Group '" + groupname + "' does not exists.");
        }

        try {
            FieldUtils.writeDeclaredField(groupToBeUpdated, updateField.getFieldName(), updateField.getFieldValue(),
                    true);

        } catch (IllegalAccessException e) {
            throw new GroupDaoException(e.getMessage());
        }

        groupMap.put(groupname, groupToBeUpdated);
        return groupMap.get(groupname);

    }

    @Override
    public Group deleteGroupByGroupname(String groupname) throws GroupDaoException {
        return groupMap.remove(groupname);
    }

}
