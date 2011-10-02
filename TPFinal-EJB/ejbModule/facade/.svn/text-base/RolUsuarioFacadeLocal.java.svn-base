package facade;
import java.util.List;

import javax.ejb.Local;

import eao.EAOManager;
import entidades.RolUsuario;
import excepciones.EntidadBaseException;

@Local
public interface RolUsuarioFacadeLocal extends EAOManager<RolUsuario>{
	public List<RolUsuario> listar_remoto(RolUsuario e, String orden) throws EntidadBaseException;
}
