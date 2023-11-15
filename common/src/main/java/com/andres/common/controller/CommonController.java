package com.andres.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andres.common.service.ICommonService;

import java.util.Optional;


public class CommonController<E, S extends ICommonService<E>> {

	@Autowired
    public S service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<E> data = service.findById(id);

        if (data.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(data.get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody E entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<?> save(@PathVariable Long id){
    	Optional<E> data = service.findById(id);

        if (data.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
