package net.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        //获取Servlet配置信息
        ServletConfig servletConfig = this.getServletConfig();
        String encoding = servletConfig.getInitParameter("encoding");
        System.out.println("encoding = " + encoding);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到get请求");

        //获取请求行
        System.out.println("请求方式：" + req.getMethod());
        System.out.println("URL:" + req.getRequestURI());
        System.out.println("发出请求客户端Ip地址：" + req.getRemoteAddr());
        System.out.println("服务点接收到请求的IP地址：" + req.getRemotePort());
        System.out.println("访问客户端的端口号：" + req.getContextPath());
        System.out.println("http协议和版本：" + req.getProtocol());


        //获取请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
           String element = headerNames.nextElement();
           //获取请求头
           System.out.println(element);
           //获取请求头的值
            System.out.println(element+":" + req.getHeader(element));

        }
        //获取请求参数
        String name = req.getParameter("name");
        String passWord = req.getParameter("passWord");
        System.out.println("用户名：" + name);
        System.out.println("密码："+ passWord);

        //HttpServletResponse发送请求体
        String result = "恭喜你登录成功";
        //第一种方法
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(result.getBytes());




    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到post请求");
    }
}
