package it.salestaxes.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author m.sbrozzi
 *
 * ProductDTO class
 * 
 * 20180919: class creation
 */
@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDTO {

	// Attributes
	@XmlAttribute(name="basicTaxes")
	Boolean basicTaxes;
	@XmlAttribute(name="importTaxes")
	Boolean importTaxes;
	
	// Fields
	@XmlElement(name="name")
	String name;
	@XmlElement(name="quantity")
	Integer quantity;
	@XmlElement(name="price")
	Double price;
	
	// Constructors
	public ProductDTO() {
		super();
	}
	public ProductDTO(Boolean basicTaxes, Boolean importTaxes, String name, Integer quantity, Double price) {
		super();
		this.basicTaxes = basicTaxes;
		this.importTaxes = importTaxes;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	// Attributes - Setters, getters and xml tags
	public Boolean getBasicTaxes() {
		return basicTaxes;
	}
	public void setBasicTaxes(Boolean basicTaxes) {
		this.basicTaxes = basicTaxes;
	}
	public Boolean getImportTaxes() {
		return importTaxes;
	}
	public void setImportTaxes(Boolean importTaxes) {
		this.importTaxes = importTaxes;
	}
	
	// Fields - Setters, getters and xml tags
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	// Override toString method
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("product{");
		sb.append("basicTaxes:"  + basicTaxes  + ", ");
		sb.append("importTaxes:" + importTaxes + ", ");
		sb.append("name:"        + name        + ", ");
		sb.append("quantity:"    + quantity    + ", ");
		sb.append("price:"       + price             );
		sb.append("}");
		return sb.toString();
	}
	
}
