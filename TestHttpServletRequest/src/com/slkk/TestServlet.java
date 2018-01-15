package com.slkk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().println("heelo");
        response.setCharacterEncoding("utf-8");


        String requestURL = request.getRequestURL().toString();
        String remoteAddr = request.getRemoteAddr();
        PrintWriter writer = response.getWriter();
        writer.println(requestURL);
        writer.println(remoteAddr);
        writer.println("中文");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            writer.println("key: " + key + " value: " + value);

        }
    }
}
