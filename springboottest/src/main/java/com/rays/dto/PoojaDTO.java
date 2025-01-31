package com.rays.dto;

import java.util.Date;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_pooja")
public class PoojaDTO extends BaseDTO {
	
	@Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "PHONE", length = 10)
	private String phone;

    @Column(name = "SPECIALIZATION", length = 50)
    private String specialization;

    @Column(name = "DESCRIPTION", length = 100)
	private String description = null;
    
    @Column(name = "QUANTITY")
	private Long quantity;

    @Column(name = "CASH_AVAILABLE")
	private double cashAvailable;

    @Column(name = "ITEMVALUE")
    private Integer itemvalue;
    
    @Column(name = "REGISTRATION_NUMBER", length = 100)
    private String registrationNumber;

    
    



		public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public double getCashAvailable() {
		return cashAvailable;
	}

	public void setCashAvailable(double cashAvailable) {
		this.cashAvailable = cashAvailable;
	}
	

    public Integer getItemvalue() {
		return itemvalue;
	}

	public void setItemvalue(Integer itemvalue) {
		this.itemvalue = itemvalue;
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
        return "Pooja";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        return map;
    }
}
