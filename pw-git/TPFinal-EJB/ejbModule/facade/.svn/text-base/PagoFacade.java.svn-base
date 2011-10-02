package facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.jasper.tagplugins.jstl.core.Otherwise;

import eao.EAOManagerImpl;
import entidades.Caja;
import entidades.Cliente;
import entidades.EntidadBase;
import entidades.Factura;
import entidades.Pago;
import entidades.RegistroPago;
import excepciones.EntidadBaseException;
import excepciones.PagoException;

/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless 
public class PagoFacade extends EAOManagerImpl<Pago> implements PagoFacadeLocal {
	@EJB FacturaFacadeLocal facturaFacade;
	@EJB CajaFacadeLocal cajaFacade;
	@EJB ClienteFacadeLocal clienteFacade;
	@EJB RegistroPagoFacadeLocal registroPagoFacade;

	@Override
	public void guardar(Pago pago) throws EntidadBaseException,PagoException {
		// TODO Auto-generated method stub
		if (pago.getId_caja() != null)
			pago.setCaja(cajaFacade.buscar(pago.getId_caja()));
		if (pago.getId_factura() != null)
			pago.setFactura(facturaFacade.buscar(pago.getId_factura()));		
		
		Factura factura = facturaFacade.buscar(pago.getFactura().getPK());
		double factura_total = factura.getMontoTotal();
		double factura_saldo = factura.getSaldo();
		
		if(factura_total == factura_saldo + pago.getMonto()){			
			factura.setPendiente("N");			
		}else{
			if (factura_total > factura_saldo + pago.getMonto()){
				factura.setPendiente("S");	
			}
			else{
				if(factura_total < factura_saldo + pago.getMonto())
					throw new PagoException("ERROR!! Pago superior a monto de Factura "+ factura.getNumero());
			}
		}
				
		factura.setSaldo(factura_saldo + pago.getMonto());
		facturaFacade.guardar(factura);
		pago.setCerrado("N");
		super.guardar(pago);
	}
	public String guardar(List<Pago> pagos){
		boolean terminadoExito = true;
		for(Pago pago:pagos){
			RegistroPago registroPago = new RegistroPago();
			registroPago.setFecha(new Date());			
			try {
				this.guardar(pago);
				registroPago.setNumeroPago(pago.getIdPago());
				registroPago.setResultado("CORRECTO");
			} catch (PagoException e) {
				terminadoExito = false;
				// TODO Auto-generated catch block				
				registroPago.setResultado(e.getMensajeError());				
			}catch (Exception e) {
				terminadoExito = false;
				// TODO Auto-generated catch block
				registroPago.setResultado(e.getLocalizedMessage());				
			}
			registroPagoFacade.guardar(registroPago);
			
		}
		if (terminadoExito == true){
			
			return "Pagos procesados con exito";
		}
		return "Pagos procesados con errores!";
	}
	
	public List<Pago> CierreCaja(Caja caja_cierre) {
		
		Pago pagos = new Pago();
		pagos.setCaja(caja_cierre);
		pagos.setCerrado("N");
		List<Pago> lista_pago = listar(pagos, "");
		List<Pago> lista_retorno = new ArrayList<Pago>();
		
		for(Pago pago: lista_pago){			
			pago.setCerrado("S");
			pago.setFechCierre(new Date());
			Pago pago_dto = new Pago();
			pago_dto.setCaja(pago.getCaja());
			pago_dto.setFactura(pago.getFactura());
			pago_dto.setId_caja(pago.getId_caja());
			pago_dto.setMonto(pago.getMonto());
			lista_retorno.add(pago_dto);
		}
		
		// TODO Auto-generated method stub		
		return lista_retorno;
	}

	@Override
	public void eliminar(List<Pago> pagos) throws EntidadBaseException {
		// TODO Auto-generated method stub
		for (Pago pago:pagos){
			Factura factura = pago.getFactura();
			double monto_pago = pago.getMonto();
			double saldo_actual = factura.getSaldo();			
			factura.setSaldo(saldo_actual-monto_pago);
			factura.setPendiente("S");
			facturaFacade.guardar(factura);
		}
		super.eliminar(pagos);
	}

	@Override
	public void eliminar(Object id) throws EntidadBaseException {
		// TODO Auto-generated method stub
		Pago pago = buscar(id);
		double monto_pago = pago.getMonto();
		Factura factura = pago.getFactura();
		double saldo_actual = factura.getSaldo();
		factura.setSaldo(saldo_actual-monto_pago);
		factura.setPendiente("S");
		facturaFacade.guardar(factura);
		super.eliminar(id);
	}
	
	public List<Pago> listar_remoto(Pago e,Factura factura, Cliente cliente, Caja caja, String orden) throws EntidadBaseException {
		// TODO Auto-generated method stub
		
		if (cliente != null){
			List<Cliente> lista_cliente = clienteFacade.listar(cliente, "");
			if (lista_cliente.size() > 0 ){
				factura.setCliente(lista_cliente.get(0));
			}
		}
		
		if (factura != null){
			List<Factura> lista_factura = facturaFacade.listar(factura, "");
			if (lista_factura.size() > 0 ){
				e.setFactura(lista_factura.get(0));
			}
		}
		
		if (caja != null){
			List<Caja> lista_caja = cajaFacade.listar(caja, "");
			if (lista_caja.size() > 0 ){
				e.setCaja(lista_caja.get(0));
			}
		}
		
		
		List<Pago> pagos =  super.listar(e, orden);
		List<Pago> pagos_retorno = new ArrayList<Pago>();
		for(Pago pago:pagos){
			Pago pago_dto = new Pago();
					
			
			
			Factura factura_dto = new Factura();
			factura_dto.setNumero(pago.getFactura().getNumero());
			Cliente cliente_dto = new Cliente();
			cliente_dto.setNombre(pago.getFactura().getCliente().getNombre());
			Caja caja_dto = new Caja();
			caja_dto.setDescripcion(pago.getCaja().getDescripcion());
			factura_dto.setCliente(cliente_dto);
			
			pago_dto.setIdPago(pago.getIdPago());
			pago_dto.setFactura(factura_dto);//pago_dto.setFactura(pago_dto.getFactura());
			pago_dto.setMonto(pago.getMonto());
			pago_dto.setFechCierre(pago.getFechCierre());			
			pago_dto.setCaja(caja_dto);
			pagos_retorno.add(pago_dto);
		}
		return pagos_retorno;
		
	}
	
}
