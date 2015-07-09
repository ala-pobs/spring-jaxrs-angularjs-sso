package com.ncs.amaretto.cloud.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang.reflect.FieldUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ncs.amaretto.cloud.dao.UserDao;
import com.ncs.amaretto.cloud.dao.UserDaoException;
import com.ncs.amaretto.cloud.model.UpdateField;
import com.ncs.amaretto.cloud.model.User;

public class UserDaoMapImplTest {
    private UserDao userDao;
    private String username = "username";

    @Before
    public void setup() {
        userDao = new UserDaoMapImpl();
    }

    @After
    public void destroy() {
        userDao = null;
    }

    @Test
    public void given_NewUser_when_Added_then_UserExists() throws IllegalAccessException {

        // GIVEN
        User newUser = User.newInstance(1, username, "password", "username@email.com");

        // WHEN
        try {
            userDao.createUser(newUser);
        } catch (UserDaoException e) {
            fail(e.getMessage());
        }

        // THEN
        try {
            User existingUser = userDao.retriveUserByUsername(username);
            assertNotNull(existingUser);

            Field[] userClazzFields = User.class.getFields();

            for (Field field : userClazzFields) {
                Object expected = FieldUtils.readDeclaredField(newUser, field.getName(), true);
                Object actual = FieldUtils.readDeclaredField(existingUser, field.getName(), true);

                assertEquals(expected, actual);
            }
        } catch (UserDaoException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void given_ExistingUser_when_UserFieldIsUpdated_then_UserFieldIsUpdated() throws IllegalAccessException {

        // GIVEN
        given_NewUser_when_Added_then_UserExists();

        // WHEN
        String emailAddressFieldName = "emailAddress";
        String emailAddressFieldValue = "updated@email.com";

        UpdateField updateField = UpdateField.newInstance(emailAddressFieldName, emailAddressFieldValue);
        try {
            userDao.updateUserByUsername(username, updateField);
        } catch (UserDaoException e) {
            fail(e.getMessage());
        }

        // THEN
        try {
            User updatedUser = userDao.retriveUserByUsername(username);
            Object actual = FieldUtils.readDeclaredField(updatedUser, emailAddressFieldName, true);

            assertEquals(emailAddressFieldValue, actual);
        } catch (UserDaoException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void given_ExistingUser_when_RetrieveAll_then_AllUsersWillBeRetrieve() throws IllegalAccessException {
        // GIVEN
        given_NewUser_when_Added_then_UserExists();

        // WHEN
        List<User> userList = null;
        try {
            userList = userDao.retrieveAllUsers();
        } catch (UserDaoException e) {
            fail(e.getMessage());
        }

        // THEN
        assertEquals(1, userList.size());
    }

}
