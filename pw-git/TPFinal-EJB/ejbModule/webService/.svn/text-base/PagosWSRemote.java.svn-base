package webService;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import entidades.Caja;
import entidades.Factura;
import entidades.Pago;

import java.rmi.Remote;
@WebService
@SOAPBinding(style = Style.RPC, use=Use.LITERAL )
public interface PagosWSRemote extends Remote {
	public String guardarPagos(Pago[] pagos) ;
	public Caja buscarCaja(Object id);
	public Factura buscarFactura(Object id);
}
