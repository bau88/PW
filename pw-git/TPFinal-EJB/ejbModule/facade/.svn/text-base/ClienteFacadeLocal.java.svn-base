package facade;

import java.util.List;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.Cliente;
import excepciones.EntidadBaseException;


@Local
public interface ClienteFacadeLocal extends EAOManager<Cliente>{
	public List<Cliente> listar_remoto(Cliente e, String orden) throws EntidadBaseException ;
}
