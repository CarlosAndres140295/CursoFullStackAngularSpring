package com.andres.microserviceusuarios.controller;

import com.andres.microserviceusuarios.model.Student;
import com.andres.microserviceusuarios.service.IStudentService;
import com.andres.common.controller.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController extends CommonController<Student, IStudentService>{

   
    @PutMapping("/{id}")
    public ResponseEntity<?> save(@RequestBody Student student, @PathVariable Long id){
        Optional<Student> data = service.findById(id);

        if (data.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        data.get().setFirstName(student.getFirstName());
        data.get().setLastName(student.getLastName());
        data.get().setEmail(student.getEmail());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(data.get()));
    }

 
}
