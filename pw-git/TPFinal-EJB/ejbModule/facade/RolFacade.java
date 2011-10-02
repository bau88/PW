package facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eao.EAOManagerImpl;
import entidades.Cliente;
import entidades.EntidadBase;
import entidades.Rol;
import excepciones.EntidadBaseException;

/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless
public class RolFacade extends EAOManagerImpl<Rol> implements RolFacadeLocal {

	
	public List<Rol> listar_remoto(Rol e, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		List<Rol> lista_aux = super.listar(e, orden);
		List<Rol> lista_remoto = new ArrayList<Rol>();
		for(Rol rol:lista_aux){
			rol.setUsuarios(null);
			lista_remoto.add(rol);
		}
		return lista_remoto;
	}
	
}
