package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the rol_usuario database table.
 * 
 */
@Entity
@Table(name="rol_usuario")
public class RolUsuario extends EntidadBase {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name="secuencia_rol_usu", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="rol_usuario",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_rol_usu")
	@Column(name="id_rolusu")
	private Integer idRolusu;

	//bi-directional many-to-one association to Rol
    @ManyToOne
	@JoinColumn(name="id_rol")
	private Rol idRol;
    
    @Transient
    private Integer id_rol;

	public Integer getId_rol() {
		return id_rol;
	}


	public void setId_rol(Integer idRol) {
		id_rol = idRol;
	}


	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario idUsuario;
   

    public RolUsuario() {
    }


	public RolUsuario(Usuario usuario, Rol rol) {
		super();
		this.idRol = rol;
		this.idUsuario = usuario;
		
	}

	
	public Integer getIdRolusu() {
		return idRolusu;
	}


	public void setIdRolusu(Integer idRolusu) {
		this.idRolusu = idRolusu;
	}


	public Usuario getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Rol getIdRol() {
		return idRol;
	}


	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}


	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdRolusu();
	}

	
}