package com.capgemini.tasklist.itemmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.tasklist.general.logic.base.AbstractUc;
import com.capgemini.tasklist.itemmanagement.dataaccess.api.repo.ItemRepository;

/**
 * Abstract use case for Items, which provides access to the commonly necessary
 * data access objects.
 */
public class AbstractItemUc extends AbstractUc {

	/** @see #getItemRepository() */
	@Inject
	private ItemRepository itemRepository;

	/**
	 * Returns the field 'itemRepository'.
	 * 
	 * @return the {@link ItemRepository} instance.
	 */
	public ItemRepository getItemRepository() {

		return this.itemRepository;
	}

}
