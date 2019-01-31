package com.capgemini.tasklist.fileitemmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.capgemini.tasklist.fileitemmanagement.common.api.FileItem}s.
 */
public class FileItemSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private Timestamp creationDate;
	private byte[] file;

	/**
	 * @return creationDateId
	 */

	public Timestamp getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate setter for creationDate attribute
	 */

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return fileId
	 */

	public byte[] getFile() {
		return file;
	}

	/**
	 * @param file setter for file attribute
	 */

	public void setFile(byte[] file) {
		this.file = file;
	}

}
