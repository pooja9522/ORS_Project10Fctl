package com.rays.dto;

import java.util.Date;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_purchase")
public class PurchaseDTO extends BaseDTO {
	
	
    @Column(name = "ORDER_DATE")
    private Date orderDate;

   
    @Column(name = "PRODUCT", length = 50)
    private String product;

   
    @Column(name = "TOTAL_QUANTITY")
	private Long totalQuantity;

    @Column(name = "TOTAL_COST")
	private double totalCost;

   
    
    



	
		public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

		@Override
    public String getValue() {
        return id + "";
    }

    @Override
    public String getUniqueKey() {
        return "id";
    }

	@Override
    public String getUniqueValue() {
        return id + "";
    }

    @Override
    public String getLabel() {
        return "Purchase";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("product", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        return map;
    }
}
