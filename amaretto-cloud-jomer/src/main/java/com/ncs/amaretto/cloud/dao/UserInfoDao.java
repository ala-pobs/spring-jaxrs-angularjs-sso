package com.ncs.amaretto.cloud.dao;

import java.util.List;

import com.ncs.amaretto.cloud.exception.UserInfoException;
import com.ncs.amaretto.cloud.model.UserInfo;

public interface UserInfoDao {

	public UserInfo createUser(UserInfo newUser) throws UserInfoException;

	public List<UserInfo> retrieveAllUsers() throws UserInfoException;

	public UserInfo retriveUserByUsername(String username) throws UserInfoException;

	public UserInfo deleteUserByUsername(String username) throws UserInfoException;
}
