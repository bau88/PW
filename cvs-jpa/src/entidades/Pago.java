package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
public class Pago extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_pago", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="pago",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_pago")
	@Column(name="id_pago")
	private Integer idPago;

    @Temporal( TemporalType.DATE)
	@Column(name="fech_cierre")
	private Date fechCierre;

	private double monto;

	//bi-directional many-to-one association to Caja
    @ManyToOne
	@JoinColumn(name="id_caja")
	private Caja caja;

	//bi-directional many-to-one association to Factura
    @ManyToOne
	@JoinColumn(name="id_factura")
	private Factura factura;

    public Pago() {
    }

	public Integer getIdPago() {
		return this.idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public Date getFechCierre() {
		return this.fechCierre;
	}

	public void setFechCierre(Date fechCierre) {
		this.fechCierre = fechCierre;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Caja getCaja() {
		return this.caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}
	
	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdPago();
	}
	
}