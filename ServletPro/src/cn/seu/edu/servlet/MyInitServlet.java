package cn.seu.edu.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import cn.edu.cn.model.Send;

public class MyInitServlet extends HttpServlet {

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
		System.out.println("MyServlet �� init ������");
		Thread t = new Thread(new Send());
		//t.start();
	}

}
