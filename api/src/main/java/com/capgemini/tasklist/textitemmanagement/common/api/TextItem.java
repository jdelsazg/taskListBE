package com.capgemini.tasklist.textitemmanagement.common.api;

import java.sql.Timestamp;

import com.capgemini.tasklist.general.common.api.ApplicationEntity;

public interface TextItem extends ApplicationEntity {

	/**
	 * @return textId
	 */

	public String getText();

	/**
	 * @param text setter for text attribute
	 */

	public void setText(String text);

	/**
	 * @return creationDateId
	 */

	public Timestamp getCreationDate();

	/**
	 * @param creationDate setter for creationDate attribute
	 */

	public void setCreationDate(Timestamp creationDate);

}
