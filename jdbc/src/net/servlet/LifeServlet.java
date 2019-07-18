package net.servlet;
/**
 * Servlet的生命周期
 * @Author刘恋
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LifeServlet",urlPatterns = "/life")
public class LifeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init 被执行了");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet被执行了");
        super.service(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doget被执行了");
    }

    @Override
    public void destroy() {
        System.out.println("destroy被执行了");
        super.destroy();
    }
}
