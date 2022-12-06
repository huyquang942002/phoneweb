package me.thlshop.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class ProductEntity {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@Column(name = "product_name")
	private String productName;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private CategoryEntity categoryId;



	@ManyToOne
	@JoinColumn(name = "image_id")
	@JsonIgnore
	private ImageEntity imageId;


	@ManyToOne
	@JoinColumn(name = "info_id")
	@JsonIgnore
	private InformationEntity infoId;
	
	@OneToMany(mappedBy = "productId", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<OrderDetailEntity> orderId;

	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private Long price;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public CategoryEntity getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryEntity categoryId) {
		this.categoryId = categoryId;
	}




	public ImageEntity getImageId() {
		return imageId;
	}

	public void setImageId(ImageEntity imageId) {
		this.imageId = imageId;
	}

	public InformationEntity getInfoId() {
		return infoId;
	}

	public void setInfoId(InformationEntity infoId) {
		this.infoId = infoId;
	}

	public Set<OrderDetailEntity> getOrderId() {
		return orderId;
	}

	public void setOrderId(Set<OrderDetailEntity> orderId) {
		this.orderId = orderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductEntity{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", categoryId=" + categoryId +
				", imageId=" + imageId +
				", infoId=" + infoId +
				", orderId=" + orderId +
				", description='" + description + '\'' +
				", price=" + price +
				'}';
	}
}
