package com.fpuna.pweb.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.types.FormLayoutType;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

import entidades.Caja;
import entidades.Usuario;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TPFinal_GWT implements EntryPoint {
	
	final Map<String, String> ventana = new HashMap<String, String>();
	
	SimplePanel sp;
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	final Caja caja = new Caja();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		this.sp = new SimplePanel();
		VerticalPanel vPanel = new VerticalPanel();
		MainHeader header = new MainHeader();
		TopMenuBar menuBar = new TopMenuBar(this);
		
		vPanel.setWidth("100%");
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        vPanel.add(header);
		vPanel.add(menuBar);
		
		MenuBar mb = new MenuBar(); // Puse xq no se me ocurria poner otra cosa para que la tabla baje mas.
		mb.setHeight("30");
		vPanel.add(mb);
		
		vPanel.add(this.sp);
		
		/* Login ------------------------------ */
		final Window winModal = new Window();
        winModal.setWidth(360);
        winModal.setHeight(115);
        winModal.setTitle("Login");
        winModal.setShowMinimizeButton(false);
        winModal.setShowCloseButton(false);
        winModal.setCanDragReposition(false);
        winModal.setIsModal(true);
        winModal.setShowModalMask(true);
        winModal.centerInPage();

        DynamicForm form = new DynamicForm();
        form.setHeight100();
        form.setWidth100();
        form.setPadding(5);
        form.setLayoutAlign(VerticalAlignment.BOTTOM);
        form.setItemLayout(FormLayoutType.TABLE);
        
        final TextItem userItem = new TextItem();
        userItem.setTitle("Usuario");
        userItem.setRequired(true);
        
        final PasswordItem pwdItem = new PasswordItem();
        pwdItem.setTitle("Password");
        pwdItem.setRequired(true);
        
        ButtonItem loginItem = new ButtonItem("login", "Ingresar");
        loginItem.setLeft(200);
        loginItem.setWidth(100);
        //loginItem.setIcon("icons/16/approved.png");
        loginItem.setIcon("approve.png");
        loginItem.addClickHandler(new ClickHandler() {
        	@Override
            public void onClick(ClickEvent event) {
        		
        		final Usuario usuario  = new Usuario();
        		
        		String user = (String)userItem.getValue();
        		String pwd = (String)pwdItem.getValue();
        		
        		if(user != null && pwd != null) {
        			usuario.setNombre(user);
        			usuario.setContrasenha(pwd);

        			UsuarioServiceAsync service = GWT.create(UsuarioService.class);

        			try {
        				service.listar(usuario, "nombre", new AsyncCallback<List<Usuario>>() {
        					@Override
        					public void onSuccess(List<Usuario> result) {
        						if (result.size() > 0) {
        							if(result.get(0) != null) {
        								caja.setIdCaja(result.get(0).getId_caja());
        								if (result.get(0).getRol() != null) {
        									if (verificarAccesoRol(result.get(0).getRol().getNombre())) {
        										winModal.destroy();
        									}
        								}
        							}
        						} else {
        							com.google.gwt.user.client.Window.alert("Usuario y/o password incorrectos");
        						}
        					}
        					
        					@Override
        					public void onFailure(Throwable caught) {
        						com.google.gwt.user.client.Window.alert("Ocurrio un error durante la autenticacion");
        					}
        				});
        			} catch (Exception e) {
        				e.printStackTrace();
        			} 

        		} else {
        			com.google.gwt.user.client.Window.alert("Usuario y/o password en blanco");
        		}        	
        	}
		});
        
        form.setFields(userItem, pwdItem, loginItem);
        winModal.addItem(form);
        winModal.show();
        /* ------------------------------------ */
		
		RootPanel.get().add(vPanel);
	}

	/**
	 * Mostrar en ventana principal el dialogo pasado
	 * @param widget
	 */
	public void showDialog(Widget widget) {
		if (this.sp.getWidget() != null)
			this.sp.remove(this.sp.getWidget());
		
		this.sp.setWidget(widget);
	}
		
	public boolean tienePermiso(String menu) {
		if (ventana.get(menu) != null)
			return true;
		
		com.google.gwt.user.client.Window.alert("No tiene permisos suficiente para realizar esta operacion");
		return false;
	}
	
	public int getCaja() {
		return caja.getIdCaja();
	}
	
	private boolean verificarAccesoRol(String rol) {

		if (rol != null) {
			ventana.clear();
			if (rol.equals("Administrador")) {
				ventana.put("Cliente", "Cliente");
				ventana.put("Producto", "Producto");
				ventana.put("Proveedor", "Proveedor");
				ventana.put("Caja", "Caja");
				ventana.put("Rol", "Rol");
				ventana.put("Compra", "Compra");
				ventana.put("Venta", "Venta");
				ventana.put("Cobranza", "Cobranza");
				ventana.put("Usuario", "Usuario");
			}
			else if (rol.equals("Cajero")) {
				ventana.put("Cobranza", "Cobranza");
			}
			else if (rol.equals("Comprador")) {
				ventana.put("Compra", "Compra");
			}
			else if (rol.equals("Vendedor")) {
				ventana.put("Venta", "Venta");
			}
			else {
				com.google.gwt.user.client.Window.alert("Ocurrio un error interno, perfil incorrecto");
				return false;
			}
			
			return true;
		}

		com.google.gwt.user.client.Window.alert("Ocurrio un error interno, no se encontro perfil");
		
		return false;
	}
}