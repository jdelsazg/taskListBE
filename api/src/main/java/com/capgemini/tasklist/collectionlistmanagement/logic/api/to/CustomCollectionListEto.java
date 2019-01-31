package com.capgemini.tasklist.collectionlistmanagement.logic.api.to;

import java.sql.Timestamp;
import java.util.List;

import com.capgemini.tasklist.itemmanagement.logic.api.to.CustomItemEto;

public class CustomCollectionListEto {

	private static final long serialVersionUID = 1L;

	private String name;
	private Timestamp creationDate;
	private int orderList;
	private Boolean active;
	private List<CustomItemEto> items;


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

	public List<CustomItemEto> getItems() {
		return items;
	}

	public void setItems(List<CustomItemEto> items) {
		this.items = items;
	}

}
