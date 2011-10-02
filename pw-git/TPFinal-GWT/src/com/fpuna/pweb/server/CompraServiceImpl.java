package com.fpuna.pweb.server;

import java.util.List;

import javax.ejb.EJB;

import com.fpuna.pweb.client.CompraService;
import com.fpuna.pweb.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import entidades.Compra;
import entidades.Compra;
import entidades.Proveedor;
import excepciones.EntidadBaseException;
import facade.CompraFacadeLocal;
import facade.ClienteFacadeLocal;
import facade.CompraFacadeLocal;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CompraServiceImpl extends RemoteServiceServlet implements
		CompraService {
	@EJB(beanInterface=CompraFacadeLocal.class,mappedName="CompraFacade/local")
	CompraFacadeLocal compraFacade;
	
	@Override
	public Compra buscar(Integer entity) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return compraFacade.buscar(entity);
	}

	@Override
	public void eliminar(Integer id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		compraFacade.eliminar(id);
	}

	@Override
	public void eliminar(List<Compra> entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		compraFacade.eliminar(entidad);	
	}

	@Override
	public void guardar(Compra entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		compraFacade.guardar(entidad);
	}

	@Override
	public List<Compra> listar(Compra entidad, Proveedor proveedor, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return compraFacade.listar_remoto(entidad, proveedor,  orden);
	}

}
