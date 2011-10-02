
package webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for factura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="factura">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webService/}entidadBase">
 *       &lt;sequence>
 *         &lt;element name="cliente" type="{http://webService/}cliente" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idFactura" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="montoTotal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pagos" type="{http://webService/}pago" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pendiente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "factura", propOrder = {
    "cliente",
    "fecha",
    "idFactura",
    "montoTotal",
    "numero",
    "pagos",
    "pendiente",
    "saldo"
})
public class Factura
    extends EntidadBase
{

    protected Cliente cliente;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    protected Integer idFactura;
    protected double montoTotal;
    protected String numero;
    @XmlElement(nillable = true)
    protected List<Pago> pagos;
    protected String pendiente;
    protected double saldo;

    /**
     * Gets the value of the cliente property.
     * 
     * @return
     *     possible object is
     *     {@link Cliente }
     *     
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Sets the value of the cliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cliente }
     *     
     */
    public void setCliente(Cliente value) {
        this.cliente = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the idFactura property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdFactura() {
        return idFactura;
    }

    /**
     * Sets the value of the idFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdFactura(Integer value) {
        this.idFactura = value;
    }

    /**
     * Gets the value of the montoTotal property.
     * 
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * Sets the value of the montoTotal property.
     * 
     */
    public void setMontoTotal(double value) {
        this.montoTotal = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
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
     * Gets the value of the pendiente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPendiente() {
        return pendiente;
    }

    /**
     * Sets the value of the pendiente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPendiente(String value) {
        this.pendiente = value;
    }

    /**
     * Gets the value of the saldo property.
     * 
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Sets the value of the saldo property.
     * 
     */
    public void setSaldo(double value) {
        this.saldo = value;
    }

}
