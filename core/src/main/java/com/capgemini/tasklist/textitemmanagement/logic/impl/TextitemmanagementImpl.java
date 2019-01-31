package com.capgemini.tasklist.textitemmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.general.logic.base.AbstractComponentFacade;
import com.capgemini.tasklist.textitemmanagement.logic.api.Textitemmanagement;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemCto;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemSearchCriteriaTo;
import com.capgemini.tasklist.textitemmanagement.logic.api.usecase.UcFindTextItem;

/**
 * Implementation of component interface of textitemmanagement
 */
@Named
public class TextitemmanagementImpl extends AbstractComponentFacade implements Textitemmanagement {

	@Inject
	private UcFindTextItem ucFindTextItem;

	@Override
	public TextItemCto findTextItemCto(long id) {

		return ucFindTextItem.findTextItemCto(id);
	}

	@Override
	public Page<TextItemCto> findTextItemCtos(TextItemSearchCriteriaTo criteria) {

		return ucFindTextItem.findTextItemCtos(criteria);
	}
}
