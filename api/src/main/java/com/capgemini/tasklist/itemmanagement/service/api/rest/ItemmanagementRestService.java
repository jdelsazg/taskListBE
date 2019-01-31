package com.capgemini.tasklist.itemmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.itemmanagement.logic.api.Itemmanagement;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemCto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Itemmanagement}.
 */
@Path("/itemmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ItemmanagementRestService {

	/**
	 * Delegates to {@link Itemmanagement#findItemCto}.
	 *
	 * @param id the ID of the {@link ItemCto}
	 * @return the {@link ItemCto}
	 */
	@GET
	@Path("/item/cto/{id}/")
	public ItemCto getItemCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Itemmanagement#findItemCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding items.
	 * @return the {@link Page list} of matching {@link ItemCto}s.
	 */
	@Path("/item/cto/search")
	@POST
	public Page<ItemCto> findItemCtos(ItemSearchCriteriaTo searchCriteriaTo);

}