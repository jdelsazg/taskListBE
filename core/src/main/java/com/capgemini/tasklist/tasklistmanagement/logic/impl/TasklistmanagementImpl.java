package com.capgemini.tasklist.tasklistmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.general.logic.base.AbstractComponentFacade;
import com.capgemini.tasklist.tasklistmanagement.logic.api.Tasklistmanagement;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListCto;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListSearchCriteriaTo;
import com.capgemini.tasklist.tasklistmanagement.logic.api.usecase.UcFindTaskList;

/**
 * Implementation of component interface of tasklistmanagement
 */
@Named
public class TasklistmanagementImpl extends AbstractComponentFacade implements Tasklistmanagement {

	@Inject
	private UcFindTaskList ucFindTaskList;

	@Override
	public TaskListCto findTaskListCto(long id) {

		return ucFindTaskList.findTaskListCto(id);
	}

	@Override
	public Page<TaskListCto> findTaskListCtos(TaskListSearchCriteriaTo criteria) {

		return ucFindTaskList.findTaskListCtos(criteria);
	}
}
