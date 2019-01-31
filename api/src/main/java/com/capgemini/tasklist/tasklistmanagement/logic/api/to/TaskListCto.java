package com.capgemini.tasklist.tasklistmanagement.logic.api.to;

import java.util.List;

import com.capgemini.tasklist.collectionlistmanagement.logic.api.to.CollectionListEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of TaskList
 */
public class TaskListCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private TaskListEto taskList;

	private List<CollectionListEto> listCollection;

	public TaskListEto getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskListEto taskList) {
		this.taskList = taskList;
	}

	public List<CollectionListEto> getListCollection() {
		return listCollection;
	}

	public void setListCollection(List<CollectionListEto> listCollection) {
		this.listCollection = listCollection;
	}

}
