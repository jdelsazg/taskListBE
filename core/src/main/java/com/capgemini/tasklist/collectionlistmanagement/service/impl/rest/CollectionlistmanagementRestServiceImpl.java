package com.capgemini.tasklist.collectionlistmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.collectionlistmanagement.logic.api.Collectionlistmanagement;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListCto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListSearchCriteriaTo;
import com.capgemini.tasklist.collectionlistmanagement.service.api.rest.CollectionlistmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Collectionlistmanagement}.
 */
@Named("CollectionlistmanagementRestService")
public class CollectionlistmanagementRestServiceImpl implements CollectionlistmanagementRestService {

	@Inject
	private Collectionlistmanagement collectionlistmanagement;

	@Override
	public CollectionListCto getCollectionListCto(long id) {
		return this.collectionlistmanagement.findCollectionListCto(id);
	}

	@Override
	public Page<CollectionListCto> findCollectionListCtos(CollectionListSearchCriteriaTo searchCriteriaTo) {
		return this.collectionlistmanagement.findCollectionListCtos(searchCriteriaTo);
	}
}