package com.rays.service;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;

import com.rays.dao.PhysicianDAOInt;
import com.rays.dto.PhysicianDTO;

@Service
@Transactional
public class PhysicianServiceImpl extends BaseServiceImpl<PhysicianDTO, PhysicianDAOInt> implements PhysicianServiceInt {
    
}
