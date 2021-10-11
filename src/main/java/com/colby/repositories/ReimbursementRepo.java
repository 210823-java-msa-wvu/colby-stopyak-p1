package com.colby.repositories;

import com.colby.models.Reimbursement;
import com.colby.models.User;

import java.util.List;

public interface ReimbursementRepo extends CrudRepository<Reimbursement> {

    Reimbursement add(Reimbursement r);


    Reimbursement getById(Integer id);


    List<Reimbursement> getAll();

    List<Reimbursement> getByEmpId(Integer id);


    void update(Reimbursement r);


    void delete(Integer id);

    Reimbursement updateByEmpId(Reimbursement r);
}
