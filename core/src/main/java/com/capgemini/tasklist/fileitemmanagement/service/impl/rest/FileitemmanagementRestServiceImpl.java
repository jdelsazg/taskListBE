package com.capgemini.tasklist.fileitemmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.fileitemmanagement.logic.api.Fileitemmanagement;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemCto;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemSearchCriteriaTo;
import com.capgemini.tasklist.fileitemmanagement.service.api.rest.FileitemmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Fileitemmanagement}.
 */
@Named("FileitemmanagementRestService")
public class FileitemmanagementRestServiceImpl implements FileitemmanagementRestService {

	@Inject
	private Fileitemmanagement fileitemmanagement;

	@Override
	public FileItemCto getFileItemCto(long id) {
		return this.fileitemmanagement.findFileItemCto(id);
	}

	@Override
	public Page<FileItemCto> findFileItemCtos(FileItemSearchCriteriaTo searchCriteriaTo) {
		return this.fileitemmanagement.findFileItemCtos(searchCriteriaTo);
	}
}