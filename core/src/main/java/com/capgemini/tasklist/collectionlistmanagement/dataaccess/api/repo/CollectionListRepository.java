package com.capgemini.tasklist.collectionlistmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.capgemini.tasklist.collectionlistmanagement.dataaccess.api.CollectionListEntity;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link CollectionListEntity}
 */
public interface CollectionListRepository extends DefaultRepository<CollectionListEntity> {

	/**
	 * @param criteria    the {@link CollectionListSearchCriteriaTo} with the
	 *                    criteria to search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link CollectionListEntity} objects that
	 *         matched the search.
	 */
	default Page<CollectionListEntity> findByCriteria(CollectionListSearchCriteriaTo criteria) {

		CollectionListEntity alias = newDslAlias();
		JPAQuery<CollectionListEntity> query = newDslQuery(alias);

		String name = criteria.getName();
		if (name != null && !name.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
		}
		Timestamp creationDate = criteria.getCreationDate();
		if (creationDate != null) {
			query.where($(alias.getCreationDate()).eq(creationDate));
		}
		Integer orderList = criteria.getOrderList();
		if (orderList != null) {
			query.where($(alias.getOrderList()).eq(orderList));
		}
		Boolean active = criteria.getActive();
		if (active != null) {
			query.where($(alias.getActive()).eq(active));
		}
		addOrderBy(query, alias, criteria.getPageable().getSort());

		return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
	}

	/**
	 * Add sorting to the given query on the given alias
	 *
	 * @param query to add sorting to
	 * @param alias to retrieve columns from for sorting
	 * @param sort  specification of sorting
	 */
	public default void addOrderBy(JPAQuery<CollectionListEntity> query, CollectionListEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "name":
					if (next.isAscending()) {
						query.orderBy($(alias.getName()).asc());
					} else {
						query.orderBy($(alias.getName()).desc());
					}
					break;
				case "creationDate":
					if (next.isAscending()) {
						query.orderBy($(alias.getCreationDate()).asc());
					} else {
						query.orderBy($(alias.getCreationDate()).desc());
					}
					break;
				case "orderList":
					if (next.isAscending()) {
						query.orderBy($(alias.getOrderList()).asc());
					} else {
						query.orderBy($(alias.getOrderList()).desc());
					}
					break;
				case "active":
					if (next.isAscending()) {
						query.orderBy($(alias.getActive()).asc());
					} else {
						query.orderBy($(alias.getActive()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}


	public List<CollectionListEntity> findByIdTaskList(Long idTaskList);
}