package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Digits;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;

import com.rays.dto.PhysicianDTO;

public class PhysicianForm extends BaseForm {

    @NotEmpty(message = "Please enter Physician FullName")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "FullName can only contain alphabets and spaces")
    private String fullName;

    @PastOrPresent(message = "BirthDate  must be today or in the past")
    @NotNull(message = "Please enter birth date")
    private Date birthDate;

    @NotNull(message = "Please enter Phone")
    @Pattern(regexp="(^$|[0-9]{10})", message = "phoneNo contain 10 digits only")
	private String phone;
    
    @NotEmpty(message = "Please select a specialization")
    private String specialization;

 
   	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
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


	@Override
    public BaseDTO getDto() {
		PhysicianDTO dto = initDTO(new PhysicianDTO());
        dto.setFullName(fullName);
        dto.setBirthDate(birthDate);
        dto.setPhone(phone);
        dto.setSpecialization(specialization);
        return dto;
    }
}
