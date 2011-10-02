package com.fpuna.pweb.server;

import java.util.List;

import javax.ejb.EJB;

import com.fpuna.pweb.client.FacturaService;
import com.fpuna.pweb.client.FacturaService;
import com.fpuna.pweb.client.GreetingService;
import com.fpuna.pweb.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import entidades.Cliente;
import entidades.Factura;
import entidades.Factura;
import excepciones.EntidadBaseException;
import facade.FacturaFacadeLocal;
import facade.CompraFacadeLocal;
import facade.FacturaFacadeLocal;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class FacturaServiceImpl extends RemoteServiceServlet implements
		FacturaService {
	@EJB(beanInterface=FacturaFacadeLocal.class,mappedName="FacturaFacade/local")
	FacturaFacadeLocal facturaFacade;
	
	@Override
	public Factura buscar(Integer entity) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return facturaFacade.buscar(entity);
	}

	@Override
	public void eliminar(Integer id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		facturaFacade.eliminar(id);
	}

	@Override
	public void eliminar(List<Factura> entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		facturaFacade.eliminar(entidad);	
	}

	@Override
	public void guardar(Factura entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		facturaFacade.guardar(entidad);
	}

	@Override
	public List<Factura> listar(Factura entidad, Cliente cliente, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		return facturaFacade.listar_remoto(entidad,  cliente, orden);
	}

	@Override
	public Integer guardar_e_imprimir(Factura entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		
		return facturaFacade.guardar_e_imprimir(entidad);
	}
}
