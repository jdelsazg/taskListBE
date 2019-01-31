package com.capgemini.tasklist.collectionlistmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.tasklist.collectionlistmanagement.dataaccess.api.repo.CollectionListRepository;
import com.capgemini.tasklist.general.logic.base.AbstractUc;

/**
 * Abstract use case for CollectionLists, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractCollectionListUc extends AbstractUc {

	/** @see #getCollectionListRepository() */
	@Inject
	private CollectionListRepository collectionListRepository;

	/**
	 * Returns the field 'collectionListRepository'.
	 * 
	 * @return the {@link CollectionListRepository} instance.
	 */
	public CollectionListRepository getCollectionListRepository() {

		return this.collectionListRepository;
	}

}
