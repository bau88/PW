package eao;


import java.util.List;

import excepciones.EntidadBaseException;

public interface EAOManager<E>  { 
	
	public E buscar(Object entity) throws EntidadBaseException; 
	public void eliminar(Object id) throws EntidadBaseException;
	public void eliminar(List<E> entidad) throws EntidadBaseException;
	public void guardar(E entidad) throws EntidadBaseException;
	public List<E> listar(E entidad, String orden) throws EntidadBaseException;
	

}
