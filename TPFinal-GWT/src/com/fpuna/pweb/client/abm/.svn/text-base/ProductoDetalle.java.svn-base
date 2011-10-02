package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.ProductoService;
import com.fpuna.pweb.client.ProductoServiceAsync;
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

import entidades.Producto;

public class ProductoDetalle extends Canvas {

	public ProductoDetalle(final TPFinal_GWT mainWindow) {
		this(null, mainWindow);
	}
	
	public ProductoDetalle(Producto producto, final TPFinal_GWT mainWindow) {
		
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
        label.setContents("<b>Registro del Producto</b>");
        
        TextItem codigoText = new TextItem("codigo");
        codigoText.setTitle("Codigo");
        codigoText.setDisabled(true);
        codigoText.setWrapTitle(false);
  
        TextItem nombreText = new TextItem("nombre");
        nombreText.setTitle("Nombre");
        nombreText.setWrapTitle(false);

        TextItem cantidadText = new TextItem("cantidad");
        cantidadText.setTitle("Cantidad");
        cantidadText.setWrapTitle(false);

        TextItem costoText = new TextItem("costo");
        costoText.setTitle("Costo");
        costoText.setWrapTitle(false);

        TextItem gananciaText = new TextItem("ganancia");
        gananciaText.setTitle("Ganancia %");
        gananciaText.setWrapTitle(false);
      
        ButtonItem button = new ButtonItem("save", "Guardar");
        button.setStartRow(false);
        button.setWidth(80);
        button.setIcon("approve.png");
        
        button.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
        		
        		ProductoServiceAsync service = GWT.create(ProductoService.class);
        		
        		Producto producto = new Producto();
				producto.setDescripcion(form.getValueAsString("nombre"));
				producto.setCantidad(Integer.valueOf(form.getValueAsString("cantidad")));
				producto.setCostoActual(Double.valueOf(form.getValueAsString("costo")));
				producto.setPorcGanancia(Double.valueOf(form.getValueAsString("ganancia")));
				
				if(form.getValueAsString("codigo") != null){
					producto.setIdProducto(Integer.valueOf(form.getValueAsString("codigo")));
				}

				try {
					service.guardar(producto, new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Ocurrio un error: " + caught.getClass().getName() + " " + caught.getMessage()) ;
						}

						@Override
						public void onSuccess(Void result) {
							new ProductoLista(mainWindow);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});

		if (producto != null){ // Sucede cuando se va a modificar datos
			codigoText.setDefaultValue(String.valueOf(producto.getIdProducto()));
			nombreText.setDefaultValue(producto.getDescripcion());
			cantidadText.setDefaultValue(String.valueOf(producto.getCantidad()));
			costoText.setDefaultValue(String.valueOf(producto.getCostoActual()));
			gananciaText.setDefaultValue(String.valueOf(producto.getPorcGanancia()));
		}
		
		form.setFields(codigoText, nombreText, cantidadText, costoText, gananciaText, button);
		layout.addMember(label);
        layout.addMember(form);
        mainWindow.showDialog(layout);
	}
}