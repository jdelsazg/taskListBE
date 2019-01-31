package com.capgemini.tasklist.fileitemmanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemCto;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemSearchCriteriaTo;

public interface UcFindFileItem {

	/**
	 * Returns a composite FileItem by its id 'id'.
	 *
	 * @param id The id 'id' of the FileItem.
	 * @return The {@link FileItemCto} with id 'id'
	 */
	FileItemCto findFileItemCto(long id);

	/**
	 * Returns a paginated list of composite FileItems matching the search criteria.
	 *
	 * @param criteria the {@link FileItemSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link FileItemCto}s.
	 */
	Page<FileItemCto> findFileItemCtos(FileItemSearchCriteriaTo criteria);

}
