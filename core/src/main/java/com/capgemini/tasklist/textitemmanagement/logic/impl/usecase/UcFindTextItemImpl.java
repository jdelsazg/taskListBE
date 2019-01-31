package com.capgemini.tasklist.textitemmanagement.logic.impl.usecase;

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

import com.capgemini.tasklist.textitemmanagement.dataaccess.api.TextItemEntity;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemCto;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemEto;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemSearchCriteriaTo;
import com.capgemini.tasklist.textitemmanagement.logic.api.usecase.UcFindTextItem;
import com.capgemini.tasklist.textitemmanagement.logic.base.usecase.AbstractTextItemUc;

/**
 * Use case implementation for searching, filtering and getting TextItems
 */
@Named
@Validated
@Transactional
public class UcFindTextItemImpl extends AbstractTextItemUc implements UcFindTextItem {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindTextItemImpl.class);

	@Override
	public TextItemCto findTextItemCto(long id) {
		LOG.debug("Get TextItemCto with id {} from database.", id);
		TextItemEntity entity = getTextItemRepository().find(id);
		TextItemCto cto = new TextItemCto();
		cto.setTextItem(getBeanMapper().map(entity, TextItemEto.class));

		return cto;
	}

	@Override
	public Page<TextItemCto> findTextItemCtos(TextItemSearchCriteriaTo criteria) {

		Page<TextItemEntity> textitems = getTextItemRepository().findByCriteria(criteria);
		List<TextItemCto> ctos = new ArrayList<>();
		for (TextItemEntity entity : textitems.getContent()) {
			TextItemCto cto = new TextItemCto();
			cto.setTextItem(getBeanMapper().map(entity, TextItemEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, textitems.getTotalElements());
	}
}
