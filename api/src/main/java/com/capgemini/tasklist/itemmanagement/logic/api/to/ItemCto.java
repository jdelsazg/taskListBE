package com.capgemini.tasklist.itemmanagement.logic.api.to;

import com.capgemini.tasklist.fileitemmanagement.logic.api.to.FileItemEto;
import com.capgemini.tasklist.textitemmanagement.logic.api.to.TextItemEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Item
 */
public class ItemCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private ItemEto item;

	private TextItemEto text;
	private FileItemEto file;

	private Long idList;

	public Long getIdList() {
		return idList;
	}

	public void setIdList(Long idList) {
		this.idList = idList;
	}

	public ItemEto getItem() {
		return item;
	}

	public void setItem(ItemEto item) {
		this.item = item;
	}

	public TextItemEto getText() {
		return text;
	}

	public void setText(TextItemEto text) {
		this.text = text;
	}

	public FileItemEto getFile() {
		return file;
	}

	public void setFile(FileItemEto file) {
		this.file = file;
	}

	public String printCto() {

		return getItem().printEto() + " ? " + (getText() != null ? getText().printEto(): null) + " ? " + ( getFile() != null ? getFile().printEto() : null ) + " ? " + getIdList();
	}

}
