package com.ncs.amaretto.cloud.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.reflect.FieldUtils;

import com.ncs.amaretto.cloud.dao.UserDao;
import com.ncs.amaretto.cloud.dao.UserDaoException;
import com.ncs.amaretto.cloud.model.UpdateField;
import com.ncs.amaretto.cloud.model.User;

public class UserDaoMapImpl implements UserDao {
    private Map<String, User> userMap = new HashMap<String, User>();
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    @Override
    public User createUser(User newUser) throws UserDaoException {
        newUser.setUserId(ID_GENERATOR.incrementAndGet());
        userMap.put(newUser.getUsername(), newUser);
        
        return userMap.get(newUser.getUsername());
    }

    @Override
    public List<User> retrieveAllUsers() throws UserDaoException {
        return new ArrayList<User>(userMap.values());
    }

    @Override
    public User retriveUserByUsername(String username) throws UserDaoException {
        return userMap.get(username);
    }

    @Override
    public User updateUserByUsername(String username, UpdateField updateField) throws UserDaoException {
        User userToBeUpdated = userMap.get(username);
        if (userToBeUpdated == null) {
            throw new UserDaoException("User '" + username + "' does not exists.");
        }

        try {
            FieldUtils.writeDeclaredField(userToBeUpdated, updateField.getFieldName(), updateField.getFieldValue(),
                    true);

        } catch (IllegalAccessException e) {
            throw new UserDaoException(e.getMessage());
        }

        userMap.put(username, userToBeUpdated);
        return userMap.get(username);

    }

    @Override
    public User deleteUserByUsername(String username) throws UserDaoException {
        return userMap.remove(username);
    }

}
