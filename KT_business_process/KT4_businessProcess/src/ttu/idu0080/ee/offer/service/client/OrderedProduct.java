
package ttu.idu0080.ee.offer.service.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderedProduct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderedProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="priceTotal" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="productCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderedProduct", propOrder = {
    "price",
    "priceTotal",
    "productCount",
    "productId",
    "productName"
})
public class OrderedProduct {

    protected float price;
    protected float priceTotal;
    protected int productCount;
    protected int productId;
    protected String productName;

    /**
     * Gets the value of the price property.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

    /**
     * Gets the value of the priceTotal property.
     * 
     */
    public float getPriceTotal() {
        return priceTotal;
    }

    /**
     * Sets the value of the priceTotal property.
     * 
     */
    public void setPriceTotal(float value) {
        this.priceTotal = value;
    }

    /**
     * Gets the value of the productCount property.
     * 
     */
    public int getProductCount() {
        return productCount;
    }

    /**
     * Sets the value of the productCount property.
     * 
     */
    public void setProductCount(int value) {
        this.productCount = value;
    }

    /**
     * Gets the value of the productId property.
     * 
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     * 
     */
    public void setProductId(int value) {
        this.productId = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

}
