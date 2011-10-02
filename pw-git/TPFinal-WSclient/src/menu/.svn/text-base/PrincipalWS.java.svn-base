package menu;


import java.util.ArrayList;

import webservice.Caja;
import webservice.Factura;
import webservice.Pago;
import webservice.PagoArray;
import webservice.PagosWSRemote;
import webservice.PagosWsService;

public class PrincipalWS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PagosWsService service = new PagosWsService();
		PagosWSRemote remote = service.getPagosWsPort();
		Caja caja = remote.buscarCaja(1);
		Factura factura = remote.buscarFactura(20);
		
		Pago pago = new Pago();
		pago.setCaja(caja);
		pago.setFactura(factura);
		pago.setMonto(100);
		PagoArray pagoArray = new PagoArray();
		pagoArray.getItem().add(pago);
		
		
		System.out.println(remote.guardarPagos(pagoArray));
	}

}
