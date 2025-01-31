package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PoojaDAOInt;
import com.rays.dto.PoojaDTO;

@Service
@Transactional
public class PoojaServiceImpl extends BaseServiceImpl<PoojaDTO, PoojaDAOInt> implements PoojaServiceInt {
    
}
