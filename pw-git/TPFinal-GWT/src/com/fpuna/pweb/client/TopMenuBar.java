package com.fpuna.pweb.client;

import com.fpuna.pweb.client.TPFinal_GWT;

import com.fpuna.pweb.client.abm.CajaLista;
import com.fpuna.pweb.client.abm.ClienteLista;
import com.fpuna.pweb.client.abm.CompraLista;
import com.fpuna.pweb.client.abm.PagoLista;
import com.fpuna.pweb.client.abm.ProductoLista;
import com.fpuna.pweb.client.abm.ProveedorLista;
import com.fpuna.pweb.client.abm.RolLista;
import com.fpuna.pweb.client.abm.UsuarioLista;
import com.fpuna.pweb.client.abm.VentaLista;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;

public class TopMenuBar extends Composite {
	
	public TopMenuBar (final TPFinal_GWT mainWindow) {
		
		MenuBar menuBar = new MenuBar();
		MenuBar subMenuMant = new MenuBar();
		MenuBar subMenuRol = new MenuBar();
		
		menuBar.setAutoOpen(true);
		subMenuMant.setAutoOpen(true);
		subMenuRol.setAutoOpen(true);

		subMenuMant.addItem("Cliente", new Command() {			
			@Override
			public void execute() {
				if (mainWindow.tienePermiso("Cliente"))
					new ClienteLista(mainWindow);
			}
		});
		
		subMenuMant.addItem("Producto", new Command() {			
			@Override
			public void execute() {
				if (mainWindow.tienePermiso("Producto"))
					new ProductoLista(mainWindow);
			}
		});

		subMenuMant.addItem("Proveedor", new Command() {			
			@Override
			public void execute() {
				if (mainWindow.tienePermiso("Proveedor"))
					new ProveedorLista(mainWindow);
			}
		});
				
		subMenuMant.addItem("Caja", new Command() {
			@Override
			public void execute() {
				if (mainWindow.tienePermiso("Caja"))
					new CajaLista(mainWindow);
			}
		});

		subMenuMant.addItem("Rol", new Command() {			
			@Override
			public void execute() {
				if (mainWindow.tienePermiso("Rol"))
					new RolLista(mainWindow);
			}
		});

		subMenuMant.addItem("Usuario", new Command() {			
			@Override
			public void execute() {
				if (mainWindow.tienePermiso("Usuario"))
					new UsuarioLista(mainWindow);
			}
		});

		menuBar.addItem("Mantenimiento", subMenuMant);

		menuBar.addItem("Compra", new Command() {			
			@Override
			public void execute() {
				if (mainWindow.tienePermiso("Compra"))
					new CompraLista(mainWindow);
			}
		});
		
		menuBar.addItem("Venta",new Command() {			
			@Override
			public void execute() {
				if (mainWindow.tienePermiso("Venta"))
					new VentaLista(mainWindow);
			}
		});
		
		menuBar.addItem("Cobranza",new Command() {			
			@Override
			public void execute() {
				if (mainWindow.tienePermiso("Cobranza"))
					new PagoLista(mainWindow);
			}
		});
		
		initWidget(menuBar);
	}
}