package facade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eao.EAOManagerImpl;
import entidades.Cliente;
import entidades.Compra;
import entidades.EntidadBase;
import entidades.ProductoProveedor;

/** 
 * Session Bean implementation class ClienteFacade
 */
@Stateless
public class ProductoProveedorFacade extends EAOManagerImpl<ProductoProveedor> implements ProductoProveedorFacadeLocal {

	@Override
	public void eliminar_relacion(Compra compra) {
		// TODO Auto-generated method stub
		ProductoProveedor relacion = new ProductoProveedor();
		relacion.setCompra(compra);
		List<ProductoProveedor> lista_relacion_borrar = this.listar(relacion, "idProdProv");
		for(ProductoProveedor registro:lista_relacion_borrar){
			this.eliminar(registro.getPK());
		}
		
	}	
}
