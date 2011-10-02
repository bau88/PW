package com.fpuna.pweb.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class MainHeader extends Composite {
	public final String HEADER_TOP_LEFT_SRC = "images/header.jpg";

	public MainHeader() {
		HorizontalPanel panel = new HorizontalPanel();					
		Image img = new Image();
		
		img.setUrl(HEADER_TOP_LEFT_SRC);
		img.setHeight("140");
		img.setWidth("100%");
		
		panel.setWidth("100%");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.add(img);
		
		initWidget(panel);
	}
}