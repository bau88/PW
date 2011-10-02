package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
public class Factura extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_venta", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="venta",
            initialValue=0,
            allocationSize=1) 
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_venta")
	@Column(name="id_factura")
	private Integer idFactura;

    @Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="monto_total")
	private double montoTotal;

	private String numero;

	private double saldo;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to FacturaDetalle
	@OneToMany(mappedBy="factura")
	private List<FacturaDetalle> facturaDetalles;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="factura")
	private List<Pago> pagos;

    public Factura() {
    }

	public Integer getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMontoTotal() {
		return this.montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<FacturaDetalle> getFacturaDetalles() {
		return this.facturaDetalles;
	}

	public void setFacturaDetalles(List<FacturaDetalle> facturaDetalles) {
		this.facturaDetalles = facturaDetalles;
	}
	
	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdFactura();
	}
	
}