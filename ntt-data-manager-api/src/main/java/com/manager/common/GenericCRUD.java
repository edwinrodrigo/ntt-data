package com.manager.common;

import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import com.manager.exception.CustomErrorResponse;

public interface GenericCRUD<T, ID> {

    T save(T t) throws CustomErrorResponse;
    T update(ID id, T t) throws CustomErrorResponse;
    List<T> findAll() throws CustomErrorResponse;
    T findById(ID id) throws ResponseStatusException;
    void delete(ID id) throws CustomErrorResponse;
}
