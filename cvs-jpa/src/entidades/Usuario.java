package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_usuario", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="usuario",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_usuario")
	@Column(name="id_usuario")
	private Integer idUsuario;

	private String alias;

	private String contrasenha;

	private String nombre;

	//bi-directional many-to-one association to Caja
    @ManyToOne
	@JoinColumn(name="id_caja")
	private Caja caja;

	//bi-directional many-to-one association to Rol
    @ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

    public Usuario() {
    }

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getContrasenha() {
		return this.contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Caja getCaja() {
		return this.caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}
	
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdUsuario();
	}
	
}