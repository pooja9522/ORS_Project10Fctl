package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.PoojaDTO;

@Repository
public class PoojaDAOImpl extends BaseDAOImpl<PoojaDTO> implements PoojaDAOInt {

    @Override
    protected List<Predicate> getWhereClause(PoojaDTO dto, CriteriaBuilder builder, Root<PoojaDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }
        
        if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

        if (dto.getRegistrationNumber() != null && !dto.getRegistrationNumber().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("registrationNumber"), dto.getRegistrationNumber() + "%"));
        }

        if (dto.getBirthDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("birthDate"), dto.getBirthDate()));
        }
        
        if (!isEmptyString(dto.getDescription())) {

			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}
        
        if (!isZeroNumber(dto.getQuantity())) {
			whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()));
		}

        if (!isZeroNumber(dto.getCashAvailable())) {
			whereCondition.add(builder.equal(qRoot.get("cashAvailable"), dto.getCashAvailable()));
		}

        if (dto.getItemvalue() != null) {
            whereCondition.add(builder.equal(qRoot.get("itemvalue"), dto.getItemvalue()));
        }
        if (!isEmptyString(dto.getPhone())) {
			whereCondition.add(builder.like(qRoot.get("phone"), dto.getPhone()+ "%"));
		}



        if (dto.getSpecialization() != null && !dto.getSpecialization().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("specialization"), dto.getSpecialization()));
        }

        return whereCondition;
    }

    @Override
    public Class<PoojaDTO> getDTOClass() {
        return PoojaDTO.class;
    }
}
