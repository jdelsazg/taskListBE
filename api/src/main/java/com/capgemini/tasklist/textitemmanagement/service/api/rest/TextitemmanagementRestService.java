package com.capgemini.tasklist.textitemmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.textitemmanagement.logic.api.Textitemmanagement;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemCto;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Textitemmanagement}.
 */
@Path("/textitemmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TextitemmanagementRestService {

	/**
	 * Delegates to {@link Textitemmanagement#findTextItemCto}.
	 *
	 * @param id the ID of the {@link TextItemCto}
	 * @return the {@link TextItemCto}
	 */
	@GET
	@Path("/textitem/cto/{id}/")
	public TextItemCto getTextItemCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Textitemmanagement#findTextItemCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding textitems.
	 * @return the {@link Page list} of matching {@link TextItemCto}s.
	 */
	@Path("/textitem/cto/search")
	@POST
	public Page<TextItemCto> findTextItemCtos(TextItemSearchCriteriaTo searchCriteriaTo);

}