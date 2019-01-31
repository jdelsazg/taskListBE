package com.capgemini.tasklist.textitemmanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of TextItem
 */
public class TextItemCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private TextItemEto textItem;

	public TextItemEto getTextItem() {
		return textItem;
	}

	public void setTextItem(TextItemEto textItem) {
		this.textItem = textItem;
	}

}
