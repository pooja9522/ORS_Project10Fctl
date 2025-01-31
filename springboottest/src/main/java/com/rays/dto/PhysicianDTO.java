package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_physician")
public class PhysicianDTO extends BaseDTO {
	
	@Column(name = "FULLNAME", length = 100)
    private String fullName;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "PHONE", length = 10)
	private String phone;

    @Column(name = "SPECIALIZATION", length = 50)
    private String specialization;


   	
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
    public String getLabel() {
        return "Physician";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("fullName", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        return map;
    }
}
