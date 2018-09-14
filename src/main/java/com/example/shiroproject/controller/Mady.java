package com.example.shiroproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@CrossOrigin
@RestController
public class Mady extends HttpServlet {
    public static final int WIDTH = 120;
    public static final int HIGHT = 35;
    @RequestMapping("/pic")
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedImage image = new BufferedImage(WIDTH, HIGHT, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        setBackGround(g);
        setBorder(g);
        drawRandomLine(g);
        drawRandomNum((Graphics2D) g);
        response.setContentType("image/jpeg");
        response.setDateHeader("expires",-1 );
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma","no-cache");
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
    private void drawRandomNum(Graphics2D g) {
        g.setColor(Color.RED);
        g.setFont(new Font("宋体",Font.BOLD,20));
        String base = "\u0031\u0032\u0033\u0034\u0035\u0036\u0037\u0038\u0039\u0030";
        int x = 10;
        for(int i=0;i<4;i++){
            int degree = new Random().nextInt()%30;
            String ch = base.charAt(new Random().nextInt(base.length()))+"";
            g.rotate(degree*Math.PI/180,x,20);//设置旋转的弧度
            g.drawString(ch, x, 20);
            g.rotate(-degree*Math.PI/180,x,20);
            x+=30;
        }
    }
    private void setBorder(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(1, 1, WIDTH-2, HIGHT-2);

    }
    private void drawRandomLine(Graphics g) {
        g.setColor(Color.GRAY);
        for(int i=0;i<5;i++){
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HIGHT);
            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HIGHT);
            g.drawLine(x1, y1, x2, y2);
        }
    }
    private void setBackGround(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HIGHT);

    }
}


