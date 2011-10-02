package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.ProveedorService;
import com.fpuna.pweb.client.ProveedorServiceAsync;
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

import entidades.Proveedor;

public class ProveedorLista extends Canvas {
	
	public ProveedorLista(final TPFinal_GWT mainWindow) {

		String PATH_IMG = "/TPFinal-GWT/images/";
		VLayout layout = new VLayout(10);
        
        final ListGrid proveedorGrid = new ListGrid(); 

        proveedorGrid.setWidth(500);  
        proveedorGrid.setHeight(224);  
        proveedorGrid.setShowAllRecords(true);  
        proveedorGrid.setAlternateRecordStyles(true);
        proveedorGrid.setShowEdges(true);
        proveedorGrid.setBorder("0px");
        proveedorGrid.setBodyStyleName("normal");
        proveedorGrid.setLeaveScrollbarGap(false);
	    
        /*-Buscar ------------------------------*/
        DynamicForm buscarFields = new DynamicForm();
        buscarFields.setItemLayout(FormLayoutType.ABSOLUTE);
        
        final TextItem nombreText = new TextItem("nombre");
        nombreText.setWrapTitle(false);
        nombreText.setLeft(55);
        nombreText.setWidth(330);
        nombreText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Proveedor proveedor = null;
        			if(nombreText.getValueField() != null){
        				proveedor = new Proveedor();
        				proveedor.setNombre(nombreText.getValueField().toString());
        			}
        			listar(proveedorGrid, proveedor, "nombre");
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
        		Proveedor proveedor = null;
    			if(nombreText.getValueField() != null){
    				proveedor = new Proveedor();
    				proveedor.setNombre(nombreText.getValueField().toString());
    			}
    			listar(proveedorGrid, proveedor, "nombre");
			}
		});
        
        buscarFields.setFields(nombreText, buscarButton);
        /*--------------------------------------*/
        
        ListGridField codigoField = new ListGridField("codigo", "Codigo");
        ListGridField nombreField = new ListGridField("nombre", "Nombre");
        ListGridField editarField = new ListGridField("edit", "Editar");
        ListGridField borrarField = new ListGridField("remove", "Borrar");

        codigoField.setAlign(Alignment.CENTER);
        editarField.setAlign(Alignment.CENTER);
        borrarField.setAlign(Alignment.CENTER);

        editarField.setType(ListGridFieldType.IMAGE);
        borrarField.setType(ListGridFieldType.IMAGE);
        
        editarField.setImageURLPrefix(PATH_IMG); 
        borrarField.setImageURLPrefix(PATH_IMG);
        
        editarField.setImageURLSuffix(".png");
        borrarField.setImageURLSuffix(".png");

        proveedorGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
                ListGridRecord record =  event.getRecord();
                int col = event.getColNum();
                if (col > 1) {
                	
                	Proveedor proveedor = new Proveedor();				
                	proveedor.setIdProveedor(record.getAttributeAsInt("codigo"));
                	proveedor.setNombre(record.getAttribute("nombre"));
                	
                	if (col == 2) {	/* Editar */
                		
                		new ProveedorDetalle(proveedor, mainWindow);
                		
                	} else {		/* Borrar */
                		
                		ProveedorServiceAsync service = GWT.create(ProveedorService.class);
        				try {
        					service.eliminar(record.getAttributeAsInt("codigo"), new AsyncCallback<Void>() {

        						@Override
        						public void onFailure(Throwable caught) {
        							Window.alert("Ocurrio un error y no se puedo eliminar (objeto referenciado)");// " + caught.getClass().getName() + " " + caught.getMessage()) ;
        						}

        						@Override
        						public void onSuccess(Void result) {
        							new ProveedorLista(mainWindow);
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
                
        codigoField.setWidth(50);
        nombreField.setWidth(330);
        proveedorGrid.setFields(codigoField, nombreField, editarField, borrarField);  
        proveedorGrid.setCanResizeFields(true);
        
        ButtonItem button = new ButtonItem("add", "Agregar");
        button.setStartRow(false);
        button.setWidth(80);
        button.setIcon("add.png");
        button.setAlign(Alignment.CENTER);
        button.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
        		new ProveedorDetalle(mainWindow);
			}
		});

        listar(proveedorGrid, new Proveedor(), "nombre");
		
		Label label = new Label();
        label.setHeight(30);
        label.setWidth(500);
        label.setPadding(10);   
        label.setAlign(Alignment.CENTER);   
        label.setValign(VerticalAlignment.CENTER);   
        label.setWrap(false);
        label.setShowEdges(true);   
        label.setContents("<b>Lista de Proveedores</b>");

        layout.addMember(label);
        layout.addMember(buscarFields);
		layout.addMember(proveedorGrid);

        DynamicForm form = new DynamicForm();   
        form.setWidth(300);
        form.setItems(button);   
        layout.addMember(form);
        mainWindow.showDialog(layout);
	}
	
	private void listar(final ListGrid proveedorGrid, Proveedor proveedor, String orden) {
		
        ProveedorServiceAsync service = GWT.create(ProveedorService.class);	

		try {
			service.listar(proveedor, orden, new AsyncCallback<List<Proveedor>>() {
				@Override
				public void onSuccess(List<Proveedor> result) {
					ProveedorRecord [] r = new ProveedorRecord [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0)!=null){
							r[f] = new ProveedorRecord((int)result.get(f).getIdProveedor(), result.get(f).getNombre());
						}
					}
					proveedorGrid.setData(r);
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

class ProveedorRecord extends ListGridRecord {

	public ProveedorRecord() {
	}

	public ProveedorRecord(int codigo, String nombre) {
		setNombre(nombre);
		setCodigo(codigo);
		setEditar("edit");
		setBorrar("remove");
	}

	public void setCodigo(int codigo) {
		setAttribute("codigo", codigo);
	}

	public void setNombre(String nombre) {
		setAttribute("nombre", nombre);
	}
	
	public void setEditar(String edit) {
		setAttribute("edit", edit);
	}

	public void setBorrar(String remove) {
		setAttribute("remove", remove);
	}
}
