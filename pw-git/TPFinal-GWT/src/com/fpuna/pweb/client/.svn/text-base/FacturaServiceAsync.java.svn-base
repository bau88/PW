package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import entidades.Cliente;
import entidades.Factura;
import excepciones.EntidadBaseException;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface FacturaServiceAsync {
	void buscar(Integer entity, AsyncCallback<Factura> callbak ) throws EntidadBaseException; 
	void eliminar(Integer id,AsyncCallback<Void> callback) throws EntidadBaseException;
	void eliminar(List<Factura> entidad,AsyncCallback<Void> callback) throws EntidadBaseException;
	void guardar(Factura entidad,AsyncCallback<Void> callback) throws EntidadBaseException;
	void guardar_e_imprimir(Factura entidad,AsyncCallback<Integer> callback) throws EntidadBaseException;
	void listar(Factura entidad, Cliente cliente, String orden,AsyncCallback<List<Factura>> callback) throws EntidadBaseException;
}
