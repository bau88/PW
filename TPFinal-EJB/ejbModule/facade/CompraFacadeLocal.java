package facade;

import java.util.List;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.Compra;
import entidades.Proveedor;
import excepciones.EntidadBaseException;


@Local
public interface CompraFacadeLocal extends EAOManager<Compra>{
	public List<Compra> listar_remoto(Compra e, Proveedor proveedor, String orden) throws EntidadBaseException;
}
