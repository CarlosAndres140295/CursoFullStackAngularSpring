package com.andres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Long>{

}
