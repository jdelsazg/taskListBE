package com.capgemini.tasklist.itemmanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemCto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemEto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemSearchCriteriaTo;

public interface UcFindItem {

	/**
	 * Returns a composite Item by its id 'id'.
	 *
	 * @param id The id 'id' of the Item.
	 * @return The {@link ItemCto} with id 'id'
	 */
	ItemCto findItemCto(long id);

	/**
	 * Returns a paginated list of composite Items matching the search criteria.
	 *
	 * @param criteria the {@link ItemSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link ItemCto}s.
	 */
	Page<ItemCto> findItemCtos(ItemSearchCriteriaTo criteria);

	List<ItemCto> findItemByIdList(long id);

}
