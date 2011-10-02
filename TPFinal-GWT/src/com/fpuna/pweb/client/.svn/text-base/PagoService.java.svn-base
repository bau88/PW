package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import entidades.Caja;
import entidades.Cliente;
import entidades.Factura;
import entidades.Pago;
import excepciones.EntidadBaseException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("servicioPago")
public interface PagoService extends RemoteService {
	Pago buscar(Integer entity) throws EntidadBaseException; 
	void eliminar(Integer id) throws EntidadBaseException;
	void eliminar(List<Pago> entidad) throws EntidadBaseException;
	void guardar(Pago entidad) throws EntidadBaseException;
	List<Pago> listar(Pago entidad,  Factura factura, Cliente cliente, Caja caja, String orden) throws EntidadBaseException;
	
}
