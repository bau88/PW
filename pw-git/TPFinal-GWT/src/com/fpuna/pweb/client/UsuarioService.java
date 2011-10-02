package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import entidades.Usuario;
import excepciones.EntidadBaseException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("servicioUsuario")
public interface UsuarioService extends RemoteService {
	Usuario buscar(Integer entity) throws EntidadBaseException; 
	void eliminar(Integer id) throws EntidadBaseException;
	void eliminar(List<Usuario> entidad) throws EntidadBaseException;
	void guardar(Usuario entidad) throws EntidadBaseException;
	List<Usuario> listar(Usuario entidad, String orden) throws EntidadBaseException;
}
