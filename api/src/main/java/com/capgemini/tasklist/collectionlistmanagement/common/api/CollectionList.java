package com.capgemini.tasklist.collectionlistmanagement.common.api;

import java.sql.Timestamp;

import com.capgemini.tasklist.general.common.api.ApplicationEntity;

public interface CollectionList extends ApplicationEntity {

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

	/**
	 * @return orderListId
	 */

	public int getOrderList();

	/**
	 * @param orderList setter for orderList attribute
	 */

	public void setOrderList(int orderList);

	/**
	 * @return activeId
	 */

	public Boolean getActive();

	/**
	 * @param active setter for active attribute
	 */

	public void setActive(Boolean active);

}
