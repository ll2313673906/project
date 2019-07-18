package net.servlet;
/**
 * 文件资源下载
 */

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "DownloadServlet",urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//如何将服务器上的资源返回到浏览器

        //从浏览器传过来的参数中获取文件的地址
      String filename = request.getParameter("filename");

      // 如何通知浏览器不是预览而是下载
       String mimeType = this.getServletContext().getMimeType(filename);
       response.setContentType(mimeType);
       response.setHeader("Content-Disposition","attachment;filename="+filename);

      //通过ServletContext对象获取文件的绝对路径
        String realPath = this.getServletContext().getRealPath("download/"+filename);

        //声明输入流将文件读取进来
        InputStream in = new FileInputStream(realPath);
        ServletOutputStream outputStream = response.getOutputStream();//输出二进制文件

        //将输入流中的对象拷贝到输出流中
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer))>0){
            outputStream.write(buffer,0,len);
        }
        in.close();
        outputStream.close();
    }
}
