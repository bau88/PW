package com.fpuna.pweb.server;

import java.util.List;

import javax.ejb.EJB;

import com.fpuna.pweb.client.CajaService;
import com.fpuna.pweb.client.GreetingService;
import com.fpuna.pweb.client.ProductoService;
import com.fpuna.pweb.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import entidades.Caja;
import entidades.Producto;
import excepciones.EntidadBaseException;
import facade.CajaFacadeLocal;
import facade.PagoFacadeLocal;
import facade.ProductoFacadeLocal;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ProductoServiceImpl extends RemoteServiceServlet implements
		ProductoService {
	@EJB(beanInterface=ProductoFacadeLocal.class,mappedName="ProductoFacade/local")
	ProductoFacadeLocal productoFacade;
	
	@Override
	public Producto buscar(Integer entity) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return productoFacade.buscar(entity);
	}

	@Override
	public void eliminar(Integer id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		productoFacade.eliminar(id);
	}

	@Override
	public void eliminar(List<Producto> entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		productoFacade.eliminar(entidad);	
	}

	@Override
	public void guardar(Producto entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		productoFacade.guardar(entidad);
	}

	@Override
	public List<Producto> listar(Producto entidad, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return productoFacade.listar_remoto(entidad, orden);
	}
}
