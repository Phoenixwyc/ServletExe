package cn.seu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet {

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//∂¡»°À˘”–cookie
		Cookie[] cookies = request.getCookies();
		out.println(cookies.length + " " + cookies + "<br/>");
		for (Cookie cookie : cookies) {
			out.println("key : " + cookie.getName() + "--value : " + cookie.getValue() + "<br/>");
			out.println("comment : " + cookie.getComment() + "<br/>");
			out.println("domain : " + cookie.getDomain() + "<br/>");
			out.println("maxAge : " + cookie.getMaxAge() + "<br/>");
			out.println("path : " + cookie.getPath() + "<br/>");
			out.println("secure :" + cookie.getSecure() + "<br/>");
			out.println("version : " + cookie.getVersion() + "<br/>");
			out.println("class : " + cookie.getClass().toString() + "<br/>");
			
		}
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
