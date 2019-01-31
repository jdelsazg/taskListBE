package com.capgemini.tasklist.itemmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.itemmanagement.common.api.Item;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Item
 */
public class ItemEto extends AbstractEto implements Item {

	private static final long serialVersionUID = 1L;

	private int ordinal;
	private Timestamp creationDate;

	private Long textId;

	private Long fileId;

	@Override
	public int getOrdinal() {
		return ordinal;
	}

	@Override
	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
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
	public Long getTextId() {
		return textId;
	}

	@Override
	public void setTextId(Long textId) {
		this.textId = textId;
	}

	@Override
	public Long getFileId() {
		return fileId;
	}

	@Override
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Integer) ordinal).hashCode();
		result = prime * result + ((this.creationDate == null) ? 0 : this.creationDate.hashCode());

		result = prime * result + ((this.textId == null) ? 0 : this.textId.hashCode());

		result = prime * result + ((this.fileId == null) ? 0 : this.fileId.hashCode());
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
		ItemEto other = (ItemEto) obj;
		if (this.ordinal != other.ordinal) {
			return false;
		}
		if (this.creationDate == null) {
			if (other.creationDate != null) {
				return false;
			}
		} else if (!this.creationDate.equals(other.creationDate)) {
			return false;
		}

		if (this.textId == null) {
			if (other.textId != null) {
				return false;
			}
		} else if (!this.textId.equals(other.textId)) {
			return false;
		}

		if (this.fileId == null) {
			if (other.fileId != null) {
				return false;
			}
		} else if (!this.fileId.equals(other.fileId)) {
			return false;
		}
		return true;
	}

	public String printEto() {
		return "Order: " + this.getOrdinal() + " creationDate: " + this.getCreationDate();
	}
}
