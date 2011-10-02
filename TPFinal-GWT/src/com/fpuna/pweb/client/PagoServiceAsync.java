package com.fpuna.pweb.client;

import java.util.List;


import com.google.gwt.user.client.rpc.AsyncCallback;

import entidades.Caja;
import entidades.Cliente;
import entidades.Factura;
import entidades.Pago;
import excepciones.EntidadBaseException;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface PagoServiceAsync {
	void buscar(Integer entity, AsyncCallback<Pago> callbak ) throws EntidadBaseException; 
	void eliminar(Integer id,AsyncCallback<Void> callback) throws EntidadBaseException;
	void eliminar(List<Pago> entidad,AsyncCallback<Void> callback) throws EntidadBaseException;
	void guardar(Pago entidad,AsyncCallback<Void> callback) throws EntidadBaseException;
	void listar(Pago entidad, Factura factura, Cliente cliente, Caja caja,String orden,AsyncCallback<List<Pago>> callback) throws EntidadBaseException;
}
