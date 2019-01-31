package com.capgemini.tasklist.itemmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.capgemini.tasklist.itemmanagement.common.api.Item}s.
 */
public class ItemSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private Integer ordinal;
	private Timestamp creationDate;

	private Long textId;

	private Long fileId;

	/**
	 * @return ordinalId
	 */

	public Integer getOrdinal() {
		return ordinal;
	}

	/**
	 * @param ordinal setter for ordinal attribute
	 */

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

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
	 * getter for textId attribute
	 *
	 * @return textId
	 */

	public Long getTextId() {
		return textId;
	}

	/**
	 * @param text setter for text attribute
	 */

	public void setTextId(Long textId) {
		this.textId = textId;
	}

	/**
	 * getter for fileId attribute
	 *
	 * @return fileId
	 */

	public Long getFileId() {
		return fileId;
	}

	/**
	 * @param file setter for file attribute
	 */

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

}
