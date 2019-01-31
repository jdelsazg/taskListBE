package com.capgemini.tasklist.collectionlistmanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.capgemini.tasklist.collectionlistmanagement.dataaccess.api.CollectionListEntity;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListCto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListEto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListSearchCriteriaTo;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.usecase.UcFindCollectionList;
import com.capgemini.tasklist.collectionlistmanagement.logic.base.usecase.AbstractCollectionListUc;
import com.capgemini.tasklist.itemmanagement.dataaccess.api.ItemEntity;
import com.capgemini.tasklist.itemmanagement.dataaccess.api.repo.ItemRepository;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemEto;

/**
 * Use case implementation for searching, filtering and getting CollectionLists
 */
@Named
@Validated
@Transactional
public class UcFindCollectionListImpl extends AbstractCollectionListUc implements UcFindCollectionList {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindCollectionListImpl.class);

	@Inject
	private ItemRepository itemRepository;

	@Override
	public CollectionListCto findCollectionListCto(long id) {
		LOG.debug("Get CollectionListCto with id {} from database.", id);
		CollectionListEntity entity = getCollectionListRepository().find(id);
		CollectionListCto cto = new CollectionListCto();
		cto.setCollectionList(getBeanMapper().map(entity, CollectionListEto.class));

		List<ItemEntity> listItems = this.itemRepository.findByIdList(id);
		cto.setItems(getBeanMapper().mapList(listItems, ItemEto.class));

		return cto;
	}

	@Override
	public Page<CollectionListCto> findCollectionListCtos(CollectionListSearchCriteriaTo criteria) {

		Page<CollectionListEntity> collectionlists = getCollectionListRepository().findByCriteria(criteria);
		List<CollectionListCto> ctos = new ArrayList<>();
		for (CollectionListEntity entity : collectionlists.getContent()) {
			CollectionListCto cto = new CollectionListCto();
			cto.setCollectionList(getBeanMapper().map(entity, CollectionListEto.class));
			cto.setItems(getBeanMapper().mapList(entity.getItems(), ItemEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, collectionlists.getTotalElements());
	}

	@Override
	public List<CollectionListEto> findCollectionListByIdTaskList(long id) {
		LOG.debug("Get CollectionListCto with id {} from database.", id);
		List<CollectionListEntity> entity = getCollectionListRepository().findByIdTaskList(id);
		List<CollectionListEto> eto = getBeanMapper().mapList(entity, CollectionListEto.class);
		//entity.stream().forEach(c -> cto.add(getBeanMapper().map(c, CollectionListCto.class)));
		return eto;
	}
}
