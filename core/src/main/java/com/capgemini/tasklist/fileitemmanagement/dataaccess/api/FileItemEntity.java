package com.capgemini.tasklist.fileitemmanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.capgemini.tasklist.fileitemmanagement.common.api.FileItem;
import com.capgemini.tasklist.general.dataaccess.api.ApplicationPersistenceEntity;

@Entity
@Table(name = "FileItem")
public class FileItemEntity extends ApplicationPersistenceEntity implements FileItem {

	private Timestamp creationDate;

	@Lob
	@Column(length = 100000)
	@NotNull
	private byte[] file;

	private Long idItem;

	private static final long serialVersionUID = 1L;

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
