package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the compra database table.
 * 
 */
@Entity
public class Compra extends EntidadBase {
	private static final long serialVersionUID = 1L;
	
	@TableGenerator(name="secuencia_compra", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="compra",
            initialValue=0,
            allocationSize=1) 
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_compra")
	@Column(name="id_compra")
	private Integer idCompra;

    @Temporal( TemporalType.DATE)
	private Date fecha;

	@Column(name="total_compra")
	private Double totalCompra;

	//bi-directional many-to-one association to Proveedor
    @ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
    
    @Transient
    private Integer id_proveedor;
    
    @Transient
    private String nombre_proveedor;

	public Integer getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Integer idProveedor) {
		id_proveedor = idProveedor;
	}

	//bi-directional many-to-one association to CompraDetalle
	@OneToMany(mappedBy="compra")//, cascade = CascadeType.ALL
	private List<CompraDetalle> compraDetalles;
	
	@OneToMany(mappedBy="compra")//, cascade = CascadeType.ALL
	private List<ProductoProveedor> productoProveedor;

    public Compra() {
    //	this.fecha = new Date();    	
    //	this.totalCompra = 0;
    //	this.compraDetalles = new ArrayList<CompraDetalle>();
    }

	public Integer getIdCompra() {
		return this.idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotalCompra() {
		return this.totalCompra;
	}

	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public List<CompraDetalle> getCompraDetalles() {
		return this.compraDetalles;
	}

	public void setCompraDetalles(CompraDetalle compraDetalle) {
		
		if (compraDetalle == null){
			this.compraDetalles = null;
		}
		else {
			if (this.compraDetalles == null)
				this.compraDetalles = new ArrayList<CompraDetalle>();			
			this.compraDetalles.add(compraDetalle);
		}
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdCompra();
	}

	public void setProductoProveedor(List<ProductoProveedor> productoProveedor) {
		this.productoProveedor = productoProveedor;
	}

	public List<ProductoProveedor> getProductoProveedor() {
		return productoProveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}
	
}