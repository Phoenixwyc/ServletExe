package cn.seu.edu;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://blog.csdn.net/techbirds_bao/article/details/8243800
 * @author Administrator
 *
 */

public class HelloWorldServlet extends HttpServlet {
    @Override  
    protected void service(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("doservice..."+this.getInitParameter("encoding"));
        System.out.println(req.getCharacterEncoding() + " " + resp.getCharacterEncoding());
          
        super.service(req, resp);  
    }  
   
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("doget...");  
        System.out.println(req.getCharacterEncoding() + " " + resp.getCharacterEncoding());
        doPost(req, resp);  
    }  
   
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("dopost...");  
        System.out.println(req.getCharacterEncoding() + " " + resp.getCharacterEncoding());
    }
}
