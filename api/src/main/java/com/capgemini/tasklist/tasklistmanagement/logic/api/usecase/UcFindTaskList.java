package com.capgemini.tasklist.tasklistmanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListCto;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListSearchCriteriaTo;

public interface UcFindTaskList {

	/**
	 * Returns a composite TaskList by its id 'id'.
	 *
	 * @param id The id 'id' of the TaskList.
	 * @return The {@link TaskListCto} with id 'id'
	 */
	TaskListCto findTaskListCto(long id);

	/**
	 * Returns a paginated list of composite TaskLists matching the search criteria.
	 *
	 * @param criteria the {@link TaskListSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link TaskListCto}s.
	 */
	Page<TaskListCto> findTaskListCtos(TaskListSearchCriteriaTo criteria);

}
