package com.colby.servlets;

import com.colby.controllers.FrontController;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontControllerServlet extends DefaultServlet {

    private RequestHandler rh = new RequestHandler();
    private Logger log = LogManager.getLogger(FrontControllerServlet.class);
    // This method is where we will funnel all of our requests
    // This way - we have one central location, and can pass them off to some handler/controller
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriNoContext = request.getRequestURI().substring(request.getContextPath().length());
        log.trace(uriNoContext);

        // We want to 'get' the correct servlet based on the uri
        System.out.println("Getting the appropriate controller...");


        // check first to make sure it's not null       del static
        if (uriNoContext.startsWith("/static")) {
            log.trace("Accessing resources and trying to forward....");
            super.doGet(request, response);
        } else {
            // We want to 'get' the correct servlet based on the uri
            log.trace("Not static...Getting the appropriate controller...");
            FrontController fc = rh.handle(request, response);

            // check first to make sure it's not null
            if (fc != null) {
                log.trace("Processing request...");
                fc.process(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
}
