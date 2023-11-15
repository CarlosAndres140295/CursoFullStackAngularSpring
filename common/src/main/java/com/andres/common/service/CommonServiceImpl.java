package com.andres.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public class CommonServiceImpl<E, R extends JpaRepository<E, Long>> implements ICommonService<E> {

    @Autowired
    public R repository;

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
