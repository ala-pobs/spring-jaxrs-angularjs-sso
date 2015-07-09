package com.ncs.amaretto.cloud.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * Created by jomerp on 7/9/2015.
 */
@JsonPropertyOrder({ "userInfoId", "userName", "address", "status", "citizenship" })
public class UserInfo {

	@JsonProperty("UserInfoId")
	private int userInfoId;

	@JsonProperty("UserName")
	private String userName;

	@JsonProperty("Address")
	private String address;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("Citizenship")
	private String citizenship;

	public static final UserInfo newInstance(int userInfoId, String address, String status, String citizenship) {
		UserInfo userInfo = new UserInfo();

		userInfo.userInfoId = userInfoId;
		userInfo.address = address;
		userInfo.status = status;
		userInfo.citizenship = citizenship;

		return userInfo;
	}

	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

}
