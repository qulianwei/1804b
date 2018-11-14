package com.jk.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.power.mapper.PowerMapper;
import com.jk.power.service.IPowerService;

@Service
public class PowerServiceImpl implements IPowerService {
	
	@Autowired
	private PowerMapper powerMapper;
	
	

}
