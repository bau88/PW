package com.fpuna.pweb.server;

import java.util.List;

import javax.ejb.EJB;

import com.fpuna.pweb.client.RolService;
import com.fpuna.pweb.client.GreetingService;
import com.fpuna.pweb.client.RolService;
import com.fpuna.pweb.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import entidades.Rol;
import entidades.Rol;
import excepciones.EntidadBaseException;
import facade.RolFacadeLocal;
import facade.ProveedorFacadeLocal;
import facade.RolFacadeLocal;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class RolServiceImpl extends RemoteServiceServlet implements
		RolService {
	@EJB(beanInterface=RolFacadeLocal.class,mappedName="RolFacade/local")
	RolFacadeLocal rolFacade;
	
	@Override
	public Rol buscar(Integer entity) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return rolFacade.buscar(entity);
	}

	@Override
	public void eliminar(Integer id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		rolFacade.eliminar(id);
	}

	@Override
	public void eliminar(List<Rol> entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		rolFacade.eliminar(entidad);	
	}

	@Override
	public void guardar(Rol entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		rolFacade.guardar(entidad);
	}

	@Override
	public List<Rol> listar(Rol entidad, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return rolFacade.listar_remoto(entidad, orden);
	}
}
