package com.capgemini.tasklist.textitemmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.textitemmanagement.common.api.TextItem;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of TextItem
 */
public class TextItemEto extends AbstractEto implements TextItem {

	private static final long serialVersionUID = 1L;

	private String text;
	private Timestamp creationDate;

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
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
		result = prime * result + ((this.text == null) ? 0 : this.text.hashCode());
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
		TextItemEto other = (TextItemEto) obj;
		if (this.text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!this.text.equals(other.text)) {
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

	public String printEto() {
		return this.getText();
	}
}
