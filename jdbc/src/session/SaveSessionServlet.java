package session;
/**
 * 使用Session域存取数据
 *
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SaveSessionServlet",urlPatterns = "/save")
public class SaveSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取Session对象
        HttpSession session = request.getSession();
        //Session持久化
        //1.第一步创建一个cookie对象覆盖之前服务器自动生成的JSESSIONID
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        //设置持久化时间
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        //存储商品
        session.setAttribute("goods","cup");

    }
}
