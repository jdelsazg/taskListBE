package com.capgemini.tasklist.tasklistmanagement.dataaccess.api;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.capgemini.tasklist.collectionlistmanagement.dataaccess.api.CollectionListEntity;
import com.capgemini.tasklist.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.tasklist.tasklistmanagement.common.api.TaskList;

@Entity
@Table(name = "TaskList")
public class TaskListEntity extends ApplicationPersistenceEntity implements TaskList {

	@NotNull
	private String name;

	private Timestamp creationDate;

	private List<CollectionListEntity> listCollection;

	private static final long serialVersionUID = 1L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="id_listas")
	//@OneToMany(mappedBy = "taskList", fetch = FetchType.EAGER)
	public List<CollectionListEntity> getListCollection() {
		return listCollection;
	}

	public void setListCollection(List<CollectionListEntity> listCollection) {
		this.listCollection = listCollection;
	}

}
