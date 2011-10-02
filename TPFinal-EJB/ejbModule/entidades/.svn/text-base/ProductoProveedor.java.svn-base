package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producto_proveedor database table.
 * 
 */
@Entity
@Table(name="producto_proveedor")
public class ProductoProveedor extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_prod_prov", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="prod_prov",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_prod_prov")
	@Column(name="id_prod_prov")
	private Integer idProdProv;

	//bi-directional many-to-one association to Producto
    @ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	//bi-directional many-to-one association to Proveedor
    @ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
    
    @ManyToOne
	@JoinColumn(name="id_compra")
	private Compra compra;

    public ProductoProveedor() {
    }

	public Integer getIdProdProv() {
		return this.idProdProv;
	}

	public void setIdProdProv(Integer idProdProv) {
		this.idProdProv = idProdProv;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public ProductoProveedor(Compra compra, Producto producto, Proveedor proveedor) {
		super();
		this.compra = compra;
		this.producto = producto;
		this.proveedor = proveedor;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdProdProv();
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Compra getCompra() {
		return compra;
	}
	
}