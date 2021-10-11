package com.colby.controllers;

import com.colby.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserController implements  FrontController {

    private UserService userServ = new UserService();
    private ObjectMapper om = new ObjectMapper();


    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("hitting user controller");
//        response.getWriter().write(om.writeValueAsString(userServ.getAllUsers()));
        HttpSession session = request.getSession();
        if(session != null && session.getAttribute("username") != null){
            String username = (String) session.getAttribute("username");
            System.out.println(userServ.getByUsername(username));
            response.getWriter().write(om.writeValueAsString(userServ.getByUsername(username)));
//
        } else {
            assert false;
            session.invalidate();
            response.sendRedirect("static/index.html");
        }

//         Getting the attribute we set in the RequestHandler's handle() method
//        String path = (String) request.getAttribute("path");
//        System.out.println("Path attribute: " + path);
//
//        if (path == null || path.equals("")) {
//
//            switch (request.getMethod()) {
//
//                case "GET": {
//                    System.out.println("Getting all users from the database...");
//                    response.getWriter().write(om.writeValueAsString(userServ.getAllUsers()));
//                    break;
//                }
//
//                case "POST": {
//                    // then we would add the user (read from the request body) to the database
//                    User u = om.readValue(request.getReader(), User.class);
//                    userServ.addUser(u);
//                    break;
//                }
//
//            }
//
//
//        } else {
//            // Else -> there IS a path attribute that we need to use in our logic
//
//            // save that attribute into an integer
//            int emp_id = Integer.parseInt(path);
//            User u = null;
//
//            switch (request.getMethod()) {
//                // /users/1
//                case "GET": {
//                    u = userServ.searchUserById(userServ.searchUserById(u));
//                    if (u != null) {
//                        response.getWriter().write(om.writeValueAsString(u));
//                    } else {
//                        response.sendError(404, "user not found");
//                    }
//                    break;
//                }
//
//                case "PUT": {
//                    u = om.readValue(request.getReader(), User.class);
//                   userServ.updateUser(u);
//                    break;
//                }
//                case "DELETE": {
//                    userServ.deleteUser(u);
//                    break;
//                }
//
//                default: {
//                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
//                    break;
//                }
//
//            }
//        }


    }
}
