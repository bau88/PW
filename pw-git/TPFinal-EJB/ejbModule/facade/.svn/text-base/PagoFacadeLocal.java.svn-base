package facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.Caja;
import entidades.Cliente;
import entidades.Factura;
import entidades.Pago;
import excepciones.EntidadBaseException;


@Local
public interface PagoFacadeLocal extends EAOManager<Pago>{
	public List<Pago> CierreCaja(Caja caja_cierre);
	public String guardar(List<Pago> pagos);
	public List<Pago> listar_remoto(Pago e,Factura factura, Cliente cliente,  Caja caja,String orden) throws EntidadBaseException ;
}
