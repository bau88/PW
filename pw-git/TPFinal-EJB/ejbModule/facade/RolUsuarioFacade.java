package facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import eao.EAOManagerImpl;
import entidades.RolUsuario;
import excepciones.EntidadBaseException;

/**
 * Session Bean implementation class RolUsuarioFacade
 */
@Stateless
public class RolUsuarioFacade  extends EAOManagerImpl<RolUsuario> implements RolUsuarioFacadeLocal {

    /**
     * Default constructor. 
     */
    public RolUsuarioFacade() {
        // TODO Auto-generated constructor stub
    }

	
	public List<RolUsuario> listar_remoto(RolUsuario e, String orden)
			throws EntidadBaseException {
		// TODO Auto-generated method stub
		List<RolUsuario> lista_aux = super.listar(e, orden);
		List<RolUsuario> lista_roles = new ArrayList<RolUsuario>();
		
		for(RolUsuario rolusuario:lista_aux){
			rolusuario.setIdUsuario(null);
			lista_roles.add(rolusuario);
		}
		
		return lista_roles;
	}

}
