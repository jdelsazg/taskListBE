package com.capgemini.tasklist.fileitemmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.fileitemmanagement.logic.api.Fileitemmanagement;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemCto;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemSearchCriteriaTo;
import com.capgemini.tasklist.fileitemmanagement.logic.api.usecase.UcFindFileItem;
import com.capgemini.tasklist.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of fileitemmanagement
 */
@Named
public class FileitemmanagementImpl extends AbstractComponentFacade implements Fileitemmanagement {

	@Inject
	private UcFindFileItem ucFindFileItem;

	@Override
	public FileItemCto findFileItemCto(long id) {

		return ucFindFileItem.findFileItemCto(id);
	}

	@Override
	public Page<FileItemCto> findFileItemCtos(FileItemSearchCriteriaTo criteria) {

		return ucFindFileItem.findFileItemCtos(criteria);
	}
}
