package menu;


import java.util.ArrayList;

import webservice.Caja;
import webservice.Factura;
import webservice.Pago;
import webservice.PagoArray;
import webservice.PagosWSRemote;
import webservice.PagosWsService;

public class PrincipalWSConsola {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//1 20 100

		// TODO Auto-generated method stub
		PagosWsService service = new PagosWsService();
		PagosWSRemote remote = service.getPagosWsPort();
		PagoArray pagoArray = new PagoArray();
		
		for(int i = 0; i<args.length;){			
			
			Caja caja_pago = remote.buscarCaja(Integer.valueOf(args[i++]));
			Factura factura_pago = remote.buscarFactura(Integer.valueOf(args[i++]));
			Double monto_pago =Double.valueOf(args[i++]);
			Pago pago = new Pago();
			pago.setCaja(caja_pago);
			pago.setFactura(factura_pago);
			pago.setMonto(monto_pago);
			pagoArray.getItem().add(pago);
		}
		System.out.println(remote.guardarPagos(pagoArray));
	}

}
