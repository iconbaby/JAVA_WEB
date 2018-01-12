package com.slkk;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setHeader("content-type", "text/html;charset=UTF-8");
//        OutputStream outputStream = response.getOutputStream();
//        outputStream.write("中国".getBytes("UTF-8"));
//        response.setCharacterEncoding("utf-8");
//        response.getWriter().println("中国");
        response.getWriter().println(1);

    }
}
