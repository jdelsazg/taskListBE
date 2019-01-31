package com.capgemini.tasklist.custommanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.capgemini.tasklist.custommanagement.logic.api.to.CustomTaskListCto;

@Path("/custommanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CustomManagementRestService {

	@GET
	@Path("/customtasklist/cto/{id}/")
	public CustomTaskListCto getCustomTasklist(@PathParam("id") long id);
}
