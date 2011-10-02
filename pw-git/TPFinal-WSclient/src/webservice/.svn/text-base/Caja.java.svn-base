
package webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for caja complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="caja">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webService/}entidadBase">
 *       &lt;sequence>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCaja" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="pagos" type="{http://webService/}pago" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usuarios" type="{http://webService/}usuario" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "caja", propOrder = {
    "descripcion",
    "idCaja",
    "pagos",
    "usuarios"
})
public class Caja
    extends EntidadBase
{

    protected String descripcion;
    protected Integer idCaja;
    @XmlElement(nillable = true)
    protected List<Pago> pagos;
    @XmlElement(nillable = true)
    protected List<Usuario> usuarios;

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the idCaja property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCaja() {
        return idCaja;
    }

    /**
     * Sets the value of the idCaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCaja(Integer value) {
        this.idCaja = value;
    }

    /**
     * Gets the value of the pagos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pagos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPagos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pago }
     * 
     * 
     */
    public List<Pago> getPagos() {
        if (pagos == null) {
            pagos = new ArrayList<Pago>();
        }
        return this.pagos;
    }

    /**
     * Gets the value of the usuarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Usuario }
     * 
     * 
     */
    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = new ArrayList<Usuario>();
        }
        return this.usuarios;
    }

}
