package session;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetCartServlet",urlPatterns = "/getCart")
public class GetCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //获取到Session对象
        HttpSession session = request.getSession();
        //获取List集合
        List<String> list = (List<String>)session.getAttribute("list");
        //解决乱码
        response.setContentType("text/html;charset=utf-8");
        //遍历集合
        for (String s: list) {
            //将商品返回给客户端浏览器
            response.getWriter().write(s+"<br/>");

        }
    }
}
