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
import entidades.Factura;
import entidades.FacturaDetalle;
import entidades.ProductoProveedor;
import excepciones.EntidadBaseException;
import excepciones.FacturaException;

/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless 
public class FacturaFacade extends EAOManagerImpl<Factura> implements FacturaFacadeLocal {
	@EJB FacturaDetalleFacadeLocal facturaDetalle;
	@EJB ClienteFacadeLocal clienteFacade;
	
	@Override
	public void guardar_nuevo(Factura factura) throws EntidadBaseException {
		double total_factura = 0 ;
		factura.setMontoTotal(total_factura);
		factura.setSaldo(0);
		factura.setPendiente("S");
		super.guardar_nuevo(factura);
	}
	
	@Override
	public void guardar(Factura factura) throws EntidadBaseException {
		// TODO Auto-generated method stub
		double total_factura = 0 ;		
		if (factura.getId_cliente() != null)
			factura.setCliente(clienteFacade.buscar(factura.getId_cliente()));
		if (factura.getPK() == null)
			this.guardar_nuevo(factura);
		for(FacturaDetalle detalle:factura.getFacturaDetalles()){
			facturaDetalle.guardar(detalle);	
			total_factura += detalle.getCantidad() * detalle.getPrecioVenta();
		}
		factura.setMontoTotal(total_factura);
		super.guardar(factura);
	}

	@Override
	public void eliminar(Object id) throws EntidadBaseException,FacturaException {
		// TODO Auto-generated method stub
		Factura factura = this.buscar(id);	
		if (factura.getPagos().size() == 0){
			facturaDetalle.eliminar(factura.getFacturaDetalles());
		}
		else{
			throw new FacturaException("ERROR!!! No se puede elimnar, factura posee Pagos");
		}
		super.eliminar(id);
	}

	@Override
	public Factura buscarRemoto(Object id) {
		// TODO Auto-generated method stub
		Factura factura = this.buscar(id);
		factura.getFacturaDetalles().size();
		factura.getPagos().size();
		factura.getCliente().setFacturas(null);
		factura.setFacturaDetalles(null);
		factura.setPagos(null);
				return factura;
	}
	
	public Factura buscar_con_detalle(Object id) {
		// TODO Auto-generated method stub
		Factura factura = this.buscar(id);
		factura.getFacturaDetalles().size();		
		factura.getCliente().setFacturas(null);		
		factura.setPagos(null);
		return factura;
	}
	public List<Factura> listar_remoto(Factura e, Cliente cliente, String orden)
			throws EntidadBaseException {
		// TODO Auto-generated method stub
		if (cliente != null){
			List<Cliente> buscar = clienteFacade.listar(cliente, "");
			if (buscar.size() > 0)
				e.setCliente(buscar.get(0));
		}
		List<Factura> lista_factura = super.listar(e, orden);
		List<Factura> lista_remoto = new ArrayList<Factura>();
		
		for(Factura factura: lista_factura){
			factura.getFacturaDetalles().size();
			factura.getPagos().size();
			factura.getCliente().setFacturas(null);
			factura.setFacturaDetalles(null);
			factura.setPagos(null);
			lista_remoto.add(factura);
		}
		return lista_remoto;
	}

	
	public int guardar_e_imprimir(Factura factura) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		double total_factura = 0 ;		
		if (factura.getId_cliente() != null)
			factura.setCliente(clienteFacade.buscar(factura.getId_cliente()));
		if (factura.getPK() == null)
			this.guardar_nuevo(factura);
		for(FacturaDetalle detalle:factura.getFacturaDetalles()){
			facturaDetalle.guardar(detalle);	
			total_factura += detalle.getCantidad() * detalle.getPrecioVenta();
		}
		factura.setMontoTotal(total_factura);
		super.guardar(factura);
		return factura.getIdFactura();
	}
	
	
}
