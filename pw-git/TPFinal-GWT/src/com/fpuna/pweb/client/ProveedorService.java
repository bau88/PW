package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import entidades.Caja;
import entidades.Pago;
import entidades.Producto;
import entidades.Proveedor;
import excepciones.EntidadBaseException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("servicioProveedor")
public interface ProveedorService extends RemoteService {
	Proveedor buscar(Integer entity) throws EntidadBaseException; 
	void eliminar(Integer id) throws EntidadBaseException;
	void eliminar(List<Proveedor> entidad) throws EntidadBaseException;
	void guardar(Proveedor entidad) throws EntidadBaseException;
	List<Proveedor> listar(Proveedor entidad, String orden) throws EntidadBaseException;
}
