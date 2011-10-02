package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @Transient
    private Integer id_caja;
	//bi-directional many-to-many association to Rol
    
  /*  @ManyToMany
	  @JoinTable(name="rol_usuario", 
	    joinColumns={
	        @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")},
	      inverseJoinColumns={
	      @JoinColumn(name="id_rol", referencedColumnName="id_rol")}
	      )
	      List<Rol> roles;
	      */
    
    @ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;
    @Transient
    private Integer id_rol;
    

	
 

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
	/*
	public List<Rol> getRol() {
		return this.roles;
	}

	public void setRol(Rol rol) {
		if (this.roles == null)
			this.roles = new ArrayList<Rol>();
		this.roles.add(rol);
	}*/
	
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {		
		this.rol = rol;
	}
	

	public Integer getId_caja() {
		return id_caja;
	}

	public void setId_caja(Integer idCaja) {
		id_caja = idCaja;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer idRol) {
		id_rol = idRol;
	}
	
	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdUsuario();
	}
	
}