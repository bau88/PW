 package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.ProductoService;
import com.fpuna.pweb.client.ProductoServiceAsync;
import com.fpuna.pweb.client.TPFinal_GWT;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.FormLayoutType;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.ListGridField;  
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import entidades.Producto;

public class ProductoLista extends Canvas {
	
	public ProductoLista(final TPFinal_GWT mainWindow) {

		String PATH_IMG = "/TPFinal-GWT/images/";
		VLayout layout = new VLayout(10);
        
        final ListGrid productoGrid = new ListGrid(); 

        productoGrid.setWidth(500);  
        productoGrid.setHeight(224);  
        productoGrid.setShowAllRecords(true);
        productoGrid.setAlternateRecordStyles(true);
        productoGrid.setShowEdges(true);
        productoGrid.setBorder("0px");
        productoGrid.setBodyStyleName("normal");
        productoGrid.setLeaveScrollbarGap(false);
	    
        /*-Buscar ------------------------------*/
        DynamicForm buscarFields = new DynamicForm();
        buscarFields.setItemLayout(FormLayoutType.ABSOLUTE);
        
        final TextItem nombreText = new TextItem("nombre");
        nombreText.setWrapTitle(false);
        nombreText.setLeft(55);
        nombreText.setWidth(150);
        nombreText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Producto producto = null;
        			if(nombreText.getValue() != null){
        				producto = new Producto();
        				producto.setDescripcion(nombreText.getValue().toString());
        				
        			}
        			listar(productoGrid, producto, "descripcion");
        		}
			}
        });
        
        ButtonItem buscarButton = new ButtonItem("find", "");
        buscarButton.setIcon("view.png");
        buscarButton.setWidth(50);
        buscarButton.setLeft(443);
        buscarButton.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
    			/* buscar por el campo correspondiente */
        		Producto producto = null;
    			if(nombreText.getValue() != null){
    				producto = new Producto();
    				producto.setDescripcion(nombreText.getValue().toString());
    				
    			}
    			listar(productoGrid, producto, "descripcion");
			}
		});
        
        buscarFields.setFields(nombreText, buscarButton);
        /*--------------------------------------*/
        
        ListGridField codigoField = new ListGridField("codigo", "Codigo");
        ListGridField nombreField = new ListGridField("nombre", "Descripcion");
        ListGridField cantidadField = new ListGridField("cantidad", "Cantidad");
        ListGridField costoField = new ListGridField("costo", "Costo");
        ListGridField gananciaField = new ListGridField("porcgan", "% Ganancia");
        ListGridField editarField = new ListGridField("edit", "Editar");
        ListGridField borrarField = new ListGridField("remove", "Borrar");

        codigoField.setAlign(Alignment.CENTER);
        cantidadField.setAlign(Alignment.CENTER);
        costoField.setAlign(Alignment.RIGHT);
        gananciaField.setAlign(Alignment.CENTER);
        editarField.setAlign(Alignment.CENTER);
        borrarField.setAlign(Alignment.CENTER);

        codigoField.setWidth(50);
        nombreField.setWidth(150);
        cantidadField.setWidth(68);
        costoField.setWidth(50);
        gananciaField.setWidth(70);
        editarField.setWidth(50);
        borrarField.setWidth(50);
        
        editarField.setType(ListGridFieldType.IMAGE);
        borrarField.setType(ListGridFieldType.IMAGE);
        
        editarField.setImageURLPrefix(PATH_IMG); 
        borrarField.setImageURLPrefix(PATH_IMG);
        
        editarField.setImageURLSuffix(".png");
        borrarField.setImageURLSuffix(".png");

        productoGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
                ListGridRecord record =  event.getRecord();
                int col = event.getColNum();
                if (col > 4) {
                	
                	Producto producto = new Producto();
                	producto.setIdProducto(record.getAttributeAsInt("codigo"));
                	producto.setDescripcion(record.getAttribute("nombre"));
                	producto.setCantidad(record.getAttributeAsInt("cantidad"));
                	producto.setCostoActual(record.getAttributeAsDouble("costo"));
                    producto.setPorcGanancia(record.getAttributeAsDouble("porcgan"));
                	
                	if (col == 5) {	/* Editar */
                		
                		new ProductoDetalle(producto, mainWindow);
                		
                	} else {		/* Borrar */
        				
                		ProductoServiceAsync service = GWT.create(ProductoService.class);
        				try {
        					service.eliminar(record.getAttributeAsInt("codigo"), new AsyncCallback<Void>() {

        						@Override
        						public void onFailure(Throwable caught) {
        							Window.alert("Ocurrio un error y no se puedo eliminar (objeto referenciado)");// " + caught.getClass().getName() + " " + caught.getMessage()) ;
        						}

        						@Override
        						public void onSuccess(Void result) {
        							new ProductoLista(mainWindow);
        						}       						
        					});
        				} catch (NumberFormatException e) {
        					e.printStackTrace();
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
                	}
                }
			}
		});
                
        productoGrid.setFields(codigoField, nombreField, cantidadField, costoField, gananciaField, editarField, borrarField);  
        productoGrid.setCanResizeFields(true);
        
        ButtonItem button = new ButtonItem("add", "Agregar");
        button.setStartRow(false);
        button.setWidth(80);
        button.setIcon("add.png");
        button.setAlign(Alignment.CENTER);
        button.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) { 		
        		new ProductoDetalle(mainWindow);    		
			}
		});

        listar(productoGrid, new Producto(), "descripcion"); 

		Label label = new Label();
        label.setHeight(30);
        label.setWidth(500);
        label.setPadding(10);   
        label.setAlign(Alignment.CENTER);   
        label.setValign(VerticalAlignment.CENTER);   
        label.setWrap(false);
        label.setShowEdges(true);   
        label.setContents("<b>Lista de Productos</b>");

        layout.addMember(label); 
        layout.addMember(buscarFields);
        layout.addMember(productoGrid);

        DynamicForm form = new DynamicForm();   
        form.setWidth(300);
        form.setItems(button);   
        layout.addMember(form);
        mainWindow.showDialog(layout);
	}
	
	private void listar(final ListGrid productoGrid, Producto producto, String orden) {

 		ProductoServiceAsync service = GWT.create(ProductoService.class);	

		try {
			service.listar(producto, orden, new AsyncCallback<List<Producto>>() {
				@Override
				public void onSuccess(List<Producto> result) {
					ProductoRecord [] r = new ProductoRecord [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0)!=null){
							r[f] = new ProductoRecord((int)result.get(f).getIdProducto(), result.get(f).getDescripcion(), result.get(f).getCantidad(), result.get(f).getCostoActual(), result.get(f).getPorcGanancia());							
						}
					}
					productoGrid.setData(r);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Ocurrio un error: " + caught.getClass().getName() + " " + caught.getMessage()) ;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ProductoRecord extends ListGridRecord {

	public ProductoRecord() {
	}

	public ProductoRecord(int codigo, String nombre, int cantidad, double costo, double ganancia) {
		setNombre(nombre);
		setCodigo(codigo);
		setCantidad(cantidad);
		setCosto(costo);
		setGanancia(ganancia);
		setEditar("edit");
		setBorrar("remove");
	}

	public void setCodigo(int codigo) {
		setAttribute("codigo", codigo);
	}

	public void setNombre(String nombre) {
		setAttribute("nombre", nombre);
	}

	public void setCantidad(int cantidad) {
		setAttribute("cantidad", cantidad);
	}

	public void setCosto(double costo) {
		setAttribute("costo", costo);
	}

	public void setGanancia(double ganancia) {
		setAttribute("porcgan", ganancia);
	}	
	
	public void setEditar(String edit) {
		setAttribute("edit", edit);
	}

	public void setBorrar(String remove) {
		setAttribute("remove", remove);
	}
}