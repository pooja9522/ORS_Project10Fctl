package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.PurchaseDTO;

@Repository
public class PurchaseDAOImpl extends BaseDAOImpl<PurchaseDTO> implements PurchaseDAOInt {

    @Override
    protected List<Predicate> getWhereClause(PurchaseDTO dto, CriteriaBuilder builder, Root<PurchaseDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }
        
       
       
        if (dto.getOrderDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("orderDate"), dto.getOrderDate()));
        }
        
                
        if (!isZeroNumber(dto.getTotalQuantity())) {
			whereCondition.add(builder.equal(qRoot.get("totalQuantity"), dto.getTotalQuantity()));
		}

        if (!isZeroNumber(dto.getTotalCost())) {
			whereCondition.add(builder.equal(qRoot.get("totalCost"), dto.getTotalCost()));
		}

        


        if (dto.getProduct() != null && !dto.getProduct().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("product"), dto.getProduct()));
        }

        return whereCondition;
    }

    @Override
    public Class<PurchaseDTO> getDTOClass() {
        return PurchaseDTO.class;
    }
}
