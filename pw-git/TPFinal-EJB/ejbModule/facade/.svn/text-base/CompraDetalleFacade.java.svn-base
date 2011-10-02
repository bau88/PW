package facade;


import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import eao.EAOManagerImpl;
import entidades.Compra;
import entidades.CompraDetalle;
import entidades.Producto;
import entidades.ProductoProveedor;
import excepciones.EntidadBaseException;


/**
 * Session Bean implementation class ClienteFacade
 */ 
@Stateless
public class CompraDetalleFacade extends EAOManagerImpl<CompraDetalle> implements CompraDetalleFacadeLocal {
	@EJB ProductoFacadeLocal productofacade;	
	@EJB ProductoProveedorFacadeLocal productoProveedor;
	@Override
	public void guardar(CompraDetalle detalle) throws EntidadBaseException {
		// TODO Auto-generated method stub
		if (detalle.getId_producto() != null)
			detalle.setProducto(productofacade.buscar(detalle.getId_producto()));
		Producto producto_nuevo = productofacade.buscar(detalle.getProducto().getPK());
		producto_nuevo = productofacade.setNuevoPrecioCompra(detalle, producto_nuevo);
		producto_nuevo = productofacade.stockAumenta(producto_nuevo, detalle.getCantidad());
		productofacade.guardar(producto_nuevo);
		super.guardar(detalle);
	}
	@Override
	public void eliminar(Object id) throws EntidadBaseException {
		// TODO Auto-generated method stub		
		CompraDetalle detalle = this.buscar(id);
		Producto stock_producto = productofacade.stockDisminuye(detalle.getProducto(), detalle.getCantidad());
		productofacade.guardar(stock_producto);
		super.eliminar(id);
		//super.guardar(detalle);
	}
	@Override
	public void eliminar(List<CompraDetalle> detalles) throws EntidadBaseException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		for (CompraDetalle detalle:detalles){		
			Producto stock_producto = productofacade.stockDisminuye(detalle.getProducto(), detalle.getCantidad());
			productofacade.guardar(stock_producto);			
		}
		super.eliminar(detalles);		
	}
	@Override
	public void guardar(Compra compra, CompraDetalle detalle) throws EntidadBaseException {
		// TODO Auto-generated method stub
		
		ProductoProveedor relacion = new ProductoProveedor(compra,detalle.getProducto(),compra.getProveedor());
		productoProveedor.guardar(relacion);
		guardar(detalle);
	}
	@Override
	public void eliminar(Compra compra) throws EntidadBaseException {
		// TODO Auto-generated method stub
		
		eliminar(compra.getCompraDetalles());
	}
	
	
}
