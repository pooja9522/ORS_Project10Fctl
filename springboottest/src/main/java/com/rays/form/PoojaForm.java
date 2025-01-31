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
import com.rays.dto.PoojaDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidDouble;
import com.rays.validation.ValidLong;



public class PoojaForm extends BaseForm {
	
	 @Pattern(regexp = "^[A-Za-z\\s]*$", message = "Name can only contain alphabets ")
		@NotEmpty(message = "Please enter name")
		private String name;


	 @NotNull(message = "Please enter last birth Date")
		@ValidDate(message = "Invalid date birthDate value")
		private String birthDate;

    
	 @NotNull(message = "Please enter phoneNo")
	    @Pattern(regexp="(^$|[0-9]{10})" , message = "invalid phoneNo")
		private String phone;
	    
    
    @NotEmpty(message = "Please enter specialization")
	private String specialization;
	
    
    @NotEmpty(message = "please enter description")
    @Size(max = 100, message = "Overview must not exceed 100 characters")
	private String description;

	@NotEmpty(message = "Please enter quantity")
	@ValidLong(message = "Invalid input for quantity", allowEmpty = true)
	private String quantity;

	

    
    @NotNull(message = "Please enter cash Available")
	@ValidDouble(message = "Invalid value for cash Available its contain points value")
	private String cashAvailable;
    
    
    
    @NotNull(message = "Please enter coverage amount")
    @Min(value = 1, message = "Coverage amount should be more than 1")
    @Max(value = 999999, message = "Coverage amount should have only 6 digits")
    private Integer itemvalue;

    
    
    @NotEmpty(message = "Please enter the registration number")
    private String registrationNumber;


   
  
   
    public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getBirthDate() {
		return birthDate;
	}





	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}





	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}






	public String getSpecialization() {
		return specialization;
	}





	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}





	public String getCashAvailable() {
		return cashAvailable;
	}

	public void setCashAvailable(String cashAvailable) {
		this.cashAvailable = cashAvailable;
	}





	public Integer getItemvalue() {
		return itemvalue;
	}





	public void setItemvalue(Integer itemvalue) {
		this.itemvalue = itemvalue;
	}





	public String getRegistrationNumber() {
		return registrationNumber;
	}





	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}





	@Override
    public BaseDTO getDto() {
        PoojaDTO dto = initDTO(new PoojaDTO());
        dto.setName(name);
        if (birthDate != null && !birthDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(birthDate);
				dto.setBirthDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}

        dto.setPhone(phone);

        dto.setSpecialization(specialization);
        dto.setDescription(description);
        if (quantity != null && !quantity.isEmpty()) {
			dto.setQuantity(Long.valueOf(quantity));
		}
        if (cashAvailable != null && !cashAvailable.isEmpty()) {
			dto.setCashAvailable(Double.parseDouble(cashAvailable));
		}

        dto.setItemvalue(itemvalue);

        dto.setRegistrationNumber(registrationNumber);




        return dto;
    }
}
