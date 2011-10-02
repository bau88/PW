package facade;

import java.util.List;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.Compra;
import entidades.CompraDetalle;
import excepciones.EntidadBaseException;


@Local
public interface CompraDetalleFacadeLocal extends EAOManager<CompraDetalle>{

	void guardar(Compra compra, CompraDetalle detalle) throws EntidadBaseException;
	void eliminar(Compra compra)throws EntidadBaseException;
	
}
