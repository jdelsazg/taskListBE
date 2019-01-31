package com.capgemini.tasklist.collectionlistmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.collectionlistmanagement.common.api.CollectionList;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of CollectionList
 */
public class CollectionListEto extends AbstractEto implements CollectionList {

	private static final long serialVersionUID = 1L;

	private String name;
	private Timestamp creationDate;
	private int orderList;
	private Boolean active;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Timestamp getCreationDate() {
		return creationDate;
	}

	@Override
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int getOrderList() {
		return orderList;
	}

	@Override
	public void setOrderList(int orderList) {
		this.orderList = orderList;
	}

	@Override
	public Boolean getActive() {
		return active;
	}

	@Override
	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.creationDate == null) ? 0 : this.creationDate.hashCode());
		result = prime * result + ((Integer) orderList).hashCode();
		result = prime * result + ((this.active == null) ? 0 : this.active.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// class check will be done by super type EntityTo!
		if (!super.equals(obj)) {
			return false;
		}
		CollectionListEto other = (CollectionListEto) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.creationDate == null) {
			if (other.creationDate != null) {
				return false;
			}
		} else if (!this.creationDate.equals(other.creationDate)) {
			return false;
		}
		if (this.orderList != other.orderList) {
			return false;
		}
		if (this.active == null) {
			if (other.active != null) {
				return false;
			}
		} else if (!this.active.equals(other.active)) {
			return false;
		}

		return true;
	}

	public String printEto() {
		return getName() + "?" + getCreationDate() + "?" + getOrderList() + "?" + getActive();
	}
}
