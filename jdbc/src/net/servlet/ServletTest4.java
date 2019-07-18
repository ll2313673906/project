package net.servlet;
/**
 * ServletContext对象获取数据
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(name = "ServletTest4",urlPatterns = "/Test4")
public class ServletTest4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("/db.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String name = properties.getProperty("name");
        String passWord = properties.getProperty("passWord");
        String url = properties.getProperty("url");
        System.out.println(url);
        System.out.println(name);
        System.out.println(passWord);
    }
}
