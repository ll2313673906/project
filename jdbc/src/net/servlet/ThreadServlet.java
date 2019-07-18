package net.servlet;
/**
 * Servlet线程
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ThreadServlet",urlPatterns = "/thread")
public class ThreadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int i= 0;
     synchronized (this){
         i++;//第一次访问i已经是1，第二次访问是=2；
         try {
             Thread.sleep(5*1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         response.setContentType("text/html;charset=utf-8");
         response.getWriter().write(i+"");
     }
    }
}
