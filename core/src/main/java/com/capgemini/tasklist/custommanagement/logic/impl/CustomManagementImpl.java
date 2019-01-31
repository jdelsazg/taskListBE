package com.capgemini.tasklist.custommanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.capgemini.tasklist.custommanagement.logic.api.CustomManagement;
import com.capgemini.tasklist.custommanagement.logic.api.to.CustomTaskListCto;
import com.capgemini.tasklist.custommanagement.logic.api.usecase.UcCustomTaskList;

@Named
public class CustomManagementImpl implements CustomManagement {

	@Inject
	private UcCustomTaskList ucCustomTaskList;

	@Override
	public CustomTaskListCto customTaskList(long id) {

		return this.ucCustomTaskList.customTaskList(id);
	}

}
