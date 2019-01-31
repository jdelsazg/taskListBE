package com.capgemini.tasklist.textitemmanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.capgemini.tasklist.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.tasklist.textitemmanagement.common.api.TextItem;

@Entity
@Table(name = "TextItem")
public class TextItemEntity extends ApplicationPersistenceEntity implements TextItem {

	@NotNull
	private String text;

	private Timestamp creationDate;

	private Long idItem;

	private static final long serialVersionUID = 1L;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}
