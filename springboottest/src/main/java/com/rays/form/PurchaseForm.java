package com.rays.form;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PurchaseDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidDouble;
import com.rays.validation.ValidLong;



public class PurchaseForm extends BaseForm {
	
	

	 @NotNull(message = "Please enter last orderDate ")
		@ValidDate(message = "Invalid date orderDate value")
		private String orderDate;

    
	    
    
    @NotEmpty(message = "Please enter product")
	private String product;
	
    
   
	@NotEmpty(message = "Please enter totalQuantity")
	@ValidLong(message = "Invalid input for totalQuantity", allowEmpty = true)
	private String totalQuantity;

	

    
    @NotNull(message = "Please enter totalCost ")
	@ValidDouble(message = "Invalid value for cash totalCost its contain points value")
	private String totalCost;
    
    
    
    
   
  
   
	public String getOrderDate() {
		return orderDate;
	}







	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}







	public String getProduct() {
		return product;
	}







	public void setProduct(String product) {
		this.product = product;
	}







	public String getTotalQuantity() {
		return totalQuantity;
	}







	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}







	public String getTotalCost() {
		return totalCost;
	}







	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}







	@Override
    public BaseDTO getDto() {
        PurchaseDTO dto = initDTO(new PurchaseDTO());
        if (orderDate != null && !orderDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(orderDate);
				dto.setOrderDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}


        dto.setProduct(product);
        if (totalQuantity != null && !totalQuantity.isEmpty()) {
			dto.setTotalQuantity(Long.valueOf(totalQuantity));
		}
        if (totalCost != null && !totalCost.isEmpty()) {
			dto.setTotalCost(Double.parseDouble(totalCost));
		}

       



        return dto;
    }
}
