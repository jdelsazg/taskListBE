package com.capgemini.tasklist.custommanagement.logic.api.to;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CustomCollectionListEto;

public class CustomTaskListCto {

	private static final long serialVersionUID = 1L;

	private String nombreTaskList;
	private Timestamp creationDateTaskList;
	private String lists;
	private String items;


	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getLists() {
		return lists;
	}

	public void setLists(String lists) {
		this.lists = lists;
	}

	public String getNombreTaskList() {
		return nombreTaskList;
	}

	public void setNombreTaskList(String nombreTaskList) {
		this.nombreTaskList = nombreTaskList;
	}

	public Timestamp getCreationDateTaskList() {
		return creationDateTaskList;
	}

	public void setCreationDateTaskList(Timestamp creationDateTaskList) {
		this.creationDateTaskList = creationDateTaskList;
	}

}
