package facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eao.EAOManagerImpl;
import entidades.Cliente;
import entidades.CompraDetalle;
import entidades.EntidadBase;
import entidades.ProductoProveedor;
import entidades.RolUsuario;
import entidades.Usuario;
import excepciones.EntidadBaseException;

/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless  
public class UsuarioFacade extends EAOManagerImpl<Usuario> implements UsuarioFacadeLocal {
	@EJB CajaFacadeLocal cajafacade;
	@EJB RolFacadeLocal rolfacade;
	
	@Override
	public void guardar(Usuario entidad) throws EntidadBaseException {
		// TODO Auto-generated method stub
		if (entidad.getId_caja() != null)
			entidad.setCaja(cajafacade.buscar(entidad.getId_caja()));
		if (entidad.getId_rol() != null)
			entidad.setRol(rolfacade.buscar(entidad.getId_rol()));
		super.guardar(entidad);
	}

	public List<Usuario> listar_remoto(Usuario e, String orden)
			throws EntidadBaseException {
		 List<Usuario> lista_usuario = super.listar(e, orden);
		 List<Usuario> lista_remoto = new ArrayList<Usuario>();
		 
		 for(Usuario usuario: lista_usuario){
			 if (usuario.getCaja() != null)
			 {
				 usuario.setId_caja(usuario.getCaja().getIdCaja());
				 usuario.getCaja().setPagos(null);
			 	 usuario.getCaja().setUsuarios(null);
			 }
			 if (usuario.getRol() != null)
				 usuario.getRol().setUsuarios(null);
			 
			 lista_remoto.add(usuario);
		 }
		 
		// TODO Auto-generated method stub
		return lista_remoto;
	}
	
}
