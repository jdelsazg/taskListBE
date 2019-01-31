package com.capgemini.tasklist.textitemmanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemCto;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemSearchCriteriaTo;

public interface UcFindTextItem {

	/**
	 * Returns a composite TextItem by its id 'id'.
	 *
	 * @param id The id 'id' of the TextItem.
	 * @return The {@link TextItemCto} with id 'id'
	 */
	TextItemCto findTextItemCto(long id);

	/**
	 * Returns a paginated list of composite TextItems matching the search criteria.
	 *
	 * @param criteria the {@link TextItemSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link TextItemCto}s.
	 */
	Page<TextItemCto> findTextItemCtos(TextItemSearchCriteriaTo criteria);

}
