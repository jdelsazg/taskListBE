package com.capgemini.tasklist.fileitemmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.sql.Timestamp;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.capgemini.tasklist.fileitemmanagement.dataaccess.api.FileItemEntity;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link FileItemEntity}
 */
public interface FileItemRepository extends DefaultRepository<FileItemEntity> {

	/**
	 * @param criteria    the {@link FileItemSearchCriteriaTo} with the criteria to
	 *                    search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link FileItemEntity} objects that matched
	 *         the search.
	 */
	default Page<FileItemEntity> findByCriteria(FileItemSearchCriteriaTo criteria) {

		FileItemEntity alias = newDslAlias();
		JPAQuery<FileItemEntity> query = newDslQuery(alias);

		Timestamp creationDate = criteria.getCreationDate();
		if (creationDate != null) {
			query.where($(alias.getCreationDate()).eq(creationDate));
		}
		byte[] file = criteria.getFile();
		if (file != null) {
			query.where($(alias.getFile()).eq(file));
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
	public default void addOrderBy(JPAQuery<FileItemEntity> query, FileItemEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "creationDate":
					if (next.isAscending()) {
						query.orderBy($(alias.getCreationDate()).asc());
					} else {
						query.orderBy($(alias.getCreationDate()).desc());
					}
					break;
				// TODO check if the toString is working inside of getFile
				case "file":
					if (next.isAscending()) {
						query.orderBy($(alias.getFile().toString()).asc());
					} else {
						query.orderBy($(alias.getFile().toString()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}