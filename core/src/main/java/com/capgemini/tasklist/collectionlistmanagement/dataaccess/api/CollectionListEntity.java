package com.capgemini.tasklist.collectionlistmanagement.dataaccess.api;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.capgemini.tasklist.collectionlistmanagement.common.api.CollectionList;
import com.capgemini.tasklist.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.tasklist.itemmanagement.dataaccess.api.ItemEntity;

@Entity
@Table(name = "List")
public class CollectionListEntity extends ApplicationPersistenceEntity implements CollectionList {

	@NotNull
	private String name;

	private Timestamp creationDate;


	private Long idTaskList;

	@NotNull
	private int orderList;

	@NotNull
	private Boolean active;

	private List<ItemEntity> items;

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

	public int getOrderList() {
		return orderList;
	}

	public void setOrderList(int orderList) {
		this.orderList = orderList;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idList")
	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	@Column(name="id_listas")
	public Long getIdTaskList() {
		return idTaskList;
	}

	public void setIdTaskList(Long idTaskList) {
		this.idTaskList = idTaskList;
	}



}
