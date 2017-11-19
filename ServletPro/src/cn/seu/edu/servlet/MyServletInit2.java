package cn.seu.edu.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class MyServletInit2 extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		System.out.println("MyServletInit2");
	}

}
