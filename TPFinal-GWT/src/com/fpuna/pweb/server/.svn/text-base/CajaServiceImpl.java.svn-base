package com.fpuna.pweb.server;

import java.util.List; 

import javax.ejb.EJB;

import com.fpuna.pweb.client.CajaService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import entidades.Caja;
import excepciones.EntidadBaseException;
import facade.CajaFacadeLocal;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CajaServiceImpl extends RemoteServiceServlet implements
		CajaService {
	@EJB(beanInterface=CajaFacadeLocal.class,mappedName="CajaFacade/local")
	CajaFacadeLocal cajaFacade;
	
	@Override
	public Caja buscar(Integer entity) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return cajaFacade.buscar(entity);
	}

	@Override
	public void eliminar(Integer id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		cajaFacade.eliminar(id);
	}

	@Override
	public void eliminar(List<Caja> entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		cajaFacade.eliminar(entidad);	
	}

	@Override
	public void guardar(Caja entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		cajaFacade.guardar(entidad);
	}

	@Override
	public List<Caja> listar(Caja entidad, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return cajaFacade.listar_remoto(entidad, orden);
	}

}
