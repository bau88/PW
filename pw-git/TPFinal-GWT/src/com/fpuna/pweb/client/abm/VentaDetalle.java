package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.ClienteService;
import com.fpuna.pweb.client.ClienteServiceAsync;
import com.fpuna.pweb.client.FacturaService;
import com.fpuna.pweb.client.FacturaServiceAsync;
import com.fpuna.pweb.client.ProductoService;
import com.fpuna.pweb.client.ProductoServiceAsync;
import com.fpuna.pweb.client.TPFinal_GWT;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.types.FormLayoutType;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.ListGridField;  
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import entidades.Cliente;
import entidades.Factura;
import entidades.FacturaDetalle;
import entidades.Producto;

public class VentaDetalle extends Canvas {
	
	public VentaDetalle(final TPFinal_GWT mainWindow) {
		
		String PATH_IMG = "/TPFinal-GWT/images/";
		HLayout hLayout = new HLayout(2);
		VLayout vLayout = new VLayout(4);
        
		/* Título ------------------------------------ */
		Label label = new Label();
        label.setHeight(30);
        label.setWidth(500);
        label.setPadding(10);   
        label.setAlign(Alignment.CENTER);   
        label.setValign(VerticalAlignment.CENTER);   
        label.setWrap(false);
        label.setShowEdges(true);   
        label.setContents("<b>Registro de Venta</b>");
		/* ------------------------------------------- */

        /* Cabecera ---------------------------------- */
        final Map<String, String> cliente = new HashMap<String, String>();
        final SelectItem clienteItem = new SelectItem();
        clienteItem.setName("cliente");
        clienteItem.setTitle("Cliente");
        clienteItem.setAddUnknownValues(false);
        clienteItem.setWidth(150);
        clienteItem.setLeft(100);
        
        /* Para cargar el comboBox de Clientes */

        ClienteServiceAsync service = GWT.create(ClienteService.class);	

		try {
			Cliente cliente_listar = new Cliente();
			String orden = "idCliente";
			service.listar(cliente_listar, orden, new AsyncCallback<List<Cliente>>() {
				@Override
				public void onSuccess(List<Cliente> result) {
					String [] r = new String [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0)!=null){
							cliente.put(result.get(f).getNombre(), new String ("" + result.get(f).getIdCliente()));
							r[f] = new String(result.get(f).getNombre());
						}
					}
					clienteItem.setValueMap(r);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Ocurrio un error: " + caught.getClass().getName() + " " + caught.getMessage()) ;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	
        final TextItem nroFactText = new TextItem("nroFact");
        nroFactText.setTitle("Factura No");
        nroFactText.setWrapTitle(false);
        nroFactText.setWidth(150);
        nroFactText.setLeft(360);
        nroFactText.setTextAlign(Alignment.CENTER);
        
		final DateItem fechaItem = new DateItem();
        fechaItem.setName("fecha");
        fechaItem.setTitle("Fecha");
        fechaItem.setUseTextField(true);
        fechaItem.setDefaultValue(new Date ());
        fechaItem.setDateFormatter(DateDisplayFormat.TOEUROPEANSHORTDATE);
        fechaItem.setWidth(146);
        fechaItem.setLeft(400);
        
        final DynamicForm formCab = new DynamicForm();
        formCab.setItems(clienteItem, nroFactText, fechaItem);
        formCab.setItemLayout(FormLayoutType.TABLE);
		HLayout hLayoutCab = new HLayout(2);
		hLayoutCab.addMember(formCab);
        
		/* Total ------------------------------------- */
        final TextItem totalText = new TextItem("total");
        totalText.setTitle("Total");
        totalText.setWrapTitle(false);
        totalText.setDisabled(true);
        totalText.setWidth(80);
        totalText.setLeft(360);
        totalText.setTextAlign(Alignment.RIGHT);
        /* ------------------------------------------- */
        
		/* Grilla ------------------------------------ */
        final ListGrid ventaGrid = new ListGrid();
        
        ventaGrid.setWidth(500);  
        ventaGrid.setHeight(224);  
        ventaGrid.setShowAllRecords(true);  
        ventaGrid.setAlternateRecordStyles(true);
        ventaGrid.setShowEdges(true);
        ventaGrid.setBorder("0px");
        ventaGrid.setBodyStyleName("normal");
        ventaGrid.setLeaveScrollbarGap(false);
        ventaGrid.setTitle("Clic sobre la fila en la columna 'Borrar' para eliminar");
        ventaGrid.setAutoFetchData(true);  
        ventaGrid.setCanEdit(true);  
        ventaGrid.setEditEvent(ListGridEditEvent.CLICK);  
        ventaGrid.setListEndEditAction(RowEndEditAction.NEXT);
        
        
        /* Columnas ---------------------------------- */
        ListGridField codigoField = new ListGridField("codigo", "Codigo");
        final ListGridField productoField = new ListGridField("producto", "Producto");
        ListGridField cantidadField = new ListGridField("cantidad", "Cantidad");
        ListGridField precioField = new ListGridField("precio", "Precio");
        ListGridField totalField = new ListGridField("total", "Total");
        ListGridField borrarField = new ListGridField("remove", "Borrar");
        
        cantidadField.setType(ListGridFieldType.INTEGER);
        precioField.setType(ListGridFieldType.FLOAT);
        totalField.setType(ListGridFieldType.FLOAT);
                
        cantidadField.addChangedHandler(new ChangedHandler() {  
            public void onChanged(ChangedEvent event) {
            	calcularProducto(event.getRowNum(), ventaGrid, totalText);
            }  
        });
        
        codigoField.setAlign(Alignment.CENTER);
        cantidadField.setAlign(Alignment.RIGHT);
        precioField.setAlign(Alignment.RIGHT);
        totalField.setAlign(Alignment.RIGHT);
        borrarField.setAlign(Alignment.CENTER);

        precioField.setCanEdit(false);
        totalField.setCanEdit(false);
        borrarField.setCanEdit(false);
        
        codigoField.setHidden(true);
        productoField.setWidth(200);
        cantidadField.setWidth(79);
        precioField.setWidth(79);
        totalField.setWidth(80);
        borrarField.setWidth(50);
        
        borrarField.setType(ListGridFieldType.IMAGE);
        borrarField.setImageURLPrefix(PATH_IMG);
        borrarField.setImageURLSuffix(".png");
        
        borrarField.setDefaultValue("remove");
        
        /* Para cargar el comboBox de Productos */
        final Map<String, String> producto = new HashMap<String, String>();
		final Map<String, String> productoPrecio = new HashMap<String, String>();
        
        ProductoServiceAsync service_producto = GWT.create(ProductoService.class);	

		try {
			Producto producto_combo = new Producto();
			String orden = "idProducto";
			service_producto.listar(producto_combo, orden, new AsyncCallback<List<Producto>>() {
				@Override
				public void onSuccess(List<Producto> result) {
					String [] r = new String [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0)!=null){
							producto.put(result.get(f).getDescripcion(), new String ("" + result.get(f).getIdProducto()));
							productoPrecio.put(result.get(f).getDescripcion(), new String ("" + result.get(f).getCostoActual()));
							r[f] = new String(result.get(f).getDescripcion());
						}
					}
					productoField.setValueMap(r);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Ocurrio un error: " + caught.getClass().getName() + " " + caught.getMessage()) ;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		        
		//record.getAttributeAsString("producto")
		// recuperar el precio, no se usa aca
		productoField.addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				String precio = productoPrecio.get(event.getValue());
        		ventaGrid.setEditValue(event.getRowNum(), "precio", precio);

				//Window.alert(event.getValue() + ", precio: " + precio + ", fila: " + event.getRowNum());
			}
		});
/*        productoField.addChangedHandler(new ChangedHandler() {  
            public void onChanged(ChangedEvent event) {
            	String precio = productoPrecio.get(productoField.getValueField());
        		ventaGrid.setEditValue(event.getRowNum(), "precio", precio);
            }  
        });
*/
		ventaGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
                ListGridRecord record =  event.getRecord();
                int col = event.getColNum();
                if (col > 3) { /* Eliminar de la grilla */
                	ventaGrid.removeData(record);
                	calcularTotal(ventaGrid, totalText);
                }
			}
		});

        ventaGrid.setFields(codigoField, productoField, cantidadField, precioField, totalField, borrarField);  
        ventaGrid.setCanResizeFields(true);
        /* ------------------------------------------- */

		/* Botones ----------------------------------- */
        ButtonItem buttonSave = new ButtonItem("add", "Grabar");
        buttonSave.setStartRow(false);
        buttonSave.setTop(55);
        buttonSave.setLeft(-85);
        buttonSave.setWidth(82);
        buttonSave.setHeight(70);
        buttonSave.setIcon("save.png");
        buttonSave.setAlign(Alignment.CENTER);
        buttonSave.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
        		/* Guardar la venta */
        		final Factura factura = new Factura();
        		factura.setFecha((Date)(fechaItem.getValue()));
        		factura.setId_cliente(Integer.parseInt(cliente.get(clienteItem.getValue())));
        		factura.setNumero(nroFactText.getValue().toString());
        		factura.setMontoTotal(Double.parseDouble(totalText.getValue().toString()));

        		for (int i=0; i<ventaGrid.getRecords().length; i++) {
        			FacturaDetalle detalle = new FacturaDetalle(factura);
        			detalle.setCantidad(Integer.parseInt(ventaGrid.getRecord(i).getAttribute("cantidad")));
        			detalle.setPrecioVenta(Double.parseDouble(ventaGrid.getRecord(i).getAttribute("precio")));
        			detalle.setId_producto(Integer.parseInt(producto.get(ventaGrid.getRecord(i).getAttribute("producto"))));
        			factura.setFacturaDetalles(detalle);
        		}

        		FacturaServiceAsync service = GWT.create(FacturaService.class);
        		try {
					service.guardar_e_imprimir(factura, new AsyncCallback<Integer>() {
 
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Ocurrio un error y no se pudo registrar la venta");
						}

						@Override
						public void onSuccess(Integer result) {
							imprimir_factura(result);
							new VentaLista(mainWindow);
						}

						private void imprimir_factura(Integer factura) {
							// TODO Auto-generated method stub 
							 Window.open("/TPFinal-GWT/tpfinal_gwt/servicioReporte?reporte=factura&numero_factura="+factura,"_blank",null);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ButtonItem buttonAdd = new ButtonItem("new", "Agregar Producto");  
		buttonAdd.setStartRow(false);
		buttonAdd.setWidth(160);
		buttonAdd.setIcon("add.png");
		buttonAdd.setAlign(Alignment.CENTER);
		buttonAdd.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
            	ventaGrid.startEditingNew();
            }  
        });

		DynamicForm formAdd = new DynamicForm();
        DynamicForm formSave = new DynamicForm();
        
        formAdd.setItemLayout(FormLayoutType.ABSOLUTE);
        formSave.setItemLayout(FormLayoutType.ABSOLUTE);
        
        formSave.setItems(buttonSave);		
		/* ------------------------------------------- */
		        
        formAdd.setItems(buttonAdd, totalText);
        /* ------------------------------------------- */
                
		/* Agregar los componentes en los layout's --- */
        vLayout.addMember(label);
        vLayout.addMember(hLayoutCab);
		vLayout.addMember(ventaGrid);
		vLayout.addMember(formAdd);

        hLayout.addMember(vLayout);
        hLayout.addMember(formSave);
        /* ------------------------------------------- */
        
        mainWindow.showDialog(hLayout);
	}
	
	private void calcularProducto(int fila, final ListGrid ventaGrid, final TextItem totalText) {

    	Object cant = ventaGrid.getEditedCell(fila, "cantidad");
    	Object prec = ventaGrid.getEditedCell(fila, "precio");
    	int cantidad = cant != null ? Integer.parseInt(cant.toString()) : 0;
    	double precio = prec != null ? Double.parseDouble(prec.toString()) : 0;

    	ventaGrid.setEditValue(fila, "total", "" + (cantidad*precio));
    	 
    	calcularTotal(ventaGrid, totalText);
	}
	
	private void calcularTotal(final ListGrid ventaGrid, final TextItem totalText) {
		int total = 0;
       	for (int i=0; i<ventaGrid.getRecords().length+1; i++) {
       		total += ventaGrid.getEditedCell(i, "total") != null ? Double.parseDouble(ventaGrid.getEditedCell(i, "total").toString()) : 0;
      	}
     	totalText.setValue(total);
	}
}

class VentaDetalleRecord extends ListGridRecord {

	public VentaDetalleRecord() {
	}

	public VentaDetalleRecord(int codigo, String producto, int cantidad, double precio, double total) {
		setCodigo(codigo);
		setProducto(producto);
		setCantidad(cantidad);
		setPrecio(precio);
		setTotal(total);
		setBorrar("remove");
	}

	public void setCodigo(int codigo) {
		setAttribute("codigo", codigo);
	}
	
	public void setProducto(String producto) {
		setAttribute("producto", producto);
	}
	
	public void setCantidad(int cantidad) {
		setAttribute("cantidad", cantidad);
	}
	
	public void setPrecio(double precio) {
		setAttribute("precio", precio);
	}
	
	public void setTotal(double total) {
		setAttribute("total", total);
	}

	public void setBorrar(String remove) {
		setAttribute("remove", remove);
	}
}