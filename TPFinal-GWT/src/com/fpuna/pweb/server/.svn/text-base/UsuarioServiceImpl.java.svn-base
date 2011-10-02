package com.fpuna.pweb.server;

import java.util.List;

import javax.ejb.EJB;

import com.fpuna.pweb.client.UsuarioService;
import com.fpuna.pweb.client.GreetingService;
import com.fpuna.pweb.client.UsuarioService;
import com.fpuna.pweb.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import entidades.Usuario;
import entidades.Usuario;
import excepciones.EntidadBaseException;
import facade.UsuarioFacadeLocal;
import facade.RolFacadeLocal;
import facade.UsuarioFacadeLocal;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UsuarioServiceImpl extends RemoteServiceServlet implements
		UsuarioService {
	@EJB(beanInterface=UsuarioFacadeLocal.class,mappedName="UsuarioFacade/local")
	UsuarioFacadeLocal usuarioFacade;
	
	@Override
	public Usuario buscar(Integer entity) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return usuarioFacade.buscar(entity);
	}

	@Override
	public void eliminar(Integer id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		usuarioFacade.eliminar(id);
	}

	@Override
	public void eliminar(List<Usuario> entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		usuarioFacade.eliminar(entidad);	
	}

	@Override
	public void guardar(Usuario entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		usuarioFacade.guardar(entidad);
	}

	@Override
	public List<Usuario> listar(Usuario entidad, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return usuarioFacade.listar_remoto(entidad, orden);
	}
}
