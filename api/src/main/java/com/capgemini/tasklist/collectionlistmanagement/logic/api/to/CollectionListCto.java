package com.capgemini.tasklist.collectionlistmanagement.logic.api.to;

import java.util.List;

import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of CollectionList
 */
public class CollectionListCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private CollectionListEto collectionList;

	private List<ItemEto> items;

	public CollectionListEto getCollectionList() {
		return collectionList;
	}

	public void setCollectionList(CollectionListEto collectionList) {
		this.collectionList = collectionList;
	}

	public List<ItemEto> getItems() {
		return items;
	}

	public void setItems(List<ItemEto> items) {
		this.items = items;
	}

}
