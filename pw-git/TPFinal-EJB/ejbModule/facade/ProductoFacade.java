package facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import eao.EAOManagerImpl;
import entidades.CompraDetalle;
import entidades.Producto;
import excepciones.EntidadBaseException;
import excepciones.StockException;
 
/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless
public class ProductoFacade extends EAOManagerImpl<Producto> implements ProductoFacadeLocal {
 
	@Override
	public void guardar_nuevo(Producto entity) throws EntidadBaseException {
		// TODO Auto-generated method stub
		//entity.setCantidad(0);
		//entity.setCostoActual(0.0);
		super.guardar_nuevo(entity);
	}

	@Override
	public Producto stockAumenta(Producto producto, Integer cantidad) throws EntidadBaseException{
		// TODO Auto-generated method stub
		Integer cantidad_actual  = producto.getCantidad();
		producto.setCantidad(cantidad_actual +  cantidad);
		return producto;	 
	}

	@Override
	public Producto buscar(Object id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		Producto producto = super.buscar(id);
		producto.getProveedores().size();
		return producto;
	}

	@Override 
	public Producto stockDisminuye(Producto producto, Integer cantidad) throws StockException {
		// TODO Auto-generated method stub
		Integer cantidad_actual  = producto.getCantidad();
		if (cantidad_actual -  cantidad < 0)
			throw new StockException("ERROR! No puede realizarse operacion, stock negativo");
		producto.setCantidad(cantidad_actual -  cantidad);
		return producto;
	}

	@Override
	public Producto setNuevoPrecioCompra(CompraDetalle compra, Producto producto) throws EntidadBaseException{
		Producto productoActual = this.buscar(compra.getProducto().getPK());
		// TODO Auto-generated method stub
		// precio de compra (costo actual * cantidad actual + costo nuevo * cantidad compra) / (cantidad actual + cantidad compra)
		Double actual = productoActual.getCostoActual()*productoActual.getCantidad();
		Double nuevo = compra.getPrecioCompra()*compra.getCantidad();
		Integer cociente = productoActual.getCantidad() + compra.getCantidad();
		producto.setCostoActual((actual + nuevo)/cociente);
		return (producto);
	}

	@Override
	public double getPrecioVenta(Producto producto) throws EntidadBaseException{
		// TODO Auto-generated method stub
		double producto_base = producto.getCostoActual();
		double producto_ganancia = producto.getCostoActual()*(producto.getPorcGanancia()/100);
		return producto_base + producto_ganancia;
	}

	
	public List<Producto> listar_remoto(Producto e, String orden)
			throws EntidadBaseException {
		// TODO Auto-generated method stub
		 List<Producto> listado_producto = super.listar(e, orden);
		 List<Producto> listado_remoto = new ArrayList<Producto>();
		 
		 for(Producto producto:listado_producto){
			 producto.setCompraDetalles(null);
			 producto.setFacturaDetalles(null);		
			 producto.setProveedores(null);
			 listado_remoto.add(producto);
		 }
		return listado_remoto;
	}	
}
