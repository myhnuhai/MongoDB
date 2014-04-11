package org.myhnuhai.core;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;

public class DefaultCustomDateEditor extends CustomDateEditor {

	private boolean allowEmpty;

	private DateFormat dateFormat;

	public DefaultCustomDateEditor(DateFormat dateFormat, boolean allowEmpty) {
		super(dateFormat, allowEmpty);
		this.allowEmpty = allowEmpty;
		this.dateFormat = dateFormat;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		} else if (text != null && text.length() < 21) {
			text += " 00:00:00";
			try {
				setValue(this.dateFormat.parse(text));
			} catch (ParseException ex) {
				throw new IllegalArgumentException("Could not parse date: "
						+ ex.getMessage(), ex);
			}
		}
	}


}
