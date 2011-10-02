
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for pago complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pago">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webService/}entidadBase">
 *       &lt;sequence>
 *         &lt;element name="caja" type="{http://webService/}caja" minOccurs="0"/>
 *         &lt;element name="factura" type="{http://webService/}factura" minOccurs="0"/>
 *         &lt;element name="fechCierre" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idPago" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pago", propOrder = {
    "caja",
    "factura",
    "fechCierre",
    "idPago",
    "monto"
})
public class Pago
    extends EntidadBase
{

    protected Caja caja;
    protected Factura factura;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechCierre;
    protected Integer idPago;
    protected double monto;

    /**
     * Gets the value of the caja property.
     * 
     * @return
     *     possible object is
     *     {@link Caja }
     *     
     */
    public Caja getCaja() {
        return caja;
    }

    /**
     * Sets the value of the caja property.
     * 
     * @param value
     *     allowed object is
     *     {@link Caja }
     *     
     */
    public void setCaja(Caja value) {
        this.caja = value;
    }

    /**
     * Gets the value of the factura property.
     * 
     * @return
     *     possible object is
     *     {@link Factura }
     *     
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * Sets the value of the factura property.
     * 
     * @param value
     *     allowed object is
     *     {@link Factura }
     *     
     */
    public void setFactura(Factura value) {
        this.factura = value;
    }

    /**
     * Gets the value of the fechCierre property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechCierre() {
        return fechCierre;
    }

    /**
     * Sets the value of the fechCierre property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechCierre(XMLGregorianCalendar value) {
        this.fechCierre = value;
    }

    /**
     * Gets the value of the idPago property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPago() {
        return idPago;
    }

    /**
     * Sets the value of the idPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPago(Integer value) {
        this.idPago = value;
    }

    /**
     * Gets the value of the monto property.
     * 
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     */
    public void setMonto(double value) {
        this.monto = value;
    }

}
