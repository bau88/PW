package webService;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import entidades.Caja;
import entidades.Factura;
import entidades.Pago;
import facade.CajaFacadeLocal;
import facade.FacturaFacadeLocal;
import facade.PagoFacadeLocal;

/**
 * Session Bean implementation class PagosWs
 */
@Stateless
@WebService(endpointInterface = "webService.PagosWSRemote")
@Remote(PagosWSRemote.class)
public class PagosWs implements PagosWSRemote{
	@EJB PagoFacadeLocal pagoFacade;
	@EJB CajaFacadeLocal cajaFacade;
	@EJB FacturaFacadeLocal facturaFacade;
    /**
     * Default constructor. 
     */
    public PagosWs() {
        // TODO Auto-generated constructor stub
    }

	
	public String guardarPagos(Pago[] pagos) {
		// TODO Auto-generated method stub
		
		List<Pago> lista_pagos = Arrays.asList(pagos);
		return pagoFacade.guardar(lista_pagos);
	}


	@Override
	public Caja buscarCaja(Object id) {
		// TODO Auto-generated method stub
		try {
			return cajaFacade.buscarRemoto(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}


	@Override
	public Factura buscarFactura(Object id) {
		// TODO Auto-generated method stub
		try {			
			return facturaFacade.buscarRemoto(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
