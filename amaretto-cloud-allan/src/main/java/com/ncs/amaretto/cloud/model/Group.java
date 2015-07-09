package com.ncs.amaretto.cloud.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "groupId", "groupname", "groupdesc" })
public class Group {

	@JsonProperty("GroupId")
	private int groupId;

	@JsonProperty("Groupname")
	private String groupname;

	@JsonProperty("Groupdesc")
	private String groupdesc;

	public static final Group newInstance(int groupId, String groupname,
			String groupdesc) {
		Group group = new Group();

		group.groupId = groupId;
		group.groupname = groupname;
		group.groupdesc = groupdesc;

		return group;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getGroupdesc() {
		return groupdesc;
	}

	public void setGroupdesc(String groupdesc) {
		this.groupdesc = groupdesc;
	}
}
