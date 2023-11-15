package com.andres.microserviceusuarios.service;

import org.springframework.stereotype.Service;

import com.andres.common.service.CommonServiceImpl;
import com.andres.microserviceusuarios.model.Student;
import com.andres.microserviceusuarios.repository.IStudentRepository;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, IStudentRepository> implements IStudentService{
	
}
