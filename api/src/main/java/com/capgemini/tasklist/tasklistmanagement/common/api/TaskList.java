package com.capgemini.tasklist.tasklistmanagement.common.api;

import java.sql.Timestamp;

import com.capgemini.tasklist.general.common.api.ApplicationEntity;

public interface TaskList extends ApplicationEntity {

	/**
	 * @return nameId
	 */

	public String getName();

	/**
	 * @param name setter for name attribute
	 */

	public void setName(String name);

	/**
	 * @return creationDateId
	 */

	public Timestamp getCreationDate();

	/**
	 * @param creationDate setter for creationDate attribute
	 */

	public void setCreationDate(Timestamp creationDate);

}
