package com.capgemini.tasklist.fileitemmanagement.common.api;

import java.sql.Timestamp;

import com.capgemini.tasklist.general.common.api.ApplicationEntity;

public interface FileItem extends ApplicationEntity {

	/**
	 * @return creationDateId
	 */

	public Timestamp getCreationDate();

	/**
	 * @param creationDate setter for creationDate attribute
	 */

	public void setCreationDate(Timestamp creationDate);

	/**
	 * @return fileId
	 */

	public byte[] getFile();

	/**
	 * @param file setter for file attribute
	 */

	public void setFile(byte[] file);

}
