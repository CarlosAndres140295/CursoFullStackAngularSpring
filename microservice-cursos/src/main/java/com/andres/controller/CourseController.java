package com.andres.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.common.controller.CommonController;
import com.andres.model.Course;
import com.andres.service.ICourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController extends CommonController<Course, ICourseService>{

	
	@PutMapping("/{id}")
    public ResponseEntity<?> save(@RequestBody Course course, @PathVariable Long id){
        Optional<Course> data = service.findById(id);

        if (data.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        data.get().setName(course.getName());
        data.get().setActive(course.getActive());
            
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(data.get()));
    }
}
