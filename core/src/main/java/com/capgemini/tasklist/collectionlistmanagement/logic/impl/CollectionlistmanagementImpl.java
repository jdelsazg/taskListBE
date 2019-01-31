package com.capgemini.tasklist.collectionlistmanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.collectionlistmanagement.logic.api.Collectionlistmanagement;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListCto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListEto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListSearchCriteriaTo;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.usecase.UcFindCollectionList;
import com.capgemini.tasklist.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of collectionlistmanagement
 */
@Named
public class CollectionlistmanagementImpl extends AbstractComponentFacade implements Collectionlistmanagement {

	@Inject
	private UcFindCollectionList ucFindCollectionList;

	@Override
	public CollectionListCto findCollectionListCto(long id) {

		return ucFindCollectionList.findCollectionListCto(id);
	}

	@Override
	public Page<CollectionListCto> findCollectionListCtos(CollectionListSearchCriteriaTo criteria) {

		return ucFindCollectionList.findCollectionListCtos(criteria);
	}

	@Override
	public List<CollectionListEto> findCollectionListByIdTaskList(long id) {
		return ucFindCollectionList.findCollectionListByIdTaskList(id);
	}
}
