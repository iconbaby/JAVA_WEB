package com.slkk;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class BufferImageDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("refresh", "5");
        //1.在内存中创建一张图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_BGR);
        //2.得到图片
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.WHITE);//设置图片背景色
        g.fillRect(0, 0, 80, 20);//设置背景色
        //3.向图片写数据
        g.setColor(Color.BLUE);//设置图片上的字体的颜色
        g.setFont(new Font(null, Font.BOLD, 20));
        g.drawString(makeNum(), 0, 20);
        //4.设置响应头控制浏览器以图片的方式打开
        response.setContentType("image/jpeg");
        //5.设置浏览器不缓存图片数据
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //6.将图片写给浏览器
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    private String makeNum() {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        System.out.println(num);
        StringBuffer stringBuffer = new StringBuffer();
        //随机数为7位，不够补零
        for (int i = 0; i < 7 - num.length(); i++) {
            stringBuffer.append("0");
        }
        num = stringBuffer.toString() + num;

        return num;
    }
}
