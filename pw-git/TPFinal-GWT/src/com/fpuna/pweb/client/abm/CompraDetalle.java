package com.fpuna.pweb.client.abm;

import com.fpuna.pweb.client.ClienteService;
import com.fpuna.pweb.client.ClienteServiceAsync;
import com.fpuna.pweb.client.CompraService;
import com.fpuna.pweb.client.CompraServiceAsync;
import com.fpuna.pweb.client.ProductoService;
import com.fpuna.pweb.client.ProductoServiceAsync;
import com.fpuna.pweb.client.ProveedorService;
import com.fpuna.pweb.client.ProveedorServiceAsync;
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

import entidades.Compra;
import entidades.Producto;
import entidades.Proveedor;

public class CompraDetalle extends Canvas {
	
	public CompraDetalle(final TPFinal_GWT mainWindow) {

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
        label.setContents("<b>Registro de Compra</b>");
		/* ------------------------------------------- */

        /* Cabecera ---------------------------------- */
        final Map<String, String> proveedor = new HashMap<String, String>();
        final SelectItem proveedorItem = new SelectItem();
        proveedorItem.setName("proveedor");
        proveedorItem.setTitle("Proveedor");
        proveedorItem.setAddUnknownValues(false);
        proveedorItem.setWidth(150);
        proveedorItem.setLeft(100);
        
        /* Para cargar el comboBox de Proveedores */
        
        ProveedorServiceAsync service = GWT.create(ProveedorService.class);	

		try {
			Proveedor proveedor_lista = new Proveedor();
			String orden = "idProveedor";
			service.listar(proveedor_lista, orden, new AsyncCallback<List<Proveedor>>() {
				@Override
				public void onSuccess(List<Proveedor> result) {
					String [] r = new String [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0)!=null){
							proveedor.put(result.get(f).getNombre(), new String ("" + result.get(f).getIdProveedor()));
							r[f] = new String(result.get(f).getNombre());
						}
					}
					proveedorItem.setValueMap(r);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Ocurrio un error: " + caught.getClass().getName() + " " + caught.getMessage()) ;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final DateItem fechaItem = new DateItem();
        fechaItem.setName("fecha");
        fechaItem.setTitle("Fecha");
        fechaItem.setUseTextField(true);
        fechaItem.setDefaultValue(new Date ());
        fechaItem.setDateFormatter(DateDisplayFormat.TOEUROPEANSHORTDATE);
        fechaItem.setWidth(146);
        fechaItem.setLeft(400);
        
        final DynamicForm formCab = new DynamicForm();
        formCab.setItems(proveedorItem, fechaItem);
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
        final ListGrid compraGrid = new ListGrid();
        
        compraGrid.setWidth(500);  
        compraGrid.setHeight(224);  
        compraGrid.setShowAllRecords(true);  
        compraGrid.setAlternateRecordStyles(true);
        compraGrid.setShowEdges(true);
        compraGrid.setBorder("0px");
        compraGrid.setBodyStyleName("normal");
        compraGrid.setLeaveScrollbarGap(false);
        compraGrid.setTitle("Clic sobre la fila en la columna 'Borrar' para eliminar");
        compraGrid.setAutoFetchData(true);  
        compraGrid.setCanEdit(true);  
        compraGrid.setEditEvent(ListGridEditEvent.CLICK);  
        compraGrid.setListEndEditAction(RowEndEditAction.NEXT);
        
        
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
            	calcularProducto(event.getRowNum(), compraGrid, totalText);
            }  
        });
        
        precioField.addChangedHandler(new ChangedHandler() {  
            public void onChanged(ChangedEvent event) {
            	calcularProducto(event.getRowNum(), compraGrid, totalText);
            }  
        });
        
        //productoField.setValueMap("Producto 1","Producto 2","Producto 3");
        codigoField.setAlign(Alignment.CENTER);
        cantidadField.setAlign(Alignment.RIGHT);
        precioField.setAlign(Alignment.RIGHT);
        totalField.setAlign(Alignment.RIGHT);
        borrarField.setAlign(Alignment.CENTER);

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
        
        ProductoServiceAsync service_prod = GWT.create(ProductoService.class);	

