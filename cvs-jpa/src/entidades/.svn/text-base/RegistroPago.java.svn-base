package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the registro_pago database table.
 * 
 */
@Entity
@Table(name="registro_pago")
public class RegistroPago extends EntidadBase {
	private static final long serialVersionUID = 1L;

    @TableGenerator(name="secuencia_registro_pago", table="secuencia",
            pkColumnName="secuencia_tabla", valueColumnName="secuencia_numero",
            pkColumnValue="registro_pago",
            initialValue=0,
            allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="secuencia_registro_pago")
	
	@Column(name="id_reg_pag")
	private Integer idRegPag;
    
    @Temporal(TemporalType.DATE)
	private Date fecha;
    
	@Column(name="numero_pago")
	private Integer numeroPago;

	private String resultado;

    public RegistroPago() {
    }

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdRegPag() {
		return this.idRegPag;
	}

	public void setIdRegPag(Integer idRegPag) {
		this.idRegPag = idRegPag;
	}

	public Integer getNumeroPago() {
		return this.numeroPago;
	}

	public void setNumeroPago(Integer numeroPago) {
		this.numeroPago = numeroPago;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public Object getPK() {
		// TODO Auto-generated method stub
		return this.getIdRegPag();
	}

}