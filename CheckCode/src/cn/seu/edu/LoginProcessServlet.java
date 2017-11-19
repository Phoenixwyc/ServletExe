package cn.seu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProcessServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		// ªÒ»°username°¢password°¢checkcode
		String username = request.getParameter("username");
		System.out.println("wyc".equals(username));
		String password = request.getParameter("password");
		System.out.println("123".equals(password));
		String checkCode = request.getParameter("checkcode");
		String checkCodeGen = (String) request.getSession().getAttribute("checkcode");
		System.out.println(checkCodeGen.equals(checkCode));
		
		if (checkCodeGen.equals(checkCode) && "wyc".equals(username) && "123".equals(password)) {
			request.getRequestDispatcher("/Welcome").forward(request, response);
		} else {
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
		System.out.println(username + " " + password + " " + checkCode + " " + checkCodeGen);
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
