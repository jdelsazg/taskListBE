package com.capgemini.tasklist.itemmanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.general.logic.base.AbstractComponentFacade;
import com.capgemini.tasklist.itemmanagement.logic.api.Itemmanagement;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemCto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemEto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemSearchCriteriaTo;
import com.capgemini.tasklist.itemmanagement.logic.api.usecase.UcFindItem;

/**
 * Implementation of component interface of itemmanagement
 */
@Named
public class ItemmanagementImpl extends AbstractComponentFacade implements Itemmanagement {

	@Inject
	private UcFindItem ucFindItem;

	@Override
	public ItemCto findItemCto(long id) {

		return ucFindItem.findItemCto(id);
	}

	@Override
	public Page<ItemCto> findItemCtos(ItemSearchCriteriaTo criteria) {

		return ucFindItem.findItemCtos(criteria);
	}

	@Override
	public List<ItemCto> findItemByIdList(long id) {

		return ucFindItem.findItemByIdList(id);
	}
}
