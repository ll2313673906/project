package net.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "VerifyCodeServlet" ,urlPatterns = "/code")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 30;

        //随机生成字符串
        //生成字符串集
        String data = "abcdefghightklmn345656713";
        Random random = new Random();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.gray);
        graphics.fillRect(0, 0, width, height);

        //在验证码上绘制文字
        graphics.setColor(Color.white);
        for (int i = 0; i <= 4; i++) {
            int position = random.nextInt(data.length());
            String randomStr = data.substring(position, position + 1);
            graphics.drawString(randomStr, width / 5 * (i + 1), 15);

        }
            ImageIO.write(image, "jpg", response.getOutputStream());

        }
}
