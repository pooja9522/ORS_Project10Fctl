package com.rays.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.PhysicianDTO;

@Repository
public class PhysicianDAOImpl extends BaseDAOImpl<PhysicianDTO> implements PhysicianDAOInt {

    @Override
    protected List<Predicate> getWhereClause(PhysicianDTO dto, CriteriaBuilder builder, Root<PhysicianDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

    	if (!isEmptyString(dto.getFullName())) {

			whereCondition.add(builder.like(qRoot.get("fullName"), dto.getFullName() + "%"));
		}


        if (dto.getBirthDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("birthDate"), dto.getBirthDate()));
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
    public Class<PhysicianDTO> getDTOClass() {
        return PhysicianDTO.class;
    }
}

