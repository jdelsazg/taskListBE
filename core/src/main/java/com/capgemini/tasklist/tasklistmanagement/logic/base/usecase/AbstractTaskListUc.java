package com.capgemini.tasklist.tasklistmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.tasklist.general.logic.base.AbstractUc;
import com.capgemini.tasklist.tasklistmanagement.dataaccess.api.repo.TaskListRepository;

/**
 * Abstract use case for TaskLists, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractTaskListUc extends AbstractUc {

	/** @see #getTaskListRepository() */
	@Inject
	private TaskListRepository taskListRepository;

	/**
	 * Returns the field 'taskListRepository'.
	 * 
	 * @return the {@link TaskListRepository} instance.
	 */
	public TaskListRepository getTaskListRepository() {

		return this.taskListRepository;
	}

}
