package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.FacturaService;
import com.fpuna.pweb.client.FacturaServiceAsync;
import com.fpuna.pweb.client.TPFinal_GWT;

import com.fpuna.pweb.client.abm.VentaDetalle;

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

import entidades.Cliente;
import entidades.Factura;

public class VentaLista extends Canvas {
	
	public VentaLista(final TPFinal_GWT mainWindow) {

		String PATH_IMG = "/TPFinal-GWT/images/";
		VLayout layout = new VLayout(10);
        
        final ListGrid ventaGrid = new ListGrid(); 

        ventaGrid.setWidth(500);  
        ventaGrid.setHeight(224);  
        ventaGrid.setShowAllRecords(true);  
        ventaGrid.setAlternateRecordStyles(true);
        ventaGrid.setShowEdges(true);
        ventaGrid.setBorder("0px");
        ventaGrid.setBodyStyleName("normal");
        ventaGrid.setLeaveScrollbarGap(false);
        ventaGrid.setTitle("Lista de Ventas");
	    
        /*-Buscar ------------------------------*/
        DynamicForm buscarFields = new DynamicForm();
        buscarFields.setItemLayout(FormLayoutType.ABSOLUTE);
        
        final TextItem numeroText = new TextItem("numero");
        numeroText.setWrapTitle(false);
        numeroText.setLeft(55);
        numeroText.setWidth(48);
        numeroText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Factura factura = new Factura();
        			if(numeroText.getValue() != null)
        				factura.setNumero(numeroText.getValue().toString());
        			listar(ventaGrid, factura, null, "numero");
        		}
			}
        });
        
        final TextItem clienteText = new TextItem("cliente");
        clienteText.setWrapTitle(false);
        clienteText.setLeft(103);
        clienteText.setWidth(140);
        clienteText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Factura factura = new Factura();
        			Cliente cliente_buscar =null;
        			if(clienteText.getValue()!= null){
        				cliente_buscar = new Cliente();
        				cliente_buscar.setNombre(clienteText.getValue().toString());
        			}
            		listar(ventaGrid, factura,cliente_buscar, "numero");
        		}
			}
        });
        
        final TextItem fechaText = new TextItem("fecha");
        fechaText.setWrapTitle(false);
        fechaText.setLeft(243);
        fechaText.setWidth(100);
        fechaText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Factura factura = null;
        			if(fechaText.getValue()!= null){
        				factura = new Factura();
        				factura.setFecha(new Date(fechaText.getValue().toString()));	
        			}
        			
        			listar(ventaGrid, factura,null, "fecha");
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
    			Factura factura = new Factura();
    			if(numeroText.getValue()!=null)
    				factura.setNumero(numeroText.getValue().toString());
    			if(fechaText.getValue()!= null)
    				factura.setFecha(new Date(fechaText.getValue().toString()));
    			Cliente cliente_buscar = null;
    			if(clienteText.getValue() != null){
    				cliente_buscar = new Cliente();
    				cliente_buscar.setNombre(clienteText.getValue().toString());
    			}
    			listar(ventaGrid, factura,cliente_buscar, "numero");
			}
		});
        
        buscarFields.setFields(numeroText, clienteText, fechaText, buscarButton);
        /*--------------------------------------*/
        
        ListGridField codigoField = new ListGridField("codigo", "Codigo");
        ListGridField numeroField = new ListGridField("numero", "Numero");
        ListGridField clienteField = new ListGridField("cliente", "Cliente");
        ListGridField fechaField = new ListGridField("fecha", "Fecha");
        ListGridField totalField = new ListGridField("total", "Total");
        ListGridField saldoField = new ListGridField("saldo", "Saldo");
        ListGridField borrarField = new ListGridField("remove", "Borrar");

        codigoField.setAlign(Alignment.CENTER);
        numeroField.setAlign(Alignment.CENTER);
        totalField.setAlign(Alignment.RIGHT);
        saldoField.setAlign(Alignment.RIGHT);
        borrarField.setAlign(Alignment.CENTER);
        
        codigoField.setWidth(50);
        numeroField.setWidth(48);
        clienteField.setWidth(140);
        fechaField.setWidth(100);
        totalField.setWidth(50);
        saldoField.setWidth(50);
        borrarField.setWidth(50);
        
        borrarField.setType(ListGridFieldType.IMAGE); 
        borrarField.setImageURLPrefix(PATH_IMG);
        borrarField.setImageURLSuffix(".png");

        ventaGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
                ListGridRecord record =  event.getRecord();
                int col = event.getColNum();
                if (col > 5) {
                	
                    FacturaServiceAsync service = GWT.create(FacturaService.class);
                	/* Borrar */
            	    
    				try {
    					service.eliminar(record.getAttributeAsInt("codigo"), new AsyncCallback<Void>() {
	
    						@Override
    						public void onFailure(Throwable caught) {
    							Window.alert("Ocurrio un error: " + caught.getClass().getName() + " " + caught.getMessage()) ;
    						}
	
    						@Override
    						public void onSuccess(Void result) {
    							new VentaLista(mainWindow);
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
        
        ventaGrid.setFields(codigoField, numeroField, clienteField, fechaField, totalField, saldoField, borrarField);  
        ventaGrid.setCanResizeFields(true);
        
        ButtonItem button = new ButtonItem("add", "Agregar");
        button.setStartRow(false);
        button.setWidth(80);
        button.setIcon("add.png");
        button.setAlign(Alignment.CENTER);
        button.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
        		new VentaDetalle(mainWindow);
			}
		});
        
        listar(ventaGrid, new Factura(), null, "fecha");
        
		Label label = new Label();
        label.setHeight(30);
        label.setWidth(500);
        label.setPadding(10);   
        label.setAlign(Alignment.CENTER);   
        label.setValign(VerticalAlignment.CENTER);   
        label.setWrap(false);
        label.setShowEdges(true);   
        label.setContents("<b>Lista de Ventas</b>");

        layout.addMember(label);
        layout.addMember(buscarFields);
		layout.addMember(ventaGrid);
        
        DynamicForm form = new DynamicForm();   
        form.setWidth(300);
        form.setItems(button);   
        layout.addMember(form);
        mainWindow.showDialog(layout);
	}
	
	private void listar(final ListGrid ventaGrid, Factura factura, Cliente cliente, String orden) {
	    
		FacturaServiceAsync service = GWT.create(FacturaService.class);	
		
		try {
			service.listar(factura, cliente, orden, new AsyncCallback<List<Factura>>() {
				@Override
				public void onSuccess(List<Factura> result) {
					VentaRecord [] r = new VentaRecord [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0)!=null) { 
							r[f] = new VentaRecord((int)result.get(f).getIdFactura(), result.get(f).getNumero(), result.get(f).getCliente().getNombre(), result.get(f).getFecha(), result.get(f).getMontoTotal(), result.get(f).getSaldo());
						}
					}
					ventaGrid.setData(r);
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

class VentaRecord extends ListGridRecord {
	
	public VentaRecord() {
	}
	
	public VentaRecord(int codigo, String numero, String cliente, Date fecha, double total, double saldo) {
		setCodigo(codigo);
		setNumero(numero);
		setCliente(cliente);
		setFecha(fecha);
		setTotal(total);
		setSaldo(saldo);
		setBorrar("remove");
	}
	
	public void setCodigo(int codigo) {
		setAttribute("codigo", codigo);
	}
	
	public void setNumero(String numero) {
		setAttribute("numero", numero);
	}
	
	public void setCliente(String cliente) {
		setAttribute("cliente", cliente);
	}
	
	public void setFecha(Date fecha) {
		setAttribute("fecha", fecha);
	}

	public void setTotal(double total) {
		setAttribute("total", total);
	}
	
	public void setSaldo(double saldo) {
		setAttribute("saldo", saldo);
	}
	
	public void setBorrar(String remove) {
		setAttribute("remove", remove);
	}
}