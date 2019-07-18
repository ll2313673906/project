package JSP;
/**
 * 在Servlet中添加html文件
 * @Author薄荷猫
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HTMLServlet",urlPatterns = "/html")
public class HTMLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
        response.setContentType("text/html;charset=utf-8");
        //获取到PrintWriter对象
        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>");
        writer.write("<html lang=\"en\">");
        writer.write("<head>");
        writer.write("<meta charset=\"UTF-8\">");
        writer.write("<title>home</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>我的网站首页</h1>");
        writer.write("</body>");
        writer.write("</html>");




   }

}
