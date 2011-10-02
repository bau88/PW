package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
public class Producto extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_producto", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="producto",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_producto")
	@Column(name="id_producto")
	private Integer idProducto;

	private Integer cantidad;

	@Column(name="costo_actual")
	private Double costoActual;

	private String descripcion;

	@Column(name="porc_ganancia")
	private Double porcGanancia;

	//bi-directional many-to-one association to CompraDetalle
	@OneToMany(mappedBy="producto")
	private List<CompraDetalle> compraDetalles;

	//bi-directional many-to-one association to FacturaDetalle
	@OneToMany(mappedBy="producto")
	private List<FacturaDetalle> facturaDetalles;

	//bi-directional many-to-one association to ProductoProveedor
	@ManyToMany(mappedBy="productos", fetch=FetchType.LAZY)
	private List<Proveedor> productoProveedores;


    public Producto() {    		
    }

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getCostoActual() {
		return this.costoActual;
	}

	public void setCostoActual(double costoActual) {
		this.costoActual = costoActual;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPorcGanancia() {
		return this.porcGanancia;
	}

	public void setPorcGanancia(double porcGanancia) {
		this.porcGanancia = porcGanancia;
	}

	public List<CompraDetalle> getCompraDetalles() {
		return this.compraDetalles;
	}

	public void setCompraDetalles(List<CompraDetalle> compraDetalles) {
		this.compraDetalles = compraDetalles;
	}
	
	public List<FacturaDetalle> getFacturaDetalles() {
		return this.facturaDetalles;
	}

	public void setFacturaDetalles(List<FacturaDetalle> facturaDetalles) {
		this.facturaDetalles = facturaDetalles;
	}
	
	public List<Proveedor> getProveedores() {
		return this.productoProveedores;
	}

	public void setProveedores(Proveedor productoProveedores) {
		if (productoProveedores == null){
			this.productoProveedores = null;}
		else{
			this.productoProveedores.add(productoProveedores);
		}
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdProducto();
	}

	
	
}