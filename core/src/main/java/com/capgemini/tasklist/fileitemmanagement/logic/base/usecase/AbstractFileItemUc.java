package com.capgemini.tasklist.fileitemmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.tasklist.fileitemmanagement.dataaccess.api.repo.FileItemRepository;
import com.capgemini.tasklist.general.logic.base.AbstractUc;

/**
 * Abstract use case for FileItems, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractFileItemUc extends AbstractUc {

	/** @see #getFileItemRepository() */
	@Inject
	private FileItemRepository fileItemRepository;

	/**
	 * Returns the field 'fileItemRepository'.
	 * 
	 * @return the {@link FileItemRepository} instance.
	 */
	public FileItemRepository getFileItemRepository() {

		return this.fileItemRepository;
	}

}
