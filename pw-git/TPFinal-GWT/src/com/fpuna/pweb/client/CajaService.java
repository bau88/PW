package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import entidades.Caja;
import excepciones.EntidadBaseException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("servicioCaja")
public interface CajaService extends RemoteService {
	Caja buscar(Integer entity) throws EntidadBaseException; 
	void eliminar(Integer id) throws EntidadBaseException;
	void eliminar(List<Caja> entidad) throws EntidadBaseException;
	void guardar(Caja entidad) throws EntidadBaseException;
	List<Caja> listar(Caja entidad, String orden) throws EntidadBaseException;
}
