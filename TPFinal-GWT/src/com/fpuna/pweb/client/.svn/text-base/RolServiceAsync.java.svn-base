package com.fpuna.pweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import entidades.Rol;
import excepciones.EntidadBaseException;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface RolServiceAsync {
	void buscar(Integer entity, AsyncCallback<Rol> callbak ) throws EntidadBaseException; 
	void eliminar(Integer id,AsyncCallback<Void> callback) throws EntidadBaseException;
	void eliminar(List<Rol> entidad,AsyncCallback<Void> callback) throws EntidadBaseException;
	void guardar(Rol entidad,AsyncCallback<Void> callback) throws EntidadBaseException;
	void listar(Rol entidad, String orden,AsyncCallback<List<Rol>> callback) throws EntidadBaseException;
;
}
