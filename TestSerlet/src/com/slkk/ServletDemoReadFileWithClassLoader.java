package com.slkk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * 用类装载器读取资源文件
 * 通过类装载器读取资源文件的注意事项:不适合装载大文件，否则会导致jvm内存溢出
 *
 * @author gacl
 */
public class ServletDemoReadFileWithClassLoader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("test/html;charset=UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        test1(response);
//        response.getWriter().println("<hr/>");
//        test2(response);
//        response.getWriter().println("<hr/>");
        test4();
    }

    private void test4()throws  IOException {
        InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/test.mp4");
        byte[] buffer = new byte[1024];
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\TEST.mp4");
        int a;
        while ((a= inputStream.read(buffer)) != 0) {
            fileOutputStream.write(buffer,0,a);
        }
    }

    private void test2(HttpServletResponse response) {

    }

    private void test1(HttpServletResponse response) throws IOException{
        //获取当前类的类装载器
        ClassLoader classLoader = ServletDemoReadFileWithClassLoader.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("/db1.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        response.getWriter().println("读取src目录下的db1.properties");
        response.getWriter().println(
                MessageFormat.format("drvier={0},url={1},username={2},password={3}", driver, url, username, password));
    }
}
