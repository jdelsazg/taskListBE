package com.capgemini.tasklist.fileitemmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.fileitemmanagement.logic.api.Fileitemmanagement;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemCto;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Fileitemmanagement}.
 */
@Path("/fileitemmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface FileitemmanagementRestService {

	/**
	 * Delegates to {@link Fileitemmanagement#findFileItemCto}.
	 *
	 * @param id the ID of the {@link FileItemCto}
	 * @return the {@link FileItemCto}
	 */
	@GET
	@Path("/fileitem/cto/{id}/")
	public FileItemCto getFileItemCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Fileitemmanagement#findFileItemCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding fileitems.
	 * @return the {@link Page list} of matching {@link FileItemCto}s.
	 */
	@Path("/fileitem/cto/search")
	@POST
	public Page<FileItemCto> findFileItemCtos(FileItemSearchCriteriaTo searchCriteriaTo);

}