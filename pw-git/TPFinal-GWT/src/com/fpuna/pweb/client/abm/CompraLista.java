package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.CompraService;
import com.fpuna.pweb.client.CompraServiceAsync;
import com.fpuna.pweb.client.TPFinal_GWT;

import java.util.Date;
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

import entidades.Compra;
import entidades.Proveedor;

public class CompraLista extends Canvas {
	
	public CompraLista(final TPFinal_GWT mainWindow) {

		String PATH_IMG = "/TPFinal-GWT/images/";
		VLayout layout = new VLayout(10);
        
        final ListGrid compraGrid = new ListGrid(); 

        compraGrid.setWidth(500);  
        compraGrid.setHeight(224);  
        compraGrid.setShowAllRecords(true);  
        compraGrid.setAlternateRecordStyles(true);
        compraGrid.setShowEdges(true);
        compraGrid.setBorder("0px");
        compraGrid.setBodyStyleName("normal");
        compraGrid.setLeaveScrollbarGap(false);
        compraGrid.setTitle("Lista de Compras");
        
        /*-Buscar ------------------------------*/
        DynamicForm buscarFields = new DynamicForm();
        buscarFields.setItemLayout(FormLayoutType.ABSOLUTE);
        
        final TextItem proveedorText = new TextItem("proveedor");
        proveedorText.setWrapTitle(false);
        proveedorText.setLeft(55);
        proveedorText.setWidth(200);
        proveedorText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Compra compra = new Compra();
        			// VER ESTA PARTE COMO ENVIAR EL PROVEEDOR PARA LA BUSQUEDA
        			Proveedor prov = null;
        			if(proveedorText.getValue() != null){
        				prov = new Proveedor();
        				prov.setNombre(proveedorText.getValue().toString());
        			}
        			
        			listar(compraGrid, compra, prov, "");
        		}
			}
        });
        
        final TextItem fechaText = new TextItem("fecha");
        fechaText.setWrapTitle(false);
        fechaText.setLeft(255);
        fechaText.setWidth(118);
        fechaText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Compra compra = null;
        			// VERIFICAR
        			if(fechaText.getValue() != null){
        				compra = new Compra();
        				compra.setFecha(new Date(fechaText.getValue().toString()));
        			}
        			listar(compraGrid, compra,null, "fecha");
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
    			Compra compra = new Compra();
    			// VER ESTA PARTE COMO ENVIAR EL PROVEEDOR PARA LA BUSQUEDA
    			//Proveedor prov = new Proveedor();
    			//prov.setNombre(proveedorText.getValue().toString());
    			//compra.setProveedor(prov);
    			Proveedor proveedor = new Proveedor();
    			if(proveedorText.getValue() != null)
    				proveedor.setNombre(proveedorText.getValue().toString());
        		// VERIFICAR
    			if(fechaText.getValue() != null)
    				compra.setFecha(new Date(fechaText.getValue().toString()));
    			listar(compraGrid, compra, proveedor, "fecha");
			}
		});
        
        buscarFields.setFields(proveedorText, fechaText, buscarButton);
        /*--------------------------------------*/
	      
        ListGridField codigoField = new ListGridField("codigo", "Codigo");
        ListGridField proveedorField = new ListGridField("proveedor", "Proveedor");
        ListGridField fechaField = new ListGridField("fecha", "Fecha");
        ListGridField totalField = new ListGridField("total", "Total");
        ListGridField borrarField = new ListGridField("remove", "Borrar");

        codigoField.setAlign(Alignment.CENTER);
        totalField.setAlign(Alignment.RIGHT);
        borrarField.setAlign(Alignment.CENTER);
        
        codigoField.setWidth(50);
        proveedorField.setWidth(200);
        fechaField.setWidth(118);
        totalField.setWidth(70);
        borrarField.setWidth(50);
        
        borrarField.setType(ListGridFieldType.IMAGE); 
        borrarField.setImageURLPrefix(PATH_IMG);
        borrarField.setImageURLSuffix(".png");

        compraGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
                ListGridRecord record =  event.getRecord();
                int col = event.getColNum();
                if (col > 3) {
                	
                    CompraServiceAsync service = GWT.create(CompraService.class);	
                    /* Borrar */

    				try {
    					service.eliminar(record.getAttributeAsInt("codigo"), new AsyncCallback<Void>() {

    						@Override
    						public void onFailure(Throwable caught) {
    							Window.alert("Ocurrio un error: " + caught.getClass().getName() + " " + caught.getMessage()) ;
    						}

    						@Override
    						public void onSuccess(Void result) {
    							new CompraLista(mainWindow);
    						}       						
    					});
    				} catch (NumberFormatException e) {
    					e.printStackTrace();
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
                }
			}
		});

        compraGrid.setFields(codigoField, proveedorField, fechaField, totalField, borrarField);  
        compraGrid.setCanResizeFields(true);
        
        ButtonItem button = new ButtonItem("add", "Agregar");
        button.setStartRow(false);
        button.setWidth(80);
        button.setIcon("add.png");
        button.setAlign(Alignment.CENTER);
        button.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
        		new CompraDetalle(mainWindow);
			}
		});
        
        listar(compraGrid, new Compra(), null, "fecha");
        
		Label label = new Label();
        label.setHeight(30);
        label.setWidth(500);
        label.setPadding(10);   
        label.setAlign(Alignment.CENTER);   
        label.setValign(VerticalAlignment.CENTER);   
        label.setWrap(false);
        label.setShowEdges(true);   
        label.setContents("<b>Lista de Compra</b>");

        layout.addMember(label);
        layout.addMember(buscarFields);
		layout.addMember(compraGrid);

        DynamicForm form = new DynamicForm();   
        form.setWidth(300);
        form.setItems(button);   
        layout.addMember(form);
        mainWindow.showDialog(layout);
	}
	
	private void listar(final ListGrid compraGrid, Compra compra, Proveedor proveedor, String orden) {
		
        CompraServiceAsync service = GWT.create(CompraService.class);	

		try {
			service.listar(compra,proveedor, orden, new AsyncCallback<List<Compra>>() {
				@Override
				public void onSuccess(List<Compra> result) {
					CompraRecord [] r = new CompraRecord [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0) != null){
							r[f] = new CompraRecord((int)result.get(f).getIdCompra(), result.get(f).getNombre_proveedor(),
									result.get(f).getFecha(), result.get(f).getTotalCompra());
						}
					}
					compraGrid.setData(r);
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

class CompraRecord extends ListGridRecord {

	public CompraRecord() {
	}

	public CompraRecord(int codigo, String proveedor, Date fecha, double total) {
		setCodigo(codigo);
		setProveedor(proveedor);
		setFecha(fecha);
		setTotal(total);
		setBorrar("remove");
	}

	public void setCodigo(int codigo) {
		setAttribute("codigo", codigo);
	}
	
	public void setProveedor(String proveedor) {
		setAttribute("proveedor", proveedor);
	}
	
	public void setFecha(Date fecha) {
		setAttribute("fecha", fecha);
	}

	public void setTotal(double total) {
		setAttribute("total", total);
	}

	public void setBorrar(String remove) {
		setAttribute("remove", remove);
	}
}
