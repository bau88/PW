package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the caja database table.
 * 
 */
@Entity
public class Caja extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_caja", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="caja",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_caja")
	@Column(name="id_caja")
	private Integer idCaja;

	private String descripcion;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="caja")
	private List<Pago> pagos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="caja")
	private List<Usuario> usuarios;

    public Caja() {
    }

	public Integer getIdCaja() {
		return this.idCaja;
	}

	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdCaja();
	}
	
}