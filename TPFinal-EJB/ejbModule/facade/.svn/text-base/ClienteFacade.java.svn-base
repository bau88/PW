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
import excepciones.EntidadBaseException;

/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless
public class ClienteFacade extends EAOManagerImpl<Cliente> implements ClienteFacadeLocal {

	
	public List<Cliente> listar_remoto(Cliente e, String orden)
			throws EntidadBaseException {
		// TODO Auto-generated method stub
		List<Cliente> lista_cliente = super.listar(e, orden);
		List<Cliente> lista_remoto = new ArrayList<Cliente>();
		for(Cliente cliente:lista_cliente){
			Cliente cliente_dto = new Cliente();
			cliente_dto.setIdCliente(cliente.getIdCliente());
			cliente_dto.setNombre(cliente.getNombre());
			lista_remoto.add(cliente_dto);
		}			
		
		return lista_remoto;
	}	
	
}
