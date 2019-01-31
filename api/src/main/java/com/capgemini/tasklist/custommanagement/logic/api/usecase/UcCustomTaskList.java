package com.capgemini.tasklist.custommanagement.logic.api.usecase;

import com.capgemini.tasklist.custommanagement.logic.api.to.CustomTaskListCto;

public interface UcCustomTaskList {

	CustomTaskListCto customTaskList(long id);
	
	

}
