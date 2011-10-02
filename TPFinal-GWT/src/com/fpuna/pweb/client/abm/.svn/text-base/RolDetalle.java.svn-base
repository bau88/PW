package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.RolService;
import com.fpuna.pweb.client.RolServiceAsync;
import com.fpuna.pweb.client.TPFinal_GWT;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;   
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;   
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextItem;   
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;   
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import entidades.Rol;

public class RolDetalle extends Canvas {

	public RolDetalle(final TPFinal_GWT mainWindow) {
		this(null, mainWindow);
	}
	
	public RolDetalle(Rol rol, final TPFinal_GWT mainWindow) {
		
		VLayout layout = new VLayout(10);
		
        final DynamicForm form = new DynamicForm();
        form.setBorder("2px");
        form.setAutoFocus(true);
        form.setNumCols(3);
        form.setWidth(500);

        Label label = new Label();   
        label.setHeight(30);
        label.setWidth(500);
        label.setPadding(10);   
        label.setAlign(Alignment.CENTER);   
        label.setValign(VerticalAlignment.CENTER);   
        label.setWrap(false);
        label.setShowEdges(true);   
        label.setContents("<b>Registro de Rol</b>");
        
        TextItem codigoText = new TextItem("codigo");
        codigoText.setTitle("Codigo");
        codigoText.setDisabled(true);
        codigoText.setWrapTitle(false);
  
        TextItem nombreText = new TextItem("nombre");
        nombreText.setTitle("Nombre");
        nombreText.setWrapTitle(false);

        ButtonItem button = new ButtonItem("save", "Guardar");
        button.setStartRow(false);
        button.setWidth(80);
        button.setIcon("approve.png");
        button.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
        		
        		RolServiceAsync service = GWT.create(RolService.class);
				 
				Rol rol = new Rol();
				
				rol.setNombre(form.getValueAsString("nombre"));

				if(form.getValueAsString("codigo") != null){
					rol.setIdRol(Integer.valueOf(form.getValueAsString("codigo")));
				}

				try {
					service.guardar(rol, new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Ocurrio un error: " + caught.getClass().getName() + " " + caught.getMessage()) ;
						}

						@Override
						public void onSuccess(Void result) {
							new RolLista(mainWindow);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
        
        
		if (rol != null){
			codigoText.setDefaultValue(String.valueOf(rol.getIdRol()));
			nombreText.setDefaultValue(rol.getNombre());
		}
		
        
		form.setFields(codigoText, nombreText, button);
		layout.addMember(label);
        layout.addMember(form);
        mainWindow.showDialog(layout);
	}
}