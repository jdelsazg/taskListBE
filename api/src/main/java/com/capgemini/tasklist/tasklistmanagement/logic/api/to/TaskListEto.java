package com.capgemini.tasklist.tasklistmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.tasklistmanagement.common.api.TaskList;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of TaskList
 */
public class TaskListEto extends AbstractEto implements TaskList {

	private static final long serialVersionUID = 1L;

	private String name;
	private Timestamp creationDate;

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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.creationDate == null) ? 0 : this.creationDate.hashCode());

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
		TaskListEto other = (TaskListEto) obj;
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

		return true;
	}
}
