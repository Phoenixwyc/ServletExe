package cn.seu.edu.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.seu.edu.domain.User;

public class MainFrame extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>主界面</h1>");
		out.println("username= " + request.getParameter("username") + " " + "password= " + request.getParameter("password") + "</b>");
		
		String username=(String)request.getSession().getAttribute("username");
		String password = (String)request.getSession().getAttribute("password");
		out.println("username_session:" + username + " " + "password_session= " + password);
		
		User user = (User)request.getSession().getAttribute("UserObj");
		out.println("username_obj= " + user.getName() + " " + "password_obj= " + user.getPassword());
		out.println("<a href=/UsersManager/LoginServlet>返回重新登录</a>");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}
