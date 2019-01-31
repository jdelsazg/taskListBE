package com.capgemini.tasklist.tasklistmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.sql.Timestamp;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.capgemini.tasklist.tasklistmanagement.dataaccess.api.TaskListEntity;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link TaskListEntity}
 */
public interface TaskListRepository extends DefaultRepository<TaskListEntity> {

	/**
	 * @param criteria    the {@link TaskListSearchCriteriaTo} with the criteria to
	 *                    search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link TaskListEntity} objects that matched
	 *         the search.
	 */
	default Page<TaskListEntity> findByCriteria(TaskListSearchCriteriaTo criteria) {

		TaskListEntity alias = newDslAlias();
		JPAQuery<TaskListEntity> query = newDslQuery(alias);

		String name = criteria.getName();
		if (name != null && !name.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
		}
		Timestamp creationDate = criteria.getCreationDate();
		if (creationDate != null) {
			query.where($(alias.getCreationDate()).eq(creationDate));
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
	public default void addOrderBy(JPAQuery<TaskListEntity> query, TaskListEntity alias, Sort sort) {
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
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}