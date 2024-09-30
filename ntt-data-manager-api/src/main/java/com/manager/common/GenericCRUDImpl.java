package com.manager.common;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.manager.exception.CustomErrorResponse;



public abstract class GenericCRUDImpl<T, ID> implements GenericCRUD<T, ID> {

    protected abstract GenericRepository<T, ID> getRepository();

    @Override
    public T save(T t) throws CustomErrorResponse {
        return getRepository().save(t);
    }

    @Override
    public T update(ID id, T t) throws CustomErrorResponse {
    	getRepository().findById(id).orElseThrow(() -> new CustomErrorResponse(
                String.format("ID  %s NOT FOUND " , id)));
        return getRepository().save(t);
    }

    @Override
    public List<T> findAll() throws CustomErrorResponse {
        return Optional.of(getRepository().findAll()).orElseThrow(() -> new CustomErrorResponse("NO DATA FOUND"));
    }

    @Override
    public T findById(ID id) throws ResponseStatusException {
        return getRepository().findById(id).orElseThrow(()-> new ResponseStatusException(
        		  HttpStatus.NOT_FOUND, "entity not found"
        		));
    }

    @Override
    public void delete(ID id) throws CustomErrorResponse {
    	getRepository().findById(id).orElseThrow(() -> new CustomErrorResponse(
                String.format("ID  %s NOT FOUND " , id)));
    	getRepository().deleteById(id);
    }
}
