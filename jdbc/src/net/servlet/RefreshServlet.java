package net.servlet;
/**
 * 实现网页自动刷新
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RefreshServlet",urlPatterns = "/refresh")
public class RefreshServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //解决乱码?????的问题
        response.setContentType("text/html;charset=utf-8");
        //在jsp 中实现自动刷洗功能
      String message = "<meta http-equiv='refresh' content='3;url=/jdbc/home.html'>3秒后会自动跳转到首页，若果没有跳转请点击<a href='/jdbc/home.html'>跳转链接</a>";
      request.setAttribute("message",message);
        //调取自动刷新的方法
        request.getRequestDispatcher("/index.JSP").forward(request,response);
        //三秒后自动刷新页面
       // RefreshDemo(response);


    }

    private void RefreshDemo(HttpServletResponse response) throws IOException {
        // response.setHeader("refresh","3");


        //刷新之后跳转到指定的页面一般不会写在Servlet中
        response.setHeader("refresh","3; url= '/jdbc/home.html'");
        response.getWriter().print("3秒后自动刷新");
    }
}
