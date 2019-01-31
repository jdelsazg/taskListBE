package com.capgemini.tasklist.itemmanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.capgemini.tasklist.fileitemmanagement.dataaccess.api.FileItemEntity;
import com.capgemini.tasklist.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.tasklist.itemmanagement.common.api.Item;
import com.capgemini.tasklist.textitemmanagement.dataaccess.api.TextItemEntity;

@Entity
@Table(name = "Item")
public class ItemEntity extends ApplicationPersistenceEntity implements Item {

	@NotNull
	private int ordinal;

	private Timestamp creationDate;

	private TextItemEntity text;

	private FileItemEntity file;

	private Long idList;

	private static final long serialVersionUID = 1L;

	@Column(name="idList")
	public Long getIdList() {
		return idList;
	}

	public void setIdList(Long idList) {
		this.idList = idList;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idText")
	public TextItemEntity getText() {
		return text;
	}

	public void setText(TextItemEntity text) {
		this.text = text;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idFile")
	public FileItemEntity getFile() {
		return file;
	}

	public void setFile(FileItemEntity file) {
		this.file = file;
	}

	@Override
	@Transient
	public Long getTextId() {

		if (this.text == null) {
			return null;
		}
		return this.text.getId();
	}

	@Override
	public void setTextId(Long textId) {

		if (textId == null) {
			this.text = null;
		} else {
			TextItemEntity textItemEntity = new TextItemEntity();
			textItemEntity.setId(textId);
			this.text = textItemEntity;
		}
	}

	@Override
	@Transient
	public Long getFileId() {

		if (this.file == null) {
			return null;
		}
		return this.file.getId();
	}

	@Override
	public void setFileId(Long fileId) {

		if (fileId == null) {
			this.file = null;
		} else {
			FileItemEntity fileItemEntity = new FileItemEntity();
			fileItemEntity.setId(fileId);
			this.file = fileItemEntity;
		}
	}

}
