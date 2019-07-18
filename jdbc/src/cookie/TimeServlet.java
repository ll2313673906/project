package cookie;
/**
 * 记录网站上一次访问的时间
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "TimeServlet",urlPatterns = "/time")
public class TimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //记录访问的时间并加入到响应头
        Date date = new Date();
        //格式化时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-hh:ss:mm");
        String time = simpleDateFormat.format(date);
        Cookie cookie = new Cookie("time",time);
        //cookie持久化
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);

   response.setContentType("text/html;charset=utf-8");
        //第二部获取客户端浏览器发送过来的cookie数据
        Cookie[] cookies = request.getCookies();
        String timeValue = null;
        for (Cookie cookie1 :cookies){
            if (cookie1.getName().equals("time")){
                timeValue=cookie1.getValue();
            }
        }
        if (timeValue == null){
            response.getWriter().write("欢迎你访问此网站");
        }

     response.getWriter().write("你上次访问网站的时间是：" + timeValue);
    }
}
