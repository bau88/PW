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
import entidades.Compra;
import entidades.CompraDetalle;
import entidades.EntidadBase;
import entidades.ProductoProveedor;
import entidades.Proveedor;
import excepciones.EntidadBaseException;

/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless
public class CompraFacade extends EAOManagerImpl<Compra> implements CompraFacadeLocal {
	@EJB CompraDetalleFacadeLocal compraDetalle;
	@EJB ProveedorFacadeLocal proveedorFacade;
	@EJB ProductoFacadeLocal productoFacade;
	@EJB ProductoProveedorFacadeLocal productoProveedor;
	@Override
	public void guardar(Compra compra) throws EntidadBaseException {
		// TODO Auto-generated method stub
		double TotalCompra = 0;
		if (compra.getId_proveedor() != null)
			compra.setProveedor(proveedorFacade.buscar(compra.getId_proveedor()));
		super.guardar(compra);// Necesario para guardar el detalle
		for(CompraDetalle detalle:compra.getCompraDetalles()){
			if (detalle.getId_producto() != null)
				detalle.setProducto(productoFacade.buscar(detalle.getId_producto()));
			detalle.setCompra(compra); // agregado
			compraDetalle.guardar(compra, detalle);			
			TotalCompra += detalle.getCantidad() * detalle.getPrecioCompra();
			}
		compra.setTotalCompra(TotalCompra);
		super.guardar(compra);// Necesario para actualizar el total
	}

	@Override
	public void eliminar(Object id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		Compra compra = buscar(id);		
		compraDetalle.eliminar(compra);
		productoProveedor.eliminar_relacion(compra);
		super.eliminar(id);
	}

	
	public List<Compra> listar_remoto(Compra e, Proveedor proveedor, String orden)
			throws EntidadBaseException { 
		// TODO Auto-generated method stub
		
		if(proveedor != null){
			List<Proveedor> lista_aux = proveedorFacade.listar(proveedor, "");			
			if (lista_aux.size() > 0){
				e.setProveedor(lista_aux.get(0));	
			}
			
		}
		List<Compra> lista_compra = super.listar(e, orden);
		List<Compra> lista_remoto = new ArrayList<Compra>();
		
		for (Compra compra: lista_compra){
			Compra compra_dto = new Compra();
			compra_dto.setIdCompra(compra.getIdCompra());
			compra_dto.setFecha(compra.getFecha());
			compra_dto.setNombre_proveedor(compra.getProveedor().getNombre());
			compra_dto.setTotalCompra(compra.getTotalCompra());
			
			lista_remoto.add(compra_dto);
		}
		return lista_remoto;
	}	
	
	
}
