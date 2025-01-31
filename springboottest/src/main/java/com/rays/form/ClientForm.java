package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Digits;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;

import com.rays.dto.ClientDTO;

public class ClientForm extends BaseForm {

    @NotEmpty(message = "Please enter Client FullName")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "Name can only contain alphabets and spaces")
    private String fullName;

    @PastOrPresent(message = "appointment date must be today or in the past")
    @NotNull(message = "Please enter appointment date")
    private Date appointmentDate;

    @NotNull(message = "Please enter phoneNo")
    @Pattern(regexp="(^$|[0-9]{10})")
	private String phone;
    
    @NotEmpty(message = "Please select a Illness")
    private String illness;

 
    public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Date getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getIllness() {
		return illness;
	}


	public void setIllness(String illness) {
		this.illness = illness;
	}


	@Override
    public BaseDTO getDto() {
		ClientDTO dto = initDTO(new ClientDTO());
        dto.setFullName(fullName);
        dto.setAppointmentDate(appointmentDate);
        dto.setPhone(phone);
        dto.setIllness(illness);
        return dto;
    }
}
