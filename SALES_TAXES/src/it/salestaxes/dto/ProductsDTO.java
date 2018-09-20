package it.salestaxes.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author m.sbrozzi
 *
 * ProductsDTO class
 * 
 * 20180919: class creation
 */
@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsDTO {

	// Fields
	@XmlElement(name="product")
	List<ProductDTO> products;

	// Constructors
	public ProductsDTO() {
		super();
	}
	public ProductsDTO(List<ProductDTO> products) {
		super();
		this.products = products;
	}

	// Setters, getters and xml tags
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
	// Override toString method
	@Override
	public String toString() {
		// Init return string
		StringBuffer sb = new StringBuffer("products{");
		for (ProductDTO p : products) {
			// Serialize each product
			if (p != null) {
				sb.append(p.toString());
			}
		}
		// Close and return string
		sb.append("}");
		return sb.toString();
	}
	
}
