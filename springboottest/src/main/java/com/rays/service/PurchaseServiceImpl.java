package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PurchaseDAOInt;
import com.rays.dto.PurchaseDTO;

@Service
@Transactional
public class PurchaseServiceImpl extends BaseServiceImpl<PurchaseDTO, PurchaseDAOInt> implements PurchaseServiceInt {
    
}
