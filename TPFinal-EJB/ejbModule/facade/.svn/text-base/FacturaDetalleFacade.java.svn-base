package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import eao.EAOManagerImpl;
import entidades.CompraDetalle;
import entidades.FacturaDetalle;
import entidades.Producto;
import excepciones.EntidadBaseException;

/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless
public class FacturaDetalleFacade extends EAOManagerImpl<FacturaDetalle> implements FacturaDetalleFacadeLocal {
	@EJB ProductoFacadeLocal productofacade;
	@Override
	public void guardar_nuevo(FacturaDetalle detalle) throws EntidadBaseException {
		// TODO Auto-generated method stub
		
		if (detalle.getId_producto() != null)
			detalle.setProducto(productofacade.buscar(detalle.getId_producto()));
		
		Producto stock_producto = productofacade.stockDisminuye(detalle.getProducto(), detalle.getCantidad());
		productofacade.guardar(stock_producto);
		super.guardar_nuevo(detalle);
	}
	@Override
	public void eliminar(List<FacturaDetalle> detalles) throws EntidadBaseException {		
		// TODO Auto-generated method stub
		for (FacturaDetalle detalle:detalles){		
			Producto stock_producto = productofacade.stockAumenta(detalle.getProducto(), detalle.getCantidad());
			productofacade.guardar(stock_producto);			
		}
		super.eliminar(detalles);
		
	}
	@Override
	public void eliminar(Object id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		FacturaDetalle detalle = this.buscar(id);
		Producto stock_producto = productofacade.stockAumenta(detalle.getProducto(), detalle.getCantidad());
		productofacade.guardar(stock_producto);
		super.eliminar(id);

	}	
	
}
