package com.ncs.amaretto.cloud.dao;

import java.util.List;

import com.ncs.amaretto.cloud.model.UpdateField;
import com.ncs.amaretto.cloud.model.User;

public interface UserDao {

    // create user
    public User createUser(User newUser) throws UserDaoException;

    // retrieve all users
    public List<User> retrieveAllUsers() throws UserDaoException;

    // retrieve user by username
    public User retriveUserByUsername(String username) throws UserDaoException;

    // update user by username
    public User updateUserByUsername(String username, UpdateField updateField) throws UserDaoException;

    // delete user by username
    public User deleteUserByUsername(String username) throws UserDaoException;

}
