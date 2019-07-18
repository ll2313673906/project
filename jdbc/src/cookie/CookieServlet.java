package cookie;
/**
 * Cookie的创建和发送
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet",urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //创建Cookie对象
        Cookie cookie = new Cookie("goods","cup");
        //cookie.setMaxAge(60*10);

        //如何删除客户端的Cookie
        //用同名同路径持久化时间为0 的Cookie来覆盖
        cookie.setMaxAge(0);


        //设置Cookie的携带信息
        cookie.setPath("/jdbc/getCookie");



        //加入到response的响应头中
        response.addCookie(cookie);
    }
}
