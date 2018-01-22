package com.testflipkart.flipkartBeanClasses;

public class ProductInfoBean {
	
	public String productName;
	public String productPrice;
	public String productRating;
	public String productRatingsCount;
	public String productsOutOfStock;
	
	public String getProductsOutOfStock() {
		return productsOutOfStock;
	}
	public void setProductsOutOfStock(String productsOutOfStock) {
		this.productsOutOfStock = productsOutOfStock;
	}
	public String getProductRating() {
		return productRating;
	}
	public void setProductRating(String productRating) {
		this.productRating = productRating;
	}
	public String getProductRatingsCount() {
		return productRatingsCount;
	}
	public void setProductRatingsCount(String productRatingsCount) {
		this.productRatingsCount = productRatingsCount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
}
