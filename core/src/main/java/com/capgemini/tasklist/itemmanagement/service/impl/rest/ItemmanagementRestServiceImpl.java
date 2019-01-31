package com.capgemini.tasklist.itemmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.itemmanagement.logic.api.Itemmanagement;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemCto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemSearchCriteriaTo;
import com.capgemini.tasklist.itemmanagement.service.api.rest.ItemmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Itemmanagement}.
 */
@Named("ItemmanagementRestService")
public class ItemmanagementRestServiceImpl implements ItemmanagementRestService {

	@Inject
	private Itemmanagement itemmanagement;

	@Override
	public ItemCto getItemCto(long id) {
		return this.itemmanagement.findItemCto(id);
	}

	@Override
	public Page<ItemCto> findItemCtos(ItemSearchCriteriaTo searchCriteriaTo) {
		return this.itemmanagement.findItemCtos(searchCriteriaTo);
	}
}