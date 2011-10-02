package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import entidades.Compra;
import entidades.Proveedor;
import excepciones.EntidadBaseException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("servicioCompra")
public interface CompraService extends RemoteService {
	Compra buscar(Integer entity) throws EntidadBaseException; 
	void eliminar(Integer id) throws EntidadBaseException;
	void eliminar(List<Compra> entidad) throws EntidadBaseException;
	void guardar(Compra entidad) throws EntidadBaseException;
	List<Compra> listar(Compra entidad, Proveedor proveedor, String orden) throws EntidadBaseException;
}
