package net.servlet;
/**
 * 登录错误返回提示信息
 *
 * */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userName = "liulian";
      String userPass = "123456";

      String name = request.getParameter("name");
      String passWord = request.getParameter("passWord");

      if (!name.equals(userName)){
          request.setAttribute("errorMessage","账号错误");
          //账户不存在
          request.getRequestDispatcher("/LoginError.JSP").forward(request,response);
      }else if (!passWord.equals(userPass)){
          //携带错误信息到错误界面
          request.setAttribute("errorMessage","密码错误");
          //密码错误
          request.getRequestDispatcher("/LoginError.JSP").forward(request,response);
      }else {
          //访问首页的第一种方法
         // response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
         // response.setHeader("Location","http://www.baidu.com/");
          //访问首页的第二种方法
         // response.sendRedirect("http://www.jd.com/");
          //访问本地的网站
          response.sendRedirect("/jdbc/home.html");
      }
    }
}
