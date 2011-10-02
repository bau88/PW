package com.fpuna.pweb.server;

import java.util.List;

import javax.ejb.EJB;

import com.fpuna.pweb.client.PagoService;
import com.fpuna.pweb.client.GreetingService;

import com.fpuna.pweb.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import entidades.Caja;
import entidades.Cliente;
import entidades.Factura;
import entidades.Pago;

import excepciones.EntidadBaseException;
import facade.PagoFacadeLocal;

import facade.FacturaFacadeLocal;


/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PagoServiceImpl extends RemoteServiceServlet implements
		PagoService {@EJB(beanInterface=PagoFacadeLocal.class,mappedName="PagoFacade/local")
	PagoFacadeLocal pagoFacade;
		
		@Override
		public Pago buscar(Integer entity) throws EntidadBaseException {
			// TODO Auto-generated method stub
			return pagoFacade.buscar(entity);
		}

		@Override
		public void eliminar(Integer id) throws EntidadBaseException {
			// TODO Auto-generated method stub
			pagoFacade.eliminar(id);
		}

		@Override
		public void eliminar(List<Pago> entidad) throws EntidadBaseException {
			// TODO Auto-generated method stub
			pagoFacade.eliminar(entidad);	
		}

		@Override
		public void guardar(Pago entidad) throws EntidadBaseException {
			// TODO Auto-generated method stub
			pagoFacade.guardar(entidad);
		}

		@Override
		public List<Pago> listar(Pago entidad, Factura factura, Cliente cliente, Caja caja, String orden) throws EntidadBaseException {
			// TODO Auto-generated method stub
			return pagoFacade.listar_remoto(entidad,factura,cliente, caja, orden);
		}
	
}