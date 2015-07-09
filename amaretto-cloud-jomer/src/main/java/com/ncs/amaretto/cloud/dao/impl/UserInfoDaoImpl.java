package com.ncs.amaretto.cloud.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.ncs.amaretto.cloud.dao.UserInfoDao;
import com.ncs.amaretto.cloud.exception.UserInfoException;
import com.ncs.amaretto.cloud.model.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao {

	private Map<String, UserInfo> userInfoMap = Collections.synchronizedMap(new HashMap<String, UserInfo>());
	private static final AtomicInteger SEQ_ID = new AtomicInteger(0);

	@Override
	public UserInfo createUser(UserInfo newUser) throws UserInfoException {
		newUser.setUserInfoId(SEQ_ID.incrementAndGet());
		userInfoMap.put(newUser.getUserName(), newUser);
		return userInfoMap.get(newUser.getUserName());
	}

	@Override
	public List<UserInfo> retrieveAllUsers() throws UserInfoException {
		return new ArrayList<UserInfo>(userInfoMap.values());
	}

	@Override
	public UserInfo retriveUserByUsername(String username) throws UserInfoException {
		return userInfoMap.get(username);
	}

	@Override
	public UserInfo deleteUserByUsername(String username) throws UserInfoException {
		return userInfoMap.remove(username);
	}

}
