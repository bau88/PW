package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.PagoService;
import com.fpuna.pweb.client.PagoServiceAsync;
import com.fpuna.pweb.client.TPFinal_GWT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;   
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;   
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;   
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;   
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import entidades.Factura;
import entidades.Pago;

public class CobroDetalle extends Canvas {
	
	public CobroDetalle(final TPFinal_GWT mainWindow) {
		this(null, mainWindow);
	}
	
	public CobroDetalle(Factura factura, final TPFinal_GWT mainWindow) {
		
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
        label.setContents("<b>Pago de Factura</b>");
        
        TextItem codigoText = new TextItem("codigo");
        codigoText.setTitle("Codigo");
        codigoText.setDisabled(true);
        codigoText.setWrapTitle(false);
        
        TextItem nroFactText = new TextItem("nroFact");
        nroFactText.setTitle("Factura No");
        nroFactText.setDisabled(true);
        nroFactText.setWrapTitle(false);
        
        TextItem clienteText = new TextItem("cliente");
        clienteText.setTitle("Cliente");
        clienteText.setDisabled(true);
        clienteText.setWrapTitle(false);

        TextItem cajaText = new TextItem("caja");
        cajaText.setTitle("Caja");
        cajaText.setDisabled(true);
        cajaText.setWrapTitle(false);
        
        TextItem totalText = new TextItem("total");
        totalText.setTitle("Total");
        totalText.setDisabled(true);
        totalText.setWrapTitle(false);
        
        TextItem saldoText = new TextItem("saldo");
        saldoText.setTitle("Pagado");
        saldoText.setDisabled(true);
        saldoText.setWrapTitle(false);
        
        TextItem montoText = new TextItem("monto");
        montoText.setTitle("A Pagar");
        montoText.setWrapTitle(false);
      
        ButtonItem button = new ButtonItem("save", "Guardar");
        button.setStartRow(false);
        button.setWidth(80);
        button.setIcon("approve.png");
        button.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
        		
        		PagoServiceAsync service = GWT.create(PagoService.class);
        		
				final Pago pago = new Pago();
				
				pago.setId_factura(Integer.valueOf((form.getValueAsString("codigo"))));				
				pago.setMonto(Double.valueOf(form.getValueAsString("monto")));
				pago.setId_caja(Integer.valueOf(form.getValueAsString("caja")));					
				try { 

					service.guardar(pago, new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Ocurrio un error y no se puedo registrr el pago");
						}

						@Override
						public void onSuccess(Void result) {
							new CobroLista(mainWindow);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
        
		if (factura != null){
			codigoText.setDefaultValue(String.valueOf(factura.getIdFactura()));
			nroFactText.setDefaultValue(factura.getNumero());
			clienteText.setDefaultValue(factura.getCliente().getNombre());
			cajaText.setDefaultValue(mainWindow.getCaja()); // Esto cambiar
			totalText.setDefaultValue((float)factura.getMontoTotal());
			saldoText.setDefaultValue((float)factura.getSaldo());
		}
				
		form.setFields(codigoText, nroFactText, clienteText, cajaText, totalText, saldoText, montoText, button);
		layout.addMember(label);
        layout.addMember(form);
        mainWindow.showDialog(layout);
	}
}