package com.capgemini.tasklist.textitemmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.tasklist.general.logic.base.AbstractUc;
import com.capgemini.tasklist.textitemmanagement.dataaccess.api.repo.TextItemRepository;

/**
 * Abstract use case for TextItems, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractTextItemUc extends AbstractUc {

	/** @see #getTextItemRepository() */
	@Inject
	private TextItemRepository textItemRepository;

	/**
	 * Returns the field 'textItemRepository'.
	 * 
	 * @return the {@link TextItemRepository} instance.
	 */
	public TextItemRepository getTextItemRepository() {

		return this.textItemRepository;
	}

}
