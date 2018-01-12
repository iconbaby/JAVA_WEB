package com.slkk;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class ResponseToDownloadFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        downloadFileWithOutputStream(response);
        downloadeChineseNameFile(response);
    }

    private void downloadFileWithOutputStream(HttpServletResponse response) throws IOException {
        InputStream inputstream = getServletContext().getResourceAsStream("/WEB-INF/test.mp4");

        response.setHeader("content-disposition", "attachment;filename=" + "test.mp4");
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputstream.read(buffer)) != 0) {
            outputStream.write(buffer, 0, len);
        }
        inputstream.close();
        outputStream.flush();
        outputStream.close();
    }

    private void downloadeChineseNameFile(HttpServletResponse response) {
        String filePath = this.getServletContext().getRealPath("/WEB-INF/挪威一号公路.jpg");
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
        try {
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
            InputStream fileInputStream = new FileInputStream(filePath);
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            fileInputStream.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
