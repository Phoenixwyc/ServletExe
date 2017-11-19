package cn.seu.edu.wyc;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet implements Servlet{

	public void init(ServletConfig config) {
	}
	
	public ServletConfig getServletConfig() {
		return null;
	}
	
	
	public void Service(ServletRequest req, ServletResponse res) throws ServletException, java.io.IOException {
		//System.out.println("hello world " + new java.util.Date());
		res.getWriter().println("hello world " + new java.util.Date().toLocalString());
	}

	
	public java.lang.String getServletInfo() {
		return null;
	}

	
	public void destroy() {

	}
}