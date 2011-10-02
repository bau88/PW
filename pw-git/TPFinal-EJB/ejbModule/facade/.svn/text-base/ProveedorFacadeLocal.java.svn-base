package facade;

import java.util.List;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.Proveedor;
import excepciones.EntidadBaseException;
 

@Local
public interface ProveedorFacadeLocal extends EAOManager<Proveedor>{
	public List<Proveedor> listar_remoto(Proveedor e, String orden)
	throws EntidadBaseException ;
}
