package com.capgemini.tasklist.fileitemmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.fileitemmanagement.common.api.FileItem;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of FileItem
 */
public class FileItemEto extends AbstractEto implements FileItem {

	private static final long serialVersionUID = 1L;

	private Timestamp creationDate;
	private byte[] file;

	@Override
	public Timestamp getCreationDate() {
		return creationDate;
	}

	@Override
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public byte[] getFile() {
		return file;
	}

	@Override
	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.creationDate == null) ? 0 : this.creationDate.hashCode());
		result = prime * result + ((this.file == null) ? 0 : this.file.hashCode());
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
		FileItemEto other = (FileItemEto) obj;
		if (this.creationDate == null) {
			if (other.creationDate != null) {
				return false;
			}
		} else if (!this.creationDate.equals(other.creationDate)) {
			return false;
		}
		if (this.file == null) {
			if (other.file != null) {
				return false;
			}
		} else if (!this.file.equals(other.file)) {
			return false;
		}
		return true;
	}

	public String printEto() {
		return this.getFile().toString();
	}
}
