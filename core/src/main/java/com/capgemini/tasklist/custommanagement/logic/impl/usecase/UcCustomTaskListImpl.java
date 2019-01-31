package com.capgemini.tasklist.custommanagement.logic.impl.usecase;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.capgemini.tasklist.collectionlistmanagement.dataaccess.api.CollectionListEntity;
import com.capgemini.tasklist.collectionlistmanagement.dataaccess.api.repo.CollectionListRepository;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.Collectionlistmanagement;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListCto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListEto;
import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CustomCollectionListEto;
import com.capgemini.tasklist.custommanagement.logic.api.to.CustomTaskListCto;
import com.capgemini.tasklist.custommanagement.logic.api.usecase.UcCustomTaskList;
import com.capgemini.tasklist.fileitemmanagement.dataaccess.api.repo.FileItemRepository;
import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemEto;
import com.capgemini.tasklist.general.logic.base.AbstractUc;
import com.capgemini.tasklist.itemmanagement.dataaccess.api.ItemEntity;
import com.capgemini.tasklist.itemmanagement.dataaccess.api.repo.ItemRepository;
import com.capgemini.tasklist.itemmanagement.logic.api.Itemmanagement;
import com.capgemini.tasklist.itemmanagement.logic.api.to.CustomItemEto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemCto;
import com.capgemini.tasklist.itemmanagement.logic.api.to.ItemEto;
import com.capgemini.tasklist.tasklistmanagement.dataaccess.api.TaskListEntity;
import com.capgemini.tasklist.tasklistmanagement.dataaccess.api.repo.TaskListRepository;
import com.capgemini.tasklist.tasklistmanagement.logic.api.Tasklistmanagement;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListCto;
import com.capgemini.tasklist.tasklistmanagement.logic.api.to.TaskListEto;
import com.capgemini.tasklist.tasklistmanagement.logic.impl.usecase.UcFindTaskListImpl;
import com.capgemini.tasklist.textitemmanagement.dataaccess.api.repo.TextItemRepository;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemEto;

@Named
//@Validated
@Transactional
public class UcCustomTaskListImpl extends AbstractUc implements UcCustomTaskList {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindTaskListImpl.class);

	@Inject
	private Tasklistmanagement taskListManagement;

	@Inject
	private Collectionlistmanagement collectionListManagement;

	@Inject
	private Itemmanagement itemManagement;

	@Override
	public CustomTaskListCto customTaskList(long id) {

		CustomTaskListCto response = new CustomTaskListCto();

		TaskListCto taskListCto = taskListManagement.findTaskListCto(id);

		response.setCreationDateTaskList(taskListCto.getTaskList().getCreationDate());
		response.setNombreTaskList(taskListCto.getTaskList().getName());

		List<CollectionListEto> lists = collectionListManagement.findCollectionListByIdTaskList(taskListCto.getTaskList().getId());

		response.setLists(lists.stream().map(CollectionListEto::printEto).collect(Collectors.joining(";")));

		String s = "";

		for(CollectionListEto cl: lists) {
			List<ItemCto> listt = itemManagement.findItemByIdList(cl.getId());
			s += listt.stream().map(ItemCto::printCto).collect(Collectors.joining(";"));
			s+=";";
		}

		response.setItems(s);

//		lists.stream().forEach(l -> {
//			  s += itemManagement.findItemByIdList(l.getId()).stream().map(ItemCto::printCto).collect(Collectors.joining(";"));
//		});

		return response;
	}


	/*@Inject
	private TaskListRepository taskListRepository;

	@Inject
	private CollectionListRepository collectionListRepository;

	@Inject
	private ItemRepository itemRepository;

	@Inject
	private FileItemRepository fileItemRepository;

	@Inject
	private TextItemRepository textItemRepository;

	@Override
	public CustomTaskListCto customTaskList(long id) {
		LOG.debug("Get CustomTaskListCto with id {} from database.", id);

		CustomTaskListCto response = new CustomTaskListCto();

		TaskListEntity entity = taskListRepository.find(id);

		response.setNombreTaskList(entity.getName());
		response.setCreationDateTaskList(entity.getCreationDate());

		List<CustomCollectionListEto> cl = new ArrayList<>();

		List<CustomItemEto> lItems = new ArrayList<>();

		for(CollectionListEntity colItem:this.collectionListRepository.findByIdTaskList(entity.getId())) {
			CustomCollectionListEto ccolList = new CustomCollectionListEto();
			ccolList.setActive(colItem.getActive());
			ccolList.setCreationDate(colItem.getCreationDate());
			ccolList.setName(colItem.getName());
			ccolList.setOrderList(colItem.getOrderList());

			for(ItemEntity items: this.itemRepository.findByIdList(colItem.getId())) {
				CustomItemEto item = new CustomItemEto();
				item.setCreationDate(items.getCreationDate());
				item.setOrdinal(items.getOrdinal());
				item.setFile(getBeanMapper().map(items.getFile(), FileItemEto.class));
				item.setText(getBeanMapper().map(items.getText(), TextItemEto.class));
				lItems.add(item);
			}

			ccolList.setItems(lItems);

			cl.add(ccolList);
		}

		response.setList(cl);

		return response;
	}*/


}