		try {
			Producto producto_lista = new Producto();
			String orden = "";
			service_prod.listar(producto_lista, orden, new AsyncCallback<List<Producto>>() {
				@Override
				public void onSuccess(List<Producto> result) {
					String [] r = new String [result.size()];
					for(int f = 0; f < result.size(); f++) {
						if(result.get(0)!=null) {
							producto.put(result.get(f).getDescripcion(), new String ("" + result.get(f).getIdProducto()));
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
		
        compraGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
                ListGridRecord record =  event.getRecord();
                int col = event.getColNum();
                if (col > 3) { /* Eliminar de la grilla */
                	compraGrid.removeData(record);
                	calcularTotal(compraGrid, totalText);
                }
			}
		});

        compraGrid.setFields(codigoField, productoField, cantidadField, precioField, totalField, borrarField);  
        compraGrid.setCanResizeFields(true);
        /* ------------------------------------------- */

		/* Botones ----------------------------------- */
        ButtonItem buttonSave = new ButtonItem("add", "Grabar");
        buttonSave.setStartRow(false);
        buttonSave.setTop(55);
        buttonSave.setLeft(-85);
        buttonSave.setWidth(82);
        buttonSave.setHeight(40);
        buttonSave.setIcon("save.png");
        buttonSave.setAlign(Alignment.CENTER);
        buttonSave.addClickHandler(new ClickHandler() {
        	@SuppressWarnings("deprecation")
			@Override
            public void onClick(ClickEvent event) {
        		/* Guardar la compra */
        		Compra compra = new Compra();
        		compra.setFecha((Date)fechaItem.getValue());
        		compra.setId_proveedor(Integer.parseInt(proveedor.get(proveedorItem.getValue())));
        		compra.setTotalCompra(Double.parseDouble(totalText.getValue().toString()));
        		
        		for (int i=0; i<compraGrid.getRecords().length; i++) {
        			entidades.CompraDetalle detalle = new entidades.CompraDetalle(compra);
        			detalle.setCantidad(Integer.parseInt(compraGrid.getRecord(i).getAttribute("cantidad")));
        			detalle.setPrecioCompra(Double.parseDouble(compraGrid.getRecord(i).getAttribute("precio")));
        			detalle.setId_producto(Integer.parseInt(producto.get(compraGrid.getRecord(i).getAttribute("producto"))));
        			compra.setCompraDetalles(detalle);
        		}
        		
        		CompraServiceAsync service = GWT.create(CompraService.class);
				try {
					service.guardar(compra, new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Ocurrio un error y no se pudo registrar la compra");
						}

						@Override
						public void onSuccess(Void result) {
							new CompraLista(mainWindow);
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
            	compraGrid.startEditingNew();
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
		vLayout.addMember(compraGrid);
		vLayout.addMember(formAdd);

        hLayout.addMember(vLayout);
        hLayout.addMember(formSave);
        /* ------------------------------------------- */
        
        mainWindow.showDialog(hLayout);
	}
	
	private void calcularProducto(int fila, final ListGrid compraGrid, final TextItem totalText) {

    	Object cant = compraGrid.getEditedCell(fila, "cantidad");
    	Object prec = compraGrid.getEditedCell(fila, "precio");
    	int cantidad = cant != null ? Integer.parseInt(cant.toString()) : 0;
    	double precio = prec != null ? Double.parseDouble(prec.toString()) : 0;

    	compraGrid.setEditValue(fila, "total", "" + (cantidad*precio));
    	 
    	calcularTotal(compraGrid, totalText);
	}
	
	private void calcularTotal(final ListGrid compraGrid, final TextItem totalText) {
		int total = 0;
       	for (int i=0; i<compraGrid.getRecords().length+1; i++) {
       		total += compraGrid.getEditedCell(i, "total") != null ? Double.parseDouble(compraGrid.getEditedCell(i, "total").toString()) : 0;
      	}
     	totalText.setValue(total);
	}
}

class CompraDetalleRecord extends ListGridRecord {

	public CompraDetalleRecord() {
	}

	public CompraDetalleRecord(int codigo, String producto, int cantidad, double precio, double total) {
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