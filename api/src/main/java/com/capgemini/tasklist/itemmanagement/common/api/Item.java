package com.capgemini.tasklist.itemmanagement.common.api;

import java.sql.Timestamp;

import com.capgemini.tasklist.general.common.api.ApplicationEntity;

public interface Item extends ApplicationEntity {

	/**
	 * @return ordinalId
	 */

	public int getOrdinal();

	/**
	 * @param ordinal setter for ordinal attribute
	 */

	public void setOrdinal(int ordinal);

	/**
	 * @return creationDateId
	 */

	public Timestamp getCreationDate();

	/**
	 * @param creationDate setter for creationDate attribute
	 */

	public void setCreationDate(Timestamp creationDate);

	/**
	 * getter for textId attribute
	 *
	 * @return textId
	 */

	public Long getTextId();

	/**
	 * @param text setter for text attribute
	 */

	public void setTextId(Long textId);

	/**
	 * getter for fileId attribute
	 *
	 * @return fileId
	 */

	public Long getFileId();

	/**
	 * @param file setter for file attribute
	 */

	public void setFileId(Long fileId);

}
