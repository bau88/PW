package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
public class Rol extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_rol", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="rol",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_rol")
	@Column(name="id_rol")
	private Integer idRol;

	private String nombre;

	//bi-directional many-to-many association to Usuario
	@OneToMany(mappedBy="rol", fetch=FetchType.LAZY)
	private List<Usuario> usuarios;	
	
    public Rol() {
    }

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return this.getIdRol();
	}
	
}