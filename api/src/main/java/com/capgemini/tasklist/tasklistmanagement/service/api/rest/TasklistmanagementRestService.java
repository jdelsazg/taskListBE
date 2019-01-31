package com.capgemini.tasklist.tasklistmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.tasklistmanagement.logic.api.Tasklistmanagement;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListCto;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Tasklistmanagement}.
 */
@Path("/tasklistmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TasklistmanagementRestService {

	/**
	 * Delegates to {@link Tasklistmanagement#findTaskListCto}.
	 *
	 * @param id the ID of the {@link TaskListCto}
	 * @return the {@link TaskListCto}
	 */
	@GET
	@Path("/tasklist/cto/{id}/")
	public TaskListCto getTaskListCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Tasklistmanagement#findTaskListCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding tasklists.
	 * @return the {@link Page list} of matching {@link TaskListCto}s.
	 */
	@Path("/tasklist/cto/search")
	@POST
	public Page<TaskListCto> findTaskListCtos(TaskListSearchCriteriaTo searchCriteriaTo);

}