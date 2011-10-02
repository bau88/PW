package facade;

import java.util.List;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.CompraDetalle;
import entidades.Producto;
import excepciones.EntidadBaseException;

  
@Local 
public interface ProductoFacadeLocal extends EAOManager<Producto>{
	Producto stockAumenta(Producto producto, Integer cantidad);
	Producto stockDisminuye(Producto producto, Integer cantidad);
	Producto setNuevoPrecioCompra(CompraDetalle compra, Producto producto);
	double getPrecioVenta(Producto producto);
	public List<Producto> listar_remoto(Producto e, String orden) throws EntidadBaseException; 
}
