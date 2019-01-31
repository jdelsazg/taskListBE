package com.capgemini.tasklist.textitemmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.capgemini.tasklist.textitemmanagement.common.api.TextItem}s.
 */
public class TextItemSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String text;
	private Timestamp creationDate;
	private StringSearchConfigTo textOption;

	/**
	 * @return textId
	 */

	public String getText() {
		return text;
	}

	/**
	 * @param text setter for text attribute
	 */

	public void setText(String text) {
		this.text = text;
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
	 * @return the {@link StringSearchConfigTo} used to search for {@link #getText()
	 *         text}.
	 */
	public StringSearchConfigTo getTextOption() {

		return this.textOption;
	}

	/**
	 * @param textOption new value of {@link #getTextOption()}.
	 */
	public void setTextOption(StringSearchConfigTo textOption) {

		this.textOption = textOption;
	}

}
