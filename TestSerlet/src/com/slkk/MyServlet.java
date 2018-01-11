package com.slkk;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class MyServlet extends HttpServlet {
    private ServletConfig mConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {

        this.mConfig = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the post method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//        out.println("<HTML>");
//        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//        out.println("  <BODY>");
//        out.print("    This is ");
//        out.print(this.getClass());
//        out.println(", using the get method");
//        out.println("  </BODY>");
//        out.println("</HTML>");
//        out.flush();
//        out.close();
//        String name = mConfig.getInitParameter("name");
//        response.getWriter().println(name);

        Enumeration<String> initParameterNames = mConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {

            String key = initParameterNames.nextElement();
            String value = mConfig.getInitParameter(key);

            response.getWriter().println(value);

        }

    }
}
