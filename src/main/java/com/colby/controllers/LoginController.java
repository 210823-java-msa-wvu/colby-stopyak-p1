package com.colby.controllers;

import com.colby.models.User;
import com.colby.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController implements FrontController {
    private Logger log = LogManager.getLogger(LoginController.class);
    private UserService userService = new UserService();
    HttpSession session = null;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("working?");


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Username: " + username + " Password: " + password);

        if (userService.login(username, password)) {
            session = request.getSession();
            session.setAttribute("username", username);
            User u = userService.getByUsername(username);
            session.setAttribute("emp_id", u.getEmp_id());
//            session.setAttribute("emp_id", emp_id);
            //functionality for supervisor and benco
            if(userService.admin(username) == false){
                response.sendRedirect("static/home.html");
            }

            else if(userService.admin(username) == true){
                response.sendRedirect("static/admin.html");
            }
            System.out.println("welcome user!");
        } else {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid login credentials");
            response.sendRedirect(("static/failed.html"));
        }


    }
}
