package facade;

import java.util.List;

import javax.ejb.Local;

import eao.EAOManager;
import entidades.Caja;
import excepciones.EntidadBaseException;


@Local
public interface CajaFacadeLocal extends EAOManager<Caja>{
	Caja buscarRemoto(Object id);
	public List<Caja> listar_remoto(Caja e, String orden) throws EntidadBaseException;
}
