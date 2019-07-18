package session;
/**
 * 购物车
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddCartServlet",urlPatterns = "/addCart")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1,获取得到商品的信息
        String name = request.getParameter("name");
        //2,需要保存商品的信息到 session
        HttpSession session = request.getSession();
        List list = (List) session.getAttribute("list");

        //第一次访问时候List不存在，需要创建一个List
        if (list == null){
            list = new ArrayList();
        }
        list.add(name);
        session.setAttribute("list",list);
        //session的持久化操作，也就是持久化JSESSIONID
        Cookie cookie = new Cookie("JSEESIONID",session.getId());
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/jdbc");
        response.addCookie(cookie);

    }
}
