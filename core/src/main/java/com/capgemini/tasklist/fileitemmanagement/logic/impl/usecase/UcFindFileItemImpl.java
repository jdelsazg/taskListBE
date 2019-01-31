package com.capgemini.tasklist.fileitemmanagement.logic.impl.usecase;

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

import com.capgemini.tasklist.fileitemmanagement.dataaccess.api.FileItemEntity;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemCto;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemEto;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemSearchCriteriaTo;
import com.capgemini.tasklist.fileitemmanagement.logic.api.usecase.UcFindFileItem;
import com.capgemini.tasklist.fileitemmanagement.logic.base.usecase.AbstractFileItemUc;

/**
 * Use case implementation for searching, filtering and getting FileItems
 */
@Named
@Validated
@Transactional
public class UcFindFileItemImpl extends AbstractFileItemUc implements UcFindFileItem {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindFileItemImpl.class);

	@Override
	public FileItemCto findFileItemCto(long id) {
		LOG.debug("Get FileItemCto with id {} from database.", id);
		FileItemEntity entity = getFileItemRepository().find(id);
		FileItemCto cto = new FileItemCto();
		cto.setFileItem(getBeanMapper().map(entity, FileItemEto.class));

		return cto;
	}

	@Override
	public Page<FileItemCto> findFileItemCtos(FileItemSearchCriteriaTo criteria) {

		Page<FileItemEntity> fileitems = getFileItemRepository().findByCriteria(criteria);
		List<FileItemCto> ctos = new ArrayList<>();
		for (FileItemEntity entity : fileitems.getContent()) {
			FileItemCto cto = new FileItemCto();
			cto.setFileItem(getBeanMapper().map(entity, FileItemEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, fileitems.getTotalElements());
	}
}
