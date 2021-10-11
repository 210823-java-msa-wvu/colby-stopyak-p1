package com.colby.services;

import com.colby.models.Reimbursement;
import com.colby.repositories.JDBC.ReimbursementJDBC;
import com.colby.repositories.ReimbursementRepo;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementService {
//    ReimbursementRepo rmRepo = new ReimbursementJDBC();
    ReimbursementRepo rmRepo = new ReimbursementJDBC();

    public Reimbursement getReimbursementById(Integer id) {return rmRepo.getById(id);}

    public List <Reimbursement> getByEmpId(Integer id){ return rmRepo.getByEmpId(id);}

    public List <Reimbursement> getAll() {
        return rmRepo.getAll();
    }

    public List<Reimbursement> getAllEmp(int emp_id){
        List<Reimbursement> request = rmRepo.getAll();
        List<Reimbursement> res = new ArrayList<Reimbursement>();
        for(Reimbursement r : request){
            if(r.getUser().getEmp_id() == emp_id){
                res.add(r);
            }
        }
        return res;
    }

    public Reimbursement add (Reimbursement r) {
        // made switch case for property in rm in services
        return rmRepo.add(r);
    }

    public void updateReimbursement(Reimbursement r) {
        if (rmRepo.getById(r.getRm_id()) != null){
            rmRepo.update(r);
        } else {
            System.out.println("Error reimbursement does not exist...");
        }
    }


    public void updateByEmpId(Reimbursement r){
        rmRepo.updateByEmpId(r);
    }

    public void deleteReimbursement(Integer id) {
        if (rmRepo.getById(id) != null)
            rmRepo.delete(id);
        else
            System.out.println("Error doesn't exist");
    }

    public void update(Reimbursement r){ rmRepo.update(r); }


}
