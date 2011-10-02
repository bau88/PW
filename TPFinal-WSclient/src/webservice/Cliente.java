
package webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cliente complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cliente">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webService/}entidadBase">
 *       &lt;sequence>
 *         &lt;element name="facturas" type="{http://webService/}factura" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cliente", propOrder = {
    "facturas",
    "idCliente",
    "nombre"
})
public class Cliente
    extends EntidadBase
{

    @XmlElement(nillable = true)
    protected List<Factura> facturas;
    protected Integer idCliente;
    protected String nombre;

    /**
     * Gets the value of the facturas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the facturas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFacturas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Factura }
     * 
     * 
     */
    public List<Factura> getFacturas() {
        if (facturas == null) {
            facturas = new ArrayList<Factura>();
        }
        return this.facturas;
    }

    /**
     * Gets the value of the idCliente property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the value of the idCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCliente(Integer value) {
        this.idCliente = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

}
