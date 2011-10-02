package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import entidades.Producto;
import excepciones.EntidadBaseException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("servicioProducto")
public interface ProductoService extends RemoteService {
	Producto buscar(Integer entity) throws EntidadBaseException; 
	void eliminar(Integer id) throws EntidadBaseException;
	void eliminar(List<Producto> entidad) throws EntidadBaseException;
	void guardar(Producto entidad) throws EntidadBaseException;
	List<Producto> listar(Producto entidad, String orden) throws EntidadBaseException;
}
