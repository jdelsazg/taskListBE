package com.capgemini.tasklist.custommanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.capgemini.tasklist.custommanagement.logic.api.CustomManagement;
import com.capgemini.tasklist.custommanagement.logic.api.to.CustomTaskListCto;
import com.capgemini.tasklist.custommanagement.service.api.rest.CustomManagementRestService;

@Named("CustomManagementRestService")
public class CustomManagementServiceRestImpl implements CustomManagementRestService {

	@Inject
	private CustomManagement customManagement;

	@Override
	public CustomTaskListCto getCustomTasklist(long id) {

		return this.customManagement.customTaskList(id);
	}

}
