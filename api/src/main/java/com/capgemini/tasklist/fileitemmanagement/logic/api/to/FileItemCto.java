package com.capgemini.tasklist.fileitemmanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of FileItem
 */
public class FileItemCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private FileItemEto fileItem;

	public FileItemEto getFileItem() {
		return fileItem;
	}

	public void setFileItem(FileItemEto fileItem) {
		this.fileItem = fileItem;
	}

}
