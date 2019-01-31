package com.capgemini.tasklist.tasklistmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.tasklistmanagement.logic.api.Tasklistmanagement;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListCto;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListSearchCriteriaTo;
import com.capgemini.tasklist.tasklistmanagement.service.api.rest.TasklistmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Tasklistmanagement}.
 */
@Named("TasklistmanagementRestService")
public class TasklistmanagementRestServiceImpl implements TasklistmanagementRestService {

	@Inject
	private Tasklistmanagement tasklistmanagement;

	@Override
	public TaskListCto getTaskListCto(long id) {
		return this.tasklistmanagement.findTaskListCto(id);
	}

	@Override
	public Page<TaskListCto> findTaskListCtos(TaskListSearchCriteriaTo searchCriteriaTo) {
		return this.tasklistmanagement.findTaskListCtos(searchCriteriaTo);
	}
}