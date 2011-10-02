package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import entidades.Cliente;
import excepciones.EntidadBaseException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("servicioCliente")
public interface ClienteService extends RemoteService {
	Cliente buscar(Integer entity) throws EntidadBaseException ; 
	void eliminar(Integer id) throws EntidadBaseException ;
	void eliminar(List<Cliente> entidad) throws EntidadBaseException ;
	void guardar(Cliente entidad) throws EntidadBaseException ;
	List<Cliente> listar(Cliente entidad, String orden) throws EntidadBaseException ;
}