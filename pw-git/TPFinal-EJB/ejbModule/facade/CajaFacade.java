package facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eao.EAOManagerImpl;
import entidades.Caja;
import entidades.Cliente;
import entidades.EntidadBase;
import excepciones.EntidadBaseException;

/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless
public class CajaFacade extends EAOManagerImpl<Caja> implements CajaFacadeLocal {

	@Override
	public Caja buscarRemoto(Object id) {
		// TODO Auto-generated method stub
		Caja caja = this.buscar(id);
		caja.setPagos(null);
		caja.setUsuarios(null);
		return caja;
	}

	
	public List<Caja> listar_remoto(Caja e, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		List<Caja> lista_auxiliar = super.listar(e, orden);
		List<Caja> lista_remoto = new ArrayList<Caja>();
		
		for (Caja caja : lista_auxiliar){
			Caja caja_aux = caja;
			caja_aux.setPagos(null);
			caja_aux.setUsuarios(null);
			lista_remoto.add(caja_aux);
		}
		return lista_remoto;
	}


}
