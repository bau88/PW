package facade;

import java.util.List;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.Cliente;
import entidades.Factura;
import excepciones.EntidadBaseException;


@Local
public interface FacturaFacadeLocal extends EAOManager<Factura>{
	Factura buscarRemoto(Object id);
	public List<Factura> listar_remoto(Factura e, Cliente cliente, String orden)	throws EntidadBaseException;
	public Factura buscar_con_detalle(Object id);
	public int guardar_e_imprimir(Factura entidad);
}
