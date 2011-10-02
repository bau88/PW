package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.FacturaService;
import com.fpuna.pweb.client.FacturaServiceAsync;
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

public class CobroLista extends Canvas {
	
	public CobroLista(final TPFinal_GWT mainWindow) {

		String PATH_IMG = "/TPFinal-GWT/images/";
		VLayout layout = new VLayout(10);
        
        final ListGrid cobroGrid = new ListGrid();

        cobroGrid.setWidth(500);
        cobroGrid.setHeight(224);
        cobroGrid.setShowAllRecords(true);
        cobroGrid.setAlternateRecordStyles(true);
        cobroGrid.setShowEdges(true);
        cobroGrid.setBorder("0px");
        cobroGrid.setBodyStyleName("normal");
        cobroGrid.setLeaveScrollbarGap(false);
        cobroGrid.setTitle("Lista Pendiente de Cobros");

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
        			factura.setNumero(numeroText.getValue().toString());
        			listar(cobroGrid, null, factura, "numero");
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
        			// VER ESTA PARTE COMO ENVIAR EL CLIENTE PARA LA BUSQUEDA
        			Cliente cliente = new Cliente();
        			cliente.setNombre(clienteText.getValue().toString());
        			//factura.setCliente(clienteText.getValueField());
        			listar(cobroGrid, cliente, factura, "");
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
        			Factura factura = new Factura();
        			// VERIFICAR
        			factura.setFecha(new Date(fechaText.getValue().toString()));
        			listar(cobroGrid, null, factura, "fecha");
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
        		factura.setNumero(numeroText.getValueField());
        		// VER ESTA PARTE COMO ENVIAR EL CLIENTE PARA LA BUSQUEDA
        		Cliente cliente = new Cliente();
    			cliente.setNombre(clienteText.getValue().toString());
    			//factura.setCliente(clienteText.getValueField());
        		// VERIFICAR!!
        		factura.setFecha(new Date(fechaText.getValue().toString()));
    			listar(cobroGrid, cliente, factura, "numero");
			}
		});
        
        buscarFields.setFields(numeroText, clienteText, fechaText, buscarButton);
        /*--------------------------------------*/
        
        ListGridField codigoField = new ListGridField("codigo", "Codigo");
        ListGridField numeroField = new ListGridField("numero", "Numero");
        ListGridField clienteField = new ListGridField("cliente", "Cliente");
        ListGridField fechaField = new ListGridField("fecha", "Fecha");
        ListGridField totalField = new ListGridField("total", "Total");
        ListGridField saldoField = new ListGridField("saldo", "Pagado");
        ListGridField cobrarField = new ListGridField("caja", "Cobrar");

        codigoField.setAlign(Alignment.CENTER);
        numeroField.setAlign(Alignment.CENTER);
        totalField.setAlign(Alignment.RIGHT);
        saldoField.setAlign(Alignment.RIGHT);
        cobrarField.setAlign(Alignment.CENTER);
        
        codigoField.setWidth(50);
        numeroField.setWidth(48);
        clienteField.setWidth(140);
        fechaField.setWidth(100);
        totalField.setWidth(50);
        saldoField.setWidth(50);
        cobrarField.setWidth(50);
        
        cobrarField.setType(ListGridFieldType.IMAGE);
        cobrarField.setImageURLPrefix(PATH_IMG);
        cobrarField.setImageURLSuffix(".png");

        cobroGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
                ListGridRecord record =  event.getRecord();
                int col = event.getColNum();
                if (col > 5) {
                	Factura factura = new Factura();
                	factura.setIdFactura(Integer.parseInt(record.getAttribute("codigo")));
                	factura.setNumero(record.getAttribute("numero"));
                	Cliente cliente = new Cliente();
                	cliente.setNombre(record.getAttribute("cliente"));
                	factura.setCliente(cliente);
                	factura.setMontoTotal(Double.parseDouble(record.getAttribute("total")));
                	factura.setSaldo(Double.parseDouble(record.getAttribute("saldo")));
            		new CobroDetalle(factura, mainWindow);
                }
			}
		});
        
        cobroGrid.setFields(codigoField, numeroField, clienteField, fechaField, totalField, saldoField, /*editarField,*/ cobrarField);
        cobroGrid.setCanResizeFields(true);
        
        /* Traer solo las pendientes de cobro */
        Factura factura = new Factura();
        factura.setPendiente("S");
        listar(cobroGrid, null, factura, "");   
        
		Label label = new Label();
        label.setHeight(30);
        label.setWidth(500);
        label.setPadding(10);   
        label.setAlign(Alignment.CENTER);   
        label.setValign(VerticalAlignment.CENTER);   
        label.setWrap(false);
        label.setShowEdges(true);   
        label.setContents("<b>Facturas Pendienentes de Cobro</b>");

        layout.addMember(label);
        layout.addMember(buscarFields);
        layout.addMember(cobroGrid);
        
        DynamicForm form = new DynamicForm();   
        form.setWidth(300);

        layout.addMember(form);
        mainWindow.showDialog(layout);
	}
	
	private void listar(final ListGrid cobroGrid, Cliente cliente, Factura factura, String orden) {
		
        FacturaServiceAsync service = GWT.create(FacturaService.class);	

		try {
			service.listar(factura, cliente, orden, new AsyncCallback<List<Factura>>() {
				@Override
				public void onSuccess(List<Factura> result) {
					CobroRecord [] r = new CobroRecord [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0)!=null){
							r[f] = new CobroRecord((int)result.get(f).getIdFactura(), result.get(f).getNumero(), result.get(f).getCliente().getNombre(), result.get(f).getFecha(), result.get(f).getMontoTotal(),result.get(f).getSaldo());
						}
					}
					cobroGrid.setData(r);
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

class CobroRecord extends ListGridRecord {
	
	public CobroRecord() {
	}
	
	public CobroRecord(int codigo, String numero, String cliente, Date fecha, double total, double saldo) {
		setCodigo(codigo);
		setNumero(numero);
		setCliente(cliente);
		setFecha(fecha);
		setTotal(total);
		setSaldo(saldo);
		setCobrar("caja");
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
	
	public void setEditar(String edit) {
		setAttribute("edit", edit);
	}
	
	public void setCobrar(String caja) {
		setAttribute("caja", caja);
	}
}