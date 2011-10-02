package facade;

import java.util.List;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.Usuario;
import excepciones.EntidadBaseException;


@Local 
public interface UsuarioFacadeLocal extends EAOManager<Usuario>{
	public List<Usuario> listar_remoto(Usuario e, String orden)	throws EntidadBaseException; 
}
