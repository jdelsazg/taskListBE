package com.capgemini.tasklist.itemmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.capgemini.tasklist.itemmanagement.dataaccess.api.ItemEntity;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link ItemEntity}
 */
public interface ItemRepository extends DefaultRepository<ItemEntity> {

	/**
	 * @param criteria    the {@link ItemSearchCriteriaTo} with the criteria to
	 *                    search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link ItemEntity} objects that matched the
	 *         search.
	 */
	default Page<ItemEntity> findByCriteria(ItemSearchCriteriaTo criteria) {

		ItemEntity alias = newDslAlias();
		JPAQuery<ItemEntity> query = newDslQuery(alias);

		Integer ordinal = criteria.getOrdinal();
		if (ordinal != null) {
			query.where($(alias.getOrdinal()).eq(ordinal));
		}
		Timestamp creationDate = criteria.getCreationDate();
		if (creationDate != null) {
			query.where($(alias.getCreationDate()).eq(creationDate));
		}
		Long text = criteria.getTextId();
		if (text != null) {
			query.where($(alias.getText().getId()).eq(text));
		}
		Long file = criteria.getFileId();
		if (file != null) {
			query.where($(alias.getFile().getId()).eq(file));
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
	public default void addOrderBy(JPAQuery<ItemEntity> query, ItemEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "ordinal":
					if (next.isAscending()) {
						query.orderBy($(alias.getOrdinal()).asc());
					} else {
						query.orderBy($(alias.getOrdinal()).desc());
					}
					break;
				case "creationDate":
					if (next.isAscending()) {
						query.orderBy($(alias.getCreationDate()).asc());
					} else {
						query.orderBy($(alias.getCreationDate()).desc());
					}
					break;
				case "text":
					if (next.isAscending()) {
						query.orderBy($(alias.getText().getId()).asc());
					} else {
						query.orderBy($(alias.getText().getId()).desc());
					}
					break;
				case "file":
					if (next.isAscending()) {
						query.orderBy($(alias.getFile().getId()).asc());
					} else {
						query.orderBy($(alias.getFile().getId()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

	public List<ItemEntity> findByIdList(Long idList);
}