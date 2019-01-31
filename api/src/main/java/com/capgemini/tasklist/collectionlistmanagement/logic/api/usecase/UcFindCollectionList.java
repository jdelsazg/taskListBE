package com.capgemini.tasklist.collectionlistmanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListCto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListEto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListSearchCriteriaTo;

public interface UcFindCollectionList {

	/**
	 * Returns a composite CollectionList by its id 'id'.
	 *
	 * @param id The id 'id' of the CollectionList.
	 * @return The {@link CollectionListCto} with id 'id'
	 */
	CollectionListCto findCollectionListCto(long id);

	/**
	 * Returns a paginated list of composite CollectionLists matching the search
	 * criteria.
	 *
	 * @param criteria the {@link CollectionListSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link CollectionListCto}s.
	 */
	Page<CollectionListCto> findCollectionListCtos(CollectionListSearchCriteriaTo criteria);

	List<CollectionListEto> findCollectionListByIdTaskList(long id);

}
