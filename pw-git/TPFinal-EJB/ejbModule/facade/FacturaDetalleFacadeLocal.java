package facade;

import javax.ejb.Local;
import eao.EAOManager;
import entidades.FacturaDetalle;


@Local
public interface FacturaDetalleFacadeLocal extends EAOManager<FacturaDetalle>{
}
