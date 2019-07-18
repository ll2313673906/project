package session;
/**
 * Session对象的创建和获取
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //第一次访问浏览器时没有session，服务器会自动创建一个session对象
        //再次访问的时候已经存在了session对象，这个直接获取这个对象
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        response.getWriter().write("JESSIONID=" + sessionId);
    }
}
