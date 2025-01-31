package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ClientDTO;

@Repository
public class ClientDAOImpl extends BaseDAOImpl<ClientDTO> implements ClientDAOInt {

    @Override
    protected List<Predicate> getWhereClause(ClientDTO dto, CriteriaBuilder builder, Root<ClientDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

    	if (!isEmptyString(dto.getFullName())) {

			whereCondition.add(builder.like(qRoot.get("fullName"), dto.getFullName() + "%"));
		}


        if (dto.getAppointmentDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("appointmentDate"), dto.getAppointmentDate()));
        }

        if (!isEmptyString(dto.getPhone())) {
			whereCondition.add(builder.like(qRoot.get("phone"), dto.getPhone()+ "%"));
		}

        if (dto.getIllness() != null && !dto.getIllness().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("illness"), dto.getIllness()));
        }

        return whereCondition;
    }

    @Override
    public Class<ClientDTO> getDTOClass() {
        return ClientDTO.class;
    }
}
