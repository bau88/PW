package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.PagoService;
import com.fpuna.pweb.client.PagoServiceAsync;
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

import entidades.Caja;
import entidades.Cliente;
import entidades.Factura;
import entidades.Pago;

public class PagoLista extends Canvas {
	
	public PagoLista(final TPFinal_GWT mainWindow) {

		String PATH_IMG = "/TPFinal-GWT/images/";
		VLayout layout = new VLayout(10);
        
        final ListGrid pagoGrid = new ListGrid(); 

        pagoGrid.setWidth(500);  
        pagoGrid.setHeight(224);  
        pagoGrid.setShowAllRecords(true);  
        pagoGrid.setAlternateRecordStyles(true);
        pagoGrid.setShowEdges(true);
        pagoGrid.setBorder("0px");
        pagoGrid.setBodyStyleName("normal");
        pagoGrid.setLeaveScrollbarGap(false);
	    
        /*-Buscar ------------------------------*/
        DynamicForm buscarFields = new DynamicForm();
        buscarFields.setItemLayout(FormLayoutType.ABSOLUTE);
        
        final TextItem numeroText = new TextItem("numero");
        numeroText.setWrapTitle(false);
        numeroText.setLeft(55);
        numeroText.setWidth(50);
        numeroText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Pago pago = new Pago();
        			// VER COMO BUSCAR X EL NRO DE FACTURA
        			//pago.setNumero(numeroText.getValueField());
        			Factura factura = new Factura();
        			factura.setNumero(numeroText.getValueField());
        			listar(pagoGrid, pago, factura, null, null, "numero");
        		}
			}
        });
        
        final TextItem clienteText = new TextItem("cliente");
        clienteText.setWrapTitle(false);
        clienteText.setLeft(105);
        clienteText.setWidth(150);
        clienteText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Pago pago = new Pago();
        			// VER ESTA PARTE COMO ENVIAR EL CLIENTE PARA LA BUSQUEDA
        			//pago.setCliente();
        			Cliente cliente = new Cliente();
        			cliente.setNombre(clienteText.getValueField());
        			listar(pagoGrid, pago,null, cliente, null,"");
        		}
			}
        });
        
        final TextItem fechaText = new TextItem("fecha");
        fechaText.setWrapTitle(false);
        fechaText.setLeft(323);
        fechaText.setWidth(70);
        fechaText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Pago pago = new Pago();
        			pago.setFechCierre(new Date(fechaText.getValueField()));
        			listar(pagoGrid, pago, null, null,null, "fecha");
        		}
			}
        });
        
        final TextItem cajaText = new TextItem("caja");
        cajaText.setWrapTitle(false);
        cajaText.setLeft(393);
        cajaText.setWidth(50);
        cajaText.addKeyPressHandler(new KeyPressHandler () {
        	public void onKeyPress(KeyPressEvent event) {
        		if ("Enter".equals(event.getKeyName())) {
        			/* buscar por el campo correspondiente */
        			Pago pago = new Pago();
        			// VER ESTA PARTE COMO ENVIAR EL CAJA PARA LA BUSQUEDA
        			Caja caja = new Caja();
        			caja.setIdCaja(Integer.valueOf(cajaText.getValueField()));
        			
        			listar(pagoGrid, pago, null, null, caja, "");
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
    			Pago pago = new Pago();
        		//pago.setNumero(numeroText.getValueField());
        		// VER ESTA PARTE COMO ENVIAR EL CLIENTE PARA LA BUSQUEDA
    			
    			Cliente cliente = new Cliente();
    			cliente.setNombre(numeroText.getValueField());
    			//pago.setCliente(clienteText.getValueField());
        		//pago.setFecha(fechaText.getValueField());
        		// VER ESTA PARTE COMO ENVIAR EL CAJA PARA LA BUSQUEDA
    			//pago.setCaja(cajaText.getValueField());
    			Caja caja = new Caja();
    			caja.setIdCaja(Integer.valueOf(cajaText.getValueField()));
    			listar(pagoGrid, pago, null, cliente,caja, "numero");
			}
		});
        
        buscarFields.setFields(numeroText, clienteText, fechaText, cajaText, buscarButton);
        /*--------------------------------------*/
        
        ListGridField codigoField = new ListGridField("codigo", "Codigo");
        ListGridField numeroField = new ListGridField("numero", "Numero");
        ListGridField clienteField = new ListGridField("cliente", "Cliente");
        ListGridField montoField = new ListGridField("monto", "Monto");
        ListGridField fechaField = new ListGridField("fecha", "Fecha");
        ListGridField cajaField = new ListGridField("caja", "Caja");
        ListGridField borrarField = new ListGridField("remove", "Borrar");

        codigoField.setAlign(Alignment.CENTER);
        numeroField.setAlign(Alignment.CENTER);
        montoField.setAlign(Alignment.RIGHT);
        cajaField.setAlign(Alignment.CENTER);
        borrarField.setAlign(Alignment.CENTER);

        codigoField.setWidth(50);
        clienteField.setWidth(150);
        montoField.setWidth(68);
        numeroField.setWidth(50);
        fechaField.setWidth(70);
        cajaField.setWidth(50);
        borrarField.setWidth(50);
        
        borrarField.setType(ListGridFieldType.IMAGE); 
        borrarField.setImageURLPrefix(PATH_IMG);
        borrarField.setImageURLSuffix(".png");

        pagoGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
                ListGridRecord record =  event.getRecord();
                int col = event.getColNum();
                if (col > 5) {
     				
            		PagoServiceAsync service = GWT.create(PagoService.class);
    				try {
    					service.eliminar(record.getAttributeAsInt("codigo"), new AsyncCallback<Void>() {

    						@Override
    						public void onFailure(Throwable caught) {
    							Window.alert("Ocurrio un error: " + caught.getClass().getName() + " " + caught.getMessage()) ;
    						}

    						@Override
    						public void onSuccess(Void result) {
    							new PagoLista(mainWindow);
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
                
        pagoGrid.setFields(codigoField, numeroField, clienteField, montoField, fechaField, cajaField, borrarField);  
        pagoGrid.setCanResizeFields(true);
        
        ButtonItem button = new ButtonItem("add", "Agregar");
        button.setStartRow(false);
        button.setWidth(80);
        button.setIcon("add.png");
        button.setAlign(Alignment.CENTER);
        button.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {	
        		new CobroLista(mainWindow); 		
			}
		});
        
        ButtonItem buttonCerrar = new ButtonItem("cerrar", "Cerrar Caja");
        buttonCerrar.setStartRow(false);
        buttonCerrar.setTop(-33);
        buttonCerrar.setLeft(390);
        buttonCerrar.setWidth(100);
        buttonCerrar.setIcon("cerrarcaja.png");
        buttonCerrar.setAlign(Alignment.CENTER);
        buttonCerrar.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
    			Window.open("/TPFinal-GWT/tpfinal_gwt/servicioReporte?reporte=cierrecaja&numero_caja=" + mainWindow.getCaja(), "_blank", null);
        		new PagoLista(mainWindow);    		
			}
		}); 

        
        listar(pagoGrid, new Pago(), null, null, null, "idPago");
        		
		Label label = new Label();
        label.setHeight(30);
        label.setWidth(500);
        label.setPadding(10);   
        label.setAlign(Alignment.CENTER);   
        label.setValign(VerticalAlignment.CENTER);   
        label.setWrap(false);
        label.setShowEdges(true);   
        label.setContents("<b>Lista de Pagos</b>");

        layout.addMember(label);
        layout.addMember(buscarFields);
        layout.addMember(pagoGrid);

        DynamicForm form = new DynamicForm();   
        form.setWidth(300);
        form.setItems(button);
        layout.addMember(form);
        
        DynamicForm formCerrar = new DynamicForm();
        formCerrar.setItemLayout(FormLayoutType.ABSOLUTE);
        formCerrar.setItems(buttonCerrar);		

        layout.addMember(formCerrar);
        
        mainWindow.showDialog(layout);
	}
	
	private void listar(final ListGrid pagoGrid, Pago pago, Factura factura, Cliente cliente, Caja caja, String orden) {
		PagoServiceAsync service = GWT.create(PagoService.class);	

		try {
			service.listar(pago, factura, cliente, caja, orden, new AsyncCallback<List<Pago>>() {
				@Override
				public void onSuccess(List<Pago> result) {
					PagoRecord [] r = new PagoRecord [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0)!=null){ //(int codigo, String numero, String cliente, double monto, Date fecha, int caja)
							r[f] = new PagoRecord((int)result.get(f).getIdPago(), result.get(f).getFactura().getNumero(), 
									result.get(f).getFactura().getCliente().getNombre(), result.get(f).getMonto(), result.get(f).getFechCierre(), 
									result.get(f).getCaja().getDescripcion());							
						}
					}
					pagoGrid.setData(r);
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

class PagoRecord extends ListGridRecord { 

	public PagoRecord() {
	}
    ListGridField codigoField = new ListGridField("codigo", "Codigo");
    ListGridField numeroField = new ListGridField("numero", "Numero");
    ListGridField clienteField = new ListGridField("cliente", "Cliente");
    ListGridField montoField = new ListGridField("monto", "Monto");
    ListGridField fechaField = new ListGridField("fecha", "Fecha");
    ListGridField cajaField = new ListGridField("caja", "Caja");
    ListGridField borrarField = new ListGridField("remove", "Borrar");
	public PagoRecord(int codigo, String numero, String cliente, double monto, Date fecha, String caja) {
		setCodigo(codigo);
		setNumero(numero);
		setCliente(cliente);
		setMonto(monto);
		setFecha(fecha);
		setCaja(caja);
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

	public void setMonto(double monto) {
		setAttribute("monto", monto);
	}

	public void setFecha(Date fecha) {
		setAttribute("fecha", fecha);
	}	
	
	public void setCaja(String caja) {
		setAttribute("caja", caja);
	}

	public void setBorrar(String remove) {
		setAttribute("remove", remove);
	}
}