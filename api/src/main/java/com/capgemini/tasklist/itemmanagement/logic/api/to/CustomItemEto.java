package com.capgemini.tasklist.itemmanagement.logic.api.to;

import java.sql.Timestamp;

import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemEto;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemEto;

public class CustomItemEto {

	private static final long serialVersionUID = 1L;

	private int ordinal;
	private Timestamp creationDate;
	private FileItemEto file;
	private TextItemEto text;

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

	public FileItemEto getFile() {
		return file;
	}

	public void setFile(FileItemEto file) {
		this.file = file;
	}

	public TextItemEto getText() {
		return text;
	}

	public void setText(TextItemEto text) {
		this.text = text;
	}

}
