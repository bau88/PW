package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
public class Proveedor extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_proveedor", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="proveedor",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_proveedor")
	@Column(name="id_proveedor")
	private Integer idProveedor;

	private String nombre;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="proveedor")
	private List<Compra> compras;

	//bi-directional many-to-one association to ProductoProveedor
	//@OneToMany(mappedBy="proveedor")
	//private List<ProductoProveedor> productoProveedors;


	@ManyToMany
	  @JoinTable(name="producto_proveedor", 
	    joinColumns={
	        @JoinColumn(name="id_proveedor", referencedColumnName="id_proveedor")},
	      inverseJoinColumns={
	      @JoinColumn(name="id_producto", referencedColumnName="id_producto")}
	      )

	List<Producto> productos;
	
    public Proveedor() {
    }

	public Integer getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	public List<Producto> getProductoProveedores() {
		return this.productos;
	}

	public void setProductoProveedores(Producto producto) {
		this.productos.add(producto);
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdProveedor();
	}
	
}