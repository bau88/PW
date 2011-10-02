package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
public class Cliente extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_cliente", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="cliente",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_cliente")
	@Column(name="id_cliente")
	private Integer idCliente;

	private String nombre;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="cliente")
	private List<Factura> facturas;

    public Cliente() {
    }

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdCliente();
	}
	
}