package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HealthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        // Setting the response content type
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        
        // Writing the health status message
        resp.getWriter().write("SkillBarter Backend is UP and Running");
        
        // Explicitly setting status code (200 is default, but good for clarity)
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}