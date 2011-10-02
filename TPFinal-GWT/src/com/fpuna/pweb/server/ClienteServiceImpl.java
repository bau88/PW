package com.fpuna.pweb.server;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;


import com.fpuna.pweb.client.CajaService;
import com.fpuna.pweb.client.ClienteService;
import com.fpuna.pweb.client.GreetingService;
import com.fpuna.pweb.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import facade.CajaFacadeLocal;
import facade.ClienteFacadeLocal;
import entidades.Cliente;
import excepciones.EntidadBaseException;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ClienteServiceImpl extends RemoteServiceServlet implements
ClienteService {
	@EJB(beanInterface=ClienteFacadeLocal.class,mappedName="ClienteFacade/local")
	ClienteFacadeLocal clienteFacade;
	
	@Override
	public Cliente buscar(Integer entity) throws EntidadBaseException  {
		// TODO Auto-generated method stub
		Cliente cliente;
		try {						
			return clienteFacade.buscar(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
		
	}

	@Override
	public void eliminar(Integer id) throws EntidadBaseException  {
		// TODO Auto-generated method stub
		try {
			clienteFacade.eliminar(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(List<Cliente> entidad) throws EntidadBaseException  {
		// TODO Auto-generated method stub
		try {
			clienteFacade.eliminar(entidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void guardar(Cliente entidad) throws EntidadBaseException  {
		// TODO Auto-generated method stub
		try {
			clienteFacade.guardar(entidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cliente> listar(Cliente entidad, String orden) throws EntidadBaseException  {
		// TODO Auto-generated method stub
		return  clienteFacade.listar_remoto(entidad, orden);
		
	}
}
