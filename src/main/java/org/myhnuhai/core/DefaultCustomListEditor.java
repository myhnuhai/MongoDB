package org.myhnuhai.core;

import antlr.collections.List;
import org.myhnuhai.util.JsonUtil;

import java.beans.PropertyEditorSupport;

public class DefaultCustomListEditor extends PropertyEditorSupport {

	private Object o;
	public DefaultCustomListEditor(Object o) {
		this.o = o;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		this.setValue(JsonUtil.json2Bean(text, List.class));
	}
	
	

}
