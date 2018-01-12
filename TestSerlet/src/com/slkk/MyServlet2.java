package com.slkk;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class MyServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("frome myservlet 2");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        readSrcDirPropCfgFile(response);
        readWebRootDirPropCfgFile(response);
        readPropCfgFile(response);
    }

    private void readSrcDirPropCfgFile(HttpServletResponse response) throws IOException {

        InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db1.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        response.getWriter().println("读取src目录下的db1.properties");
        response.getWriter().println(
                MessageFormat.format("drvier={0},url={1},username={2},password={3}", driver, url, username, password)
        );
    }

    private void readWebRootDirPropCfgFile(HttpServletResponse response) throws IOException {
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("/db2.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        response.getWriter().println("读取src目录下的db2.properties");
        response.getWriter().println(
                MessageFormat.format("drvier={0},url={1},username={2},password={3}", driver, url, username, password)
        );
    }

    private void readPropCfgFile(HttpServletResponse response) throws IOException {
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/com/slkk/config/db3.properties");
        InputStream is = new FileInputStream(realPath);
        Properties properties = new Properties();
        properties.load(is);
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        response.getWriter().println("读取root目录下的db3.properties");
        response.getWriter().println(
                MessageFormat.format("drvier={0},url={1},username={2},password={3}", driver, url, username, password)
        );
    }
}
