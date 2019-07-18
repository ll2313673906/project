package net.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "ServletTest1",urlPatterns = "/test1")
public class ServletTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        this.getServletContext().getInitParameterNames();
        System.out.println(encoding);
        //获得共享


      }
}
