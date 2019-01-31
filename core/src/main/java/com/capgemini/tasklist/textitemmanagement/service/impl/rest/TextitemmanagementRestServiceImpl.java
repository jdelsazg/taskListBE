package com.capgemini.tasklist.textitemmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.textitemmanagement.logic.api.Textitemmanagement;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemCto;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemSearchCriteriaTo;
import com.capgemini.tasklist.textitemmanagement.service.api.rest.TextitemmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Textitemmanagement}.
 */
@Named("TextitemmanagementRestService")
public class TextitemmanagementRestServiceImpl implements TextitemmanagementRestService {

	@Inject
	private Textitemmanagement textitemmanagement;

	@Override
	public TextItemCto getTextItemCto(long id) {
		return this.textitemmanagement.findTextItemCto(id);
	}

	@Override
	public Page<TextItemCto> findTextItemCtos(TextItemSearchCriteriaTo searchCriteriaTo) {
		return this.textitemmanagement.findTextItemCtos(searchCriteriaTo);
	}
}