package com.capgemini.tasklist.collectionlistmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.capgemini.tasklist.collectionlistmanagement.common.api.CollectionList}s.
 */
public class CollectionListSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String name;
	private Timestamp creationDate;
	private Integer orderList;
	private Boolean active;

	private StringSearchConfigTo nameOption;

	/**
	 * @return nameId
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name setter for name attribute
	 */

	public void setName(String name) {
		this.name = name;
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
	 * @return orderListId
	 */

	public Integer getOrderList() {
		return orderList;
	}

	/**
	 * @param orderList setter for orderList attribute
	 */

	public void setOrderList(Integer orderList) {
		this.orderList = orderList;
	}

	/**
	 * @return activeId
	 */

	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active setter for active attribute
	 */

	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for {@link #getName()
	 *         name}.
	 */
	public StringSearchConfigTo getNameOption() {

		return this.nameOption;
	}

	/**
	 * @param nameOption new value of {@link #getNameOption()}.
	 */
	public void setNameOption(StringSearchConfigTo nameOption) {

		this.nameOption = nameOption;
	}

}
