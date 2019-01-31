package com.capgemini.tasklist.tasklistmanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.capgemini.tasklist.collectionlistmanagement.dataaccess.api.repo.CollectionListRepository;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListEto;
import com.capgemini.tasklist.tasklistmanagement.dataaccess.api.TaskListEntity;
import com.capgemini.tasklist.tasklistmanagement.dataaccess.api.repo.TaskListRepository;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListCto;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListEto;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListSearchCriteriaTo;
import com.capgemini.tasklist.tasklistmanagement.logic.api.usecase.UcFindTaskList;
import com.capgemini.tasklist.tasklistmanagement.logic.base.usecase.AbstractTaskListUc;

/**
 * Use case implementation for searching, filtering and getting TaskLists
 */
@Named
@Validated
@Transactional
public class UcFindTaskListImpl extends AbstractTaskListUc implements UcFindTaskList {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindTaskListImpl.class);

	@Inject
	private CollectionListRepository collectionListRepository;

	@Override
	public TaskListCto findTaskListCto(long id) {
		LOG.debug("Get TaskListCto with id {} from database.", id);
		TaskListEntity entity = getTaskListRepository().find(id);
		TaskListCto cto = new TaskListCto();
		cto.setTaskList(getBeanMapper().map(entity, TaskListEto.class));

		List<CollectionListEntity> listCollection = this.collectionListRepository.findByIdTaskList(id);
		cto.setListCollection(getBeanMapper().mapList(listCollection, CollectionListEto.class));

		return cto;
	}

	@Override
	public Page<TaskListCto> findTaskListCtos(TaskListSearchCriteriaTo criteria) {

		Page<TaskListEntity> tasklists = getTaskListRepository().findByCriteria(criteria);
		List<TaskListCto> ctos = new ArrayList<>();
		for (TaskListEntity entity : tasklists.getContent()) {
			TaskListCto cto = new TaskListCto();
			cto.setTaskList(getBeanMapper().map(entity, TaskListEto.class));
			cto.setListCollection(getBeanMapper().mapList(entity.getListCollection(), CollectionListEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, tasklists.getTotalElements());
	}
}
