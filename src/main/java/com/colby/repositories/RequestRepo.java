package com.colby.repositories;

import com.colby.models.Request;
import com.colby.models.User;

import java.util.List;

public interface RequestRepo extends CrudRepository<Request> {

    @Override
    Request add(Request request);

    @Override
    Request getById(Integer id);

    @Override
    List<Request> getAll();

    @Override
    void update(Request request);

    @Override
    void delete(Integer id);
}
