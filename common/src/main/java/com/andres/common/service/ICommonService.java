package com.andres.common.service;

import java.util.List;
import java.util.Optional;

public interface ICommonService<E> {

    public List<E> findAll();

    public Optional<E> findById(Long id);

    public E save(E entity);

    void deleteById(Long id);
}
