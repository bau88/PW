package com.fpuna.pweb.server;

import java.util.List;

import javax.ejb.EJB;

import com.fpuna.pweb.client.CajaService;
import com.fpuna.pweb.client.GreetingService;
import com.fpuna.pweb.client.ProveedorService;
import com.fpuna.pweb.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import entidades.Caja;
import entidades.Proveedor;
import excepciones.EntidadBaseException;
import facade.CajaFacadeLocal;
import facade.ProductoFacadeLocal;
import facade.ProveedorFacadeLocal;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ProveedorServiceImpl extends RemoteServiceServlet implements
		ProveedorService {
	@EJB(beanInterface=ProveedorFacadeLocal.class,mappedName="ProveedorFacade/local")
	ProveedorFacadeLocal proveedorFacade;
	
	@Override
	public Proveedor buscar(Integer entity) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return proveedorFacade.buscar(entity);
	}

	@Override
	public void eliminar(Integer id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		proveedorFacade.eliminar(id);
	}

	@Override
	public void eliminar(List<Proveedor> entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		proveedorFacade.eliminar(entidad);	
	}

	@Override
	public void guardar(Proveedor entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		proveedorFacade.guardar(entidad);
	}

	@Override
	public List<Proveedor> listar(Proveedor entidad, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return proveedorFacade.listar_remoto(entidad, orden);
	}
	
}
