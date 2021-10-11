package com.colby.controllers;

import com.colby.models.Reimbursement;
import com.colby.services.ReimbursementService;
import com.colby.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReimbursementController implements FrontController{

    private ReimbursementService rServ = new ReimbursementService();
    private ObjectMapper om = new ObjectMapper();
    private UserService uServ = new UserService();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String path = (String) request.getAttribute("path");
        System.out.println("path att" + path);
        String username = request.getParameter("username");

        Integer emp_id = (Integer) request.getSession().getAttribute("emp_id");
        if(path == null || path.equals("")){
            switch ( request.getMethod()){
                case "GET": {
                    System.out.println("gettting all ");
//                    System.out.println("emp_id" + emp_id);
//                    response.getWriter().write(om.writeValueAsString(rServ.getByEmpId(emp_id)));
                    response.getWriter().write(om.writeValueAsString(rServ.getAll()));
                    break;
                }
                case "POST": {
                    System.out.println("post request");
                    //adding to db for rm
                    Reimbursement r = om.readValue(request.getReader(), Reimbursement.class);
                    //add get paramater
                    rServ.add(r);
                    System.out.println(r);
                    break;
                }



                }
            }
            else {
            int rm_id = Integer.parseInt(path);
//            Reimbursement riem = null;
            switch(request.getMethod()){
                case "GET":{
                    System.out.println("getting by rm id");
                    response.getWriter().write(om.writeValueAsString(rServ.getReimbursementById(rm_id)));
                    break;
                }
                case "PUT":{
                    System.out.println("updating put");
                    Reimbursement r= om.readValue(request.getReader(), Reimbursement.class);
                    rServ.update(r);
                    System.out.println(r);
                    break;
                }

            }
        }
    }
}
