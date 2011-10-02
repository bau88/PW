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
import entidades.Proveedor;
import excepciones.EntidadBaseException;

/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless 
public class ProveedorFacade extends EAOManagerImpl<Proveedor> implements ProveedorFacadeLocal {

		public List<Proveedor> listar_remoto(Proveedor e, String orden)
			throws EntidadBaseException {
		// TODO Auto-generated method stub
			List<Proveedor> lista_proveedor = super.listar(e, orden);
			List<Proveedor> lista_remoto = new ArrayList<Proveedor>();
			
			for(Proveedor proveedor:lista_proveedor){
				Proveedor proveedor_dto = new Proveedor();
				proveedor_dto.setIdProveedor(proveedor.getIdProveedor());
				proveedor_dto.setNombre(proveedor.getNombre());
	
				lista_remoto.add(proveedor_dto);
			}
			
		return lista_remoto;
	}
	
	
}
