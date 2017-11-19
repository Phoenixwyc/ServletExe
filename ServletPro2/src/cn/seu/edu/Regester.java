package cn.seu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Regester extends HttpServlet {

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
		String username = request.getParameter("username");
		out.println(username +"<br/>");
		String password = request.getParameter("password");
		out.println(password + "<br/>");
		String sex = request.getParameter("sex");
		out.println(sex + "<br/>");
		//复选框，可能有多个值，需要使用getParameterValues
		String hobby[] = request.getParameterValues("hobby");
		if(hobby != null) {
			for(int i=0; i < hobby.length; i++){
				out.println(hobby[i]);
			}
			out.println("<br/>");
		}
		String city = request.getParameter("city");
		out.println(city + "<br/>");
		String intro = request.getParameter("intro");
		out.println(intro);
		
		String hiden1 = request.getParameter("hiden1");
		out.println(hiden1);

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
