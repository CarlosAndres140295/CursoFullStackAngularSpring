package com.andres.service;

import org.springframework.stereotype.Service;

import com.andres.common.service.CommonServiceImpl;
import com.andres.model.Course;
import com.andres.repository.ICourseRepository;

@Service
public class CourseServiceImpl extends CommonServiceImpl<Course, ICourseRepository> implements ICourseService{

}
