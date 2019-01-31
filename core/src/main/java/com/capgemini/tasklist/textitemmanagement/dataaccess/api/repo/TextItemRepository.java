package com.capgemini.tasklist.textitemmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.sql.Timestamp;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.capgemini.tasklist.textitemmanagement.dataaccess.api.TextItemEntity;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link TextItemEntity}
 */
public interface TextItemRepository extends DefaultRepository<TextItemEntity> {

	/**
	 * @param criteria    the {@link TextItemSearchCriteriaTo} with the criteria to
	 *                    search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link TextItemEntity} objects that matched
	 *         the search.
	 */
	default Page<TextItemEntity> findByCriteria(TextItemSearchCriteriaTo criteria) {

		TextItemEntity alias = newDslAlias();
		JPAQuery<TextItemEntity> query = newDslQuery(alias);

		String text = criteria.getText();
		if (text != null && !text.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getText()), text, criteria.getTextOption());
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
	public default void addOrderBy(JPAQuery<TextItemEntity> query, TextItemEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "text":
					if (next.isAscending()) {
						query.orderBy($(alias.getText()).asc());
					} else {
						query.orderBy($(alias.getText()).desc());
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