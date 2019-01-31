package com.capgemini.tasklist.collectionlistmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.capgemini.tasklist.collectionlistmanagement.logic.api.Collectionlistmanagement;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListCto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Collectionlistmanagement}.
 */
@Path("/collectionlistmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CollectionlistmanagementRestService {

	/**
	 * Delegates to {@link Collectionlistmanagement#findCollectionListCto}.
	 *
	 * @param id the ID of the {@link CollectionListCto}
	 * @return the {@link CollectionListCto}
	 */
	@GET
	@Path("/collectionlist/cto/{id}/")
	public CollectionListCto getCollectionListCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Collectionlistmanagement#findCollectionListCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding collectionlists.
	 * @return the {@link Page list} of matching {@link CollectionListCto}s.
	 */
	@Path("/collectionlist/cto/search")
	@POST
	public Page<CollectionListCto> findCollectionListCtos(CollectionListSearchCriteriaTo searchCriteriaTo);

}