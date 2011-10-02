package facade;

import java.util.List;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.Rol;
import excepciones.EntidadBaseException;


@Local
public interface RolFacadeLocal extends EAOManager<Rol>{
	public List<Rol> listar_remoto(Rol e, String orden) throws EntidadBaseException ;
}
