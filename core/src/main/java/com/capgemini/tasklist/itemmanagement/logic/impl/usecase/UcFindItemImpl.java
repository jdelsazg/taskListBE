package com.capgemini.tasklist.itemmanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListEto;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemEto;
import com.capgemini.tasklist.itemmanagement.dataaccess.api.ItemEntity;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemCto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemEto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemSearchCriteriaTo;
import com.capgemini.tasklist.itemmanagement.logic.api.usecase.UcFindItem;
import com.capgemini.tasklist.itemmanagement.logic.base.usecase.AbstractItemUc;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemEto;

/**
 * Use case implementation for searching, filtering and getting Items
 */
@Named
@Validated
@Transactional
public class UcFindItemImpl extends AbstractItemUc implements UcFindItem {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindItemImpl.class);

	@Override
	public ItemCto findItemCto(long id) {
		LOG.debug("Get ItemCto with id {} from database.", id);
		ItemEntity entity = getItemRepository().find(id);
		ItemCto cto = new ItemCto();
		cto.setItem(getBeanMapper().map(entity, ItemEto.class));
		cto.setText(getBeanMapper().map(entity.getText(), TextItemEto.class));
		cto.setFile(getBeanMapper().map(entity.getFile(), FileItemEto.class));

		return cto;
	}

	@Override
	public Page<ItemCto> findItemCtos(ItemSearchCriteriaTo criteria) {

		Page<ItemEntity> items = getItemRepository().findByCriteria(criteria);
		List<ItemCto> ctos = new ArrayList<>();
		for (ItemEntity entity : items.getContent()) {
			ItemCto cto = new ItemCto();
			cto.setItem(getBeanMapper().map(entity, ItemEto.class));
			cto.setText(getBeanMapper().map(entity.getText(), TextItemEto.class));
			cto.setFile(getBeanMapper().map(entity.getFile(), FileItemEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, items.getTotalElements());
	}

	@Override
	public List<ItemCto> findItemByIdList(long id) {
		List<ItemEntity> items = getItemRepository().findByIdList(id);
		List<ItemCto> ctos = new ArrayList<>();
		for (ItemEntity entity : items) {
			ItemCto cto = new ItemCto();
			cto.setItem(getBeanMapper().map(entity, ItemEto.class));
			cto.setText(getBeanMapper().map(entity.getText(), TextItemEto.class));
			cto.setFile(getBeanMapper().map(entity.getFile(), FileItemEto.class));
			cto.setIdList(entity.getIdList());
			ctos.add(cto);
		}
		return ctos;
	}
}
