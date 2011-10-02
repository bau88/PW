package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import entidades.Cliente;
import entidades.Factura;
import excepciones.EntidadBaseException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("servicioFactura")
public interface FacturaService extends RemoteService {
	Factura buscar(Integer entity) throws EntidadBaseException; 
	void eliminar(Integer id) throws EntidadBaseException;
	void eliminar(List<Factura> entidad) throws EntidadBaseException;
	void guardar(Factura entidad) throws EntidadBaseException;
	Integer guardar_e_imprimir(Factura entidad) throws EntidadBaseException;
	List<Factura> listar(Factura entidad, Cliente cliente, String orden) throws EntidadBaseException;
}
